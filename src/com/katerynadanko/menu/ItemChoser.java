package com.katerynadanko.menu;

import com.katerynadanko.exceptions.*;
import com.katerynadanko.model.*;

import java.util.List;
import java.util.Scanner;

public class ItemChoser implements InteractiveMenuElement {
    Scanner scanner = new Scanner(System.in);
    List<Item> items;

    private ItemGameChouser itemGameChouser = new ItemGameChouser();

    public ItemChoser(Unit unit, List<Item> items) {
        this.items = items;
    }

    private ItemGameChouser getItemGameChouser() {
        return itemGameChouser;
    }


    @Override
    public void printMenu() {
        System.out.println("Print 1 to see available items");
        System.out.println("Print 2 to add an item");
        System.out.println("Print 3 to print already chosen items");
        System.out.println("Print 10 to go back to previous menu");
    }

    private void printAvailableItems() {
        System.out.println("Print 1 to choose HEALTH_INCREASE");
        System.out.println("Print 2 to choose ARMOR_INCREASE");
        System.out.println("Print 3 to choose DEMAGE_INCREASE");
        System.out.println("Print 4 to choose CRITICAL_DAMAGE_CHANSE");
        System.out.println("Print 5 to choose MAGIC_DAMAGE");
        System.out.println("Print 6 to choose MAGICAL_IMMUNITY");
        System.out.println("Print 7 to choose FENCE_USE_OBJECTS_2_MOVES");
        System.out.println("Print 8 to choose FENCE_USE_MAGIC_NEXT_OFFENSIVE");
        System.out.println("Print 9 to choose FENCE_PHYSICALLY_ATTACK");
        System.out.println("Print 10 to go back to previous menu");
    }

    @Override
    public void decisionLoop() throws Exception {
        String read = null;
        int action = 0;

        lable:
        while ((read = scanner.nextLine()) != null & (action = Integer.parseInt(read)) != Integer.MIN_VALUE) {
            switch (action) {
                case 1:
                    System.out.println("Available items: ");
                    printAvailableItems();
                    break;
                case 2:
                    System.out.println("Add an item");
                    itemGameChouser.decisionLoop();
                    break;
                case 3:
                    System.out.println("Already chosen items: ");
                    for (Item item : items) {
                        System.out.println(item);
                    }
                    break;
                case 10:
                    System.out.println("Exiting...  to previous menu");
                    break lable;
                default:
                    System.out.println("Make your chose!");
                    break;
            }
            printMenu();
        }
    }


    private class ItemGameChouser implements InteractiveMenuElement{

        @Override
        public void printMenu() {
            printAvailableItems();
            System.out.println("Print 10 to exit");
        }

        @Override
        public void decisionLoop() throws Exception {
                String read = null;
                int action = 0;
                lable:
                while ((read = scanner.nextLine()) != null & (action = Integer.parseInt(read)) != Integer.MIN_VALUE) {
                    switch (action) {

                        case 1:
                            System.out.println("You add HEALTH_INCREASE to your hero");
                            items.add(new Item(Characteristics.HEALTH_INCREASE, 150, 40));
                            break;
                        case 2:
                            System.out.println("You add RMOR_INCREASE to your hero");
                            items.add(new Item(Characteristics.ARMOR_INCREASE,100,30));
                            break;
                        case 3:
                            System.out.println("You add DEMAGE_INCREASE to your hero");
                            items.add(new Item(Characteristics.DEMAGE_INCREASE,500,80));
                            break;
                        case 4:
                            System.out.println("You add CRITICAL_DAMAGE_CHANSE to your hero");
                            items.add(new Item(Characteristics.CRITICAL_DAMAGE_CHANSE,120,50));
                            break;
                        case 5:
                            System.out.println("You add MAGIC_DAMAGE to your hero");
                            items.add(new Item(Characteristics.MAGIC_DAMAGE,130,20));
                            break;
                        case 6:
                            System.out.println("You add MAGICAL_IMMUNITY to your hero");
                            items.add(new Item(Characteristics.MAGICAL_IMMUNITY,90,30));
                            break;
                        case 7:
                            System.out.println("You add FENCE_USE_OBJECTS_2_MOVES to your hero");
                            items.add(new Item(Characteristics.FENCE_USE_OBJECTS_2_MOVES,200,120));
                            break;
                        case 8:
                            System.out.println("You add FENCE_USE_MAGIC_NEXT_OFFENSIVE to your hero");
                            items.add(new Item(Characteristics.FENCE_USE_MAGIC_NEXT_OFFENSIVE,200,80));
                            break;
                        case 9:
                            System.out.println("You add FENCE_PHYSICALLY_ATTACK to your hero");
                            items.add(new Item(Characteristics.FENCE_PHYSICALLY_ATTACK,150,70));
                            break;
                        case 10:
                            System.out.println("Exiting... to previous menu");
                            break lable;
                        default:
                            System.out.println("Select a hero from list!");
                            break;
                    }
                    printMenu();
                }
        }
    }
}
