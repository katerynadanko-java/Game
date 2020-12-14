package com.katerynadanko.model;

import com.katerynadanko.GameComponent;

import java.util.ArrayList;
import java.util.List;
@GameComponent
public class Item {
    private static final List<Item> itemsInTheGame = new ArrayList<>();

    protected int coolDown = 0;

    private Characteristics characteristics;

    private double value;

    private double price; // the value this characteristics can add

    public Item(){

    }
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    // getters and setters
}
