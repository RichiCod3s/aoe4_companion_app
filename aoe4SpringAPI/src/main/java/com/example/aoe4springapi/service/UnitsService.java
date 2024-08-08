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
    private List<CivilizationsUnits> civilizationsUnitsList;

    public UnitsService() {
        unitList = new ArrayList<>();
        civilizationList  = new ArrayList<>();
        strongAgainstList = new ArrayList<>();
        weakAgainstList = new ArrayList<>();
        civilizationsUnitsList = new ArrayList<>();

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

        // Initialize CivilizationUnits - links civ to unit type
        // spearman example
        CivilizationsUnits s1 = new CivilizationsUnits(1,1);
        CivilizationsUnits s2 = new CivilizationsUnits(2,1);
        CivilizationsUnits s3 = new CivilizationsUnits(4,1);

        civilizationsUnitsList = Arrays.asList(s1, s2, s3);
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

    public Optional<CivilizationsUnits> getCivilizationsUnits(Integer id) {
        Optional<CivilizationsUnits> optional = Optional.empty();
        for (CivilizationsUnits civsUnits : civilizationsUnitsList) {
            if (id == civsUnits.getCivId()){
                optional = Optional.of(civsUnits);
                return optional;
            }
        }
        return optional;
    }
}


