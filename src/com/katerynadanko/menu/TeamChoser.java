package com.katerynadanko.menu;

import com.katerynadanko.exceptions.*;
import com.katerynadanko.menu.InteractiveMenuElement;
import com.katerynadanko.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeamChoser implements InteractiveMenuElement {
    Scanner scanner = new Scanner(System.in);
    List<Unit> heroes;

    private  HeroChouser heroChouser = new HeroChouser();

    public TeamChoser(List<Unit> heroes) {
        this.heroes = heroes;
    }

    private HeroChouser getHeroChouser() {
        return heroChouser;
    }

    @Override
    public void decisionLoop() {
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
//                case 4:
//                    System.out.println("Selected a hero archer");
//                    archerObjectSelector.decisionLoop();
//                    break;
//                case 5:
//                    System.out.println("Selected a hero healer");
//                    healerObjectSelector.decisionLoop();
//                    break;
//                case 6:
//                    System.out.println("Selected a hero knight");
//                    knightObjectSelector.decisionLoop();
//                    break;
//                case 7:
//                    System.out.println("Selected a hero magician");
//                    magicianObjectSelector.decisionLoop();
//                    break;
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
        public void printMenu () {

            System.out.println("Print 1 to see available heroes");
            System.out.println("Print 2 to add a hero");
            System.out.println("Print 3 to print already chosen heroes");
            System.out.println("Print 4 to choose archer to add inventory to him");
            System.out.println("Print 5 to choose healer to add inventory to him");
            System.out.println("Print 6 to choose knight to add inventory to him");
            System.out.println("Print 7 to choose magician to add inventory to him");
            System.out.println("Print 10 to go back to previous menu");
        }
        private void printAvailableHeroes () {
            System.out.println("Print 1 to choose Magician");
            System.out.println("Print 2 to choose Knight");
            System.out.println("Print 3 to choose Healer");
            System.out.println("Print 4 to choose Archer");
            System.out.println("Print 10 to go back to previous menu");
        }

    private class HeroChouser implements InteractiveMenuElement{
        Unit magic = new Magic(2000, 2000, 1, friends, enemies, 500, 999, 8);
        Unit knight = new Knight();
        Unit healer = new Healer();
        Unit archer = new Archer();
        @Override
        public void printMenu() {
                printAvailableHeroes();
                System.out.println("Print 10 to exit");
            }
        @Override
        public void decisionLoop() {
            String read = null;
            int action = 0;
            Team team1 = new Team("1", TeamSide.FIRST_TEAM);
            Team team2 = new Team("2", TeamSide.SECOND_TEAM);
            List<Team> teams = new ArrayList<>();
            lable:
            while ((read = scanner.nextLine()) != null & (action = Integer.parseInt(read)) != Integer.MIN_VALUE) {
                switch (action) {
                    case 1:
                        System.out.println("You add Magician to your team");
                        try {
                            team1.addUnit(magic);
                        }
                        catch (Exception e) {
                            System.out.println("You can`t add Magician! You already have 2 Magicians!");
                        }
                        break;
                    case 2:
                        if(heroes.size()>5){
                            System.out.println("Your team is staffed!");
                        }
                        System.out.println("You add Knight to your team");
                        heroes.add(knight);
                        break;
                    case 3:
                        if(heroes.size()>5){
                            System.out.println("Your team is staffed!");
                        }
                        for (Unit hero : heroes) {
                            if(hero.equals("Healer")) {
                                System.out.println("You can`t add Healer! You already have it!");
                            }
                        }
                        System.out.println("You add Healer to your team");
                        heroes.add(healer);
                        break;
                    case 4:
                        if(heroes.size()>5){
                            System.out.println("Your team is staffed!");
                        }
                        System.out.println("You add Archer to your team");
                        heroes.add(archer);
                        break;
                    case 10:
                        System.out.println("Exiting to previous menu");
                        break lable;
                    default:
                        System.out.println("Select a hero from list!");
                        break;
                }
                printMenu();
            }
    }
}
