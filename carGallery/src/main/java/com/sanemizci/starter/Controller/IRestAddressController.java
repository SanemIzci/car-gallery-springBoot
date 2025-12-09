package com.sanemizci.starter.controller;

import com.sanemizci.starter.dto.DtoAddress;
import com.sanemizci.starter.dto.DtoAddressIU;

public interface IRestAddressController {
    public RootEntity<DtoAddress> saveAddress(DtoAddressIU dtoAddressIU);
    public RootEntity<DtoAddress> getAddressById(Long id);
    public RootEntity<DtoAddress> updateAddress(Long id,DtoAddressIU dtoAddressIU);
    public RootEntity<DtoAddress> deleteAddress(Long id);
}
