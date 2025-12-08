package com.sanemizci.starter.service.impl;

import com.sanemizci.starter.dto.DtoCar;
import com.sanemizci.starter.dto.DtoCarIU;
import com.sanemizci.starter.model.Car;
import com.sanemizci.starter.repository.CarRepository;
import com.sanemizci.starter.service.ICarService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CarServiceImpl implements ICarService {

    @Autowired
    private CarRepository carRepository;

    private Car createCar(DtoCarIU dtoCarIU){
        Car car = new Car();
        car.setCreateTime(new Date());
        BeanUtils.copyProperties(dtoCarIU, car);
        return car;
    }
    @Override
    public DtoCar saveCar(DtoCarIU dtoCarIU) {
        DtoCar dtoCar = new DtoCar();
        Car savedCar=carRepository.save(createCar(dtoCarIU));
        BeanUtils.copyProperties(savedCar, dtoCar);
        return dtoCar;
    }
}
