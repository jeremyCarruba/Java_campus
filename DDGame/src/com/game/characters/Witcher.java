package com.game.characters;

public class Witcher extends Hero {
    private int spellStrength;
    private String spell;

    public Witcher() {
        super();
        this.spell = "inconnu";
        this.spellStrength = 0;
    }

    public Witcher(String pName) {
        super(pName);
        System.out.println("Création d'un witcher avec paramètres");
        this.spell = "inconnu";
        this.spellStrength = 10;
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
        return super.toString() +
                " Strength: " + spellStrength +
                " Spell: " + spell;
    }

}
