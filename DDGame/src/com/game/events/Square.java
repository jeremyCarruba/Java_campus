package com.game.events;

import com.game.Printer;
import com.game.characters.Hero;
import com.game.play.Board;

/**
 * Interface implementant les eventHandler sur toutes mes cases descendant de event
 */
public interface Square {
    void eventHandler(Hero perso, Event e, Printer p, Board board);
}
