package com.game.events.bonuses;

import com.game.characters.Hero;
import com.game.characters.Warrior;
import com.game.events.Bonus;
import com.game.events.Event;
import com.game.Printer;

public class Weapon extends Bonus {

    public Weapon() {
    }

    public Weapon(int posPlateau, String name) {
        this(posPlateau, name, "blabla", 0);
        if (name.equals("Massue")) {
            this.bonusIncrease = 3;
        } else {
            this.bonusIncrease = 5;
        }
        this.description = "Cette arme inflige " + this.bonusIncrease + " points de dégats en plus.";
    }

    public Weapon(int posPlateau, String name, String description, int bonusIncrease) {
        super(posPlateau, name, description, bonusIncrease);
    }

    public void eventHandler(Hero perso, Event e, Printer p) {
        if(this.name.equalsIgnoreCase("Épée")) {
            p.printSword();
        }else{
            p.printMass();
        }

        if (perso instanceof Warrior) {
            if (this.name.equals(perso.getWeapon())) {
                System.out.println("C'est pas la fête non plus, " + perso.getName() + " peut pas porter 1000 trucs non plus, paposs");
            } else if((perso.getStrength() + this.bonusIncrease <= perso.getMAXSTRENGTH()) || perso.getWeapon().equals("inconnu")){
                System.out.println(perso.getName() + " chope une " + this.name + ". Il a maintenant " + (5 + this.bonusIncrease) + " d'attaque !");
                perso.setStrength(5 + this.bonusIncrease);
                perso.setWeapon(this.name);
            }
        } else {
            System.out.println(perso.getName() + " tombe sur " + this.name + " mais c'est pas tant son truc.");
        }
        this.posPlateau = 0;
    }
}
