package org.seleniumtest.funcionaltests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


import java.util.List;

public class FlightTicket {

    @Test
    public void dummyFlightTicketOldDate() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://dummy-tickets.com/");
        driver.findElement(By.name("source[]")).sendKeys("Po");
        List<WebElement> source = driver.findElements(By.xpath("//ul[@class='suggestions-list']//p"));
        source.stream().filter(webElement -> webElement.getText().contains("Al Ain"))
                .forEach(webElement -> webElement.click());

        driver.findElement(By.name("destination[]")).sendKeys("Ol");
        List<WebElement> destination = driver.findElements(By.xpath("//input[@name='destination[]']/following-sibling::ul//p"));
        destination.stream().filter(webElement -> webElement.getText().contains("Bole"))
                .forEach(webElement -> webElement.click());

        driver.findElement(By.name("departure[]")).click();
        WebElement monthElement = driver.findElement(By.className("ui-datepicker-month"));
        Select month = new Select(monthElement);
        month.selectByIndex(0);

        WebElement yearElement = driver.findElement(By.className("ui-datepicker-year"));
        Select year = new Select(yearElement);
        year.selectByValue("2023");

        List<WebElement> days = driver.findElements(By.xpath("//table//td/a"));
        days.stream().filter(webElement -> webElement.getText().equals("2"))
                .forEach(webElement -> webElement.click());

        driver.findElement(By.id("flight_oneway_btn")).click();
    }


    @Test
    public void dummyFlightTicketFutureDate() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://dummy-tickets.com/");
        driver.findElement(By.name("source[]")).sendKeys("Po");
        List<WebElement> source = driver.findElements(By.xpath("//ul[@class='suggestions-list']//p"));
        source.stream().filter(webElement -> webElement.getText().contains("Al Ain"))
                .forEach(webElement -> webElement.click());

        driver.findElement(By.name("destination[]")).sendKeys("Ol");
        List<WebElement> destination = driver.findElements(By.xpath("//input[@name='destination[]']/following-sibling::ul//p"));
        destination.stream().filter(webElement -> webElement.getText().contains("Bole"))
                .forEach(webElement -> webElement.click());

        driver.findElement(By.name("departure[]")).click();
        WebElement monthElement = driver.findElement(By.className("ui-datepicker-month"));
        Select month = new Select(monthElement);
        month.selectByIndex(10);

        WebElement yearElement = driver.findElement(By.className("ui-datepicker-year"));
        Select year = new Select(yearElement);
        year.selectByValue("2025");

        List<WebElement> days = driver.findElements(By.xpath("//table//td/a"));
        days.stream().filter(webElement -> webElement.getText().equals("25"))
                .forEach(webElement -> webElement.click());

        driver.findElement(By.id("flight_oneway_btn")).click();


    }
}
