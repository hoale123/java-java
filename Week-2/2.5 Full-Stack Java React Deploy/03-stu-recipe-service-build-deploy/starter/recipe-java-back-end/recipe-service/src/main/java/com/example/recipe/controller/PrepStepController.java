package com.example.recipe.controller;

import com.example.recipe.repository.PrepStepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrepStepController {

    @Autowired
    PrepStepRepository repo;

}
