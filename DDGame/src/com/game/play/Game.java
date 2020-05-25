package com.game.play;

import com.game.Printer;
import com.game.characters.Hero;
import com.game.Menu;
import com.game.events.Event;

import java.util.Scanner;

import com.game.exceptions.*;

/**
 * Classe responsable de toute la logique du jeu
 */
public class Game {
    Scanner scan = new Scanner(System.in);
    private Menu menu;
    private Board board;
    private String difficulty;
    public Printer p;

    public enum Modes {
        NORMAL,
        RANDOM
    }

    /**
     * Constructeur unique, prenant en paramètre le menu créé précédemment, posant quelques questions à l'utilisateur
     * pour mettre sa partie en place:
     * Plateau normal ou random / difficulté
     * Puis instanciation du Printer
     * @param menu
     */
    public Game(Menu menu) {
        this.menu = menu;
        this.board = new Board();
        System.out.println("Voulez vous jouer sur un plateau normal ou aléatoire ? normal / random");
        Modes boardMode = Modes.valueOf(scan.nextLine().toUpperCase());
        if (boardMode == Modes.RANDOM) {
            this.board.setRandomBoardEvents(this.board.getBoardEvents());
        } else if (boardMode == Modes.NORMAL) {
            this.board.setNormalBoardEvents(this.board.getBoardEvents());
        }

        System.out.println("Voulez vous jouer en difficile ou en facile (Possibilité de fuir) ? hard / easy");
        String difficulty = scan.nextLine();
        if (difficulty.equalsIgnoreCase("hard")) {
            this.difficulty = "hard";
            System.out.println("Difficulté : Hard");
        } else {
            this.difficulty = "easy";
            System.out.println("Difficulté: Easy");
        }

        this.p = new Printer();
    }

    /**
     * Fonction responsable de la logique de jeu, avancer, rencontrer un event, gagner ou perdre
     * @param mainChar
     */
    public void play(Hero mainChar) {
        int posPlayer = 1, nbTours = 0;
        int[] scenario = {3, 6, 9, 10, 14, 25, 56, 64};
        int iScenar = 0;

        System.out.println("Voulez vous jouer en mode debug / normal / scenario");
        String mode = scan.nextLine();
        System.out.println("Vous débuter en case 1");

        while (posPlayer < 64) {
            nbTours++;
            boolean victory = false;
            System.out.println("---Tour " + nbTours + "---");
            if (mainChar.getHeroStatus().equals("fighting")) {
                if (this.difficulty.equalsIgnoreCase("hard")) {
                    posPlayer = stillFighting(posPlayer, mainChar);
                } else {
                    posPlayer = stillFightingEasy(posPlayer, mainChar);
                }

                if (mainChar.getHealth() <= 0) {
                    endGame(mainChar, victory);
                }
            }

            if (mode.equalsIgnoreCase("normal")) {
                if (difficulty.equalsIgnoreCase("easy") && mainChar.getHeroStatus().equals("fighting")) {
                    mainChar.setHeroStatus("moving");
                } else {
                    posPlayer = normalMode(posPlayer);
                }
            } else if (mode.equalsIgnoreCase("debug")) {
                posPlayer = debugMode();
            } else {
                posPlayer = scenarMode(iScenar, scenario, posPlayer);
                iScenar++;
            }
            try {
                if (posPlayer > 64) {
                    throw new PersonnageHorsPlateauException(posPlayer);
                } else if (posPlayer == 64) {
                    victory = true;
                    endGame(mainChar, victory);
                } else {
                    System.out.println("Vous êtes maintenant en case " + (posPlayer));
                    Event e = this.board.getBoardEvent(posPlayer);
                    System.out.println(e.toString());
                    e.eventHandler(mainChar, e, p, this.board);
                    if (mainChar.getHealth() <= 0) {
                        endGame(mainChar, victory);
                    }
                }
            } catch (PersonnageHorsPlateauException e) {
                posPlayer = depassementPlateau(posPlayer);
            }
        }

        boolean waitingUserInput = true;
        while (waitingUserInput) {
            System.out.println("Appuyer sur entrée pour passer au tour suivant");
            String newInput = scan.nextLine();
            if (newInput.isEmpty()) {
                waitingUserInput = false;
            }
        }

    }

    /**
     * Si le joueur dépasse le plateau,
     * on lance une exception et il revient en arrière d'un nombre de case équivalent à son dépassement de la case 64
     * @param posPlayer
     * @return
     */
    public int depassementPlateau(int posPlayer) {
        posPlayer = 64 - (posPlayer - 64);
        System.out.println("Vous retournez case " + posPlayer);
        return posPlayer;
    }

    /**
     * Dans le mode de jeu normal on lance les dés et on avance de tant
     * @param posPlayer
     * @return
     */
    public int normalMode(int posPlayer) {
        System.out.println("Appuyer sur entrée pour lancer le dés");
        String newInput = scan.nextLine();
        int dice;
        if (newInput.isEmpty()) {
            dice = throwDice();
            System.out.println("Vous faites un " + dice);
            posPlayer = posPlayer + dice;
        }
        return posPlayer;
    }

    /**
     * en mode debug on entre la case à laquelle on veut se rendre
     * @return
     */
    public int debugMode() {
        System.out.println("À Quelle case voulez vous vous rendre ?");
        return scan.nextInt();
    }

    /**
     * En mode scenar on suit un chemin décris dans une array intitulé scenario
     * @param iScenar
     * @param scenario
     * @param posPlayer
     * @return
     */
    public int scenarMode(int iScenar, int[] scenario, int posPlayer) {
        System.out.println("Appuyez sur entrée pour avancer dans le scénario");
        String newInput = scan.nextLine();
        if (newInput.isEmpty()) {
            posPlayer = scenario[iScenar];
        }
        return posPlayer;
    }

    /**
     * Si le joueur ne s'est pas défait d'un ennemi en une fois, cette fonction est appelée
     * En difficulté hard l'ennemi peut potentiellement fuir si le joueur fait un 6 ou un 1
     * Sinon le combat reprend jusqu'à ce que l'ennemi soit vaincu, au tour par tour
     * @param posPlayer
     * @param mainChar
     * @return
     */
    public int stillFighting(int posPlayer, Hero mainChar) {
        System.out.println("Vous devez encore fighter votre ennemi en case " + posPlayer);
        System.out.println("Vous tentez de faire flipper votre ennemi, lancez les dés. Si vous faites un 1 ou un 6" +
                ", ce dernier fuit, sinon vous devez vous le faire.");
        String nextInput = scan.nextLine();
        if (nextInput.isEmpty()) {
            int tentativeDeFuite = throwDice();
            if (tentativeDeFuite == 1 || tentativeDeFuite == 6) {
                System.out.println("Vous faites un " + tentativeDeFuite + ". Votre ennemi fuit, continuez votre chemin");
                mainChar.setHeroStatus("moving");
            } else {
                System.out.println("Dommage il stand his ground, fumez le..");
                Event e = this.board.getBoardEvent(posPlayer);
                e.eventHandler(mainChar, e, p, this.board);
            }
        }
        return posPlayer;
    }

    /**
     * En easy, il est possible de fuir avant chaque début de nouveau tour de combat, d'un nombre de case aléatoire entre
     * 1 et 6
     * @param posPlayer
     * @param mainChar
     * @return
     */
    public int stillFightingEasy(int posPlayer, Hero mainChar) {
        System.out.println("Vous devez encore fighter votre ennemi en case " + posPlayer);
        System.out.println("Souhaitez vous fuir ? oui / non");
        String nextInput = scan.nextLine();
        if (nextInput.equalsIgnoreCase("oui")) {
            int tentativeDeFuite = throwDice();
            posPlayer = posPlayer - tentativeDeFuite;
            if (posPlayer <= 0) {
                posPlayer = 1;
            }
            System.out.println("Vous reculez de " + tentativeDeFuite + " cases.");
        } else {
            System.out.println("Bon bah fumez le..");
            Event e = this.board.getBoardEvent(posPlayer);
            e.eventHandler(mainChar, e, p, this.board);
        }
        return posPlayer;
    }

    /**
     * Fonction responsable de la fin du jeu, prenant en paramètre un boolean signifiant victoire ou défaite
     * Dans les deux cas on peut rejouer ou quitter
     * @param mainChar
     * @param victory
     */
    public void endGame(Hero mainChar, Boolean victory) {
        if (victory) {
            System.out.println("Vous avez gagné !!");
        } else {
            System.out.println("Arg vous êtes morts...");
        }
        System.out.println("Voulez vous rejouer ou quitter ? rejouer / quitter");
        while (true) {
            String newInput = menu.checkUserInput();
            if (newInput.equalsIgnoreCase("rejouer")) {
                mainChar.characterReset();
                menu.mainMenu(mainChar);
                break;
            } else if (newInput.equalsIgnoreCase("quitter")) {
                System.out.println("Bye bye !");
                menu.shutDown();
            } else {
                System.out.println("Hein ? rejouer / quitter");
            }
        }
    }

    /**
     * Lancer les dés
     * @return resultat de lancée
     */
    public int throwDice() {
        return (int) (Math.random() * 6 + 1);
    }

}
