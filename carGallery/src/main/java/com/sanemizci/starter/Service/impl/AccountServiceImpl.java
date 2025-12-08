package com.sanemizci.starter.service.impl;

import com.sanemizci.starter.dto.DtoAccount;
import com.sanemizci.starter.dto.DtoAccountIU;
import com.sanemizci.starter.model.Account;
import com.sanemizci.starter.repository.AccountRepository;
import com.sanemizci.starter.service.IAccountService;
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
    @Override
    public DtoAccount deleteAccount(Long id) {
        return null;
    }
}
