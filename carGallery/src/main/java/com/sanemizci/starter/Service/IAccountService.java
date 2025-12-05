package com.sanemizci.starter.Service;

import com.sanemizci.starter.Dto.DtoAccount;
import com.sanemizci.starter.Dto.DtoAccountIU;

public interface IAccountService {

    public DtoAccount saveAccount(DtoAccountIU dtoAccountIU);
    public DtoAccount deleteAccount(Long id);
}
