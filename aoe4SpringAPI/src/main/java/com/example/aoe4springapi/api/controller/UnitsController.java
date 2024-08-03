package com.example.aoe4springapi.api.controller;

import com.example.aoe4springapi.api.model.Civilization;
import com.example.aoe4springapi.api.model.StrongAgainst;
import com.example.aoe4springapi.api.model.Unit;
import com.example.aoe4springapi.api.model.WeakAgainst;
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
    }