package com.automation.tests;

import com.automation.pages.CartPage;
import com.automation.pages.CheckoutPage;
import com.automation.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends HomeTest {

    @Test
    public void checkoutTest() {
        ProductsPage productsPage = new ProductsPage(driver);

        productsPage.addBackpackToCart();
        productsPage.openCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);

        checkoutPage.enterFirstName("Dhruv");
        checkoutPage.enterLastName("Malhotra");
        checkoutPage.enterPostalCode("160001");

        checkoutPage.clickContinue();
        checkoutPage.clickFinish();

        Assert.assertEquals(
                checkoutPage.getOrderConfirmation(),
                "Thank you for your order!"
        );
    }
}