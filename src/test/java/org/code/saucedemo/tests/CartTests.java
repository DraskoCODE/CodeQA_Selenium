package org.code.saucedemo.tests;

import org.code.saucedemo.pages.CartPage;
import org.code.saucedemo.pages.InventoryPage;
import org.code.saucedemo.pages.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CartTests {

    @DataProvider(name = "data-provider")
    public Object[][] dataProviderProductsName(){
        return new Object[][] {{"sauce-labs-backpack", "Sauce Labs Backpack"},
                               {"sauce-labs-onesie", "Sauce Labs Onesie"}};
    }

    @Test(dataProvider = "data-provider")
    public void verifyAddedItemNameInCart(String itemName, String itemNameInCart) {
        System.setProperty("webdriver.chrome.driver", "D:\\Driver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickOnLogin();

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addItemToCart(itemName);
        inventoryPage.openCart();

        CartPage cartPage = new CartPage(driver);
        String itemNameInCartActual = cartPage.returnItemName();

        Assert.assertEquals(itemNameInCartActual, itemNameInCart, "Item name is not as expected");

        cartPage.close();

    }

    @Test
    public void verifyAddedSauceLabsFleeceJacketItemNameInCart() {
        System.setProperty("webdriver.chrome.driver", "D:\\Driver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickOnLogin();

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addItemToCart("sauce-labs-fleece-jacket");
        inventoryPage.openCart();

        CartPage cartPage = new CartPage(driver);
        String itemNameInCart = cartPage.returnItemName();

        Assert.assertEquals(itemNameInCart, "Sauce Labs Fleece Jacket", "Item name is not as expected");

        cartPage.close();

    }

    @Test
    public void verifyAddedItemPriceInCart() {
        System.setProperty("webdriver.chrome.driver", "D:\\Driver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickOnLogin();

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addItemToCart("sauce-labs-bike-light");
        inventoryPage.openCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.returnItemPrice();

        Assert.assertEquals(cartPage.returnItemPrice(), 9.99, "Item price is not as expected");

        cartPage.close();
    }

}
