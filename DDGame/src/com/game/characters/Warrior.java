package com.game.characters;

public class Warrior extends Hero {
    private int strength;
    private String weapon;

    public Warrior() {
        super();
        this.weapon = "inconnu";
        this.strength = 5;
    }

    public Warrior(String pName, String weapon) {
        super(pName);
        if (weapon.equalsIgnoreCase("épée") || weapon.equalsIgnoreCase("epee")) {
            this.weapon = "Épée";
            this.strength = 10;
        } else {
            this.weapon = "Massue";
            this.strength = 8;
        }
        this.setHealth(10);
        System.out.println("Création d'un guerrier avec " + this.getHealth() + " points de vie et " + this.strength
                + " d'attaque grâce à sa " + this.weapon);

    }

    public Warrior(String pName, String weapon, int health, int pStrength) {
        super(pName, health);
        System.out.println("Création d'un wawa avec tous les paramètres");
        this.weapon = weapon;
        this.strength = (int) pStrength;
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
        return this.getName() + " est un " + this.getClass().getSimpleName() +
                " avec " + this.getHealth() + " points de vie et "+ this.strength +
                " points d'attaque grâce à son arme: " + this.weapon;
    }
}
