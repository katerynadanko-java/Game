package com.katerynadanko.model;

import com.katerynadanko.GameComponent;

@GameComponent
public class Knight extends Unit {

    public Knight(){
        super();
    }
    public Knight(double health, double level, Team friends, Team enemies) {
        // TODO: same logic like described for the 'Healer.java'
        super(300,2000, 2000, 1, friends, enemies, 500,
                200, 10);
    }

    @Override
    public void hit(Unit other) {
        if (other.isAlive()) {
            other.healthCurrent -= attackDamage;
        }
        // here your code
    }

    @Override
    public String toString() {
        return "Knight";
    }
}
