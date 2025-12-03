package com.sanemizci.starter.Service.impl;

import com.sanemizci.starter.Dto.AuthRequest;
import com.sanemizci.starter.Dto.DtoUser;
import com.sanemizci.starter.Model.User;
import com.sanemizci.starter.Repository.UserRepository;
import com.sanemizci.starter.Service.IAuthenticationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AuthenticationServiceImpl implements IAuthenticationService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

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
}
