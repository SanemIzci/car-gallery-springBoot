package com.sanemizci.starter.service;

import com.sanemizci.starter.dto.DtoAddress;
import com.sanemizci.starter.dto.DtoAddressIU;

public interface IAddressService {
    public DtoAddress saveAddress(DtoAddressIU dtoAddressIU);
    public DtoAddress getAddressById(Long id);
    public DtoAddress deleteAddress(Long id);
    public DtoAddress updateAddress(Long id, DtoAddressIU dtoAddressIU);
}
