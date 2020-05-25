package com.game;

import com.game.characters.*;
import com.game.play.Game;

import java.util.Scanner;
import com.game.DBConnection;
/**
 * Fonction responsable des menus du jeu
 */
public class Menu {
    private String gameStatus;
    private String userInput;
    private DBConnection connection = new DBConnection();

    Scanner scan = new Scanner(System.in);

    // ===== USER ACTIONS ====//
    //=============================//

    /**
     * Check les inputs du user et vérifie s'il veut quitter ou non
     * @return input de l'utilisateur
     */
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

    /**
     * Une fois le perso créé, propose à l'utilisateur un menu lui permettant de jouer, modifier son perso
     * ou quitter. S'il choisit de modifier son perso on reprend la première étape, soit createChar();
     * @param perso
     */
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

    /**
     * Fonction de création de personnage:
     * On demande un nom, et une classe, guerrier ou witcher. On retourne ensuite un objet de type guerrier
     * ou witcher
     * @return witcher ou guerrier
     */

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

    /**
     * Fonction appelé au commencement du jeu, pour créer le perso puis appelé le menu principal
     */
    public void start() {
        Hero mainChar = createChar();
        mainMenu(mainChar);
    }

    /**
     * Fonction de sortie du système
     */
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
