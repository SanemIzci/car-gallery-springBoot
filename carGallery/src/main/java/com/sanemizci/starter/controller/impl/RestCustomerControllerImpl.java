package com.sanemizci.starter.controller.impl;

import com.sanemizci.starter.controller.IRestCustomerController;
import com.sanemizci.starter.controller.RootEntity;
import com.sanemizci.starter.dto.DtoCustomer;
import com.sanemizci.starter.dto.DtoCustomerIU;
import com.sanemizci.starter.service.ICustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/{id}")
    @Override
    public RootEntity<DtoCustomer> getCustomerById(@PathVariable Long id) {
        return ok(customerService.getCustomerById(id));
    }
    @PutMapping("/{id}")
    @Override
    public RootEntity<DtoCustomer> updateCustomer(@PathVariable Long id,@Valid @RequestBody DtoCustomerIU dtoCustomerIU) {
        return ok(customerService.updateCustomer(id, dtoCustomerIU));
    }

    @DeleteMapping("/{id}")
    @Override
    public RootEntity<DtoCustomer> deleteCustomer(@PathVariable Long id) {
        return ok(customerService.deleteCustomer(id));
    }
}
