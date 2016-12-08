/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.bettype;

import interfaces.AvailableBet;
import interfaces.BetType;
import java.util.ArrayList;

/**
 *
 * @author Rypon
 */
public class SoccerHalftimeBet implements AvailableBet {

    private String name = "HT";
    private HandicapBetType handicap;
    private GoalBetType goal;
    private Fulltime1x2BetType fulltime1x2;
    private ArrayList<BetType> allBets;

    public SoccerHalftimeBet(HandicapBetType handicap, GoalBetType goal, Fulltime1x2BetType fulltime1x2) {
        this.handicap = handicap;
        this.goal = goal;
        this.fulltime1x2 = fulltime1x2;
    }

    public SoccerHalftimeBet(HandicapBetType handicap, GoalBetType goal) {
        this.handicap = handicap;
        this.goal = goal;
    }

    public SoccerHalftimeBet() {
    }

    private void initAllBets() {
        allBets = new ArrayList<BetType>();
        allBets.add(goal);
        allBets.add(handicap);
        allBets.add(fulltime1x2);
    }

    public HandicapBetType getHandicap() {
        return handicap;
    }

    public void setHandicap(HandicapBetType handicap) {
        this.handicap = handicap;
    }

    public GoalBetType getGoal() {
        return goal;
    }

    public void setGoal(GoalBetType goal) {
        this.goal = goal;
    }

    public Fulltime1x2BetType getFulltime1x2() {
        return fulltime1x2;
    }

    public void setFulltime1x2(Fulltime1x2BetType fulltime1x2) {
        this.fulltime1x2 = fulltime1x2;
    }

    @Override
    public ArrayList<BetType> getBets() {
        return allBets;
    }

    @Override
    public void setBets(ArrayList<BetType> bets) {
        this.allBets = bets;
    }

    @Override
    public String getName() {
        return name;
    }
}
