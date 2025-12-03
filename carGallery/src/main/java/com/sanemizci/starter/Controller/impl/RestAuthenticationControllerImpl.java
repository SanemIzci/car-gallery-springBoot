package com.sanemizci.starter.Controller.impl;

import com.sanemizci.starter.Controller.IRestAuthenticationController;
import com.sanemizci.starter.Controller.RestBaseController;
import com.sanemizci.starter.Controller.RootEntity;
import com.sanemizci.starter.Dto.AuthRequest;
import com.sanemizci.starter.Dto.DtoUser;
import com.sanemizci.starter.Service.IAuthenticationService;
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
}
