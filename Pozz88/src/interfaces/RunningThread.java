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
public interface RunningThread {
    public void startThread();
    public void preconditionCheck();
    public void perform();
    public boolean isGoingToStop();
    public String getName();
    public void stopNow();
    public void updateInfo(ArrayList<Match> matches);
}
