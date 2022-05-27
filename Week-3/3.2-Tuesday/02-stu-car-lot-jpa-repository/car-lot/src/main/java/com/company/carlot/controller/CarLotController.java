package com.company.carlot.controller;

import com.company.carlot.dao.CarLotRepository;
import com.company.carlot.dto.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarLotController {
    @Autowired
    CarLotRepository carLotRepo;

    @RequestMapping(value = "/car", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Car> getAllCar(@RequestParam(required = false)String make, @RequestParam(required = false)String color){
        if (make != null && make != null){
            return carLotRepo.findByMakeAndColor(make,color);
        }
        if (make != null){
            return carLotRepo.findByMake(make);
        }
        if (color != null){
            return carLotRepo.findByColor(color);
        }
        return carLotRepo.findAll();
    }

    @RequestMapping(value = "/car", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Car createCar(@RequestBody Car car){
        return carLotRepo.save(car);
    }
}
