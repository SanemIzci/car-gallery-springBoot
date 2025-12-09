package com.sanemizci.starter.service.impl;

import com.sanemizci.starter.dto.DtoAddress;
import com.sanemizci.starter.dto.DtoGallery;
import com.sanemizci.starter.dto.DtoGalleryIU;
import com.sanemizci.starter.model.Address;
import com.sanemizci.starter.model.Gallery;
import com.sanemizci.starter.repository.AddressRepository;
import com.sanemizci.starter.repository.GalleryRepository;
import com.sanemizci.starter.service.IGalleryService;
import com.sanemizci.starter.exception.BaseException;
import com.sanemizci.starter.exception.ErrorMessage;
import com.sanemizci.starter.exception.MessageType;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class GalleryServiceImpl implements IGalleryService {

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private GalleryRepository galleryRepository;

    private Gallery createGallery(DtoGalleryIU dtoGalleryIU) {

        Optional<Address> optAddress = addressRepository.findById(dtoGalleryIU.getAddress_id());
        if (optAddress.isEmpty()) {
            throw new BaseException(new ErrorMessage(
                    MessageType.NO_RECORD_EXISTS,
                    "Address with ID " + dtoGalleryIU.getAddress_id() + " not found"
            ));
        }
        Gallery gallery = new Gallery();
        gallery.setCreateTime(new Date());

        BeanUtils.copyProperties(dtoGalleryIU, gallery);

        gallery.setAddress(optAddress.get());
        return gallery;
    }
    private Gallery findGalleryById(Long id) {
        Optional<Gallery> optGallery = galleryRepository.findById(id);
        if (optGallery.isEmpty()) {
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXISTS, "Gallery with ID " + id + " not found"));
        }
        return  optGallery.get();
    }

    @Override

    public DtoGallery saveGallery(DtoGalleryIU dtoGalleryIU) {

        Gallery savedGallery = galleryRepository.save(createGallery(dtoGalleryIU));


        DtoGallery dtoGallery = new DtoGallery();
        BeanUtils.copyProperties(savedGallery, dtoGallery);

        if (savedGallery.getAddress() != null) {
            dtoGallery.setAddress_id(savedGallery.getAddress().getId());
        }

        return dtoGallery;
    }

    @Override
    public DtoGallery getGalleryById(Long id) {
        Gallery gallery = findGalleryById(id);
        DtoGallery dtoGallery = new DtoGallery();
        DtoAddress dtoAddress = new DtoAddress();
        if (gallery.getAddress() != null) {
            BeanUtils.copyProperties(gallery.getAddress(), dtoAddress);
            dtoGallery.setAddress(dtoAddress);
            dtoGallery.setAddress_id(gallery.getAddress().getId());
        }
        BeanUtils.copyProperties(gallery, dtoGallery);
        return dtoGallery;
    }

    @Override
    public DtoGallery updateGallery(Long id, DtoGalleryIU dtoGalleryIU) {
        return null;
    }

    @Override
    public DtoGallery deleteGallery(Long id) {
        return null;
    }
}
