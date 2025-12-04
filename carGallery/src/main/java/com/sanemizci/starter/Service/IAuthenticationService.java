package com.sanemizci.starter.Service;

import com.sanemizci.starter.Dto.AuthRequest;
import com.sanemizci.starter.Dto.AuthResponse;
import com.sanemizci.starter.Dto.DtoUser;
import com.sanemizci.starter.Dto.RefreshTokenRequest;

public interface IAuthenticationService {
    public DtoUser register(AuthRequest  authRequest);
    public AuthResponse authenticate(AuthRequest  authRequest);
    public AuthResponse refreshToken(RefreshTokenRequest input);
}
