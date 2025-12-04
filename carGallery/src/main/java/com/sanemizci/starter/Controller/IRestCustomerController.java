package com.sanemizci.starter.Controller;

import com.sanemizci.starter.Dto.DtoCustomer;
import com.sanemizci.starter.Dto.DtoCustomerIU;

public interface IRestCustomerController {
    public RootEntity<DtoCustomer> saveCustomer(DtoCustomerIU dtoCustomerIU);
}
