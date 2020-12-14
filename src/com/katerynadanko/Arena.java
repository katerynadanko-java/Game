package com.katerynadanko;

import com.katerynadanko.model.Team;
import com.katerynadanko.model.Unit;
@GameComponent
public class Arena {
    private String name;

    private Team team1;

    private Team team2;

    public Arena(String name, Team team1, Team team2) {
        this.name = name;
        this.team1 = team1;
        this.team2 = team2;
    }

    public void fightTillTeamIsAlive() {
        System.out.println("First team will fight with second team");

        boolean weHaveWinner = false;
        Team winner = null;

        while (!weHaveWinner) {
            Fight fight = new Fight(team1, team2);

            fight.fight();

            boolean firstTeamIsAlive = checkIfTeamIsAlive(team1);
            boolean secondTeamIsAlive = checkIfTeamIsAlive(team2);

            if (firstTeamIsAlive ^ secondTeamIsAlive) {
                weHaveWinner = true;
                winner = firstTeamIsAlive ? team1 : team2;
            }
        }

        System.out.println("The team number " + winner + " is the winner!");
    }

    private boolean checkIfTeamIsAlive(Team team) {

        for (Unit unit : team) {
            if (unit.isAlive()) {
                return true;
            }
        }
        return false;
    }
}
