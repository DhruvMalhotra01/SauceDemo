package com.automation.tests;

import com.automation.base.BaseTest;
import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class HomeTest extends BaseTest {

    @BeforeMethod
    public void setUpLogin() {
        LoginPage loginPage = new LoginPage(driver, configReader);
        loginPage.login();
    }

    @Test
    public void logoutTest() throws InterruptedException{
        HomePage homePage = new HomePage(driver);

        homePage.openMenu();
        homePage.logout();

        Thread.sleep(2000);


        Assert.assertTrue(
                homePage.isLoginButtonDisplayed(),
                "Login button is not displayed after logout!"
        );

        Assert.assertEquals(
                driver.getCurrentUrl(),
                "https://www.saucedemo.com/"
        );
    }
}