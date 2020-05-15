package com.game.play;

import com.game.characters.Hero;
import com.game.Menu;
import com.game.events.Event;
import com.game.play.Board;

import java.util.Hashtable;
import java.util.Scanner;

import com.game.exceptions.*;

public class Game {
    Scanner scan = new Scanner(System.in);
    private Menu menu;
    private Board board;

    public Game(Menu menu) {
        this.menu = menu;
        this.board = new Board();
        this.board.setNormalBoardEvents(this.board.getBoardEvents());
    }

    public void play(Hero mainChar) {
        int posPlayer = 1, nbTours = 1;

        System.out.println("Vous débuter en case 1");

        while (posPlayer < 64) {
            System.out.println("---Tour " + nbTours + "---");
            if (mainChar.getHeroStatus().equals("fighting")) {
                System.out.println("Vous devez encore fighter votre ennemi en case " + posPlayer);
                Event e = this.board.getBoardEvent(posPlayer);
                e.eventHandler(mainChar, e);
            } else {
                System.out.println("Appuyer sur entrée pour lancer le dés");
                String newInput = scan.nextLine();
                int dice;
                if (newInput.isEmpty()) {
                    dice = throwDice();
                    System.out.println("Vous faites un " + dice);
                    posPlayer = posPlayer + dice;
                }
                try {
                    boolean victory = false;
                    if (posPlayer > 64) {
                        throw new PersonnageHorsPlateauException(posPlayer);
                    } else if (posPlayer == 64) {
                        victory = true;
                        endGame(mainChar, victory);
                    } else {
                        System.out.println("Vous avancez en case " + (posPlayer));
                        Event e = this.board.getBoardEvent(posPlayer);
                        System.out.println(e.toString());
                        e.eventHandler(mainChar, e);
                        if (mainChar.getHealth() <= 0) {
                            endGame(mainChar, victory);
                        }
                    }
                } catch (PersonnageHorsPlateauException e) {
                    posPlayer = 64 - (posPlayer - 64);
                    System.out.println("Vous retournez case " + posPlayer);
                }
            }

            boolean waitingUserInput = true;
            while (waitingUserInput) {
                System.out.println("Appuyer sur entrée pour passer au tour suivant");
                String newInput = scan.nextLine();
                if (newInput.isEmpty()) {
                    waitingUserInput=false;
                }
            }
            nbTours++;
        }
    }

//    public int normalMode() {
//
//    }

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
