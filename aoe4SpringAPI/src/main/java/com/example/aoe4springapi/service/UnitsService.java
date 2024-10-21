package com.example.aoe4springapi.service;

import com.example.aoe4springapi.api.model.*;
import com.example.aoe4springapi.dao.UnitRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UnitsService {


    private final UnitRepository unitRepository;

    public UnitsService(UnitRepository unitRepository) {
    this.unitRepository = unitRepository;
    }

    public List<ConcreteUnit> listAllUnits() {
        return unitRepository.list();
    }

        public Optional<ConcreteUnit> getUnit(int id) {
            Optional<ConcreteUnit> unit = unitRepository.get(id);
            if (unit.isPresent()) {
                ConcreteUnit concreteUnit = unit.get();
                // get strength and weakness lists
                concreteUnit.getStrongAgainst().addAll(unitRepository.retrieveStrongAgainst(id));
                concreteUnit.getWeakAgainst().addAll(unitRepository.retrieveWeakAgainst(id));
            }
            return unit;
        }


    public void createUnit(ConcreteUnit unit) {

        unitRepository.create(unit);
    }

    public void updateUnit(ConcreteUnit unit, int id) {

        unitRepository.update(unit, id);
    }

    public void deleteUnit(int id) {
        unitRepository.delete(id);
    }

}


