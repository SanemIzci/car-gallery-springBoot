package com.sanemizci.starter.Service.impl;

import com.sanemizci.starter.Dto.DtoAccount;
import com.sanemizci.starter.Dto.DtoAccountIU;
import com.sanemizci.starter.Model.Account;
import com.sanemizci.starter.Repository.AccountRepository;
import com.sanemizci.starter.Service.IAccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private AccountRepository accountRepository;


    private Account createAccount(DtoAccountIU dtoAccountIU) {
        Account account = new Account();
        account.setCreateTime(new Date());
        BeanUtils.copyProperties(dtoAccountIU, account);
        return account;
    }


    @Override
    public DtoAccount saveAccount(DtoAccountIU dtoAccountIU) {
        DtoAccount dtoAccount = new DtoAccount();
        Account savedAccount = accountRepository.save(createAccount(dtoAccountIU));
        BeanUtils.copyProperties(savedAccount, dtoAccount);
        return dtoAccount;
    }
}
