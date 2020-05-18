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
            shutDown();
        }
        return newInput;
    }

    // ===== MENUS ==============//
    //=============================//

    enum Choices {
        JOUER,
        PERSO,
        QUITTER,
    }

    public void mainMenu(Hero perso) {
        System.out.println("What's next ? Jouer / Perso / Quitter");
        String newInput = checkUserInput();
        Choices choice = Choices.valueOf(newInput.toUpperCase());
        switch (choice) {
            case JOUER:
                Game nouvellePartie = new Game(this);
                nouvellePartie.play(perso);
            case PERSO:
                System.out.println(perso.toString());
                System.out.println("Voulez vous modifier votre perso ? oui / non");
                newInput = checkUserInput();
                if (newInput.equalsIgnoreCase("oui")) {
                    perso = createChar();
                }
                mainMenu(perso);
            case QUITTER:
                System.out.println("Vous quittez le jeu");
                System.exit(0);
        }
    }


    enum PersoChoices {
        GUERRIER,
        WITCHER
    }

    public Hero createChar() {
        boolean waitingForInput = true;
        System.out.println("Quel est le nom de ton perso ?");
        String nomPerso = checkUserInput();
        while (waitingForInput) {
            try {
                System.out.println("Voulez vous faire un Guerrier ou un Witcher ?");
                String newInput = checkUserInput();
                PersoChoices choice = PersoChoices.valueOf(newInput.toUpperCase());
                switch (choice) {
                    case WITCHER:
                        return new Witcher(nomPerso);
                    case GUERRIER:
                        return new Warrior(nomPerso);
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Mauvais choix. Guerrier / Witcher ? ");
            }
        }
        return null;
    }

    public void start() {
        Hero mainChar = createChar();
        mainMenu(mainChar);
    }

    public void shutDown() {
        //Do stuff//
        System.exit(0);
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
