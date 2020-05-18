package com.game.characters;

public class Warrior extends Hero {
    final int MINHEALTH = 5;
    final int MAXHEALTH = 10;
    final int MINSTRENGTH = 5;
    final int MAXSTRENGTH = 10;

    public Warrior() {
        super();
    }

    public Warrior(String pName) {
        super(pName);
        this.health = 5;
        this.strength = 5;
        System.out.println("Création d'un Guerrier avec " + this.health + " points de vie et " + this.strength + " points d'attaque.");
    }

    public Warrior(String pName, String spell, int health, int pStrength) {
        super(pName, health, spell, pStrength);
        System.out.println("Création d'un Guerrier avec tous les paramètres");
    }


    public void characterReset() {
        this.setHealth(this.MINHEALTH);
        this.setStrength(this.MINSTRENGTH);
        this.setWeapon("inconnu");
        System.out.println(this.name + " reviens à " + this.health + " points de vie et " + this.strength + " points d'attaque."
                + "Il n'a plus d'arme.");
    }

    public void findBonus(int strength, int bonusIncrease, String weapon) {
        if(weapon.equalsIgnoreCase(this.weapon)){
            System.out.println("C'est pas la fête non plus, " + this.name + " peut pas porter avoir 1000 armes non plus, paposs.");
        } else {
            System.out.println(this.name + " trouve une " + weapon + ". Il a maintenant " + (this.strength + bonusIncrease) + " d'attaque !");
            this.setStrength(this.strength + bonusIncrease);
            this.weapon = weapon;
        }
    }

    @Override
    public int getMAXHEALTH() {
        return MAXHEALTH;
    }

    @Override
    public int getMAXSTRENGTH() {
        return MAXSTRENGTH;
    }
}
