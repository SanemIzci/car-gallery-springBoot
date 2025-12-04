package com.sanemizci.starter.Service.impl;

import com.sanemizci.starter.Controller.RootEntity;
import com.sanemizci.starter.Dto.DtoCustomer;
import com.sanemizci.starter.Dto.DtoCustomerIU;
import com.sanemizci.starter.Model.Customer;
import com.sanemizci.starter.Repository.CustomerRepository;
import com.sanemizci.starter.Service.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    private Customer createCustomer(DtoCustomerIU dtoCustomerIU) {
        Customer customer = new Customer();
        customer.setCreateTime(new Date());
        BeanUtils.copyProperties(dtoCustomerIU, customer);
        return customer;
    }


    @Override
    public DtoCustomer saveCustomer(DtoCustomerIU dtoCustomerIU) {
        DtoCustomer dtoCustomer=new DtoCustomer();
        Customer savedCustomer=customerRepository.save(createCustomer(dtoCustomerIU));
        BeanUtils.copyProperties(savedCustomer,dtoCustomer);
        return dtoCustomer;
    }
}
