package org.seleniumtest.funcionaltests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.seleniumtest.BaseBrowser;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;


public class HotelTicket extends BaseBrowser {


    @Test
    public void dummyHotelTicketFutureDate() {
        driver = BaseBrowser.getDriver();
        driver.findElement(By.xpath("//a[text()='Hotel']")).click();
        WebElement city = driver.findElement(By.name("city[]"));
        city.sendKeys("Londo");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='suggestions-cities-list']//p")));
        List<WebElement> cities = driver.findElements(By.xpath("//ul[@class='suggestions-cities-list']//p"));
        cities.stream().filter(webElement -> webElement.getText().contains("Londonderr"))
                .forEach(webElement -> webElement.click());
        driver.findElement(By.name("checkin[]")).click();

        while(true){
            String actualYear = driver.findElement(By.className("ui-datepicker-year")).getText();
            driver.findElement(By.xpath("//span[text()='Next']")).click();
            if(actualYear.equals("2026")){
               break;
            }
        }

        WebElement datepickerMonth= driver.findElement(By.className("ui-datepicker-month"));
        Select month = new Select(datepickerMonth);
        month.selectByVisibleText("Apr");

        List<WebElement> daysList = driver.findElements(By.xpath("//tbody//td/a"));
        for(WebElement day : daysList){
            if(day.getText().equals("26")){
                day.click();
                break;
            }
        }

        driver.findElement(By.name("checkout[]")).click();
        while(true){
            String actualYear = driver.findElement(By.className("ui-datepicker-year")).getText();
            driver.findElement(By.xpath("//span[text()='Next']")).click();
            if(actualYear.equals("2027")){
                break;
            }
        }

        datepickerMonth = driver.findElement(By.className("ui-datepicker-month"));
        Select month2 = new Select(datepickerMonth);
        month2.selectByVisibleText("Apr");

        daysList = driver.findElements(By.xpath("//tbody//td/a"));
        for(WebElement day : daysList){
            if(day.getText().equals("26")){
                day.click();
                break;
            }
        }
    }

    @Test

    public void dummyHotelTicketPastDate() {
        driver = BaseBrowser.getDriver();
        driver.findElement(By.xpath("//a[text()='Hotel']")).click();
        WebElement city = driver.findElement(By.name("city[]"));
        city.sendKeys("Londo");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='suggestions-cities-list']//p")));
        List<WebElement> cities = driver.findElements(By.xpath("//ul[@class='suggestions-cities-list']//p"));
        cities.stream().filter(webElement -> webElement.getText().contains("Londonderr"))
                .forEach(webElement -> webElement.click());
        driver.findElement(By.name("checkin[]")).click();

        while (true) {
            String actualYear = driver.findElement(By.className("ui-datepicker-year")).getText();
            driver.findElement(By.xpath("//span[text()='Prev']")).click();
            if (actualYear.equals("2022")) {
                break;
            }
        }

        WebElement datepickerMonth = driver.findElement(By.className("ui-datepicker-month"));
        Select month = new Select(datepickerMonth);
        month.selectByVisibleText("Dec");

        List<WebElement> daysList = driver.findElements(By.xpath("//tbody//td/a"));
        for (WebElement day : daysList) {
            if (day.getText().equals("15")) {
                day.click();
                break;
            }
        }

        driver.findElement(By.name("checkout[]")).click();
        while (true) {
            String actualYear = driver.findElement(By.className("ui-datepicker-year")).getText();
            driver.findElement(By.xpath("//span[text()='Prev']")).click();
            if (actualYear.equals("2023")) {
                break;
            }
        }

        datepickerMonth = driver.findElement(By.className("ui-datepicker-month"));
        Select month2 = new Select(datepickerMonth);
        month2.selectByVisibleText("Jun");

        daysList = driver.findElements(By.xpath("//tbody//td/a"));
        for (WebElement day : daysList) {
            if (day.getText().equals("9")) {
                day.click();
                break;
            }
        }
    }
}
