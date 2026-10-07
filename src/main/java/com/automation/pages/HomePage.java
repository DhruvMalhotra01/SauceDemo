package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement menuButton;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutLink;

    @FindBy(id = "login-button")
    private WebElement loginButton;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openMenu() {
        menuButton.click();

        wait.until(ExpectedConditions.visibilityOf(logoutLink));
    }
    public void logout() {
        logoutLink.click();
        // Wait until the URL goes back to the base login URL
        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/"));
    }
    public boolean isLoginButtonDisplayed() {
        return loginButton.isDisplayed();
    }
}