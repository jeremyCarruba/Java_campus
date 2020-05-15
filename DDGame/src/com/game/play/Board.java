package com.game.play;

import com.game.events.*;
import com.game.events.bonuses.Potion;
import com.game.events.bonuses.Spell;
import com.game.events.bonuses.Weapon;

import java.util.*;

public class Board {
    protected TreeMap boardEvents;

    public Board() {
        this.boardEvents = new TreeMap<Integer, Event>();
    }

    public TreeMap getBoardEvents() {
        return boardEvents;
    }

    public Event getBoardEvent(int id){
        return (Event)boardEvents.get(id);
    }

    public void setBoardEvents(TreeMap boardEvents) {
        this.boardEvents = boardEvents;
    }

    public void setNormalBoardEvents(TreeMap boardEvents) {
        this.emptySquares(64);
        this.createGoblins(10);
        this.createFoes(4, new int[] {45, 52, 56, 62}, "Dragon");
        this.createFoes(10, new int[] {10, 20, 25, 32, 35, 36, 37, 40, 44, 47}, "Sorcerer");
        this.createWeapons(5, new int[] {2, 11, 5 ,22, 38}, "Massue");
        this.createWeapons(4, new int[] {19, 26, 42 ,53}, "Épée");
        this.createSpell(5, new int[] {1, 4, 8 ,17 , 23}, "Éclair");
        this.createSpell(2, new int[] {48, 49}, "Boule de feu");
        this.createPotions(6, new int[] {7, 13, 31 ,33, 39, 43}, "Potion standard");
        this.createPotions(2, new int[] {28, 41}, "Grande potion");
    }

    public void emptySquares(int taillePlateau){
        for (int i=1; i<taillePlateau; i++) {
            Event empty = new EmptySquare(i);
            boardEvents.put(i, empty);
        }
    }

    public void createFoes(int number, int[] positions, String foeType) {
        for (int i = 0; i < number; i++) {
            Event Foe = new Foe(positions[i], foeType);
            boardEvents.put(positions[i], Foe);
        }
    }

    public void createGoblins(int number) {
        int position = 3;
        for (int i = 0; i < number; i++) {
            Event Gobelin = new Foe(position, "Gobelin");
            boardEvents.put(position, Gobelin);
            position += 3;
        }
    }

    public void createPotions(int number, int[] positions, String bonusType){
        for (int i = 0; i < number; i++) {
            Event Bonus = new Potion(positions[i], bonusType);
            boardEvents.put(positions[i], Bonus);
        }
    }

    public void createWeapons(int number, int[] positions, String bonusType){
        for (int i = 0; i < number; i++) {
            Event Bonus = new Weapon(positions[i], bonusType);
            boardEvents.put(positions[i], Bonus);
        }
    }

    public void createSpell(int number, int[] positions, String bonusType){
        for (int i = 0; i < number; i++) {
            Event Bonus = new Spell(positions[i], bonusType);
            boardEvents.put(positions[i], Bonus);
        }
    }

    public void listBoardEvents() {
        Set listOfEvents = this.boardEvents.entrySet();
        for (Object listOfEvent : listOfEvents) {
            Map.Entry me = (Map.Entry) listOfEvent;
            System.out.println(me.getKey() + ": " + me.getValue());
        }
    }
}
