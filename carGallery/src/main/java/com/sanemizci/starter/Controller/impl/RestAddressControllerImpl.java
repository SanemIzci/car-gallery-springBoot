package com.sanemizci.starter.Controller.impl;

import com.sanemizci.starter.Controller.IRestAddressController;
import com.sanemizci.starter.Controller.RestBaseController;
import com.sanemizci.starter.Controller.RootEntity;
import com.sanemizci.starter.Dto.DtoAddress;
import com.sanemizci.starter.Dto.DtoAddressIU;
import com.sanemizci.starter.Service.IAddressService;
import com.sanemizci.starter.Service.impl.AddressServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.sanemizci.starter.Controller.RootEntity.ok;

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
