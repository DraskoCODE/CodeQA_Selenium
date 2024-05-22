package org.code.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CartPage {

    public ChromeDriver driver;

    public CartPage(ChromeDriver driver) {
        this.driver = driver;
    }

    public String returnItemName() {
        return driver.findElement(By.xpath("//div[@data-test='inventory-item-name']")).getText();
    }

    public Double returnItemPrice() {
        WebElement weItemPrice = driver.findElement(By.xpath("//div[@data-test='inventory-item-price']"));
        String priceAsString = weItemPrice.getText();
        return Double.parseDouble(priceAsString.substring(1));
    }

    public void close() {
        driver.quit();
    }

}
