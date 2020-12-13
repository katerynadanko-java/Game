package com.katerynadanko.service;

import com.katerynadanko.GameComponent;
import com.katerynadanko.model.Team;
import com.katerynadanko.model.Unit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@GameComponent
public class HeroRandomizer {
    private HeroRandomizer() {
        throw new RuntimeException();
    }

    public static List<Unit> randomizeUnits(Team team1, Team team2) {
        List<Unit> teams = new ArrayList<>();
        teams.addAll(team1.getUnits());
        teams.addAll(team2.getUnits());

        Collections.shuffle(teams);

        return teams;
    }
}
