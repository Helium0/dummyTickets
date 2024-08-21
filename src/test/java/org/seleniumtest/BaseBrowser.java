package org.seleniumtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseBrowser {

    protected static WebDriver driver;

    public static WebDriver getDriver() {
        if(driver == null) {
            driver = new ChromeDriver();
            driver.get("https://dummy-tickets.com/");
            driver.manage().window().maximize();
        }
        return driver;
    }
}
