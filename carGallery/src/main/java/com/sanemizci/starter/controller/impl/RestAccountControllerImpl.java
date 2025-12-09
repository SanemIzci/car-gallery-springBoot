package com.sanemizci.starter.controller.impl;

import com.sanemizci.starter.controller.IRestAccountController;
import com.sanemizci.starter.controller.RootEntity;
import com.sanemizci.starter.dto.DtoAccount;
import com.sanemizci.starter.dto.DtoAccountIU;
import com.sanemizci.starter.service.IAccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.sanemizci.starter.controller.RootEntity.ok;

@RestController
@RequestMapping("/rest/api/account")
public class RestAccountControllerImpl implements IRestAccountController {

    @Autowired
    private IAccountService accountService;

    @PostMapping("/save")
    @Override
    public RootEntity<DtoAccount> createAccount(@Valid @RequestBody DtoAccountIU dtoAccountIU) {
        return ok(accountService.saveAccount(dtoAccountIU));
    }
    @DeleteMapping("/{id}")
    @Override
    public RootEntity<DtoAccount> deleteAccount(@Valid @PathVariable Long id) {
        return ok(accountService.deleteAccount(id));
    }
    @GetMapping("/{id}")
    @Override
    public RootEntity<DtoAccount> getAccountById( @Valid @PathVariable Long id) {
        return ok(accountService.getAccountById(id));
    }
    @PutMapping("/{id}")
    @Override
    public RootEntity<DtoAccount> updateAccount(@PathVariable Long id, @Valid @RequestBody DtoAccountIU dtoAccountIU) {
        return ok(accountService.updateAccount(id, dtoAccountIU));
    }


}
