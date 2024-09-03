package org.seleniumtest.funcionaltests;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.seleniumtest.pages.HomePage;
import org.seleniumtest.tests.BaseTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;


public class FlightAndHotelTicket extends BaseTest {

    private String parameterForWaitMethodForXpath = "//ul[@class='suggestions-list']//p";
    private String parameterForWaitMethodForXpathDestination = "//input[@name='destination[]']/following-sibling::ul//p";
    private String xpath = "//ul[@class='suggestions-cities-list']//p";
    private String airPortDeparture = "Malaga Air";
    private String airPortDestination = "Kabri Dar";
    private String hotelName = "Brampton";

    @Test
    public void oneWay() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.ticketForAirportAndHotel();
        homePage.bothMultiTrip();
        WebElement trip = driver.findElement(By.xpath("//input[@value='multicityfh']"));
        trip.sendKeys(Keys.TAB);
        WebElement el = driver.findElement(By.xpath("(//input[@name='source[]'])[last()]"));
        el.sendKeys("Mala");
        int att = 0;
        int max = 5;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='suggestions-list']//p")));
        while (att < max) {
            try {
                att++;
                System.out.println("Proba: " + att);
                wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//ul[@class='suggestions-list']//p[text()='Malaga Airport, ']"),"Malaga Airport"));
                break;
            } catch (TimeoutException e) {
                System.out.println("Proba znalezienia elementu: " + att);
                el.clear();
                el.sendKeys("Mala");
                if (att == max) {
                    System.out.println("Nie udalo sie znalezc elementu po 5 probach");
                    throw e;
                }
            }

        }
        List<WebElement> s = driver.findElements(By.xpath("//ul[@class='suggestions-list']//p"));
        s.stream().filter(element -> element.getText().contains(airPortDeparture))
                .forEach(element -> element.click());
        driver.findElement(By.xpath("(//input[@name='destination[]'])[last()]")).sendKeys("Ka");
        homePage.waitMethodForXpath(parameterForWaitMethodForXpathDestination);
        homePage.airPortPicker(airPortDestination);
        driver.findElement(By.xpath("(//input[@name='departure[]'])[last()]")).click();
        homePage.datePicker(5,"2025","9");
        WebElement ho = driver.findElement(By.xpath("(//input[@name='city[]'])[last()]"));
        ho.sendKeys("Bra");
        while (att < max) {
            try {
                att++;
                System.out.println("Proba: " + att);
                wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//ul[@class='suggestions-cities-list']//p[text()='Brampton']"),"Brampton"));
                break;
            } catch (TimeoutException e) {
                System.out.println("Proba znalezienia elementu: " + att);
                ho.clear();
                ho.sendKeys("Bra");
                if (att == max) {
                    System.out.println("Nie udalo sie znalezc elementu po 5 probach");
                    throw e;
                }
            }

        }
        List<WebElement> see = driver.findElements(By.xpath("//ul[@class='suggestions-cities-list']//li"));
        see.stream().filter(element -> element.getText().contains(hotelName))
                .forEach(element -> element.click());
        driver.findElement(By.xpath("(//input[@name='checkin[]'])[last()]")).click();
        homePage.hotelDatePickerMethod("2025","Jul","13","//span[text()='Next']");
        driver.findElement(By.xpath("(//input[@name='checkout[]'])[last()]")).click();
        homePage.hotelDatePickerMethod("2026","Apr","26","//span[text()='Next']");
        driver.findElement(By.xpath("(//input[@value='Buy Dummy Ticket'])[last()]")).click();
        Thread.sleep(5000);
    }





}
