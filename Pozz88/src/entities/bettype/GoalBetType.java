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
public class GoalBetType implements BetType{
    
    private float rate;
    private float over;
    private float under;

    public GoalBetType(float rate, float over, float under) {
        this.rate = rate;
        this.over = over;
        this.under = under;
    }

    public GoalBetType() {
    }  
    
    public float getOver() {
        return over;
    }

    public void setOver(float over) {
        this.over = over;
    }

    public float getUnder() {
        return under;
    }

    public void setUnder(float under) {
        this.under = under;
    }
    
    @Override
    public float getRate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setRate(float rate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
