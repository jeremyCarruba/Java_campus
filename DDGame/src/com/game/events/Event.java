package com.game.events;

import com.game.Printer;
import com.game.characters.Hero;
import com.game.play.Board;

/**
 * Classe parente de tous les evenements, implémentant l'interface Square
 */
public abstract class Event implements Square {
    protected int posPlateau;
    protected String name;
    protected String description;

    public Event(int posPlateau) {this(posPlateau, "inconnu", "inconnu");}

    public Event(int posPlateau, String name) {this(posPlateau, name, "");}

    public Event(int posPlateau, String name, String description) {
        this.posPlateau = posPlateau;
        this.name = name;
        this.description = description;
    }

    public int getPosPlateau() {
        return posPlateau;
    }

    @Override
    public abstract void eventHandler(Hero perso, Event e, Printer p, Board board);

    public void setPosPlateau(int posPlateau) {
        this.posPlateau = posPlateau;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return "Vous tombez sur " + this.name + ". " + this.description;
    }
}
