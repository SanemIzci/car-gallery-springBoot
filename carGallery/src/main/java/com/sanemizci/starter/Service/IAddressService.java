package com.sanemizci.starter.service;

import com.sanemizci.starter.dto.DtoAddress;
import com.sanemizci.starter.dto.DtoAddressIU;

public interface IAddressService {
    public DtoAddress saveAdress(DtoAddressIU dtoAdressIU);

}
