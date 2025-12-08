package com.sanemizci.starter.service.impl;

import com.sanemizci.starter.dto.*;
import com.sanemizci.starter.exception.BaseException;
import com.sanemizci.starter.exception.ErrorMessage;
import com.sanemizci.starter.exception.MessageType;
import com.sanemizci.starter.model.Car;
import com.sanemizci.starter.model.Gallery;
import com.sanemizci.starter.model.GalleryCars;
import com.sanemizci.starter.repository.CarRepository;
import com.sanemizci.starter.repository.GalleryCarsRepository;
import com.sanemizci.starter.repository.GalleryRepository;
import com.sanemizci.starter.service.IGalleryCarService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class GalleryCarsServiceImpl implements IGalleryCarService {
    @Autowired
    private GalleryCarsRepository galleryCarsRepository;
    @Autowired
    private GalleryRepository galleryRepository;
    @Autowired
    private CarRepository carRepository;


    private GalleryCars createGalleryCars(DtoGalleryCarsIU dtoGalleryCarsIU) {
        Optional<Gallery> dbGallery=galleryRepository.findById(dtoGalleryCarsIU.getGalleryId());
        if(dbGallery.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXISTS,dtoGalleryCarsIU.getGalleryId().toString()));
        }
        Optional<Car> dbCar=carRepository.findById(dtoGalleryCarsIU.getCarId());
        if(dbCar.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXISTS,dtoGalleryCarsIU.getCarId().toString()));
        }
        GalleryCars galleryCars = new GalleryCars();
        galleryCars.setCreateTime(new Date());
        galleryCars.setGallery(dbGallery.get());
        galleryCars.setCar(dbCar.get());

        return galleryCars;
    }


    @Override
    public DtoGalleryCars saveGalleryCars(DtoGalleryCarsIU dtoGalleryCarsIU) {
        DtoGalleryCars dtoGalleryCars = new DtoGalleryCars();
        DtoGallery dtoGallery = new DtoGallery();
        DtoCar dtoCar = new DtoCar();
        DtoAddress dtoAddress = new DtoAddress();

        GalleryCars dtoGalleryCar= galleryCarsRepository.save(createGalleryCars(dtoGalleryCarsIU));
        BeanUtils.copyProperties(dtoGalleryCar, dtoGalleryCars);
        BeanUtils.copyProperties(dtoGalleryCar.getGallery(), dtoGallery);
        BeanUtils.copyProperties(dtoGalleryCar.getCar(), dtoCar);

        if (dtoGalleryCar.getGallery().getAddress() != null) {
            BeanUtils.copyProperties(dtoGalleryCar.getGallery().getAddress(), dtoAddress);
            dtoGallery.setAddress_id(dtoAddress.getId());
            dtoGallery.setAddress(dtoAddress);
        }
        dtoGalleryCars.setGallery(dtoGallery);
        dtoGalleryCars.setCar(dtoCar);
        return dtoGalleryCars;
    }
}
