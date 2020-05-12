package com.game;

import com.game.characters.*;

import java.util.InputMismatchException;
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

    // ===== PERSONNAGE ====//
    //=============================//

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
                perso = (Hero) createChar();
            }
            mainMenu(perso);
        } else if (newInput.equalsIgnoreCase("jouer")) {
            play(perso);
        } else if (newInput.equalsIgnoreCase("quitter")) {
            System.out.println("Vous quittez le jeu");
            System.exit(0);
        }
    }

    //======= GAME ======//
    //==================//

    public void start() {
        Hero mainChar;
        mainChar = (Hero) createChar();
        mainMenu(mainChar);
    }

    public void play(Hero mainChar) {
        int posPlayer;
        posPlayer = 1;
        System.out.println("Vous débuter en case 1");

        while (posPlayer < 64) {
            System.out.println("Appuyer sur entrée pour lancer le dés");
            String newInput = scan.nextLine();
            while (newInput != null) {
                if (newInput.isEmpty()) {
                    int dice = throwDice();
                    System.out.println("Vous faites un " + dice);
                    posPlayer = posPlayer + dice;
                    System.out.println("Vous avancez en case " + (posPlayer));
                    newInput = null;
                }
            }
        }

        System.out.println("Vous avez gagner !! Voulez vous rejouer ou quitter ? rejouer / quitter");
        while (true) {
            String newInput = checkUserInput();
            if (newInput.equalsIgnoreCase("rejouer")) {
                mainMenu(mainChar);
                break;
            } else if (newInput.equalsIgnoreCase("quitter")) {
                System.out.println("Bye bye !");
                System.exit(0);
            } else {
                System.out.println("Hein ?");
            }
        }
    }

    public int throwDice() {
        int dice = (int) (Math.random() * 6 + 1);
        return dice;
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
