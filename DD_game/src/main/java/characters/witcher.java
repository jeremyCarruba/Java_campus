package characters;

public class Witcher {
    private String nom;
    private int healthPoints;
    private String spell;
    private int spellStrength;

    public Witcher() {
        System.out.println("Création d'un witcher");
        nom = "inconnu";
        healthPoints = 0;
        spell = "inconnu"
        spellStrength = 0;
    }

    public Witcher(String pNom) {
        System.out.println("Création d'un witcher avec paramètre");
        nom = pNom.toString();
        healthPoints = 10;
        spell ="inconnu";
        spellStrength = 10;
    }

    public Witcher(String pNom, int health, String spell, int pStrength) {
        System.out.println("Création d'un witcher avec tous les paramètres");
        nom = pNom.toString();
        healthPoints = (int)health.;
        spellStrength = (int)pStrength;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

}