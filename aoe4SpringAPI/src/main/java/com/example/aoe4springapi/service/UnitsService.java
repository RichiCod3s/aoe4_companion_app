package com.example.aoe4springapi.service;

import com.example.aoe4springapi.api.model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UnitsService {

    private List<Unit> unitList;
    private List<Civilization> civilizationList;
    private List<StrongAgainst> strongAgainstList;
    private List<WeakAgainst> weakAgainstList;
    private List<CivilizationsUnits> civilizationsUnitsList;

    public UnitsService() {
        unitList = new ArrayList<>();
        civilizationList  = new ArrayList<>();
        strongAgainstList = new ArrayList<>();
        weakAgainstList = new ArrayList<>();
        civilizationsUnitsList = new ArrayList<>();

        //Initialize Units
        Unit spearman = new Unit(1, "Spearman", "Infantry", "Light", "Melee");
        Unit archer = new Unit(2, "Archer", "Infantry", "Light", "Ranged");
        Unit horseman = new Unit(3, "Horseman", "Cavalry", "Light", "Melee");
        Unit springald = new Unit(4, "Springald", "Siege", null, "Ranged");

        unitList.addAll(Arrays.asList(spearman, archer, horseman, springald));

        //Initialize Civilizations

        Civilization abbasidDynasty = new Civilization(1, "Abbasid Dynasty");
        Civilization ayyubids = new Civilization(2, "Ayyubids");
        Civilization byzantines = new Civilization(3, "Byzantines");
        Civilization chinese = new Civilization(4, "Chinese");

        civilizationList.addAll(Arrays.asList(abbasidDynasty, ayyubids, byzantines,chinese));

        // Initialize StrongAgainst
        StrongAgainst spearmanStrength = new StrongAgainst(1,3);
        StrongAgainst archerStrength = new StrongAgainst(2,1);
        StrongAgainst horsemanStrength = new StrongAgainst(3,2);

        strongAgainstList = Arrays.asList(spearmanStrength, archerStrength, horsemanStrength);

        // Initialize WeakAgainst
        WeakAgainst spearmanWeakness = new WeakAgainst(1,2);
        WeakAgainst archerWeakness = new WeakAgainst(2,3);
        WeakAgainst horsemanWeakness = new WeakAgainst(3,1);

        weakAgainstList = Arrays.asList(spearmanWeakness, archerWeakness, horsemanWeakness);


        // Initialize CivilizationUnits - links civ to unit type
        // spearman example
        CivilizationsUnits s1 = new CivilizationsUnits(1,1);
        CivilizationsUnits s2 = new CivilizationsUnits(2,1);
        CivilizationsUnits s3 = new CivilizationsUnits(4,1);

        civilizationsUnitsList = Arrays.asList(s1, s2, s3);
    }

    public Optional<Unit> getUnit(Integer id) {
        Optional<Unit> optional = Optional.empty();
        for (Unit unit : unitList) {
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

    public Optional<StrongAgainst> getStrongAgainst(Integer id) {
        Optional<StrongAgainst> optional = Optional.empty();
        for (StrongAgainst strongAgainst : strongAgainstList) {
            if (id == strongAgainst.getUnitId()){
                optional = Optional.of(strongAgainst);
                return optional;
            }
        }
        return optional;
    }

    public Optional<WeakAgainst> getWeakAgainst(Integer id) {
        Optional<WeakAgainst> optional = Optional.empty();
        for (WeakAgainst weakAgainst : weakAgainstList) {
            if (id == weakAgainst.getUnitId()){
                optional = Optional.of(weakAgainst);
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


