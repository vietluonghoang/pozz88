/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import interfaces.RunningThread;
import utilities.GeneralHelper;

/**
 *
 * @author Rypon
 */
public class ThreadRunner implements Runnable {

    private RunningThread thread;
    private GeneralHelper helper;

    public ThreadRunner(RunningThread thread, GeneralHelper helper) {
        this.thread = thread;
        this.helper = helper;
    }

    @Override
    public void run() {
        if (!thread.isGoingToStop()) {
            thread.startThread();
        }
        while (!thread.isGoingToStop()) {
            thread.perform();
        }
    }

}
