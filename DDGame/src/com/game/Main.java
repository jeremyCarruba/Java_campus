package com.game;
import com.game.DBConnection;

/**
 * Création d'un nouveau menu et début du jeu
 */

public class Main {
    public static void main(String[] args) {

//        DBConnection connection = new DBConnection();
//        connection.createConnection();

        System.out.println("Wesh alors, bienvenue dans le game");
        Menu menu = new Menu();
        menu.start();
    }
}
