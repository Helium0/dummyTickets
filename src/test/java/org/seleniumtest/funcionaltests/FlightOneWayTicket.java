package org.seleniumtest.funcionaltests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.seleniumtest.BaseBrowser;
import org.testng.annotations.Test;


import java.time.Duration;
import java.util.List;

public class FlightOneWayTicket extends BaseBrowser {

    @Test
    public void dummyFlightTicketOldDate() {
        driver = BaseBrowser.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.name("source[]")).sendKeys("Po");
        List<WebElement> source = driver.findElements(By.xpath("//ul[@class='suggestions-list']//p"));
        source.stream().filter(webElement -> webElement.getText().contains("Al Ain"))
                .forEach(webElement -> webElement.click());

        driver.findElement(By.name("destination[]")).sendKeys("Ol");
        List<WebElement> destination = driver.findElements(By.xpath("//input[@name='destination[]']/following-sibling::ul//p"));
        destination.stream().filter(webElement -> webElement.getText().contains("Olkhovka"))
                .forEach(webElement -> webElement.click());

        datePicker(2,"2023", "10");

        driver.findElement(By.id("flight_oneway_btn")).click();

    }

    @Test
    public void dummyFlightTicketFutureDate() {
        driver = BaseBrowser.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.name("source[]")).sendKeys("Po");
        List<WebElement> source = driver.findElements(By.xpath("//ul[@class='suggestions-list']//p"));
        source.stream().filter(webElement -> webElement.getText().contains("Al Ain"))
                .forEach(webElement -> webElement.click());

        driver.findElement(By.name("destination[]")).sendKeys("Ol");
        List<WebElement> destination = driver.findElements(By.xpath("//input[@name='destination[]']/following-sibling::ul//p"));
        destination.stream().filter(webElement -> webElement.getText().contains("Olkhovka"))
                .forEach(webElement -> webElement.click());

        datePicker(10,"2025","26");

        driver.findElement(By.id("flight_oneway_btn")).click();


    }
}
