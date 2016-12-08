/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Rypon
 */
public interface Match {
    public String getId();
    public String getTime();
    public Team getHomeName();
    public Team getAwayName();
    public League getLeague();
    public HashMap<Team, Integer> getScore();
    public Team getFavourite();
    public ArrayList<AvailableBet> getBets();
}
