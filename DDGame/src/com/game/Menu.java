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
    
    // --- Commentaire Flo --- //
    // System.exit(0) c'est un peu bourrin -> tu peux peut être avoir 
    // besoin de faire des choses avant de quitter : sauvegarder des trucs en BDD; etc.
    // --- Fin Commentaire Flo --- //
    public String checkUserInput() {
        String newInput = scan.nextLine();
        if (newInput.equalsIgnoreCase("quit")) {
            System.exit(0);
        }
        return newInput;
    }

    // ===== MENUS ==============//
    //=============================//

    // --- Commentaire Flo --- //
    // 1. Transforme tes choix (perso, Jouer, quitter, ....) en class Enum -> plus propre.
    // 2. Structure swith case plus jolie à regarder
    // --- Fin Commentaire Flo --- //
    
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

    // --- Commentaire Flo --- //
    // Ici tu peux faire un peu plus sexy comme code
    // 1. weapon n'est pas utilisé
    // 2. La portée des tes variables est mal controlée -> choice & nomPerso ne 
    //         sont utilisés que dans le while mais ont une portée au niveau de la fonction
    // 3. Pas besoin de déclarer Hero perso -> fais plutôt direct 
    //          if (choice.equalsIgnoreCase("Guerrier")) {
    //                return new Warrior(nomPerso);
    //          }
    // 4. Fais des classes Enum pour tes choix
    // --- Fin Commentaire Flo --- //
    
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
