package com.sanemizci.starter.controller.impl;

import com.sanemizci.starter.controller.IRestAuthenticationController;
import com.sanemizci.starter.controller.RestBaseController;
import com.sanemizci.starter.controller.RootEntity;
import com.sanemizci.starter.dto.AuthRequest;
import com.sanemizci.starter.dto.AuthResponse;
import com.sanemizci.starter.dto.DtoUser;
import com.sanemizci.starter.dto.RefreshTokenRequest;
import com.sanemizci.starter.service.IAuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestAuthenticationControllerImpl extends RestBaseController implements IRestAuthenticationController  {
    @Autowired
    private IAuthenticationService  authenticationService;
    @PostMapping("/register")
    @Override
    public RootEntity<DtoUser> register(@Valid @RequestBody AuthRequest authRequest) {
        return ok(authenticationService.register(authRequest));
    }
    @PostMapping("/authenticate")
    @Override
    public RootEntity<AuthResponse> authenticate(@Valid @RequestBody AuthRequest authRequest) {
        return ok(authenticationService.authenticate(authRequest));
    }
    @PostMapping("/refresh-token")
    @Override
    public RootEntity<AuthResponse> refreshToken(RefreshTokenRequest request) {
        return ok(authenticationService.refreshToken(request));
    }
}
