package com.game.characters;

public class Witcher {
    private String name;
    private int healthPoints;

    private String weapon;
    private int strength;

    public Witcher() {
        System.out.println("Création d'un witcher");
        this.name = "inconnu";
        this.healthPoints = 0;
        this.weapon = "inconnu";
        this.strength = 0;
    }

    public Witcher(String pName) {
        System.out.println("Création d'un witcher avec paramètre");
        this.name = pName.toString();
        this.healthPoints = 10;
        this.weapon ="inconnu";
        this.strength = 10;
    }

    public Witcher(String pName, String weapon, int health, int pStrength) {
        System.out.println("Création d'un witcher avec tous les paramètres");
        this.name = pName.toString();
        this.weapon = weapon;
        this.healthPoints = (int)health;
        this.strength = (int)pStrength;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getStrength() {
        return strength;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public String toString() {
        return "name: " + name +
                " Health: " + healthPoints +
                " Strength: " + strength +
                " Weapon: " + weapon;
    }

}