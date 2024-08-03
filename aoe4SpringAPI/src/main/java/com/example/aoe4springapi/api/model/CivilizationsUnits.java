package com.example.aoe4springapi.api.model;

public class CivilizationsUnits {
    private int civId;
    private int unitId;

    public CivilizationsUnits(int civId, int unitId) {
        this.civId = civId;
        this.unitId = unitId;
    }

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public int getCivId() {
        return civId;
    }

    public void setCivId(int civId) {
        this.civId = civId;
    }
}
