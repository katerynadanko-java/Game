package com.katerynadanko;

import com.katerynadanko.model.Item;
import com.katerynadanko.model.Team;
import com.katerynadanko.model.Unit;
import com.katerynadanko.service.HeroRandomizer;

import java.util.List;

public class Fight {
    private static int roundCounter = 1;

    private final int number = roundCounter++;

    private Team firstTeam;

    private Team secondTeam;

    public Fight(Team firstTeam, Team secondTeam) {
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
    }

    public void fight() {
        System.out.println("Fight " + number + " has been started:");

        List<Unit> unitActionsSequence = HeroRandomizer.randomizeUnits(firstTeam, secondTeam);

        for (Unit unit : unitActionsSequence) {
            Unit target = unit.getTarget();
            System.out.println("Unit " + unit/* put your information about the unit */ + " attacks " + target);
            unit.hit(target);
        }

        System.out.println("Fight finished");

        Item.onFightFinished();
    }
}
