/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import entities.bettype.SoccerFulltimeBet;
import entities.bettype.SoccerHalftimeBet;
import interfaces.Match;
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
    private HashMap<SoccerTeam, Integer> score;
    private SoccerTeam favourite;
    private SoccerFulltimeBet fulltimeBet;
    private SoccerHalftimeBet halftimeBet;

    public SoccerMatch(String id, String time, SoccerTeam homeName, SoccerTeam awayName, SoccerLeague league, HashMap<SoccerTeam, Integer> score, SoccerTeam favourite, SoccerFulltimeBet fulltimeBet, SoccerHalftimeBet halftimeBet) {
        this.id = id;
        this.time = time;
        this.homeName = homeName;
        this.awayName = awayName;
        this.league = league;
        this.score = score;
        this.favourite = favourite;
        this.fulltimeBet = fulltimeBet;
        this.halftimeBet = halftimeBet;
    }

    public SoccerMatch(String time, SoccerTeam homeName, SoccerTeam awayName, SoccerLeague league, SoccerTeam favourite, SoccerFulltimeBet fulltimeBet, SoccerHalftimeBet halftimeBet) {
        this.time = time;
        this.homeName = homeName;
        this.awayName = awayName;
        this.league = league;
        this.favourite = favourite;
        this.fulltimeBet = fulltimeBet;
        this.halftimeBet = halftimeBet;
    }

    public SoccerMatch() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public SoccerTeam getHomeName() {
        return homeName;
    }

    public void setHomeName(SoccerTeam homeName) {
        this.homeName = homeName;
    }

    public SoccerTeam getAwayName() {
        return awayName;
    }

    public void setAwayName(SoccerTeam awayName) {
        this.awayName = awayName;
    }

    public SoccerLeague getLeague() {
        return league;
    }

    public void setLeague(SoccerLeague league) {
        this.league = league;
    }

    public HashMap<SoccerTeam, Integer> getScore() {
        return score;
    }

    public void setScore(HashMap<SoccerTeam, Integer> score) {
        this.score = score;
    }

    public SoccerTeam getFavourite() {
        return favourite;
    }

    public void setFavourite(SoccerTeam favourite) {
        this.favourite = favourite;
    }

    public SoccerFulltimeBet getFulltimeBet() {
        return fulltimeBet;
    }

    public void setFulltimeBet(SoccerFulltimeBet fulltimeBet) {
        this.fulltimeBet = fulltimeBet;
    }

    public SoccerHalftimeBet getHalftimeBet() {
        return halftimeBet;
    }

    public void setHalftimeBet(SoccerHalftimeBet halftimeBet) {
        this.halftimeBet = halftimeBet;
    }

}
