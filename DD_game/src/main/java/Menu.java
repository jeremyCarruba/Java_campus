import java.util.Scanner;

public class Menu{
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Wesh alors, bienvenue dans le game");

        String userInput= "";
        while(true) {
            String choice, nomPerso, imagePerso;
            System.out.println("Voulez vous faire un Guerrier ou un Witcher ?");
            userInput = scan.nextLine();

            if (userInput.equalsIgnoreCase("quit")) {
                System.out.println("Vous quittez le jeu");
                break;
            } else {
               choice = userInput;
            }

            System.out.println("Quel est le nom de ton perso ?");
            userInput = scan.nextLine();

            if (userInput.equalsIgnoreCase("quit")) {
                System.out.println("Vous quittez le jeu");
                break;
            } else {
                nomPerso = userInput;
            }

            System.out.println("Quel face a t'il ?");
            userInput = scan.nextLine();

            if (userInput.equalsIgnoreCase("quit")) {
                System.out.println("Vous quittez le jeu");
                break;
            } else {
                imagePerso = userInput;
            }

            imagePerso = userInput;

            System.out.println("Combien de pts de vie ?");
            int pvPerso = scan.nextInt();

            System.out.println("Quelle est sa force, oui la force ?");
            int strength = scan.nextInt();

            if (choice.equalsIgnoreCase("Guerrier")) {
                Warrior perso = new Warrior(nomPerso, imagePerso, pvPerso, strength);
                System.out.println(perso.toString());
            } else if (choice == "Witcher") {
                Witcher perso = new Witcher();
                System.out.println(perso.toString());
            }
        }
    }
}