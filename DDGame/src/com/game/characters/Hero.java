package com.game.characters;

public class Hero {
    private String name;
    private int health;

    public Hero() {
        this.name = "inconnu";
        this.health = 10;
    }

    public Hero(String pName) {
        this.name = pName;
        this.health = 10;
    }

    public Hero(String pName, int health) {
        this.name = pName.toString();
        this.health = (int) health;
    }

    public String toString() {
        return "Name: " + name +
                " Health: " + health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
