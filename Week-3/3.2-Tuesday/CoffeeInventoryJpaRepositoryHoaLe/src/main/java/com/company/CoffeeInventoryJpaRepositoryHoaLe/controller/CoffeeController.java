package com.company.CoffeeInventoryJpaRepositoryHoaLe.controller;

import com.company.CoffeeInventoryJpaRepositoryHoaLe.dto.Coffee;
import com.company.CoffeeInventoryJpaRepositoryHoaLe.repository.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CoffeeController {

    @Autowired
    CoffeeRepository coffeesRepository;


    @RequestMapping(value = "/coffee", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Coffee> getAllCoffee(@RequestParam(required = false) String type, @RequestParam(required = false) Integer roasterId) {
        if (type!= null && roasterId != null){
            return coffeesRepository.findByTypeAndRoasterId(type,roasterId);
        }
        if (type!= null){
            return coffeesRepository.findByType(type);
        }
        if (roasterId!= null){
            return coffeesRepository.findByRoasterId(roasterId);
        }
        return coffeesRepository.findAll();

    }

    @RequestMapping(value = "/coffee", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Coffee createCoffees(@RequestBody Coffee coffee) {
        return coffeesRepository.save(coffee);
    }
}