package com.sanemizci.starter.service;

import com.sanemizci.starter.dto.DtoCar;
import com.sanemizci.starter.dto.DtoCarIU;

public interface ICarService {

    public DtoCar saveCar(DtoCarIU dtoCarIU);
}
