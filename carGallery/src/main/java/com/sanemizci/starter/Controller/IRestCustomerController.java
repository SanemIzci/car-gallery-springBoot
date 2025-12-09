package com.sanemizci.starter.controller;

import com.sanemizci.starter.dto.DtoCustomer;
import com.sanemizci.starter.dto.DtoCustomerIU;

public interface IRestCustomerController {
    public RootEntity<DtoCustomer> saveCustomer(DtoCustomerIU dtoCustomerIU);

    public RootEntity<DtoCustomer> getCustomerById(Long id);

    public RootEntity<DtoCustomer> updateCustomer(Long id, DtoCustomerIU dtoCustomerIU);

    public RootEntity<DtoCustomer> deleteCustomer(Long id);
}
