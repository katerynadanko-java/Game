package com.katerynadanko.model;

import com.katerynadanko.model.Characteristics;
import com.katerynadanko.model.Item;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<Item> itemList;

    public Shop() {
        itemList = new ArrayList<>();

        // here you define the items with their characteristics that should be present in the shop

        itemList.add(new Item(Characteristics.HEALTH_INCREASE, 150,40));
        itemList.add(new Item(Characteristics.ARMOR_INCREASE, 100, 30));
        itemList.add(new Item(Characteristics.CRITICAL_DAMAGE_CHANSE, 500,80));
        itemList.add(new Item(Characteristics.DEMAGE_INCREASE, 120, 50));
        itemList.add(new Item(Characteristics.FENCE_PHYSICALLY_ATTACK, 130, 20));
        itemList.add(new Item(Characteristics.FENCE_USE_MAGIC_NEXT_OFFENSIVE, 90, 30));
        itemList.add(new Item(Characteristics.FENCE_USE_OBJECTS_2_MOVES, 200, 120));
        itemList.add(new Item(Characteristics.MAGIC_DAMAGE, 200, 80));
        itemList.add(new Item(Characteristics.MAGICAL_IMMUNITY, 150, 70));



    }

    public List<Item> getItemsAvailable() {
        return itemList;
    }
}
