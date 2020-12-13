package com.katerynadanko.model;

import com.katerynadanko.GameComponent;

@GameComponent
public class Archer extends Unit {


    public Archer() {
        super();
    }

    public Archer(double healthMax, double healthCurrent, double level, Team friends,
                  Team enemies, double armour, double baseAttackDamage,
                  double criticalDamageChance) {
        super(250, healthMax, healthCurrent, level, friends, enemies, 200, 100, 3);
    }

    @Override
    public void hit(Unit other) {
        if (other.isAlive()) {
            other.healthCurrent -= attackDamage;
        }
    }

    public double resultHealthAfterAttack(Unit enemy) {
        double damageTaken = (attackDamage - (1 - armour));
        return damageTaken;
    }

    @Override
    public String toString() {
        return "Archer";
    }
}
