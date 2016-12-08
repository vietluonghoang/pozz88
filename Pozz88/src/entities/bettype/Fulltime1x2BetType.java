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
public class Fulltime1x2BetType implements BetType {

    private String name = "1x2";
    private float draw;
    private float home;
    private float away;

    public Fulltime1x2BetType() {
    }

    public Fulltime1x2BetType(float draw, float home, float away) {
        this.draw = draw;
        this.home = home;
        this.away = away;
    }

    public float getHome() {
        return home;
    }

    public void setHome(float home) {
        this.home = home;
    }

    public float getAway() {
        return away;
    }

    public void setAway(float away) {
        this.away = away;
    }

    @Override
    public float getRate() {
        return draw;
    }

    @Override
    public void setRate(float rate) {
        this.draw = rate;
    }

    @Override
    public String getName() {
        return name;
    }
}
