package com.sanemizci.starter.Service;

import com.sanemizci.starter.Dto.AuthRequest;
import com.sanemizci.starter.Dto.DtoUser;

public interface IAuthenticationService {
    public DtoUser register(AuthRequest  authRequest);
}
