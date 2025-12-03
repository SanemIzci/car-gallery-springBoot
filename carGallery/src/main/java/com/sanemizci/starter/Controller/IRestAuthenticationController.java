package com.sanemizci.starter.Controller;

import com.sanemizci.starter.Dto.AuthRequest;
import com.sanemizci.starter.Dto.DtoUser;

public interface IRestAuthenticationController {
    public RootEntity<DtoUser> register(AuthRequest authRequest);

}
