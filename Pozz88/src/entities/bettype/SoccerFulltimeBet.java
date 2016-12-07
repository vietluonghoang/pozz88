/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.bettype;

/**
 *
 * @author Rypon
 */
public class SoccerFulltimeBet {

    private HandicapBetType handicap;
    private GoalBetType goal;

    public SoccerFulltimeBet(HandicapBetType handicap, GoalBetType goal) {
        this.handicap = handicap;
        this.goal = goal;
    }

    public SoccerFulltimeBet() {
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
}
