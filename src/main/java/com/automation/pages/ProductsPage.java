package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;



public class ProductsPage {

    private WebDriver driver;

    @FindBy(className = "app_logo")
    private WebElement pageTitle;

    @FindBy(className = "inventory_item")
    private List<WebElement> products;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addBackpackButton;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartLink;


    public ProductsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getPageTitle(){
        return pageTitle.getText();
    }

    public int getProductCount(){
        return products.size();
    }

    public void addBackpackToCart() {
        addBackpackButton.click();
    }
    public void openCart() {
        cartLink.click();
    }

}
