package com.sanemizci.starter.controller.impl;

import com.sanemizci.starter.controller.IRestCarControler;
import com.sanemizci.starter.controller.RootEntity;
import com.sanemizci.starter.dto.DtoCar;
import com.sanemizci.starter.dto.DtoCarIU;
import com.sanemizci.starter.service.ICarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/api/car")
public class RestCarControllerImpl extends RootEntity implements IRestCarControler {
    @Autowired
    private ICarService carService;

    @PostMapping("/save")
    @Override
    public RootEntity<DtoCar> saveCar(@Valid @RequestBody DtoCarIU dtoCarIU) {
        return ok(carService.saveCar(dtoCarIU));
    }
    @GetMapping("/{id}")
    @Override
    public RootEntity<DtoCar> getCarById(@Valid @PathVariable Long id) {
        return ok(carService.getCarById(id));
    }
    @PutMapping("/{id}")
    @Override
    public RootEntity<DtoCar> updateCar(@PathVariable Long id, @Valid @RequestBody DtoCarIU dtoCarIU) {
        return  ok(carService.updateCar(id, dtoCarIU));
    }
    @DeleteMapping("/{id}")
    @Override
    public RootEntity<DtoCar> deleteCar(@Valid @PathVariable Long id) {
        return ok(carService.deleteCar(id));
    }
}
