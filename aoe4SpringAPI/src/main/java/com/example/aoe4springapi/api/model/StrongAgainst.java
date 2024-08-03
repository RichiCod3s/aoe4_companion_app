package com.example.aoe4springapi.api.model;

public class StrongAgainst {
    private int unitId;
    private int enemyId;

    public StrongAgainst(int unitId, int enemyId) {
        this.unitId = unitId;
        this.enemyId = enemyId;
    }

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public int getEnemyId() {
        return enemyId;
    }

    public void setEnemyId(int enemyId) {
        this.enemyId = enemyId;
    }
}

