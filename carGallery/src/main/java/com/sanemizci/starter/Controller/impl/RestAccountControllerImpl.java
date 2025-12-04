package com.sanemizci.starter.Controller.impl;

import com.sanemizci.starter.Controller.IRestAccountController;
import com.sanemizci.starter.Controller.RootEntity;
import com.sanemizci.starter.Dto.DtoAccount;
import com.sanemizci.starter.Dto.DtoAccountIU;
import com.sanemizci.starter.Service.IAccountService;
import com.sanemizci.starter.Service.IAddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.sanemizci.starter.Controller.RootEntity.ok;

@RestController
@RequestMapping("/rest/api/account")
public class RestAccountControllerImpl implements IRestAccountController {

    @Autowired
    private IAccountService accountService;

    @PostMapping("/create")
    @Override
    public RootEntity<DtoAccount> createAccount(@Valid @RequestBody DtoAccountIU dtoAccountIU) {
        return ok(accountService.saveAccount(dtoAccountIU));
    }
}
