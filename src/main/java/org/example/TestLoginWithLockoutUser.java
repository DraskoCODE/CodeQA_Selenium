package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TestLoginWithLockoutUser {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\Driver\\chromedriver.exe");
        ChromeDriver chromeDriver = new ChromeDriver();

        chromeDriver.get("https://www.saucedemo.com/");

        //WebElement userNameField = chromeDriver.findElement(By.id("user-name"));
        WebElement userNameField = chromeDriver.findElement(By.xpath("//input[@data-test='username']"));
        userNameField.sendKeys("locked_out_user");

        WebElement passwordField = chromeDriver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");

        WebElement loginButton = chromeDriver.findElement(By.id("login-button"));
        loginButton.click();

        String actualUrl = chromeDriver.getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/";

        Assert.assertEquals(actualUrl, expectedUrl, "URL is not as expected");

        chromeDriver.quit();

    }


}
