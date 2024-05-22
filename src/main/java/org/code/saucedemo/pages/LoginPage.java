package org.code.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {

    public ChromeDriver driver;

    public LoginPage(ChromeDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://www.saucedemo.com/");
    }

    public void setUserName(String userName) {
        WebElement weUserName = driver.findElement(By.name("user-name"));
        weUserName.sendKeys(userName);
        //driver.findElement(By.name("user-name")).sendKeys(userName);
    }

    public void setPassword(String password) {
        //nalazenje webElement-a
        WebElement wePassword = driver.findElement(By.name("password"));

        //akcija nad webElementom
        wePassword.sendKeys(password);

        //driver.findElement(By.name("password")).sendKeys(password);
    }

    public void clickOnLogin() {
        WebElement weLogin = driver.findElement(By.id("login-button"));
        weLogin.click();
        //driver.findElement(By.id("login-button")).click();
    }

    public String returnUrl() {
        return driver.getCurrentUrl();
    }

    public String returnErrorMessage() {
        WebElement weErrorMessage = driver.findElement(By.xpath("//h3[@data-test='error']"));
        String stringErrorMessage = weErrorMessage.getText();
        return stringErrorMessage;
        //return driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
    }

    public void close() {
        driver.quit();
    }

}
