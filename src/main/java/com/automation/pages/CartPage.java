package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    private WebDriver driver;
    private WebDriverWait wait; // 1. Declare the wait variable

    @FindBy(className = "inventory_item_name")
    private WebElement cartItem;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 2. Initialize the wait variable
    }

    public String getCartItemName() {
        return cartItem.getText();
    }

    public void clickCheckout() {
        // Wait for the checkout button to be visible before clicking
        wait.until(ExpectedConditions.visibilityOf(checkoutButton));
        checkoutButton.click();
    }
}