package com.example.aoe4springapi.service;

import com.example.aoe4springapi.api.model.Unit;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UnitsService {

    private List<Unit> unitList;

    public UnitsService() {
        unitList = new ArrayList<>();

        Unit spearman = new Unit(1, "Spearman", "Infantry", "Light", "Melee");
        Unit archer = new Unit(2, "Archer", "Infantry", "Light", "Ranged");
        Unit horseman = new Unit(3, "Horseman", "Cavalry", "Light", "Melee");
        Unit springald = new Unit(4, "Springald", "Siege", null, "Ranged");

        unitList.addAll(Arrays.asList(spearman, archer, horseman, springald));
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

}


