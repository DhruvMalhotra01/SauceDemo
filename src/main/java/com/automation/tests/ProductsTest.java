package com.automation.tests;

import com.automation.pages.CartPage;
import com.automation.pages.LoginPage;
import com.automation.pages.ProductsPage;
import com.automation.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {

    @BeforeMethod
    public void setUpLogin() {
        LoginPage loginPage = new LoginPage(driver, configReader);
        loginPage.login();
    }

    @Test
    public void verifyProductsPage() {
        ProductsPage productsPage = new ProductsPage(driver);

        Assert.assertEquals(
                productsPage.getPageTitle(),
                "Swag Labs"
        );
    }

    @Test
    public void verifyInventoryAreDisplayed(){
        ProductsPage productsPage = new ProductsPage(driver);

        Assert.assertTrue(productsPage.getProductCount() > 0);
    }

    @Test
    public void verifyAddBackpackToCart() {
        ProductsPage productsPage = new ProductsPage(driver);

        productsPage.addBackpackToCart();
        productsPage.openCart();

        CartPage cartPage = new CartPage(driver);

        Assert.assertEquals(
                cartPage.getCartItemName(),
                "Sauce Labs Backpack"
        );
    }
}