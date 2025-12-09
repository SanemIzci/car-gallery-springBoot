package com.sanemizci.starter.controller.impl;

import com.sanemizci.starter.controller.IRestAddressController;
import com.sanemizci.starter.controller.RestBaseController;
import com.sanemizci.starter.controller.RootEntity;
import com.sanemizci.starter.dto.DtoAddress;
import com.sanemizci.starter.dto.DtoAddressIU;
import com.sanemizci.starter.service.IAddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/api/address")
public class RestAddressControllerImpl extends RestBaseController implements IRestAddressController {
    @Autowired
    private IAddressService addressService;

    @PostMapping("/save")
    @Override
    public RootEntity<DtoAddress> saveAddress(@Valid @RequestBody DtoAddressIU dtoAddressIU) {
        return ok(addressService.saveAddress(dtoAddressIU));
    }

    @GetMapping("/{id}")
    @Override
    public RootEntity<DtoAddress> getAddressById(@Valid @PathVariable Long id) {
        return ok(addressService.getAddressById(id));
    }

    @PutMapping("/{id}")
    @Override
    public RootEntity<DtoAddress> updateAddress(@PathVariable Long id, @Valid @RequestBody DtoAddressIU dtoAddressIU) {
        return ok(addressService.updateAddress(id, dtoAddressIU));
    }

    @DeleteMapping("/{id}")
    @Override
    public RootEntity<DtoAddress> deleteAddress(@Valid @PathVariable Long id) {
        return ok(addressService.deleteAddress(id));
    }

}
