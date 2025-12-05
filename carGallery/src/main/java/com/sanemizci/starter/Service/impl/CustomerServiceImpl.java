package com.sanemizci.starter.Service.impl;

import com.sanemizci.starter.Controller.RootEntity;
import com.sanemizci.starter.Dto.DtoAccount;
import com.sanemizci.starter.Dto.DtoAddress;
import com.sanemizci.starter.Dto.DtoCustomer;
import com.sanemizci.starter.Dto.DtoCustomerIU;
import com.sanemizci.starter.Model.Account;
import com.sanemizci.starter.Model.Address;
import com.sanemizci.starter.Model.Customer;
import com.sanemizci.starter.Repository.AccountRepository;
import com.sanemizci.starter.Repository.AddressRepository;
import com.sanemizci.starter.Repository.CustomerRepository;
import com.sanemizci.starter.Service.ICustomerService;
import com.sanemizci.starter.exception.BaseException;
import com.sanemizci.starter.exception.ErrorMessage;
import com.sanemizci.starter.exception.MessageType;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private AccountRepository accountRepository;

    private Customer createCustomer(DtoCustomerIU dtoCustomerIU) {
        Optional<Address> optAddress=addressRepository.findById(dtoCustomerIU.getAddress());
        if(optAddress.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXISTS,optAddress.toString()));
        }
        Optional<Account> optAccount=accountRepository.findById(dtoCustomerIU.getAccount());
        if(optAccount.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXISTS,optAccount.toString()));
        }
        Customer customer = new Customer();
        customer.setCreateTime(new Date());
        BeanUtils.copyProperties(dtoCustomerIU,customer);
        customer.setAddress(optAddress.get());
        customer.setAccount(optAccount.get());
        return customer;
    }


    @Override
    public DtoCustomer saveCustomer(DtoCustomerIU dtoCustomerIU) {
        DtoCustomer dtoCustomer=new DtoCustomer();
        DtoAccount dtoAccount=new DtoAccount();
        DtoAddress dtoAddress=new DtoAddress();
        Customer savedCustomer=customerRepository.save(createCustomer(dtoCustomerIU));
        BeanUtils.copyProperties(savedCustomer,dtoCustomer);
        BeanUtils.copyProperties(savedCustomer.getAccount(),dtoAccount);
        BeanUtils.copyProperties(savedCustomer.getAddress(),dtoAddress);
        dtoCustomer.setAddress(dtoAddress.getId());
        dtoCustomer.setAccount(dtoAccount.getId());
        return dtoCustomer;
    }
}
