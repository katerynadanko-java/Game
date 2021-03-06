package com.katerynadanko.model;

import com.katerynadanko.GameComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
@GameComponent
public abstract class Unit {
    double unitPrice;

    protected double healthMax;
    protected double healthCurrent;


    protected double level;

    protected Team friends;
    protected Team enemies;

    protected List<Item> invertory;

    // random for performing actions
    protected final Random random = new Random();

    double armour;
    double baseAttackDamage;
    double criticalDamageChance;
    double attackDamage;


    // put here others characteristics that unit can have (armor, critical damage chance, etc.)

    // TODO: expand this constructor and assign the appropriate values (armor, damage, critical damage chance, etc.)
    public Unit(){

    }
    public Unit(double unitPrice, double healthMax, double healthCurrent, double level,
                Team friends, Team enemies, double armour, double baseAttackDamage,
                double criticalDamageChance) {
        this.unitPrice = unitPrice;
        this.healthMax = healthMax;
        this.healthCurrent = healthCurrent;
        this.level = level;
        this.friends = friends;
        this.enemies = enemies;
        this.armour = armour;
        this.baseAttackDamage = baseAttackDamage;
        this.criticalDamageChance = criticalDamageChance;
    }

    public abstract void hit(Unit other);

    public double getAttackDamage(Unit init){
    return attackDamage-armour;
}
    // common for all units logic:
    // add your methods here

    public Unit getTarget() {
//        for (Unit u : enemies) {
//            if (u.isAlive()) {
                List<Unit> units = enemies.getUnits();

                Unit target = null;
                boolean found = false;

                boolean isEverybodyDead = true;

                for (Unit unit : units) {
                    if (unit.isAlive())
                    if (unit.getHeroCurrentHealth() >= 0) {
                        isEverybodyDead = false;
                    }
                }

                while (target == null) {
                    Unit unit = units.get(random.nextInt(units.size()));
                    if (unit.getHeroCurrentHealth() >= 0) {
                        target = unit;
                    }
                }
                return target;

            }
//        }
//    }


    public boolean isAlive() {
        return getHeroCurrentHealth() >= 0;
    }

    // we mark these methods as final to avoid changes by specific unit
    protected final double getHeroMaxHealth() {
        for(Item i : invertory){
            if(i.equals(new Item(Characteristics.HEALTH_INCREASE, 150,40))){
                healthCurrent += new Item(Characteristics.HEALTH_INCREASE, 150,40).getValue();
            }
        }
        return healthMax /* here you should add the health given by items and then use
        this method for calculating*/;
    }

    protected final double getHeroCurrentHealth() {

        return healthCurrent /* here you should add the health given by items and then
        use this method for calculating*/;
    }

    protected double getHealthLevelInPercentage() {
        return getHeroMaxHealth() / getHeroCurrentHealth();
    }

    public void buyUnit(){

    }
    public void healthIncrese(double d) {
        if(new Item(Characteristics.HEALTH_INCREASE, 150,40).getValue()<300) {
            healthCurrent = (healthMax + d) / getHealthLevelInPercentage();
            new Item(Characteristics.HEALTH_INCREASE, 150, 40).setValue(d - ((healthMax + d) / getHealthLevelInPercentage()));
        }
        healthCurrent = (healthMax + d);
    };


    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getHealthMax() {
        return healthMax;
    }

    public void setHealthMax(double healthMax) {
        this.healthMax = healthMax;
    }

    public double getHealthCurrent() {
        return healthCurrent;
    }

    public void setHealthCurrent(double healthCurrent) {
        this.healthCurrent = healthCurrent;
    }

    public double getLevel() {
        return level;
    }

    public void setLevel(double level) {
        this.level = level;
    }

    public Team getFriends() {
        return friends;
    }

    public void setFriends(Team friends) {
        this.friends = friends;
    }

    public Team getEnemies() {
        return enemies;
    }

    public void setEnemies(Team enemies) {
        this.enemies = enemies;
    }

    public List<Item> getInvertory() {
        return invertory;
    }

    public void setInvertory(List<Item> invertory) {
        this.invertory = invertory;
    }

    public Random getRandom() {
        return random;
    }

    // getters and setters here as well
}
