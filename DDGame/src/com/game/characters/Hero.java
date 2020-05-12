package com.game.characters;

import java.util.Scanner;

public class Hero {
    private String name;
    private int health;
    Scanner scan = new Scanner(System.in);

    public Hero() {
        this.name = "inconnu";
        this.health = 10;
    }

    public Hero(String pName) {
        this.name = pName;
        this.health = 10;
    }

    public Hero(String pName, int health) {
        this.name = pName;
        this.health = health;
    }

    public String checkUserInput() {
        String newInput = scan.nextLine();
        if (newInput.equalsIgnoreCase("quit")) {
            System.exit(0);
        }
        return newInput;
    }

    public Object createChar() {
        String choice, nomPerso, weapon;
        Hero perso;

        System.out.println("Quel est le nom de ton perso ?");
        nomPerso = checkUserInput();

        System.out.println("Voulez vous faire un Guerrier ou un Witcher ?");

        while (true) {
            choice = checkUserInput();
            if (choice.equalsIgnoreCase("Guerrier")) {
                System.out.println("Quel arme a t'il ? Épée (+5 en attaque) / Massue (+3 en attaque)");
                weapon = checkUserInput();
                perso = new Warrior(nomPerso, weapon);
                break;
            } else if (choice.equalsIgnoreCase("Witcher")) {
                System.out.println("Quel sort a t'il ? Éclair (+2 en attaque) / Boule de feu (+7 en attaque)");
                weapon = checkUserInput();
                perso = new Witcher(nomPerso, weapon);
                break;
            } else {
                System.out.println("Mauvais choix ");
            }
        }
        return perso;
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
