package com.game;

import com.game.characters.*;
import com.game.Menu;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        System.out.println("Wesh alors, bienvenue dans le game");
        menu.newGame();
    }
}
