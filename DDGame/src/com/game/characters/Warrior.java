package com.game.characters;

public class Warrior extends Hero {

    public Warrior() {
        super();
    }

    public Warrior(String pName) {
        super(pName);
        this.health = 5;
        this.strength = 5;
        this.maxHealth = 10;
        this.maxStrength = 10;
        System.out.println("Création d'un Guerrier avec " + this.health + " points de vie et " + this.strength + " points d'attaque.");
    }

    public Warrior(String pName, String spell, int health, int pStrength) {
        super(pName, health, spell, pStrength);
        System.out.println("Création d'un Guerrier avec tous les paramètres");
    }


    public void characterReset() {
        this.setHealth(this.minHealth);
        this.setStrength(this.minStrength);
        this.setWeapon("inconnu");
        System.out.println(this.name + " reviens à " + this.health + " points de vie et " + this.strength + " points d'attaque."
                + "Il n'a plus d'arme.");
    }
}
