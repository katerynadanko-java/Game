package com.katerynadanko.model;

import java.util.ArrayList;
import java.util.List;

public class Item {
    private static final List<Item> itemsInTheGame = new ArrayList<>();

    protected int coolDown = 0;

    private Characteristics characteristics;

    private double value;

    private double price; // the value this characteristics can add

    public Item(Characteristics characteristics, double value, double price) {
        this.characteristics = characteristics;
        this.value = value;
        this.price = price;
        // assign these values

        itemsInTheGame.add(this);
    }

    protected boolean isAvailable() {
        return coolDown == 0;
    }

    // decreasing the colldown after each fight
    public static void onFightFinished() {
        for (Item item : itemsInTheGame) {
            if (item.coolDown != 0) {
                item.coolDown--;
            }
        }
    }

    // getters and setters
}
