package com.game.events;

import com.game.Printer;
import com.game.characters.Hero;
import com.game.characters.Warrior;
import com.game.characters.Witcher;

public abstract class Bonus extends Event {
    protected int bonusIncrease;

    public Bonus() {
        this(0, "inconnu", "inconnu", 0, "inconnu");
    }

    public Bonus(int posPlateau, String name) {
        super(posPlateau, name);
    }

    public Bonus(int posPlateau, String name, String description) {
        this(posPlateau, name, description, 0, "inconnu");
    }

    public Bonus(int posPlateau, String name, String description, int bonusIncrease, String bonusType) {
        super(posPlateau, name, description);
        this.bonusIncrease = bonusIncrease;
    }

    public abstract void eventHandler(Hero perso, Event e, Printer p);
}
