package com.katerynadanko.model;

public class Knight extends Unit {
    public Knight(double health, double level, Team friends, Team enemies) {
        // TODO: same logic like described for the 'Healer.java'
        super(2000, 2000, 1, friends, enemies, 500,
                200, 10);
    }

    @Override
    public void hit(Unit other) {
        // here your code
    }
}