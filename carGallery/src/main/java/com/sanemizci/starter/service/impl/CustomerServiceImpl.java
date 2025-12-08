package com.sanemizci.starter.service.impl;

import com.sanemizci.starter.dto.DtoAccount;
import com.sanemizci.starter.dto.DtoAddress;
import com.sanemizci.starter.dto.DtoCustomer;
import com.sanemizci.starter.dto.DtoCustomerIU;
import com.sanemizci.starter.model.Account;
import com.sanemizci.starter.model.Address;
import com.sanemizci.starter.model.Customer;
import com.sanemizci.starter.repository.AccountRepository;
import com.sanemizci.starter.repository.AddressRepository;
import com.sanemizci.starter.repository.CustomerRepository;
import com.sanemizci.starter.service.ICustomerService;
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
