package com.game.play;

import com.game.characters.Hero;
import com.game.Menu;
import java.util.Scanner;

public class Game {
    Scanner scan = new Scanner(System.in);
    private Menu menu;
    public Game(Menu menu){
        this.menu = menu;
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
            String newInput = menu.checkUserInput();
            if (newInput.equalsIgnoreCase("rejouer")) {
                menu.mainMenu(mainChar);
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
        return (int) (Math.random() * 6 + 1);
    }
}
