package com.game.events.bonuses;

import com.game.characters.Hero;
import com.game.characters.Witcher;
import com.game.events.Bonus;
import com.game.events.Event;

public class Spell extends Bonus {

    public Spell() {
        if (name.equals("Boule de feu")) {
            this.bonusIncrease = 7;
        } else {
            this.bonusIncrease = 2;
        }
    }

    public Spell(int posPlateau, String name) {
        super(posPlateau, name);
        if (name.equals("Spell standard")) {
            this.bonusIncrease = 2;
        } else if (name.equals("Grande Spell")) {
            this.bonusIncrease = 5;
        }
    }

    public Spell(int posPlateau, String name, String description, int bonusIncrease, String bonusType) {
        super(posPlateau, name, description, bonusIncrease, bonusType);
    }

    public void eventHandler(Hero perso, Event e) {
        if (perso instanceof Witcher) {
            int totalAfterBonus = perso.getStrength() + this.bonusIncrease;
            if (totalAfterBonus>perso.getMaxStrength()) {
                System.out.println("C'est pas la fête non plus, " + perso.getName() + " peut pas porter avoir 1000 sorts non plus, paposs." +
                        "Mais on va dire que c'est toujours cool d'apprendre des sorts, donc " + perso.getName() + " a maintenant " +
                        perso.getMaxStrength() + " points d'attaque !");
                perso.setStrength(perso.getMaxStrength());
            } else {
                System.out.println(perso.getName() + " apprend le sort " + this.name + ". Il a maintenant " + (perso.getStrength() + this.bonusIncrease) + " d'attaque !");
                perso.setStrength(5 + this.bonusIncrease);
                perso.setWeapon(this.name);
            }
        } else {
            System.out.println(perso.getName() + " tombe sur " + this.name + " mais c'est pas tant son truc.");
        }
        this.posPlateau = 0;
    }
}
