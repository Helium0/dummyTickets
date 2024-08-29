package org.seleniumtest.funcionaltests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.seleniumtest.pages.HomePage;
import org.seleniumtest.tests.BaseTest;
import org.testng.annotations.Test;



public class FlightandHotelTicket extends BaseTest {

    String fromWhichAirport = "Mala";

    @Test
    public void oneWay() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        homePage.ticketForAirportAndHotel();
        homePage.bothMultiTrip();
        WebElement trip = driver.findElement(By.xpath("//input[@value='multicityfh']"));
        trip.sendKeys(Keys.TAB);
//        homePage.waitMethodForElementToBeClickable();
//        WebElement city = driver.findElement(By.name("source[]"));
        driver.findElement(By.xpath("(//*[@name='source[]'])[5]")).sendKeys(fromWhichAirport);


//        WebElement source =  driver.findElement(By.name("source[]"));
//        JavascriptExecutor executor = (JavascriptExecutor) driver;
//        executor.executeScript("arguments[0].setAttribute('value','Mala');", source);
        Thread.sleep(5000);
//        homePage.fromWhereWeGo(fromWhichAirport);
        homePage.searchHotelFromDynamicListMethod("Malaga");
        homePage.whereWeGo("Sela");
//        homePage.searchHotelFromDynamicListMethod("Selaparang");

    }

    @Test
    public void okey() throws InterruptedException{
        HomePage homePage = new HomePage(driver);
        driver.findElement(By.xpath("//a[text()='Hotel']")).click();
        WebElement source =  driver.findElement(By.name("city[]"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].setAttribute('value','Mala');", source);
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@class='addcityh']")).click();
        executor.executeScript("arguments[1].setAttribute('value','Lon');", source);
        Thread.sleep(5000);
    }

}
