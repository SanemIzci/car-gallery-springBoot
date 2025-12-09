package com.sanemizci.starter.service.impl;

import com.sanemizci.starter.dto.DtoCar;
import com.sanemizci.starter.dto.DtoCarIU;
import com.sanemizci.starter.exception.BaseException;
import com.sanemizci.starter.exception.ErrorMessage;
import com.sanemizci.starter.exception.MessageType;
import com.sanemizci.starter.model.Car;
import com.sanemizci.starter.repository.CarRepository;
import com.sanemizci.starter.repository.GalleryCarsRepository;
import com.sanemizci.starter.service.ICarService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@Service
public class CarServiceImpl implements ICarService {

    @Autowired
    private CarRepository carRepository;
    @Autowired
    private GalleryCarsRepository galleryCarsRepository;

    private Car createCar(DtoCarIU dtoCarIU) {
        Car car = new Car();
        car.setCreateTime(new Date());
        BeanUtils.copyProperties(dtoCarIU, car);
        return car;
    }

    @Override
    public DtoCar saveCar(DtoCarIU dtoCarIU) {
        DtoCar dtoCar = new DtoCar();
        Car savedCar = carRepository.save(createCar(dtoCarIU));
        BeanUtils.copyProperties(savedCar, dtoCar);
        return dtoCar;
    }

    private Car findCarById(Long id) {
        Optional<Car> optionalCar = carRepository.findById(id);
        if (optionalCar.isEmpty()) {
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXISTS, id.toString()));
        }
        return optionalCar.get();
    }

    @Override
    public DtoCar getCarById(Long id) {
        Car car = findCarById(id);
        DtoCar dtoCar = new DtoCar();
        BeanUtils.copyProperties(car, dtoCar);
        return dtoCar;
    }

    @Override
    public DtoCar updateCar(Long id, DtoCarIU dtoCarIU) {
        Car car = findCarById(id);
        car.setCarStatusType(dtoCarIU.getCarStatusType());
        car.setBrandName(dtoCarIU.getBrandName());
        car.setCurrency(dtoCarIU.getCurrency());
        car.setDamageCost(dtoCarIU.getDamageCost());
        car.setPrice(dtoCarIU.getPrice());
        car.setPlateNumber(String.valueOf(dtoCarIU.getPlateNumber()));
        car.setProductionYear(dtoCarIU.getProductionYear());
        car.setModel(dtoCarIU.getModel());

        carRepository.save(car);
        DtoCar dtoCar = new DtoCar();
        BeanUtils.copyProperties(car, dtoCar);

        return dtoCar;
    }

    @Override
    @Transactional
    public DtoCar deleteCar(Long id) {
        Car car = findCarById(id);
        galleryCarsRepository.deleteByCar_Id(id);
        carRepository.delete(car);
        DtoCar dtoCar = new DtoCar();
        BeanUtils.copyProperties(car, dtoCar);
        return dtoCar;
    }
}
