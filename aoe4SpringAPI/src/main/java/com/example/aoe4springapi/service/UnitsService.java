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
       return unitRepository.get(id);
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


