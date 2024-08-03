package com.example.aoe4springapi.api.controller;

import com.example.aoe4springapi.api.model.Unit;
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
    public Unit getUnit(@RequestParam Integer id){
        Optional unit = unitsService.getUnit(id);
        if(unit.isPresent()){
            return (Unit) unit.get();
        }
        return null;
    }

}
