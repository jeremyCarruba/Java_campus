package com.game.characters;

public class Witcher extends Hero {
    private int spellStrength;
    private String spell;

    public Witcher() {
        super();
        this.spell = "inconnu";
        this.spellStrength = 0;
    }

    public Witcher(String pName, String spell) {
        super(pName);
        if(spell.equalsIgnoreCase("Boule de feu")) {
            this.spell = "Boule de feu";
            this.spellStrength = 15;
        } else {
            this.spell = "Éclair";
            this.spellStrength = 10;
        }
        this.setHealth(8);
        System.out.println("Création d'un witcher avec " + this.getHealth() + " points de vie et " + this.spellStrength
        + " d'attaque grâce à " + this.spell);
    }

    public Witcher(String pName, String spell, int health, int pStrength) {
        super(pName, health);
        System.out.println("Création d'un witcher avec tous les paramètres");
        this.spell = spell;
        this.spellStrength = (int)pStrength;
    }

    public int getSpellStrength() {
        return spellStrength;
    }

    public void setSpellStrength(int strength) {
        this.spellStrength = strength;
    }

    public String getSpell() {
        return spell;
    }

    public void setSpell(String spell) {
        this.spell = spell;
    }

    public String toString() {
        return this.getName() + " est un " + this.getClass().getSimpleName() +
                " avec " + this.getHealth() + " points de vie et "+ spellStrength +
                " points d'attaque grâce à son sort " + spell;
    }

}
