package com.sanemizci.starter.controller;


import com.sanemizci.starter.dto.DtoAccount;
import com.sanemizci.starter.dto.DtoAccountIU;

public interface IRestAccountController {
    public RootEntity<DtoAccount> createAccount(DtoAccountIU dtoAccountIU);
    public RootEntity<DtoAccount> deleteAccount(Long id);
    public RootEntity<DtoAccount> getAccountById(Long id);
    public RootEntity<DtoAccount> updateAccount(Long id,DtoAccountIU dtoAccountIU);

}
