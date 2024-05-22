package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TestSortProductItem {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\Driver\\chromedriver.exe");
        ChromeDriver chromeDriver = new ChromeDriver();

        chromeDriver.get("https://www.saucedemo.com/");

        //WebElement userNameField = chromeDriver.findElement(By.id("user-name"));
        WebElement userNameField = chromeDriver.findElement(By.xpath("//input[@data-test='username']"));
        userNameField.sendKeys("standard_user");

        WebElement passwordField = chromeDriver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");

        WebElement loginButton = chromeDriver.findElement(By.id("login-button"));
        loginButton.click();

        WebElement sortFilter = chromeDriver.findElement(By.xpath("//select[@class='product_sort_container']"));
        sortFilter.click();

        WebElement optionLowToHigh = sortFilter.findElement(By.xpath("//option[@value='lohi']"));
        optionLowToHigh.click();

        WebElement weInventoryList = chromeDriver.findElement(By.xpath(("//div[@data-test='inventory-container']")));
        List<WebElement> weListPrices = weInventoryList.findElements(By.xpath("//div[@class='inventory_item_price']"));

        Double previousPriceAsNumber = Double.parseDouble(weListPrices.get(0).getText().substring(1));
        for(int i = 0; i < weListPrices.size(); i++) {
            String priceAsString = weListPrices.get(i).getText();
            System.out.println(priceAsString);

            Double priceAsNumber = Double.parseDouble(priceAsString.substring(1));
            if(priceAsNumber >= previousPriceAsNumber) {
                System.out.println("PASSED");
            }
            else {
                System.out.println("FAILED");
            }
            previousPriceAsNumber = priceAsNumber;

        }

        chromeDriver.quit();
    }

}
