package com.sanemizci.starter.Controller;

import com.sanemizci.starter.Dto.AuthRequest;
import com.sanemizci.starter.Dto.AuthResponse;
import com.sanemizci.starter.Dto.DtoUser;
import com.sanemizci.starter.Dto.RefreshTokenRequest;


public interface IRestAuthenticationController {
    public RootEntity<DtoUser> register(AuthRequest authRequest);
    public RootEntity<AuthResponse>  authenticate(AuthRequest authRequest);
    public RootEntity<AuthResponse>  refreshToken(RefreshTokenRequest request);

}
