package com.example.aoe4springapi.service;

import com.example.aoe4springapi.api.model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UnitsService {

    private List<ConcreteUnit> unitList;
    private List<Civilization> civilizationList;


    public UnitsService() {
        unitList = new ArrayList<>();
        civilizationList  = new ArrayList<>();


        //Initialize Units
        ConcreteUnit spearman = new ConcreteUnit(1, "Spearman", "Infantry", "Light", "Melee");
        ConcreteUnit archer = new ConcreteUnit(2, "Archer", "Infantry", "Light", "Ranged");
        ConcreteUnit horseman = new ConcreteUnit(3, "Horseman", "Cavalry", "Light", "Melee");
        ConcreteUnit springald = new ConcreteUnit(4, "Springald", "Siege", null, "Ranged");

        unitList.addAll(Arrays.asList(spearman, archer, horseman, springald));

        //Initialize Civilizations

        Civilization abbasidDynasty = new Civilization(1, "Abbasid Dynasty");
        Civilization ayyubids = new Civilization(2, "Ayyubids");
        Civilization byzantines = new Civilization(3, "Byzantines");
        Civilization chinese = new Civilization(4, "Chinese");

        civilizationList.addAll(Arrays.asList(abbasidDynasty, ayyubids, byzantines,chinese));

    }

    public Optional<ConcreteUnit> getUnit(Integer id) {
        Optional<ConcreteUnit> optional = Optional.empty();
        for (ConcreteUnit unit : unitList) {
            if (id== unit.getId()) {
                optional = Optional.of(unit);
                return optional;
            }
        }
        return optional;
    }

    public Optional<Civilization> getCivilization(Integer id) {
        Optional<Civilization> optional = Optional.empty();
        for (Civilization civilization : civilizationList) {
            if(id == civilization.getCivId()){
                optional = Optional.of(civilization);
                return optional;
            }
        }
        return optional;
    }


}


