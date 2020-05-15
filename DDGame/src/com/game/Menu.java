package com.game;

import com.game.characters.*;
import com.game.play.Game;

import java.util.Scanner;

public class Menu {
    private String gameStatus;
    private String userInput;

    Scanner scan = new Scanner(System.in);

    // ===== USER ACTIONS ====//
    //=============================//

    public String checkUserInput() {
        String newInput = scan.nextLine();
        if (newInput.equalsIgnoreCase("quit")) {
            System.exit(0);
        }
        return newInput;
    }

    // ===== MENUS ==============//
    //=============================//

    public void mainMenu(Hero perso) {

        System.out.println("What's next ? Jouer / Perso / Quitter");
        String newInput = checkUserInput();
        if (newInput.equalsIgnoreCase("perso")) {

            System.out.println(perso.toString());
            System.out.println("Voulez vous modifier votre perso ? oui / non");

            newInput = checkUserInput();

            if (newInput.equalsIgnoreCase("oui")) {
                perso = createChar();
            }

            mainMenu(perso);
        } else if (newInput.equalsIgnoreCase("jouer")) {
            Game nouvellePartie = new Game(this);
            nouvellePartie.play(perso);
        } else if (newInput.equalsIgnoreCase("quitter")) {
            System.out.println("Vous quittez le jeu");
            System.exit(0);
        }
    }

    public Hero createChar() {
        String choice, nomPerso, weapon;
        Hero perso;
        System.out.println("Quel est le nom de ton perso ?");
        nomPerso = checkUserInput();

        System.out.println("Voulez vous faire un Guerrier ou un Witcher ?");
        while (true) {
            choice = checkUserInput();
            if (choice.equalsIgnoreCase("Guerrier")) {
                perso = new Warrior(nomPerso);
                break;
            } else if (choice.equalsIgnoreCase("Witcher")) {
                perso = new Witcher(nomPerso);
                break;
            } else {
                System.out.println("Mauvais choix. Guerrier / Witcher ? ");
            }
        }
        return perso;
    }

    public void start() {
        Hero mainChar = createChar();
        mainMenu(mainChar);
    }

    // ===== Getters / Setters ====//
    //=============================//

    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    public String getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(String gameStatus) {
        this.gameStatus = gameStatus;
    }
}
