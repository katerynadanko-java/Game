package com.katerynadanko.menu;

import com.katerynadanko.exceptions.*;
import com.katerynadanko.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeamChoser implements InteractiveMenuElement {
    Scanner scanner = new Scanner(System.in);
    List<Unit> heroes;

    private HeroChouser heroChouser = new HeroChouser();

    List<Item> archerItems = new ArrayList<>();
    List<Item> healerItems = new ArrayList<>();
    List<Item> knightItems = new ArrayList<>();
    List<Item> magicItems = new ArrayList<>();

    ItemChoser archerItemChose = new ItemChoser(new Archer(), archerItems);
    ItemChoser healerItemChose = new ItemChoser(new Healer(), healerItems);
    ItemChoser knightItemChose = new ItemChoser(new Knight(), knightItems);
    ItemChoser magicItemChose = new ItemChoser(new Magic(), magicItems);


    public TeamChoser(List<Unit> heroes) {
        this.heroes = heroes;
    }

    private HeroChouser getHeroChouser() {
        return heroChouser;
    }

    @Override
    public void decisionLoop() throws Exception {
        String read = null;
        int action = 0;

        lable:
        while ((read = scanner.nextLine()) != null & (action = Integer.parseInt(read)) != Integer.MIN_VALUE) {
            switch (action) {
                case 1:
                    System.out.println("Available heroes: ");
                    printAvailableHeroes();
                    break;
                case 2:
                    System.out.println("Add a hero");
                    heroChouser.decisionLoop();
                    break;
                case 3:
                    System.out.println("Already chosen heroes: ");
                    for (Unit hero : heroes) {
                        System.out.println(hero);
                    }
                    break;
                case 4:
                    System.out.println("Select items for archer:");
                    archerItemChose.decisionLoop();
                    break;
                case 5:
                    System.out.println("Select items for healer:");
                    healerItemChose.decisionLoop();
                    break;
                case 6:
                    System.out.println("Select items for knight:");
                    knightItemChose.decisionLoop();
                    break;
                case 7:
                    System.out.println("Select items for magician:");
                    magicItemChose.decisionLoop();
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

    @Override
    public void printMenu() {

        System.out.println("Print 1 to see available heroes");
        System.out.println("Print 2 to add a hero");
        System.out.println("Print 3 to print already chosen heroes");
        System.out.println("Print 4 to choose archer to add inventory to him");
        System.out.println("Print 5 to choose healer to add inventory to him");
        System.out.println("Print 6 to choose knight to add inventory to him");
        System.out.println("Print 7 to choose magician to add inventory to him");
        System.out.println("Print 10 to go back to previous menu");
    }

    private void printAvailableHeroes() {
        System.out.println("Print 1 to choose Magician");
        System.out.println("Print 2 to choose Knight");
        System.out.println("Print 3 to choose Healer");
        System.out.println("Print 4 to choose Archer");
        System.out.println("Print 10 to go back to previous menu");
    }

    private class HeroChouser implements InteractiveMenuElement {
//

        @Override
        public void printMenu() {
            printAvailableHeroes();
            System.out.println("Print 10 to exit");
        }

        @Override
        public void decisionLoop() throws TeamNumberException, MagicianNumberException, KnightNumberException, HealerNumberException, ArcherNumberException {
            String read = null;
            int action = 0;
            lable:
            while ((read = scanner.nextLine()) != null & (action = Integer.parseInt(read)) != Integer.MIN_VALUE) {
                switch (action) {

                    case 1:
                        limitsHeroes();
                        if (heroes.stream().
                                filter(unit1 -> unit1 instanceof Magic).
                                count() > 1) {
                            throw new MagicianNumberException("You already have 2 Magicians!");
                        }
                        System.out.println("You add Magician to your team");
                        heroes.add(new Magic());
                        break;
                    case 2:
                        limitsHeroes();
                        if (heroes.stream().
                                filter(unit1 -> unit1 instanceof Knight).
                                count() > 2) {
                            throw new KnightNumberException("You already have 3 Knights!");
                        }
                        System.out.println("You add Knight to your team");
                        heroes.add(new Knight());
                        break;
                    case 3:
                        limitsHeroes();
                        if (heroes.stream().
                                filter(unit1 -> unit1 instanceof Healer).
                                count() > 0) {
                            throw new HealerNumberException("You already have Healer!");
                        }
                        System.out.println("You add Healer to your team");
                        heroes.add(new Healer());
//                        double currentMoney = getMoneyAvailable - hero.getUnitPrise;
                        break;
                    case 4:
                        limitsHeroes();
                        if (heroes.stream().
                                filter(unit1 -> unit1 instanceof Archer).
                                count() > 0) {
                            throw new ArcherNumberException("You already have Archer!");
                        }
                        System.out.println("You add Archer to your team");
                        heroes.add(new Archer());
                        break;
                    case 10:
                        System.out.println("Exiting... to previous menu");
//                        GameApplication.printMenu();
                        break lable;
                    default:
                        System.out.println("Select a hero from list!");
                        break;
                }
                printMenu();
            }
        }
        public void limitsHeroes() throws TeamNumberException {
            if(heroes.size()>4){
                throw new TeamNumberException("You already have 5 players!");
        }

        }
    }
}

