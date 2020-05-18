package com.game.events;

import com.game.Printer;
import com.game.characters.Hero;

public class Foe extends Event {

    protected int attackPower;
    protected int health;

    public Foe() {
        this(0, "inconnu", "inconnu", 0, 0);
    }

    public Foe(int posPlateau, String name) {
        this(posPlateau, name, "blabla");
        if (name.equals("Dragon")) {
            this.attackPower = 4;
            this.health = 15;
        } else if (name.equals("Sorcerer")) {
            this.attackPower = 2;
            this.health = 9;
        } else {
            this.attackPower = 1;
            this.health = 6;
        }
    }

    public Foe(int posPlateau, String name, String description) {
        this(posPlateau, name, description, 0, 0);
    }

    public Foe(int posPlateau, String name, String description, int attackPower, int health) {
        super(posPlateau, name, description);
        this.attackPower = attackPower;
        this.health = health;
    }

    public void eventHandler(Hero perso, Event e, Printer p) {
        System.out.println("Début du combat !");
        perso.setHeroStatus("fighting");
        System.out.println(perso.getName() + " attaque le " + this.name + " et lui inflige " + perso.getStrength() + " dégats..");
        this.health = this.health - perso.getStrength();
        if (this.health <= 0) {
            this.posPlateau = 0;
            System.out.println(this.name + " a canné ! Bien joué, vous continuez votre aventure pépère");
            perso.setHeroStatus("moving");
        } else {
            perso.setHealth(perso.getHealth() - this.attackPower);
            if (perso.getHealth() < 0) {
                perso.setHealth(0);
            }
            System.out.println(this.name + " riposte !! Il vous inflige " + this.attackPower + " points de vie , ce batard!" +
                    "Vous êtes maintenant à " + perso.getHealth() + " points de vie.");
            if (perso.getHealth() <= 0) {
                perso.setHealth(0);
                perso.setHeroStatus("moving");
            } else {
                System.out.println(this.name + " a encore " + this.health + " points de vie, il fuit pour le moment mais" +
                        " on est pas rendu...");
            }
        }
    }

    public void attack() {
        System.out.println(this.name + " vous attaque ! Vous subissez " + this.attackPower + " dégats..");
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String toString() {
        this.description = "Un " + this.name + " se trouve sur la case " + this.posPlateau + ". Il a " + this.health + " points de vie et " +
                this.attackPower + " points d'attaque.";
        return this.description;
    }
}
