package com.game.characters;

public class Warrior extends Hero {
    private int strength;
    private String weapon;

    public Warrior() {
        super();
        this.weapon = "inconnu";
        this.strength = 0;
    }

    public Warrior(String pName) {
        super(pName);
        System.out.println("Création d'un wawa avec paramètres");
        this.weapon = "inconnu";
        this.strength = 10;
    }

    public Warrior(String pName, String weapon, int health, int pStrength) {
        super(pName, health);
        System.out.println("Création d'un wawa avec tous les paramètres");
        this.weapon = weapon;
        this.strength = (int)pStrength;
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
        return super.toString() +
                " Strength: " + strength +
                " Weapon: " + weapon;
    }

}
