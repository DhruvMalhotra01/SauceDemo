package com.automation.tests;

import com.automation.base.BaseTest;
import com.automation.pages.LoginPage;
import com.automation.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest(){
        LoginPage loginPage = new LoginPage(driver, configReader);
        loginPage.login("standard_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertEquals(productsPage.getPageTitle(),"Swag Labs");
    }

    @Test
    public void invalidPasswordTest(){
        LoginPage loginPage = new LoginPage(driver, configReader);
        loginPage.login(
                configReader.getProperty("username"),
                "wrong_password"
        );
        Assert.assertTrue(loginPage.getErrorMessage().contains("Username and password do not match"));
    }

    @Test
    public void emptyUsernameTest() {
        LoginPage loginPage = new LoginPage(driver, configReader);
        loginPage.login("", "secret_sauce");

        Assert.assertTrue(
                loginPage.getErrorMessage().contains("Username is required")
        );
    }
}