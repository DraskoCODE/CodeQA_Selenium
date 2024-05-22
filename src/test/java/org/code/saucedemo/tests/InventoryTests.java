package org.code.saucedemo.tests;

import org.code.saucedemo.pages.InventoryPage;
import org.code.saucedemo.pages.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class InventoryTests {

    @DataProvider(name = "data-provider")
    public Object[][] returnItemName() {
        return new Object[][] {{"sauce-labs-onesie"},
                               {"sauce-labs-backpack"},
                               {"sauce-labs-fleece-jacket"}};
    }

    @DataProvider(name = "data-provider-two-items")
    public Object[][] returnItemsName() {
        return new Object[][] {{"sauce-labs-onesie", "sauce-labs-fleece-jacket"},
                               {"sauce-labs-backpack", "sauce-labs-fleece-jacket"},
                               {"sauce-labs-fleece-jacket", "sauce-labs-bolt-t-shirt"}};
    }

    @DataProvider(name = "data-provider-three-items")
    public Object[][] returnThreeItemsName() {
        return new Object[][] {{"sauce-labs-onesie", "sauce-labs-fleece-jacket", "sauce-labs-backpack"},
                               {"sauce-labs-backpack", "sauce-labs-fleece-jacket", "sauce-labs-bolt-t-shirt"}};
    }

    @Test(dataProvider = "data-provider")
    public void addItemToCart(String itemName) {
        System.setProperty("webdriver.chrome.driver", "D:\\Driver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickOnLogin();

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addItemToCart(itemName);
        //inventoryPage.addItemToCart("sauce-labs-onesie");
        System.out.println("Cart number " + inventoryPage.showNumberItemInCart());

        Assert.assertEquals(inventoryPage.showNumberItemInCart(), 1, "Number count is not as expected");

        inventoryPage.close();

    }

    @Test(dataProvider = "data-provider-two-items")
    public void addTwoItemsToCart(String firstItemName, String secondItemName) {
        System.setProperty("webdriver.chrome.driver", "D:\\Driver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickOnLogin();

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addItemToCart(firstItemName);
        inventoryPage.addItemToCart(secondItemName);
        System.out.println("Cart number " + inventoryPage.showNumberItemInCart());

        Assert.assertEquals(inventoryPage.showNumberItemInCart(), 2, "Number count is not as expected");

        inventoryPage.close();

    }

    @Test(dataProvider = "data-provider-three-items")
    public void addThreeItemsToCart(String firstItemName, String secondItemName, String thirdItem) {
        System.setProperty("webdriver.chrome.driver", "D:\\Driver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickOnLogin();

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addItemToCart(firstItemName);
        inventoryPage.addItemToCart(secondItemName);
        inventoryPage.addItemToCart(thirdItem);
        System.out.println("Cart number " + inventoryPage.showNumberItemInCart());

        Assert.assertEquals(inventoryPage.showNumberItemInCart(), 3, "Number count is not as expected");

        inventoryPage.close();

    }

    @Test
    public void addAllItemsToCart() {
        System.setProperty("webdriver.chrome.driver", "D:\\Driver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickOnLogin();

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addItemToCart("sauce-labs-backpack");
        inventoryPage.addItemToCart("sauce-labs-bike-light");
        inventoryPage.addItemToCart("sauce-labs-bolt-t-shirt");
        inventoryPage.addItemToCart("sauce-labs-fleece-jacket");
        inventoryPage.addItemToCart("sauce-labs-onesie");
        inventoryPage.addItemToCart("test.allthethings()-t-shirt-(red)");

        System.out.println("Cart number " + inventoryPage.showNumberItemInCart());

        Assert.assertEquals(inventoryPage.showNumberItemInCart(), 6, "Number count is not as expected");

        inventoryPage.close();

    }

}
