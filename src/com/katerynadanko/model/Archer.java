package com.katerynadanko.model;

public class Archer extends Unit {

    public Archer(double healthMax, double healthCurrent, double level, Team friends,
                  Team enemies, double armour, double baseAttackDamage,
                  double criticalDamageChance) {
        super(healthMax, healthCurrent, level, friends, enemies, 200, 100, 3);
    }

    @Override
    public void hit(Unit other) {

    }
}
