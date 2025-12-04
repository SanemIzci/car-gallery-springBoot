package com.sanemizci.starter.Controller.impl;

import com.sanemizci.starter.Controller.IRestCustomerController;
import com.sanemizci.starter.Controller.RootEntity;
import com.sanemizci.starter.Dto.DtoCustomer;
import com.sanemizci.starter.Dto.DtoCustomerIU;
import com.sanemizci.starter.Service.ICustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/customer")
public class RestCustomerControllerImpl extends RootEntity implements IRestCustomerController  {

    @Autowired
    private ICustomerService customerService;

    @PostMapping("/save")
    @Override
    public RootEntity<DtoCustomer> saveCustomer(@Valid @RequestBody DtoCustomerIU dtoCustomerIU) {
        return ok(customerService.saveCustomer(dtoCustomerIU));
    }
}
