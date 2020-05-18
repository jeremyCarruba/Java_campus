package com.game.characters;

public abstract class Hero {

    protected String name;
    protected int health;
    protected String weapon;
    protected int strength;
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

    @Override
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

    public abstract void findBonus(int strength, int bonusIncrease, String weapon);

    public String getHeroStatus() {
        return heroStatus;
    }

    public void setHeroStatus(String heroStatus) {
        this.heroStatus = heroStatus;
    }

    public abstract void characterReset();

    public abstract int getMAXHEALTH();

    public abstract int getMAXSTRENGTH();
}
