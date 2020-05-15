package com.game.events;

import com.game.characters.Hero;

public class EmptySquare extends Event{
    public EmptySquare(int posPlateau) {
        super(posPlateau);
    }

    public EmptySquare(int posPlateau, String name) {
        super(posPlateau, name);
    }

    public EmptySquare(int posPlateau, String name, String description) {
        super(posPlateau, name, description);
    }

    public void eventHandler(Hero perso, Event e) {
        System.out.println("rien");
    }

    public String toString() {
        return "La case " + this.posPlateau + " est vide";
    }
}
