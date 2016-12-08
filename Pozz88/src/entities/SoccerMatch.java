/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import interfaces.AvailableBet;
import interfaces.Match;
import interfaces.Team;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Rypon
 */
public class SoccerMatch implements Match {

    private String id;
    private String time;
    private SoccerTeam homeName;
    private SoccerTeam awayName;
    private SoccerLeague league;
    private HashMap<Team, Integer> score;
    private SoccerTeam favourite;
    private ArrayList<AvailableBet> bets;

    public SoccerMatch() {
    }

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public SoccerTeam getHomeName() {
        return homeName;
    }

    public void setHomeName(SoccerTeam homeName) {
        this.homeName = homeName;
    }

    @Override
    public SoccerTeam getAwayName() {
        return awayName;
    }

    public void setAwayName(SoccerTeam awayName) {
        this.awayName = awayName;
    }

    @Override
    public SoccerLeague getLeague() {
        return league;
    }

    public void setLeague(SoccerLeague league) {
        this.league = league;
    }

    @Override
    public HashMap<Team, Integer> getScore() {
        return score;
    }

    public void setScore(HashMap<Team, Integer> score) {
        this.score = score;
    }

    @Override
    public SoccerTeam getFavourite() {
        return favourite;
    }

    @Override
    public ArrayList<AvailableBet> getBets() {
        return bets;
    }
}
