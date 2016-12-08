/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import org.openqa.selenium.WebDriver;

/**
 *
 * @author Rypon
 */
public class DriverHelper {

    private WebDriver driver;
    private GeneralHelper helper;

    public DriverHelper(GeneralHelper helper, WebDriver driver) {
        this.helper = helper;
        this.driver = driver;
    }

    public void cleanupWindows(String currentWindow) {
        if (driver == null) {
            helper.setLog("Driver does not seem to be available. Please check!");
        } else {
            for (String window : driver.getWindowHandles()) {
                if (!window.equals(currentWindow)) {
                    driver.switchTo().window(window).close();
                }
            }
            driver.switchTo().window(currentWindow);
        }
    }

    public void closeAllWindows() {
        if (driver == null) {
            helper.setLog("Driver does not seem to be available. Please check!");
        } else {
            for (String window : driver.getWindowHandles()) {
                driver.switchTo().window(window).close();
            }
            driver.close();
        }
    }
}
