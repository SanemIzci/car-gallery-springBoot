package com.sanemizci.starter.service.impl;

import com.sanemizci.starter.dto.DtoAccount;
import com.sanemizci.starter.dto.DtoAccountIU;
import com.sanemizci.starter.exception.BaseException;
import com.sanemizci.starter.exception.ErrorMessage;
import com.sanemizci.starter.exception.MessageType;
import com.sanemizci.starter.model.Account;
import com.sanemizci.starter.repository.AccountRepository;
import com.sanemizci.starter.service.IAccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

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
    private Account findAccountById(Long id) {
        Optional<Account> optionalAccount = accountRepository.findById(id);
        if (optionalAccount.isEmpty()) {
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXISTS, id.toString()));
        }
        return optionalAccount.get();
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
        Account accountToDelete = findAccountById(id);
        
        DtoAccount dtoAccount = new DtoAccount();
        BeanUtils.copyProperties(accountToDelete, dtoAccount);
        
        accountRepository.delete(accountToDelete);
        
        return dtoAccount;
    }

    @Override
    public DtoAccount updateAccount(Long id, DtoAccountIU dtoAccountIU) {
        
        Account account = findAccountById(id);

        
        account.setAccountNo(dtoAccountIU.getAccountNo());
        account.setIBAN(dtoAccountIU.getIBAN());
        account.setAmount(dtoAccountIU.getAmount());
        account.setCurrencyType(dtoAccountIU.getCurrencyType());


        Account updated = accountRepository.save(account);

        
        DtoAccount dtoAccount = new DtoAccount();
        BeanUtils.copyProperties(updated, dtoAccount);
        return dtoAccount;
    }

    @Override
    public DtoAccount getAccountById(Long id) {
        Account accountToGet=findAccountById(id);
        DtoAccount dtoAccount = new DtoAccount();
        BeanUtils.copyProperties(accountToGet, dtoAccount);

        return dtoAccount;
    }

}
