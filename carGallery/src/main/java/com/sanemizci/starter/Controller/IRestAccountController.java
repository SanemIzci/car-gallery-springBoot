package com.sanemizci.starter.Controller;


import com.sanemizci.starter.Dto.DtoAccount;
import com.sanemizci.starter.Dto.DtoAccountIU;
import com.sanemizci.starter.Model.Account;

public interface IRestAccountController {
    public RootEntity<DtoAccount> createAccount(DtoAccountIU dtoAccountIU);
}
