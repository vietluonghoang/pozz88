/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author Rypon
 */
public class AccountHelper {

    private GeneralHelper helper;

    public AccountHelper(GeneralHelper helper) {
        this.helper = helper;
    }

    public void bong88Login(WebDriver driver) {
        String username = "sjk36t300019";
        String password = "Qqq111";
        String homeUrl = "http://bong88.com";
        
        driver.get(homeUrl);
        if (driver.getCurrentUrl().contains("login888")) {
            List<WebElement> userFields = driver.findElements(By.xpath("//input[@id='txtID']"));
            List<WebElement> pwdFields = driver.findElements(By.xpath("//input[@id='txtPW']"));
            List<WebElement> loginBtns = driver.findElements(By.xpath("//div[@class='loginBtnPos']/a[@class='login_btn']"));
            if (userFields.size() > 0 && pwdFields.size() > 0 && loginBtns.size() > 0 && userFields.size() < 2 && pwdFields.size() < 2 && loginBtns.size() < 2) {
                userFields.get(0).sendKeys(username);
                pwdFields.get(0).sendKeys(password);
                loginBtns.get(0).click();
            } else {
                helper.setLog("Username or Password or Login button not found.");
            }
        } else {
            helper.setLog("User seems to be logged in.");
        }
    }
}
