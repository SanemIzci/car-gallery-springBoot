package com.sanemizci.starter.Service.impl;

import com.sanemizci.starter.Dto.DtoAddress;
import com.sanemizci.starter.Dto.DtoAddressIU;
import com.sanemizci.starter.Model.Address;
import com.sanemizci.starter.Repository.AddressRepository;
import com.sanemizci.starter.Service.IAddressService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AddressServiceImpl implements IAddressService {
    @Autowired
    private AddressRepository addressRepository;


    private Address createAdress(DtoAddressIU dtoAddressIU) {
        Address address = new Address();
        address.setCreateTime(new Date());
        BeanUtils.copyProperties(dtoAddressIU, address);
        return address;
    }

    @Override
    public DtoAddress saveAdress(DtoAddressIU dtoAddressIU) {
        DtoAddress dtoAddress = new DtoAddress();
        Address  savedAddress= addressRepository.save(createAdress(dtoAddressIU));
        BeanUtils.copyProperties(savedAddress, dtoAddress);
        return dtoAddress;

    }
}
