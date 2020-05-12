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

    public int checkUserInputInt() {
        int newInput = 0;
        while (true) {
            try {
                newInput = scan.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Oops, tu dois rentrer un chiffre");
                scan.next();
            }
        }
        scan.nextLine();
        return newInput;
    }

    // ===== PERSONNAGE ====//
    //=============================//

    public Object createChar() {
        String choice, nomPerso, weapon;
        int pvPerso, strength;
        Hero perso = null;

        System.out.println("Quel est le nom de ton perso ?");
        nomPerso = checkUserInput();

        System.out.println("Combien de pts de vie ?");
        pvPerso = checkUserInputInt();

        System.out.println("Voulez vous faire un Guerrier ou un Witcher ?");

        while (true) {
            choice = checkUserInput();
            if (choice.equalsIgnoreCase("Guerrier")) {
                System.out.println("Quel arme a t'il ?");
                weapon = checkUserInput();

                System.out.println("Quelle est la force de son arme ?");
                strength = checkUserInputInt();

                perso = new Warrior(nomPerso, weapon, pvPerso, strength);
                break;
            } else if (choice.equalsIgnoreCase("Witcher")) {
                System.out.println("Quel sort a t'il ?");
                weapon = checkUserInput();

                System.out.println("Quelle est la force de son sort ?");
                strength = checkUserInputInt();
                perso = new Witcher(nomPerso, weapon, pvPerso, strength);
                break;
            } else {
                System.out.println("Mauvais choix ");
                continue;
            }
        }

        return perso;
    }

    public Object modifyHero(Hero mainChar) {
        String newInput;
        int newInt;
        String heroClass = mainChar.getClass().getSimpleName();
        System.out.println("Quel est son nouveau nom ?");
        newInput = checkUserInput();
        mainChar.setName(newInput);

        if (heroClass.equals("Warrior")) {
            System.out.println("Voulez vous devenir witcher ? oui / non");
            newInput = checkUserInput();
            if (newInput.equalsIgnoreCase("oui")) {
                mainChar = new Witcher();
                heroClass = "Witcher";
            }
        } else {
            System.out.println("Voulez vous devenir warrior ? oui / non");
            newInput = checkUserInput();
            if (newInput.equalsIgnoreCase("oui")) {
                mainChar = new Warrior();
                heroClass = "Warrior";
            }
        }

        if (heroClass.equals("Warrior")) {
            System.out.println("Quel est son arme ?");
            newInput = checkUserInput();
            ((Warrior) mainChar).setWeapon(newInput);

            System.out.println("Quelle est sa force, oui la force ?");
            newInt = checkUserInputInt();
            ((Warrior) mainChar).setStrength(newInt);
        } else {
            System.out.println("Quel est son sort ?");
            newInput = checkUserInput();
            ((Witcher) mainChar).setSpell(newInput);

            System.out.println("Quelle est la force de son sort?");
            newInt = checkUserInputInt();
            ((Witcher) mainChar).setSpellStrength(newInt);
        }

        System.out.println("Combien de pts de vie ?");
        newInt = checkUserInputInt();
        mainChar.setHealth(newInt);

        return mainChar;
    }

    // ===== MENUS ==============//
    //=============================//

    public void mainMenu(Hero perso) {
        System.out.println("What's next ? Play / Character / Quit");
        String newInput = checkUserInput();
        if (newInput.equalsIgnoreCase("character")) {
            System.out.println(perso.toString());
            System.out.println("Voulez vous modifier votre perso ? oui / non");
            newInput = checkUserInput();
            if (newInput.equalsIgnoreCase("oui")) {
                perso = (Hero) modifyHero(perso);
            }
            mainMenu(perso);
        } else if (newInput.equalsIgnoreCase("play")) {

        } else if (newInput.equalsIgnoreCase("quit")) {
            setGameStatus("quit");
            System.out.println("Vous quittez le jeu");
            System.exit(0);
        }
    }

    public void newGame() {
        Hero mainChar;
        setGameStatus("playing");
        mainChar = (Hero) createChar();
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
