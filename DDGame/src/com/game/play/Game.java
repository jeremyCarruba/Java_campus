package com.game.play;

import com.game.Printer;
import com.game.characters.Hero;
import com.game.Menu;
import com.game.events.Event;

import java.util.Scanner;

import com.game.events.Foe;
import com.game.exceptions.*;

public class Game {
    Scanner scan = new Scanner(System.in);
    private Menu menu;
    private Board board;
    public Printer p;

    public Game(Menu menu) {
        this.menu = menu;
        this.board = new Board();
        System.out.println("Voulez vous jouer sur un plateau normal ou aléatoire ? normal / random");
        String boardMode = scan.nextLine();
        if (boardMode.equalsIgnoreCase("random")) {
            this.board.setRandomBoardEvents(this.board.getBoardEvents());
        } else {
            this.board.setNormalBoardEvents(this.board.getBoardEvents());
        }
        this.p = new Printer();
    }

    public void play(Hero mainChar) {
        int posPlayer = 1, nbTours = 0;
        int[] scenario = {3, 6, 9, 10, 14, 25, 56, 64};
        int iScenar = 0;

        System.out.println("Voulez vous jouer en mode debug / normal / scenario");
        String mode = scan.nextLine();
        System.out.println("Vous débuter en case 1");

        while (posPlayer < 64) {
            nbTours++;
            System.out.println("---Tour " + nbTours + "---");
            if (mainChar.getHeroStatus().equals("fighting")) {
                stillFighting(posPlayer, mainChar);
            } else {
                if (mode.equalsIgnoreCase("normal")) {
                    posPlayer = normalMode(posPlayer);
                } else if (mode.equalsIgnoreCase("debug")) {
                    posPlayer = debugMode();
                } else {
                    posPlayer = scenarMode(iScenar, scenario, posPlayer);
                    iScenar++;
                }
            }
            try {
                boolean victory = false;
                if (mainChar.getHealth() <= 0) {
                    endGame(mainChar, victory);
                }

                if (posPlayer > 64) {
                    throw new PersonnageHorsPlateauException(posPlayer);
                } else if (posPlayer == 64) {
                    victory = true;
                    endGame(mainChar, victory);
                } else {
                    System.out.println("Vous avancez en case " + (posPlayer));
                    Event e = this.board.getBoardEvent(posPlayer);
                    System.out.println(e.toString());
                    e.eventHandler(mainChar, e, p);
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

    public int depassementPlateau(int posPlayer) {
        posPlayer = 64 - (posPlayer - 64);
        System.out.println("Vous retournez case " + posPlayer);
        return posPlayer;
    }

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

    public int debugMode() {
        System.out.println("À Quelle case voulez vous vous rendre ?");
        return scan.nextInt();
    }

    public int scenarMode(int iScenar, int[] scenario, int posPlayer) {
        System.out.println("Appuyez sur entrée pour avancer dans le scénario");
        String newInput = scan.nextLine();
        if (newInput.isEmpty()) {
            posPlayer = scenario[iScenar];
        }
        return posPlayer;
    }

    public void stillFighting(int posPlayer, Hero mainChar) {
        System.out.println("Vous devez encore fighter votre ennemi en case " + posPlayer);
        System.out.println("Vous tentez de faire flipper votre ennemi, lancez les dés. Si vous faites un 1 ou un 6" +
                ", ce dernier fuit, sinon vous devez vous le faire.");
        String nextInput = scan.nextLine();
        if(nextInput.isEmpty()) {
            int tentativeDeFuite = throwDice();
            if (tentativeDeFuite == 1 || tentativeDeFuite == 6) {
                System.out.println("Vous faites un " + tentativeDeFuite + ". Votre ennemi fuit, continuez votre chemin");
                mainChar.setHeroStatus("moving");
            } else {
                System.out.println("Dommage il stand his ground, fumez le..");
                Event e = this.board.getBoardEvent(posPlayer);
                e.eventHandler(mainChar, e, p);
                if(((Foe)e).getHealth() <= 0){
                    posPlayer = posPlayer+ throwDice();
                    System.out.println("Vous relancez les dés et avancez en case " + posPlayer);
                    mainChar.setHeroStatus("moving");
                }
            }
        }
    }

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
                System.exit(0);
            } else {
                System.out.println("Hein ? rejouer / quitter");
            }
        }
    }

    public int throwDice() {
        return (int) (Math.random() * 6 + 1);
    }

}
