package characters;

public class Warrior {
    private String nom;
    private int healthPoints;
    private int strength;
    private String weapon;

    public Warrior() {
        System.out.println("Création d'un wawa");
        nom = "inconnu";
        healthPoints = 0;
        weapon = "inconnu"
        strength = 0;
    }

    public Warrior(String pNom) {
        System.out.println("Création d'un wawa avec paramètres");
        nom = pNom.toString();
        healthPoints = 10;
        weapon = "inconnu"
        strength = 10;
    }

    public Warrior(String pNom, int health, String weapon, int pStrength) {
        System.out.println("Création d'un wawa avec tous les paramètres");
        nom = pNom.toString();
        healthPoints = (int)health.;
        weapon = weapon;
        strength = (int)pStrength;
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