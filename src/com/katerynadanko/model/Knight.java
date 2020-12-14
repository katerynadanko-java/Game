package com.katerynadanko.model;

import com.katerynadanko.GameComponent;

import java.util.Random;

@GameComponent
public class Knight extends Unit {

    public Knight() {
        super();
    }
    public Knight(double unitPrise){
        this.unitPrice = unitPrise;
    }

    public Knight(double health, double level, Team friends, Team enemies) {
        // TODO: same logic like described for the 'Healer.java'
        super(300,1000, health, 1, friends, enemies, 500,
                200, 10);
    }

    @Override
    public void hit(Unit other) {
        if (other.isAlive()) {
            other.healthCurrent -= attackDamage;
        }

        int itemUses = 0;
        for (Item item : invertory) {
            if (item.isAvailable() && itemUses < 2) {
                if (item instanceof UsableItem) {
                    ((UsableItem) item).use(other);
                    itemUses++;
                }
            }
        }
        // here your code
    }

    public double resultHealthAfterAttack(Unit enemy) {
        Random rand = new Random();
        double block = attackDamage;

        double damageTaken = (attackDamage - rand.nextInt(2)*block)*(1 - armour);
        return damageTaken;
    }

//    public double resultHealthAfterAttack(Unit enemy) {
//        double damageTaken = (attackDamage - rand.nextInt(2)*block)*(1-armour);
//
//        return damageTaken;
//}
    @Override
    public String toString() {
        return "Knight";
    }
}
