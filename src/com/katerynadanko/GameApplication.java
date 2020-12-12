package com.katerynadanko;

import com.katerynadanko.menu.TeamChoser;
import com.katerynadanko.model.Team;
import com.katerynadanko.model.TeamSide;
import com.katerynadanko.model.Unit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameApplication {
    public static void main(String[] args) {

        List<Unit> firstTeamHeroes = new ArrayList<>();
        List<Unit> secondTeamHeroes = new ArrayList<>();

        TeamChoser firstTeamChose = new TeamChoser (firstTeamHeroes);
        TeamChoser secondTeamChose = new TeamChoser (secondTeamHeroes);

        Team firstTeam = new Team ("Dragons", TeamSide.FIRST_TEAM);
        Team secondTeam = new Team ("Zeus", TeamSide.SECOND_TEAM );


        Scanner scanner = new Scanner(System.in);

        printMenu();
        String read = null;
        int action = 0;

        lable:
        while ((read = scanner.nextLine()) != null & (action = Integer.parseInt(read)) != Integer.MIN_VALUE)
        {
            switch (action) {
                case 1:
                    System.out.println("Select team 1");
                    firstTeamChose.decisionLoop();
                    break;
                case 2:
                    System.out.println("Select team 2");
                    secondTeamChose.decisionLoop();
                    break;
                case 3:
                    System.out.println("Start Fighting...");
                    new Arena("Koliseum", firstTeam, secondTeam);
                    break;
                case 10:
                    System.out.println("Exiting...");
                    break lable;
                default:
                    System.out.println("Make your chose!");
                    break;
            }
        }



    }





        static void printMenu(){
            System.out.println("Print 1 to choose team 1");
            System.out.println("Print 2 to choose team 2");
            System.out.println("Print 3 to start fight");
            System.out.println("Print 10 to exit");
        }
        // here the menu should be

}
