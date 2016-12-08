/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.runningthread;

import interfaces.RunningThread;
import org.openqa.selenium.WebDriver;
import utilities.AccountHelper;
import utilities.ConnectionHelper;
import utilities.DriverHelper;
import utilities.GeneralHelper;

/**
 *
 * @author Rypon
 */
public class SoccerRunningThread implements RunningThread {

    private String name = "http://bong88.com - Soccer";
    private WebDriver driver;
    private GeneralHelper helper;
    private DriverHelper driverHelper;
    private String browserName = ConnectionHelper.FIREFOX;
    private boolean isKeepRunning = true;

    public SoccerRunningThread(GeneralHelper helper) {
        this.helper = helper;
    }

    @Override
    public void startThread() {
        initDriver();
        new AccountHelper(helper).bong88Login(driver);
    }

    private void initDriver() {
        if (driver == null) {
            driver = new ConnectionHelper(helper).startDriver(browserName);
            driverHelper = new DriverHelper(helper, driver);
        } else {
            helper.setLog("Driver does not seem to be available. Please check!");
        }
    }

    @Override
    public boolean isGoingToStop() {
        return !isKeepRunning;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void preconditionCheck() {
        boolean isPassed = false;

        if (isPassed) {
            isKeepRunning = true;
        } else {
            isKeepRunning = false;
        }
    }

    @Override
    public void perform() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void stopNow() {
        isKeepRunning = false;
    }
}
