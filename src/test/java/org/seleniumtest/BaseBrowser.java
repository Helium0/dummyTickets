package org.seleniumtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

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

}
