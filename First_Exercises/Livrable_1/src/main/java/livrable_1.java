public class livrable_1{
    public static void main(String[] args) {
        int ancienLocal = 34, camion = 0, nouveauLocal=0;
        System.out.println("Début du déménagement");
        while(ancienLocal>0) {
            System.out.println("Chargement du camion");
            while(camion <9 && ancienLocal>0) {
                ancienLocal--;
                camion++;
            }
            System.out.println("Ils ont chargé " + camion + " cartons dans le mionmion." +
                    "Il reste " + ancienLocal + " cartons à déménager.");
            System.out.println("Camion chargé, voyage jusqu'au local");
            System.out.println("Déchargement du camion");
            while(camion>0) {
                camion--;
                nouveauLgit ocal++;
            }
            System.out.println("Camion déchargé, retour à l'ancien local");
        }
        System.out.println("Il reste " + ancienLocal + " cartons à décharger");
        if(ancienLocal == 0) {
            System.out.println("Déménagement terminé");
        }else{
            System.out.println("ahaha t'as mal codé t'es nul");
        }
    }
}


