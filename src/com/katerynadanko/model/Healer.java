package com.katerynadanko.model;

import com.katerynadanko.GameComponent;

import java.util.Random;
@GameComponent
public class Healer extends Unit {
    public static double healthHealedStatistics = 0;


    // healer specific properties, like the amount of health he can recover
    private double healthRecoveryValue;

    public Healer(double unitPrise){
        this.unitPrice = unitPrise;
    }
    public Healer(){
    super();
}
    public Healer(double healthRecoveryValue, Team friends, Team enemies) {

        // here you call the superconstructor and assign some default values
        // each hero would be created only once, so that's why we use constructors here
        // just for example:
        super(350,1000, 1000, 1, friends, enemies, 100,
                100, 2);
        healthRecoveryValue = 100;
    }

    @Override
    public void hit(Unit other) {
        // here should be a specific logic
        Random random = new Random();

        if (other.isAlive()) {
            other.healthCurrent -= attackDamage;
        }

//       Unit enemyToHit = enemies.get(random.nextInt(enemies.size());
//       attackDamage = getAttackDamage(enemyToHit);

        // check the invertory and try to use an item
        int itemUses = 0;
        for (Item item : invertory) {
            if (item.isAvailable() && itemUses < 2) {
                if (item instanceof UsableItem) {
                    ((UsableItem) item).use(other);
                    itemUses++;
                }
            }
        }


        // for example, healer should go through all the freinds and check their helth level:
        boolean stillCanAttack = true;
        for (Unit unit : friends) {
            // better to find a hero with a minimal value of the health
            if (unit.getHealthLevelInPercentage() < 0.3) {
                setHealthRecoveryValue(50);
                unit.healthIncrese(healthRecoveryValue); // you can implement this method in the unit or edit the unit state directly here
                healthHealedStatistics += healthRecoveryValue;
                stillCanAttack = false;
            }
        }

        if (stillCanAttack) {
            attackDamage = this.getAttackDamage(other);
            // here the logic of calculating the physical attack damage and making a damage to the enemy
        }
    }


    public void setHealthRecoveryValue(double healthRecoveryValue) {
        this.healthRecoveryValue = healthRecoveryValue;
    }

    @Override
    public String toString() {
        return "Healer";
    }
}
