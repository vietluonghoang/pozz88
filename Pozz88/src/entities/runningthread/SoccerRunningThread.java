/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.runningthread;

import gui.Main;
import interfaces.Match;
import interfaces.RunningThread;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    private Main parent;
    private ArrayList<Match> matches;
    private String[] preconditions = {"isLoggedin"};

    public SoccerRunningThread(Main parent, GeneralHelper helper) {
        this.helper = helper;
        this.parent = parent;
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
        for (String method : preconditions) {
            try {
                if (!(boolean) this.getClass().getMethod(method).invoke(this)) {
                    isKeepRunning = false;
                    helper.setLog("Check: '" + method + "'... Fail");
                    break;
                }
            } catch (IllegalAccessException ex) {
                helper.setLog("Illegal Access Invoking Method: " + method);
            } catch (IllegalArgumentException ex) {
                helper.setLog("Illegal Argument Invoking Method: " + method);
            } catch (InvocationTargetException ex) {
                helper.setLog("Invocation Target Invoking Method: " + method);
            } catch (NoSuchMethodException ex) {
                helper.setLog("No such method found: " + method);
            } catch (SecurityException ex) {
                helper.setLog("Security exception for accessing method: " + method);
            }
            helper.setLog("Check: '" + method + "'... Pass");
        }
    }

    public boolean isLoggedin() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame("topFrame");
        return driver.findElements(By.xpath("//div[@id='Logout']")).size() > 0;
    }

    @Override
    public void perform() {
        preconditionCheck();
        expandSoccerEvents();
        prepareDefinedMainFly();
    }

    private void expandSportMenu() {
        if (!driver.findElement(By.xpath("//span[@id='lblHideSportsMenu']")).isDisplayed()) {
            safelyClick("//span[@id='lblShowSportsMenu']");
        }
    }

    private void expandTodaySportMenuTab() {
        expandSportMenu();
        safelyClick("//span[@id='market_T_text']");
    }

    private void expandSoccerEvents() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame("leftFrame");
        expandTodaySportMenuTab();
        safelyClick("//span[@id='MenuContainer']/div[@id='subnavbg']//a[@title='Soccer']");
    }

    private void prepareDefinedMainFly() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame("mainFrame");
        safelyClick("//div[@id='MainFly']/div[@id='column1']/div[@class='right']/div[@id='selLeagueType_Div']");
        safelyClick("//div[@id='MainFly']/div[@id='column1']/div[@class='right']/div[@id='selLeagueType_Div']/ul[@id='selLeagueType_menu']/li[1]");
        safelyClick("//div[@id='MainFly']/div[@id='column1']/div[@class='right']/div[@id='disstyle_Div']");
        safelyClick("//div[@id='MainFly']/div[@id='column1']/div[@class='right']/div[@id='disstyle_Div']/ul[@id='disstyle_menu']/li[2]");
    }

    private void safelyClick(String xpath) {
        List<WebElement> elements = driver.findElements(By.xpath(xpath));
        if (elements.size() > 1) {
            helper.setLog("---- more than 1 element found for:\n" + xpath);
        }
        if (elements.size() < 1) {
            helper.setLog("---- no elements found for:\n" + xpath);
        } else {
            elements.get(0).click();
            helper.setLog("Clicking: \n" + xpath);
        }
    }

    @Override
    public void stopNow() {
        isKeepRunning = false;
    }

    @Override
    public void updateInfo(ArrayList<Match> matches) {
        parent.updateInfo(matches);
    }
}
