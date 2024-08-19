package org.seleniumtest.funcionaltests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FlightTicket {

    @Test
    public void dummyFlightTicket() {
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
    }
}