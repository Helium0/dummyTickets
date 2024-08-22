package org.seleniumtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import java.time.Duration;
import java.util.List;

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


    public void datePicker(int monthh, String year, String day) {
        driver.findElement(By.name("departure[]")).click();
        WebElement monthElement = driver.findElement(By.className("ui-datepicker-month"));
        Select monthValue = new Select(monthElement);
        monthValue.selectByIndex(monthh);

        WebElement yearElement = driver.findElement(By.className("ui-datepicker-year"));
        Select desiredYear = new Select(yearElement);
        desiredYear.selectByValue(year);

        List<WebElement> days = driver.findElements(By.xpath("//table//td/a"));
        days.stream().filter(webElement -> webElement.getText().equals(day))
                .forEach(webElement -> webElement.click());

    }

    public void waitMethod(String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public void sourceMethod(String place) {
        List<WebElement> source = driver.findElements(By.xpath("//ul[@class='suggestions-list']//p"));
        source.stream().filter(webElement -> webElement.getText().contains(place))
                .forEach(webElement -> webElement.click());
    }

}


