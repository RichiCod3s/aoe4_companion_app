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
    public Unit getUnit(@RequestParam Integer id){
        Optional<Unit> unit = unitsService.getUnit(id);
        if(unit.isPresent()){
            return (Unit) unit.get();
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

    @GetMapping("strongagainst")
    public StrongAgainst getStrongagainst(@RequestParam Integer id){
        Optional<StrongAgainst> strongAgainst = unitsService.getStrongAgainst(id);
        if(strongAgainst.isPresent()){
            return (StrongAgainst) strongAgainst.get();
        }
        return null;
        }

        @GetMapping("weakagainst")
    public WeakAgainst getWeakagainst(@RequestParam Integer id){
        Optional<WeakAgainst> weakAgainst = unitsService.getWeakAgainst(id);
        if(weakAgainst.isPresent()){
            return (WeakAgainst) weakAgainst.get();
        }
        return null;
        }

    @GetMapping("civilizationsunits")
    public CivilizationsUnits getCivilizationUnits(@RequestParam Integer id ){
        Optional<CivilizationsUnits> civilizationUnits = unitsService.getCivilizationsUnits(id);
        if(civilizationUnits.isPresent()){
            return (CivilizationsUnits) civilizationUnits.get();
        }
        return null;
    }
    }

