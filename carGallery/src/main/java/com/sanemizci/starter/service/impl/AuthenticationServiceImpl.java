package com.sanemizci.starter.service.impl;

import com.sanemizci.starter.dto.AuthRequest;
import com.sanemizci.starter.dto.AuthResponse;
import com.sanemizci.starter.dto.DtoUser;
import com.sanemizci.starter.dto.RefreshTokenRequest;
import com.sanemizci.starter.model.RefreshToken;
import com.sanemizci.starter.model.User;
import com.sanemizci.starter.repository.RefreshTokenRepository;
import com.sanemizci.starter.repository.UserRepository;
import com.sanemizci.starter.service.IAuthenticationService;
import com.sanemizci.starter.exception.BaseException;
import com.sanemizci.starter.exception.ErrorMessage;
import com.sanemizci.starter.exception.MessageType;
import com.sanemizci.starter.jwt.JWTService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.Date;
import java.util.UUID;

@Service
public class AuthenticationServiceImpl implements IAuthenticationService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private AuthenticationProvider authenticationProvider;
    @Autowired
    private JWTService jwtService;
    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    private User createUser(AuthRequest authRequest) {
        User user = new User();
        user.setCreateTime(new Date());
        user.setUsername(authRequest.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(authRequest.getPassword()));
        return user;
    }

    @Override
    public DtoUser register(AuthRequest authRequest) {
        User savedUser=userRepository.save(createUser(authRequest));
        DtoUser dtoUser=new DtoUser();
        BeanUtils.copyProperties(savedUser,dtoUser);
        return dtoUser ;
    }

    public RefreshToken generateRefreshToken(User user) {
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setCreateTime(new Date());
        refreshToken.setExpireDate(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 4));
        refreshToken.setRefreshToken(UUID.randomUUID().toString());
        refreshToken.setUser(user);


        return refreshToken;
    }

    @Override
    public AuthResponse authenticate(AuthRequest authRequest) {
        try{
            UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(
                    authRequest.getUsername()
                    ,authRequest.getPassword());
            authenticationProvider.authenticate(authenticationToken);

            User user=userRepository.findByUsername(authRequest.getUsername()).orElseThrow(()->new RuntimeException("Username not found"));

            String accessToken=jwtService.generateToken(user);

            RefreshToken refreshToken=generateRefreshToken(user);

            RefreshToken savedRefreshToken=refreshTokenRepository.save(refreshToken);

            return new AuthResponse(accessToken,savedRefreshToken.getRefreshToken());

        }catch (Exception e) {
            throw new BaseException(
                    new ErrorMessage(MessageType.USERNAME_OR_PASSWORD_IS_NOT_VALID, e.getMessage())
            );
        }
    }
    public boolean isValidRefreshToken(Date expiration) {
        return expiration.after(new Date());
    }




    @Override
    public AuthResponse refreshToken(RefreshTokenRequest input) {
        Optional<RefreshToken> optRefreshToken= refreshTokenRepository.findRefreshTokenBy(input.getRefreshToken());
        if(optRefreshToken.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.REFRESH_TOKEN_NOT_FOUND,input.getRefreshToken()));
        }
        else if(!isValidRefreshToken(optRefreshToken.get().getExpireDate())){
            throw new BaseException(new ErrorMessage(MessageType.REFRESH_TOKEN_EXPIRED,input.getRefreshToken()));
        }
        User user=optRefreshToken.get().getUser();
        String accessToken=jwtService.generateToken(user);
        RefreshToken refreshToken=generateRefreshToken(user);
        RefreshToken savedRefreshToken=refreshTokenRepository.save(refreshToken);
        return new AuthResponse(accessToken,savedRefreshToken.getRefreshToken());
    }
}
