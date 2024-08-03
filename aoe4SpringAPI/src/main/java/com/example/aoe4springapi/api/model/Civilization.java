package com.example.aoe4springapi.api.model;

public class Civilization {
    private int civId;
    private String name;

    public Civilization(int civId, String name) {
        this.civId = civId;
        this.name = name;
    }

    public int getCivId() {
        return civId;
    }

    public void setCivId(int civId) {
        this.civId = civId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
