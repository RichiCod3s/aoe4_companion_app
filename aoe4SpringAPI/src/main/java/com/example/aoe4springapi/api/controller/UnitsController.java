package com.example.aoe4springapi.api.controller;

import com.example.aoe4springapi.api.model.*;
import com.example.aoe4springapi.service.UnitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UnitsController {

    private UnitsService unitsService;

    @Autowired
    public UnitsController(UnitsService unitsService) {
        this.unitsService = unitsService;
    }

    //get unit by id
    @GetMapping("/unit")
    public ConcreteUnit getUnit(@RequestParam Integer id){
        Optional<ConcreteUnit> unit = unitsService.getUnit(id);
        if(unit.isPresent()){
            return (ConcreteUnit) unit.get();
        }
        return null;
    }

    //list all units
    @GetMapping("/units")
    public List<ConcreteUnit> getAllUnits(){
        return unitsService.listAllUnits();
    }

    //create new unit
    @PostMapping("/unit")
    public void createUnit(@RequestBody ConcreteUnit unit){
        unitsService.createUnit(unit);
    }

    @PutMapping("/unit/{id}")
    public void updateUnit(@PathVariable Integer id, @RequestBody ConcreteUnit unit){
        unitsService.updateUnit(unit, id);
    }

    @DeleteMapping("unit/{id}")
    public void deleteUnit(@PathVariable Integer id){
        unitsService.deleteUnit(id);
    }


    /* may be used later
    @GetMapping("/civilization")
    public Civilization getCivilization(@RequestParam Integer id){
        Optional<Civilization> civilization = unitsService.getCivilization(id);
        if(civilization.isPresent()){
            return (Civilization) civilization.get();
        }
        return null;
    }
   */

    }

