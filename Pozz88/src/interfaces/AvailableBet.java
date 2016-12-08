/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.ArrayList;

/**
 *
 * @author Rypon
 */
public interface AvailableBet {

    public ArrayList<BetType> getBets();

    public void setBets(ArrayList<BetType> bets);

    public String getName();
}
