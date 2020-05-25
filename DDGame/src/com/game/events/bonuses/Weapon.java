package com.game.events.bonuses;

import com.game.characters.Hero;
import com.game.characters.Warrior;
import com.game.events.Bonus;
import com.game.events.Event;
import com.game.Printer;
import com.game.play.Board;

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

    public void eventHandler(Hero perso, Event e, Printer p, Board board) {
        if(this.name.equalsIgnoreCase("Épée")) {
            p.printSword();
        }else{
            p.printMass();
        }

        if (perso instanceof Warrior) {
            int totalAfterBonus = perso.getStrength() + this.bonusIncrease;
            perso.findBonus(totalAfterBonus, this.bonusIncrease, this.name);
        } else {
            System.out.println(perso.getName() + " est un " + perso.getClass().getSimpleName() + " donc c'est pas tant son truc.");
        }
        board.removeEvent(posPlateau);
        this.posPlateau = 0;
    }
}
