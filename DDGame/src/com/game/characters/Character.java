package com.game.characters;

public class Character {
    private String name;
    private int health;

    public Character() {
        System.out.println("Création d'un perso");
        this.name = "inconnu";
        this.health = 10;
    }

    public Character(String pName) {
        System.out.println("Création d'un perso avec nom");
        this.name = pName;
        this.health = 10;
    }

    public Character(String pName, int health) {
        System.out.println("Création d'un perso avec tous les paramètres");
        this.name = pName.toString();
        this.health = (int) health;
    }

    public String toString() {
        return "Name: " + name +
                " Health: " + health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
