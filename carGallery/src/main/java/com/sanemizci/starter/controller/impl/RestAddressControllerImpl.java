package com.sanemizci.starter.controller.impl;

import com.sanemizci.starter.controller.IRestAddressController;
import com.sanemizci.starter.controller.RestBaseController;
import com.sanemizci.starter.controller.RootEntity;
import com.sanemizci.starter.dto.DtoAddress;
import com.sanemizci.starter.dto.DtoAddressIU;
import com.sanemizci.starter.service.IAddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/address")
public class RestAddressControllerImpl extends RestBaseController implements IRestAddressController {
    @Autowired
    private IAddressService addressService;

    @PostMapping("/save")
    @Override
    public RootEntity<DtoAddress> saveAddres(@Valid @RequestBody DtoAddressIU dtoAddressIU) {
       return ok(addressService.saveAdress(dtoAddressIU));
    }
}
