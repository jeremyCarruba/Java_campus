import java.util.Scanner;

public class menu{
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Wesh alors, bienvenue dans le game");
        System.out.println("Voulez vous faire un Guerrier ou un Witcher ?");
        String choice = scan.nextLine();
        System.out.println("Quel est le nom de ton perso ?");
        String nomPerso = scan.nextLine();
        scan.nextLine();
        System.out.println("Quel face a t'il ?");
        String imagePerso = scan.nextLine();
        scan.nextLine();
        System.out.println("Combien de pts de vie ?");
        int pvPerso = scan.nextInt();
        scan.nextLine();
        System.out.println("Quelle est sa force, oui la force ?");
        int strength = scan.nextInt();

        if(choice == "Guerrier") {
            Perso = new Warrior();
        } else {
            Perso = new Witcher();
        }
    }
}