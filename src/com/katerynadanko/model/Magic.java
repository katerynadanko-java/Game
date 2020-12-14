package com.katerynadanko.model;

import com.katerynadanko.GameComponent;

import java.util.List;

@GameComponent
public class Magic extends Unit {

    public Magic(){
        super();
    }
    public Magic(double healthMax, Team friends, Team enemies) {
        // TODO: same logic like described for the 'Healer.java'
        super(500,1000, 1000, 1, friends, enemies, 500, 200, 8);
    }
    public Magic(double unitPrise){
        this.unitPrice = unitPrise;
    }

    @Override
    public void hit(Unit other) {
        if (other.isAlive()) {
            attackDamage = 10*attackDamage;
            for (int i = 0; i<3; i++){
                attackDamage = attackDamage/3;
            }



//            other.healthCurrent -= attackDamage;
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

    }

    @Override
    public String toString() {
        return "Magic";
    }
}
