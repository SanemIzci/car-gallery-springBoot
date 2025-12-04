package com.sanemizci.starter.Controller;

import com.sanemizci.starter.Dto.DtoAddress;
import com.sanemizci.starter.Dto.DtoAddressIU;

public interface IRestAddressController {
    public RootEntity<DtoAddress> saveAddres(DtoAddressIU dtoAddressIU);
}
