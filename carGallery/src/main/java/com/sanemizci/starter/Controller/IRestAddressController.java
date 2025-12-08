package com.sanemizci.starter.controller;

import com.sanemizci.starter.dto.DtoAddress;
import com.sanemizci.starter.dto.DtoAddressIU;

public interface IRestAddressController {
    public RootEntity<DtoAddress> saveAddres(DtoAddressIU dtoAddressIU);
}
