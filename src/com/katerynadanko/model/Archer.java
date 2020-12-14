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
        super(250, 1000, healthCurrent, level, friends, enemies, 200, 100, 3);
    }
    public Archer(double unitPrise){
        this.unitPrice = unitPrise;
    }
    @Override
    public void hit(Unit other) {
        Unit other1 = new Unit() {
            @Override
            public void hit(Unit other) {
                other.healthCurrent -= attackDamage;
            }
        };

        if (other.isAlive()) {
            if (other1.isAlive()) {
                other.attackDamage = 1 * getAttackDamage(other);
                other1.attackDamage = 0.7 * getAttackDamage(other1);
            }
        }
        attackDamage = this.getAttackDamage(other);

        int itemUses = 0;
        for (Item item : invertory) {
            if (item.isAvailable() && itemUses < 2) {
                if (item instanceof UsableItem) {
                    ((UsableItem) item).use(other);
                    itemUses++;
                }
            }
        }


    }

    public double resultHealthAfterAttack(Unit enemy) {
    enemy.healthCurrent = (attackDamage - (1 - armour));

        return enemy.healthCurrent;
    }

    @Override
    public String toString() {
        return "Archer";
    }
}
