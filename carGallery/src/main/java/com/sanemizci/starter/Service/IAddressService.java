package com.sanemizci.starter.Service;

import com.sanemizci.starter.Dto.DtoAddress;
import com.sanemizci.starter.Dto.DtoAddressIU;

public interface IAddressService {
    public DtoAddress saveAdress(DtoAddressIU dtoAdressIU);

}
