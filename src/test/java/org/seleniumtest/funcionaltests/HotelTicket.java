package org.seleniumtest.funcionaltests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.seleniumtest.BaseTest;
import org.testng.annotations.Test;



public class HotelTicket extends BaseTest {


    @Test
    public void dummyHotelTicketFutureDate() {
        driver.findElement(By.xpath("//a[text()='Hotel']")).click();
        WebElement city = driver.findElement(By.name("city[]"));
        city.sendKeys("Londo");
        waitMethod("//ul[@class='suggestions-cities-list']//p");
        searchHotelFromDynamicListMethod();
        driver.findElement(By.name("checkin[]")).click();
        hotelDatePickerMethod("2026", "Apr", "26","//span[text()='Next']");

        driver.findElement(By.name("checkout[]")).click();
        hotelDatePickerMethod("2027","Apr", "26","//span[text()='Next']");

    }

    @Test

    public void dummyHotelTicketPastDate() {
        driver.findElement(By.xpath("//a[text()='Hotel']")).click();
        WebElement city = driver.findElement(By.name("city[]"));
        city.sendKeys("Londo");
        waitMethod("//ul[@class='suggestions-cities-list']//p");
        searchHotelFromDynamicListMethod();
        driver.findElement(By.name("checkin[]")).click();
        hotelDatePickerMethod("2022", "Dec","15","//span[text()='Prev']");

        driver.findElement(By.name("checkout[]")).click();
        hotelDatePickerMethod("2023", "Jun","9","//span[text()='Prev']");

    }
}
