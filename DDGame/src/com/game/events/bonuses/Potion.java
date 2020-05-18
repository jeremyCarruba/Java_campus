package com.game.events.bonuses;

import com.game.characters.Hero;
import com.game.events.Bonus;
import com.game.events.Event;
import com.game.Printer;

public class Potion extends Bonus {

    public Potion() {
    }

    public Potion(int posPlateau, String name) {
        super(posPlateau, name);
        if (name.equals("Potion standard")) {
            this.bonusIncrease = 2;
        } else {
            this.bonusIncrease = 5;
        }
    }

    public Potion(int posPlateau, String name, String description, int bonusIncrease, String bonusType) {
        super(posPlateau, name, description, bonusIncrease, bonusType);
    }

    public void eventHandler(Hero perso, Event e, Printer p) {
        p.printPotion();
        System.out.println(perso.getName() + " trouve une " + this.name + " et ça lui plait.");
        int totalAfterBonus = perso.getHealth() + this.bonusIncrease;
        if (totalAfterBonus <= perso.getMaxHealth()) {
            System.out.println(perso.getName() + " boit la " + this.name + " et gagne " + this.bonusIncrease + " points de vie !" +
                    "Il a maintenant " + totalAfterBonus + " points de vie.");
            perso.setHealth(totalAfterBonus);
        } else {
            perso.setHealth(perso.getMaxHealth());
            System.out.println("Ça fait du bien mais ça repousse pas les limites non plus, " + perso.getName() + " est au max" +
                    " de sa vie, soit " + perso.getMaxHealth() + " points de vie.");
        }
        this.posPlateau = 0;
    }
}
