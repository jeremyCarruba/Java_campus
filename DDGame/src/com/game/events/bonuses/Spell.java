package com.game.events.bonuses;

import com.game.Printer;
import com.game.characters.Hero;
import com.game.characters.Witcher;
import com.game.events.Bonus;
import com.game.events.Event;
import com.game.play.Board;

public class Spell extends Bonus {

    public Spell() {
        this(0, "inconnu");
    }

    public Spell(int posPlateau, String name) {
        this(posPlateau, name, "inconnu", 0);
        if (name.equals("Boule de feu")) {
            this.bonusIncrease = 7;
        } else {
            this.bonusIncrease = 2;
        }
        this.description = "Ce sort inflige " + this.bonusIncrease + " points de dégats en plus.";
    }

    public Spell(int posPlateau, String name, String description, int bonusIncrease) {
        super(posPlateau, name, description, bonusIncrease);
    }
    
    public void eventHandler(Hero perso, Event e, Printer p, Board board) {
        if (perso instanceof Witcher) {
            int totalAfterBonus = perso.getStrength() + this.bonusIncrease;
            perso.findBonus(totalAfterBonus, this.bonusIncrease, this.name);
        } else {
            System.out.println(perso.getName() + " est un " + perso.getClass().getSimpleName() + " donc c'est pas tant son truc.");
        }
        board.removeEvent(posPlateau);
        this.posPlateau = 0;
    }
}
