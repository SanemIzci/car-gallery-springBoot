package com.sanemizci.starter.service;

import com.sanemizci.starter.dto.DtoCar;
import com.sanemizci.starter.dto.DtoCarIU;

public interface ICarService {
    public DtoCar saveCar(DtoCarIU dtoCarIU);

    public DtoCar getCarById(Long id);

    public DtoCar updateCar(Long id,DtoCarIU dtoCarIU);

    public DtoCar deleteCar(Long id);
}
