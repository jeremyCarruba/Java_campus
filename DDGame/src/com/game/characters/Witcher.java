package com.game.characters;

public class Witcher extends Hero {
    final int MINHEALTH = 3;
    final int MAXHEALTH = 6;
    final int MINSTRENGTH = 8;
    final int MAXSTRENGTH = 15;

    public Witcher() {
        super();
    }

    public Witcher(String pName) {
        super(pName);
        this.health = 3;
        this.strength = 8;
        System.out.println("Création d'un witcher avec " + this.health + " points de vie et " + this.strength +
                " points d'attaque.");
    }

    public Witcher(String pName, String spell, int health, int pStrength) {
        super(pName, health, spell, pStrength);
        System.out.println("Création d'un witcher avec tous les paramètres");
    }

    public void characterReset() {
        this.setHealth(this.MINHEALTH);
        this.setStrength(this.MINSTRENGTH);
        this.setWeapon("inconnu");
        System.out.println(this.name + " reviens à " + this.health + " points de vie et " + this.strength + " points d'attaque."
                + "Il n'a plus d'arme.");
    }

    @Override
    public int getMAXHEALTH() {
        return MAXHEALTH;
    }

    @Override
    public int getMAXSTRENGTH() {
        return MAXSTRENGTH;
    }

    public void findBonus(int strength, int bonusIncrease, String weapon) {
        if(strength>this.MAXSTRENGTH){
            System.out.println("C'est pas la fête non plus, " + this.name + " peut pas porter avoir 1000 sorts non plus, paposs." +
                    "Mais on va dire que c'est toujours cool d'apprendre des sorts, donc " + this.name + " a maintenant " +
                    this.MAXSTRENGTH + " points d'attaque !");
            this.setStrength(this.MAXSTRENGTH);
        } else {
            System.out.println(this.name + " apprend le sort " + weapon + ". Il a maintenant " + (this.strength + bonusIncrease) + " d'attaque !");
            this.setStrength(this.strength + bonusIncrease);
            this.weapon = weapon;
        }
    }
}
