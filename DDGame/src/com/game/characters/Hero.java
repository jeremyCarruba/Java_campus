package com.game.characters;

public abstract class Hero {

    // -- Commentaire Flo -- //
    // Pourquoi protected plutôt que privé ? 
    // Si minHealth, maxHealth, etc... sont des constantes, declare les comme constantes, et mets tout en UPPERCASE
    // -- Fin commentaire Flo -- //
    protected String name;
    protected int health;
    protected int minHealth;
    protected int maxHealth;
    protected String weapon;
    protected int strength;
    protected int minStrength;
    protected int maxStrength;
    private String heroStatus;

    public Hero() {
        this("inconnu", 10, "inconnu", 10);
    }

    public Hero(String pName) {
        this(pName, 10, "inconnu", 10);
    }

    public Hero(String pName, int health, String weapon, int strength) {
        this.name = pName;
        this.health = health;
        this.weapon = weapon;
        this.strength = strength;
        this.heroStatus = "moving";
    }

    // -- Commentaire Flo -- //
    // Annotation @Override à rajouter 
    // -- Fin commentaire Flo -- //
    public String toString() {
        return this.getName() + " est un " + this.getClass().getSimpleName() +
                " avec " + this.health + " points de vie et " + this.strength +
                " points d'attaque grâce à son arme: " + this.weapon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public String getHeroStatus() {
        return heroStatus;
    }

    public void setHeroStatus(String heroStatus) {
        this.heroStatus = heroStatus;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getMaxStrength() {
        return maxStrength;
    }

    public void setMaxStrength(int maxStrength) {
        this.maxStrength = maxStrength;
    }

    public int getMinHealth() {
        return minHealth;
    }

    public void setMinHealth(int minHealth) {
        this.minHealth = minHealth;
    }

    public int getMinStrength() {
        return minStrength;
    }

    public void setMinStrength(int minStrength) {
        this.minStrength = minStrength;
    }

    public abstract void characterReset();
}
