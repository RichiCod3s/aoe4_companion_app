package com.example.aoe4springapi.api.model;

import java.util.ArrayList;

public  class ConcreteUnit extends EnemyUnit {

    private ArrayList<EnemyUnit> strongAgainst;
    private ArrayList<EnemyUnit> weakAgainst;

    public ConcreteUnit(int id, String unitName, String unitType, String armourType, String attackType) {
        super(id, unitName, unitType, armourType, attackType);
        strongAgainst = new ArrayList<>();
        weakAgainst = new ArrayList<>();
    }

    // some of the methods below we may not need due to pulling data from MySQL

    public void addStrongAgainst(EnemyUnit unit){
        strongAgainst.add(unit);
    }

    public void addWeakAgainst(EnemyUnit unit){
        weakAgainst.add(unit);
    }

    public ArrayList<EnemyUnit> getStrongAgainst() {
        return strongAgainst;
    }

    // not sure if we need this or not // to research database
    public void setStrongAgainst(ArrayList<EnemyUnit> strongAgainst) {
        this.strongAgainst = strongAgainst;
    }
    public ArrayList<EnemyUnit> getWeakAgainst() {
        return weakAgainst;
    }

    // not sure if we need this or not // to research database
    public void setWeakAgainst(ArrayList<EnemyUnit> weakAgainst) {
        this.weakAgainst = weakAgainst;
    }





}

