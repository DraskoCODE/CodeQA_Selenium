package org.code.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InventoryPage {

    public ChromeDriver driver;

    public InventoryPage(ChromeDriver driver) {
        this.driver = driver;
    }

    public void open() {

    }

    public void addItemToCart(String productName) {
        WebElement weAddToCart = driver.findElement(By.id("add-to-cart-" + productName));
        weAddToCart.click();
    }

    public void removeItemFromCart(String productName) {
        WebElement weRemoveFromCart = driver.findElement(By.id("remove-" + productName));
        weRemoveFromCart.click();
    }

    public void addItemSauceLabsBackPackToCart() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        //WebElement weAddToCart = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        //weAddToCart.click();
    }

    public void addItemSauceLabsBikeLightToCart() {
        WebElement weAddToCart = driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
        weAddToCart.click();
    }

    public void addItemSauceLabsOnesieToCart() {
        driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
    }

    public Integer showNumberItemInCart() {
        WebElement weCart = driver.findElement(By.xpath("//span[@data-test='shopping-cart-badge']"));
        String stringCartNumber = weCart.getText();
        Integer intCartNumber = Integer.parseInt(stringCartNumber);
        return intCartNumber;

        //return Integer.parseInt(driver.findElement(By.xpath("//span[@data-test='shopping-cart-badge']")).getText());

    }

    public void openCart() {
        driver.findElement(By.xpath("//a[@data-test='shopping-cart-link']")).click();
    }

    public void close() {
        driver.close();
    }

}
