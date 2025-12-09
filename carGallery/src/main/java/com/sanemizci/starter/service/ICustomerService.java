package com.sanemizci.starter.service;

import com.sanemizci.starter.dto.DtoCustomer;
import com.sanemizci.starter.dto.DtoCustomerIU;

public interface ICustomerService {

    public DtoCustomer saveCustomer(DtoCustomerIU dtoCustomerIU);

    public DtoCustomer updateCustomer(Long id, DtoCustomerIU dtoCustomerIU);

    public DtoCustomer deleteCustomer(Long id);

    public DtoCustomer getCustomerById(Long id);
}
