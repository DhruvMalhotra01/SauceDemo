package com.automation.base;

import com.com.automation.utils.ConfigReader; // FIXED: Removed duplicate 'com.' typo
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class BaseTest {
    protected WebDriver driver;
    protected ConfigReader configReader;
//    we use protected because login class inherit from base class

    @BeforeMethod // so each test case got a fresh browser
    public void setUp(){

        configReader = new ConfigReader();
        try{
            configReader.loadProperties();
        }catch (IOException e){
            throw new RuntimeException(e);
        }

        WebDriverManager.chromedriver().setup();
//        this will prepare the chromedriver setup from selenium
        driver = new ChromeDriver(); // create the browser session

        driver.manage().window().maximize();
        driver.get(configReader.getProperty("url"));
    }

    @AfterMethod
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }
}