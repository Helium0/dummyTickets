package org.seleniumtest.funcionaltests;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.seleniumtest.pages.AdditionalDetailsPage;
import org.seleniumtest.tests.BaseTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class AdditionalDetails extends BaseTest {


    @Test
    public void formDetails() {
        AdditionalDetailsPage additionalDetailsPage = new AdditionalDetailsPage(driver);
        additionalDetailsPage.orderFlyTicket();
        additionalDetailsPage.waitForIdElement("select2-dialcodes-container");
        additionalDetailsPage.selectAndTypeCountryCode();
        List<WebElement> codeList = driver.findElements(By.xpath("//ul[@id='select2-dialcodes-results']/li"));
        codeList.stream().filter(element -> element.getText().contains("Poland"))
                .forEach(element -> element.click());


        new WebDriverWait(driver, Duration.ofSeconds(10))
                .ignoring(StaleElementReferenceException.class)
                .until((WebDriver d) -> {
                    WebElement eee = d.findElement(By.name("contact_number"));
                    eee.sendKeys("666-666-666");
                    return true;
                });
        driver.findElement(By.name("email")).sendKeys("automateTester@gmail.com");
        WebElement nameTitle = driver.findElement(By.name("passanger_title[]"));
        Select select = new Select(nameTitle);
        List<WebElement> names = select.getOptions();
        for (WebElement nam : names) {
            if (nam.getText().equals("Mr")) {
                nam.click();
            }
        }
        driver.findElement(By.name("first_name[]")).sendKeys("Patryk");
        driver.findElement(By.name("last_name[]")).sendKeys("Tester");
        driver.findElement(By.name("dob[]")).click();
        additionalDetailsPage.datePicker(3, "2024", "12");

        WebElement eel = driver.findElement(By.xpath("(//span[@class='select2-selection__arrow'])[2]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Actions actions = new Actions(driver);
        actions.click(eel).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='select2-search__field']")));
        driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys("Po");


        int maxAttempts = 5;
        int attempt = 0;
        while (attempt <= maxAttempts) {
            List<WebElement> countries = driver.findElements(By.xpath("//ul[@class='select2-results__options']//li"));
            for (WebElement ok : countries) {
                try {
                    attempt++;
                    System.out.println("Attempt: " + attempt);
                    wait.until(ExpectedConditions.elementToBeClickable(ok));
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[text()='Poland']")));
                    if (ok.getText().endsWith("and")) {
                        ok.click();
                        System.out.println("Element clickable after: " + attempt);
                        break;
                    }
                } catch (StaleElementReferenceException exception) {
                    if (attempt == maxAttempts) {
                        System.out.println("Element not clickable");
                        throw exception;

                    }
                }
            }

            WebElement nextClick = driver.findElement(By.xpath("//input[@value='Next']"));
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            javascriptExecutor.executeScript("arguments[0].click();",nextClick);
            break;
         }
    }
}

