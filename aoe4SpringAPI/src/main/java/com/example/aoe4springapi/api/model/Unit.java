package com.example.aoe4springapi.api.model;

public class Unit {
    private int id;
    private String unitName;
    private String unitType; // infantry, cavalry, seige
    private String armourType; // light, heavy, null(seige)
    private String attackType; // melee, ranged

    public Unit(int id, String unitName, String unitType, String armourType, String attackType) {
        this.id = id;
        this.unitName = unitName;
        this.unitType = unitType;
        this.armourType = armourType;
        this.attackType = attackType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public String getArmourType() {
        return armourType;
    }

    public void setArmourType(String armourType) {
        this.armourType = armourType;
    }

    public String getAttackType() {
        return attackType;
    }

    public void setAttackType(String attackType) {
        this.attackType = attackType;
    }
}

