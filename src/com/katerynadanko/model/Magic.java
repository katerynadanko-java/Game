package com.katerynadanko.model;

import com.katerynadanko.GameComponent;

@GameComponent
public class Magic extends Unit {

    public Magic(){
        super();
    }
    public Magic(double healthMax, Team friends, Team enemies) {
        // TODO: same logic like described for the 'Healer.java'
        super(500,2000, 2000, 1, friends, enemies, 500, 999, 8);
    }

    @Override
    public void hit(Unit other) {
        if (other.isAlive()) {
            other.healthCurrent -= attackDamage;
        }

    }

    @Override
    public String toString() {
        return "Magic";
    }
}
