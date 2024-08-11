package com.example.aoe4springapi.api.controller;

import com.example.aoe4springapi.api.model.*;
import com.example.aoe4springapi.service.UnitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UnitsController {

    private UnitsService unitsService;

    @Autowired
    public UnitsController(UnitsService unitsService) {
        this.unitsService = unitsService;
    }

    @GetMapping("/unit")
    public ConcreteUnit getUnit(@RequestParam Integer id){
        Optional<ConcreteUnit> unit = unitsService.getUnit(id);
        if(unit.isPresent()){
            return (ConcreteUnit) unit.get();
        }
        return null;
    }

    @GetMapping("/civilization")
    public Civilization getCivilization(@RequestParam Integer id){
        Optional<Civilization> civilization = unitsService.getCivilization(id);
        if(civilization.isPresent()){
            return (Civilization) civilization.get();
        }
        return null;
    }

    }

