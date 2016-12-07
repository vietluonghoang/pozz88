/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.bettype;

import interfaces.BetType;

/**
 *
 * @author Rypon
 */
public class HandicapBetType implements BetType {

    private float rate;
    private float home;
    private float away;

    public HandicapBetType(float rate, float home, float away) {
        this.rate = rate;
        this.home = home;
        this.away = away;
    }

    public HandicapBetType() {
    }
    
    public void setHome(float home) {
        this.home = home;
    }

    public void setAway(float away) {
        this.away = away;
    }

    public float getHome() {
        return home;
    }

    public float getAway() {
        return away;
    }

    @Override
    public float getRate() {
        return rate;
    }

    @Override
    public void setRate(float rate) {
        this.rate = rate;
    }
}
