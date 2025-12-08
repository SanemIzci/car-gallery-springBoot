package com.sanemizci.starter.controller;

import com.sanemizci.starter.dto.AuthRequest;
import com.sanemizci.starter.dto.AuthResponse;
import com.sanemizci.starter.dto.DtoUser;
import com.sanemizci.starter.dto.RefreshTokenRequest;


public interface IRestAuthenticationController {
    public RootEntity<DtoUser> register(AuthRequest authRequest);
    public RootEntity<AuthResponse>  authenticate(AuthRequest authRequest);
    public RootEntity<AuthResponse>  refreshToken(RefreshTokenRequest request);

}
