package com.game.characters;

public class Witcher extends Hero {
    public Witcher() {
        super();
    }

    public Witcher(String pName) {
        super(pName);
        this.health = 3;
        this.strength = 8;
        this.minHealth=3;
        this.maxHealth = 6;
        this.minStrength = 8;
        this.maxStrength = 15;
        System.out.println("Création d'un witcher avec " + this.health + " points de vie et " + this.strength +
                " points d'attaque.");
    }

    public Witcher(String pName, String spell, int health, int pStrength) {
        super(pName, health, spell, pStrength);
        System.out.println("Création d'un witcher avec tous les paramètres");
    }

    public void characterReset() {
        this.setHealth(this.minHealth);
        this.setStrength(this.minStrength);
        this.setWeapon("inconnu");
        System.out.println(this.name + " reviens à " + this.health + " points de vie et " + this.strength + " points d'attaque."
                + "Il n'a plus d'arme.");
    }
}
