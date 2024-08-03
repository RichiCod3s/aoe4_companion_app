package com.example.aoe4springapi.api.model;

public class WeakAgainst {
    private int unitId;
    private int enemyId;

    public WeakAgainst(int unitId, int enemyId) {
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
