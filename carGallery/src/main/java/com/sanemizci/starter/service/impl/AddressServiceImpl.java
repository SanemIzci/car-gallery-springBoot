package com.sanemizci.starter.service.impl;

import com.sanemizci.starter.dto.DtoAddress;
import com.sanemizci.starter.dto.DtoAddressIU;
import com.sanemizci.starter.exception.BaseException;
import com.sanemizci.starter.exception.ErrorMessage;
import com.sanemizci.starter.exception.MessageType;
import com.sanemizci.starter.model.Address;
import com.sanemizci.starter.repository.AddressRepository;
import com.sanemizci.starter.service.IAddressService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class AddressServiceImpl implements IAddressService {
    @Autowired
    private AddressRepository addressRepository;


    private Address createAddress(DtoAddressIU dtoAddressIU) {
        Address address = new Address();
        address.setCreateTime(new Date());
        BeanUtils.copyProperties(dtoAddressIU, address);
        return address;
    }

    @Override
    public DtoAddress saveAddress(DtoAddressIU dtoAddressIU) {
        DtoAddress dtoAddress = new DtoAddress();
        Address savedAddress = addressRepository.save(createAddress(dtoAddressIU));
        BeanUtils.copyProperties(savedAddress, dtoAddress);
        return dtoAddress;
    }
    private Address findAddressById(Long id){
        Optional<Address> optionalAddress = addressRepository.findById(id);
        if(optionalAddress.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXISTS,id.toString()));
        }
        return optionalAddress.get();
    }


    @Override
    public DtoAddress getAddressById(Long id) {
        DtoAddress dtoAddress = new DtoAddress();
        Address savedAddress=findAddressById(id);
        BeanUtils.copyProperties(savedAddress, dtoAddress);
        return dtoAddress;
    }

    @Override
    public DtoAddress deleteAddress(Long id) {
        throw new BaseException(new ErrorMessage(
                MessageType.GENERAL_EXCEPTION,
                "Address cannot be deleted. Use update instead."
        ));
    }

    @Override
    public DtoAddress updateAddress(Long id, DtoAddressIU dtoAddressIU) {
        Address address = findAddressById(id);
        address.setNeighborhood(dtoAddressIU.getNeighborhood());
        address.setStreet(dtoAddressIU.getStreet());
        address.setCity(dtoAddressIU.getCity());
        address.setDistrict(dtoAddressIU.getDistrict());

        Address updatedAddress = addressRepository.save(address);

        DtoAddress dtoAddress = new DtoAddress();
        BeanUtils.copyProperties(updatedAddress, dtoAddress);
        return dtoAddress;
    }
}
