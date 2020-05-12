package com.game;
import com.game.characters.Warrior;
import com.game.characters.Witcher;

import java.util.InputMismatchException;
import java.util.Scanner;
public class Menu {
    private String gameStatus;
    private String userInput;

    Scanner scan = new Scanner(System.in);

    public String checkUserInput() {
        String newInput=scan.nextLine();
        if(newInput.equalsIgnoreCase("quit")) {
            System.exit(0);
        }
        return newInput;
    }

    public int checkUserInputInt() {
        int newInput=0;
        while(true){
            try{
                newInput = scan.nextInt();
                break;
            } catch(InputMismatchException e) {
                System.out.println("Oops, tu dois rentrer un chiffre");
                scan.next();
            }
        }
        return newInput;
    }

    public Object createChar() {
        String choice, nomPerso, imagePerso; int pvPerso, strength;
        System.out.println("Voulez vous faire un Guerrier ou un Witcher ?");
        choice = checkUserInput();

        System.out.println("Quel est le nom de ton perso ?");
        nomPerso = checkUserInput();

        System.out.println("Quel face a t'il ?");
        imagePerso = checkUserInput();

        System.out.println("Combien de pts de vie ?");
        pvPerso = checkUserInputInt();

        System.out.println("Quelle est sa force, oui la force ?");
        strength = checkUserInputInt();

        if (choice.equalsIgnoreCase("Guerrier")) {
            Warrior perso = new Warrior(nomPerso, imagePerso, pvPerso, strength);
            return perso;
        } else if (choice.equalsIgnoreCase("Witcher")) {
            Witcher perso = new Witcher(nomPerso, imagePerso, pvPerso, strength);
            return perso;
        }

        return "Créé moi ce perso";
    }

    public Object modifyWarrior(Warrior character){
        String newInput =""; int newInt;
         System.out.println("Voulez vous devenir witcher ? oui / non");
            newInput = checkUserInput();
            if(newInput.equalsIgnoreCase("oui")){
                Witcher newChar = new Witcher();
            }

            System.out.println("Quel est son nouveau nom ?");
            newInput = checkUserInput();
            newChar.setName(newInput);

            System.out.println("Quel arme a t'il ?");
            newInput = checkUserInput();
            character.setWeapon(newInput);

            System.out.println("Combien de pts de vie ?");
            newInt = checkUserInputInt();
            character.setHealthPoints(newInt);

            System.out.println("Quelle est sa force, oui la force ?");
            newInt = checkUserInputInt();
            character.setStrength(newInt);

            return character;
        }

    public void mainMenu(Object character){
        System.out.println("What's next ? Play / Character / Quit");
        scan.nextLine();
        String newInput = checkUserInput();
        if(newInput.equalsIgnoreCase("character")){
            System.out.println(character.toString());
            String charClass = character.getClass().getSimpleName();
            if(charClass.equals("Warrior")){
                character = modifyWarrior(character);
            } else {
                character = modifyWitcher(character);
            }
            mainMenu(character);
        } else if (newInput.equalsIgnoreCase("play")){

        } else if (newInput.equalsIgnoreCase("quit")){
            setGameStatus("quit");
            System.out.println("Vous quittez le jeu");
            System.exit(0);
        }
    }

    public void newGame() {
        Object mainChar;
        setGameStatus("playing");
        mainChar = createChar();
        Class charClass = mainChar.getClass();
        mainMenu(mainChar);
    }

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
