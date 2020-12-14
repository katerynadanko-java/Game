package com.katerynadanko.model;

import com.katerynadanko.GameComponent;
import com.katerynadanko.exceptions.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;
@GameComponent
public class Team implements Iterable<Unit>{
    protected final TeamSide teamSide;

    protected final String teamName;

    private double moneyAvailable = 10_000;

    protected List<Unit> units;

    public Team (String teamName, TeamSide teamSide) {
        this.teamName = teamName;
        this.teamSide = teamSide;
        this.units = new ArrayList<>();


        // assign the teamName and the teamSide values
        // initialize the units with a new ArrayList<>();
    }

    public void addUnit (Unit unit) throws TeamNumberException, MagicianNumberException,
            KnightNumberException, ArcherNumberException, HealerNumberException{
        if(units.size()>4){
            throw new TeamNumberException("You already have 5 players!");
        }
        if (unit instanceof Magic) {
            if (units.stream().
                    filter(unit1 -> unit1 instanceof Magic).
                    count() > 1) {
                throw new MagicianNumberException("You can`t add Magician! You already have 2 Magicians!");
            }
        }
        if (unit instanceof Healer) {
            if (units.stream().
                    filter(unit1 -> unit1 instanceof Healer).
                    count() > 0) {
                throw new HealerNumberException("You can`t add Healer! You already have 1 Healer!");
            }
        }
        if (unit instanceof Knight) {
            if (units.stream().
                    filter(unit1 -> unit1 instanceof Knight).
                    count() > 2) {
                throw new KnightNumberException("You can`t add Knight! You already have 3 Knight!");
            }
        }
        if (unit instanceof Archer) {
            if (units.stream().
                    filter(unit1 -> unit1 instanceof Archer).
                    count() > 0) {
                throw new ArcherNumberException("You can`t add Archer! You already have 1 Archer!");
            }
        }
        units.add(unit);



        // here the logic where you check for the maximum allowed number of magics, healers, etc and you add them to the unit list.
    }
    public int size() {
        return units.size();
    }
    public List<Unit> getUnits() {
        return units;
    }



    // here you can skip editing this logic, remember about the foreach-syntax and on which interface it's based on (Iterable)
    @Override
    public Iterator<Unit> iterator() {
        return units.iterator();
    }

    @Override
    public void forEach(Consumer<? super Unit> action) {
        units.forEach(action);
    }

    @Override
    public Spliterator<Unit> spliterator() {
        return units.spliterator();
    }

    public double getMoneyAvailable() {
        return moneyAvailable;
    }
}
