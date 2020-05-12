package com.game.characters;

public class Warrior {
    private String name;
    private int healthPoints;
    private int strength;
    private String weapon;

    public Warrior() {
        System.out.println("Création d'un wawa");
        this.name = "inconnu";
        this.healthPoints = 0;
        this.weapon = "inconnu";
        this.strength = 0;
    }

    public Warrior(String pName) {
        System.out.println("Création d'un wawa avec paramètres");
        this.name = pName.toString();
        this.healthPoints = 10;
        this.weapon = "inconnu";
        this.strength = 10;
    }

    public Warrior(String pName, String weapon, int health, int pStrength) {
        System.out.println("Création d'un wawa avec tous les paramètres");
        this.name = pName.toString();
        this.healthPoints = (int)health;
        this.weapon = weapon;
        this.strength = (int)pStrength;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealthPoints() {
        return this.healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public String toString() {
        return "Name: " + name +
                " Health: " + healthPoints +
                " Strength: " + strength +
                " Weapon: " + weapon;
    }

}