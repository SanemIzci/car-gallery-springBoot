package com.sanemizci.starter.service;

import com.sanemizci.starter.dto.DtoAccount;
import com.sanemizci.starter.dto.DtoAccountIU;

public interface IAccountService {

    public DtoAccount saveAccount(DtoAccountIU dtoAccountIU);
    public DtoAccount deleteAccount(Long id);
    public DtoAccount updateAccount(Long id,DtoAccountIU dtoAccountIU);
    public DtoAccount getAccountById(Long id);
}
