package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.*;

public class TestLoginWithoutPassword {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\Driver\\chromedriver.exe");
        ChromeDriver chromeDriver = new ChromeDriver();

        chromeDriver.get("https://www.saucedemo.com/");

        WebElement userNameField = chromeDriver.findElement(By.xpath("//input[@data-test='username']"));
        userNameField.sendKeys("locked_out_user");

        WebElement loginButton = chromeDriver.findElement(By.xpath("//input[@value='Login']"));
        loginButton.click();

        if(chromeDriver.getCurrentUrl().equals("https://www.saucedemo.com/")) {
            System.out.println("PASSED");

            String expectedErrorMessage = "Epic sadface: Password is required";

            WebElement errorMessage = chromeDriver.findElement(By.xpath("//h3[@data-test='error']"));
            String actualErrorMessage = errorMessage.getText();
            if(actualErrorMessage.equals(expectedErrorMessage)) {
                System.out.println("Error message is equals");
            }
            else {
                System.out.println("Failed, error message is not equals");
            }
        }
        else {
            System.out.println("FAILED");
        }

        chromeDriver.quit();

    }

}
