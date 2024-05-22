package org.code.saucedemo.tests;

import org.code.saucedemo.pages.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests {

    @Test
    public void loginWithStandardUser() {
        System.setProperty("webdriver.chrome.driver", "D:\\Driver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickOnLogin();

        String actualUrl = loginPage.returnUrl();
        String expectedUrl = "https://www.saucedemo.com/inventory.html";

        Assert.assertEquals(actualUrl, expectedUrl, "URL is not as expected");

        loginPage.close();
    }

    @Test
    public void loginWithLockOutUser() {
        System.setProperty("webdriver.chrome.driver", "D:\\Driver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.setUserName("locked_out_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickOnLogin();

        String actualUrl = loginPage.returnUrl();
        String expectedUrl = "https://www.saucedemo.com/";

        Assert.assertEquals(actualUrl, expectedUrl, "URL is not as expected");

        loginPage.close();
    }

    @Test
    public void loginWithOutUserName() {
        System.setProperty("webdriver.chrome.driver", "D:\\Driver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.setPassword("secret_sauce");
        loginPage.clickOnLogin();

        String expectedUrl = "https://www.saucedemo.com/";
        String actualUrl = loginPage.returnUrl();

        if(actualUrl.equals(expectedUrl)) {
            Assert.assertEquals(actualUrl, expectedUrl, "URL is not as expected");
        }
        else {
            loginPage.close();
            Assert.assertEquals(actualUrl, expectedUrl, "URL is not as expected");
        }
        //Assert.assertEquals(actualUrl, expectedUrl, "URL is not as expected");

        String expectedErrorMessage = "Epic sadface: Username is required";
        String actualErrorMessage = loginPage.returnErrorMessage();

        if(actualErrorMessage.equals(expectedErrorMessage)) {
            Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message is not as expected");
        }
        else {
            loginPage.close();
            Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message is not as expected");
        }
        //Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message is not as expected");

        loginPage.close();
    }

    @Test
    public void loginWithOutPassword() {
        System.setProperty("webdriver.chrome.driver", "D:\\Driver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.setUserName("standard_user");
        loginPage.clickOnLogin();

        String expectedUrl = "https://www.saucedemo.com/";
        String actualUrl = loginPage.returnUrl();

        if(actualUrl.equals(expectedUrl)) {
            Assert.assertEquals(actualUrl, expectedUrl, "URL is not as expected");
        }
        else {
            loginPage.close();
            Assert.assertEquals(actualUrl, expectedUrl, "URL is not as expected");
        }
        //Assert.assertEquals(actualUrl, expectedUrl, "URL is not as expected");

        String expectedErrorMessage = "Epic sadface: Password is required";
        String actualErrorMessage = loginPage.returnErrorMessage();

        if(actualErrorMessage.equals(expectedErrorMessage)) {
            Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message is not as expected");
        }
        else {
            loginPage.close();
            Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message is not as expected");
        }
        //Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message is not as expected");

        loginPage.close();
    }

}
