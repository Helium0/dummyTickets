package org.seleniumtest.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



public class BaseTest {

    protected static WebDriver driver;

    @BeforeMethod
    public static WebDriver  before() {
            driver = new ChromeDriver();
            driver.get("https://dummy-tickets.com/");
            driver.manage().window().maximize();

        return driver;
    }

    @AfterMethod
    public static void after(){
        driver.quit();
        System.out.println("Test passed");
    }

}


