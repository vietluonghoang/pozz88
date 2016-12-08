/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import driver.RunningDriver;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author Rypon
 */
public class ConnectionHelper {

    public static final String FIREFOX = "firefox";
    public static final String CHROME = "chrome";
    public static final String IE = "ie";
    private GeneralHelper helper;

    public ConnectionHelper(GeneralHelper helper) {
        this.helper = helper;
    }

    public WebDriver startDriver(String browserName) {
        switch (browserName) {
            case FIREFOX:
                return new RunningDriver().firefoxDriver();
            case CHROME:
                return null;
            case IE:
                return null;
            default:
                return new RunningDriver().firefoxDriver();
        }
    }
}
