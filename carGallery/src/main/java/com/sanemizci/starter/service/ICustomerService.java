package com.sanemizci.starter.Service;

import com.sanemizci.starter.Controller.RootEntity;
import com.sanemizci.starter.Dto.DtoCustomer;
import com.sanemizci.starter.Dto.DtoCustomerIU;

public interface ICustomerService {

    public DtoCustomer saveCustomer(DtoCustomerIU dtoCustomerIU);
}
