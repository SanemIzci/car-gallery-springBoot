package com.sanemizci.starter.service;

import com.sanemizci.starter.dto.AuthRequest;
import com.sanemizci.starter.dto.AuthResponse;
import com.sanemizci.starter.dto.DtoUser;
import com.sanemizci.starter.dto.RefreshTokenRequest;

public interface IAuthenticationService {
    public DtoUser register(AuthRequest  authRequest);
    public AuthResponse authenticate(AuthRequest  authRequest);
    public AuthResponse refreshToken(RefreshTokenRequest input);
}
