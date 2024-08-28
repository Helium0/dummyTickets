package org.seleniumtest.funcionaltests;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.seleniumtest.pages.AdditionalDetailsPage;
import org.seleniumtest.tests.BaseTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class AdditionalDetails extends BaseTest {

    // variables used in methods parameters
    String countryName = "Poland";
    String mobileNumber = "666-666-666";
    String userEmail = "automateTester@gmail.com";
    String title = "Mr";
    String userName = "Patryk";
    String userSurname = "Tester";
    String userNationality = "Poland";
    int month = 3;
    String year = "2024";
    String day = "12";

    @Test
    public void formDetails() {
        AdditionalDetailsPage additionalDetailsPage = new AdditionalDetailsPage(driver);
        additionalDetailsPage.orderFlyTicket();
        additionalDetailsPage.waitForIdElement("select2-dialcodes-container");
        additionalDetailsPage.selectAndTypeCountryCode();
        additionalDetailsPage.selectAndClickOnCorrectCountryCode(countryName);
        additionalDetailsPage.sendContactNumber(mobileNumber);
        additionalDetailsPage.sendUserEmail(userEmail);
        additionalDetailsPage.chooseUserTitleAndClick(title);
        additionalDetailsPage.sendUserNameAndSurname(userName, userSurname);
        additionalDetailsPage.userDateOfBirthClickField();
        additionalDetailsPage.datePicker(month, year, day);
        additionalDetailsPage.sendNationality(userNationality);
        additionalDetailsPage.chooseNationalityFromListAndClick();
    }

    @Test
    public void formDetailsAndAddPassenger() throws InterruptedException {
        AdditionalDetailsPage additionalDetailsPage = new AdditionalDetailsPage(driver);
        additionalDetailsPage.orderFlyTicket();
        additionalDetailsPage.waitForIdElement("select2-dialcodes-container");
        additionalDetailsPage.selectAndTypeCountryCode();
        additionalDetailsPage.selectAndClickOnCorrectCountryCode(countryName);
        additionalDetailsPage.sendContactNumber(mobileNumber);
        additionalDetailsPage.sendUserEmail(userEmail);
        driver.findElement(By.className("addcityfh")).click();


        List<String> addTitles = new ArrayList<>();
        addTitles.add("Mr");
        addTitles.add("Ms");
        List<WebElement> titles = driver.findElements(By.xpath("//select[@name='passanger_title[]']"));
        for (int i = 0; i < titles.size(); i++) {
            titles.get(i).sendKeys(addTitles.get(i));
        }
        List<String> addNames = new ArrayList<>();
        addNames.add("Patryk");
        addNames.add("Asia");
        List<WebElement> names = driver.findElements(By.xpath("//input[@name='first_name[]']"));
        for (int i = 0; i < names.size(); i++) {
            names.get(i).sendKeys(addNames.get(i));
        }
        List<String> addSurnames = new ArrayList<>();
        addSurnames.add("Tester");
        addSurnames.add("Tester");
        List<WebElement> surnames = driver.findElements(By.xpath("//input[@name='last_name[]']"));
        for (int i = 0; i < surnames.size(); i++) {
            surnames.get(i).sendKeys(addSurnames.get(i));
        }
        List<String> addDateOfBirth = new ArrayList<>();
        addDateOfBirth.add("10-01-1970");
        addDateOfBirth.add("18-04-1960");
        List<WebElement> dateOfBirth = driver.findElements(By.xpath("//input[@name='dob[]']"));
        for (int i = 0; i < dateOfBirth.size(); i++) {
            dateOfBirth.get(i).sendKeys(addDateOfBirth.get(i));
        }

        List<String> addNationality = new ArrayList<>();
        addNationality.add("Poland");
        addNationality.add("Poland");
        int attempt = 0;
        int maxAttempts = 5;
        List<WebElement> nationality = driver.findElements(By.xpath("//span[@title='Nationality']"));
        for (int i = 0; i < nationality.size(); i++) {
            Actions actions = new Actions(driver);
            actions.click(nationality.get(i)).sendKeys(addNationality.get(i)).build().perform();
            List<WebElement> pol = driver.findElements(By.xpath("//ul[@class='select2-results__options']//li"));
            for (WebElement pel : pol) {

                try {
                    attempt++;
                    System.out.println("Attempt: " + attempt);
                    pel.getText().equals("Poland");
                    pel.isDisplayed();
                    pel.click();
                    if (pel.isSelected()) {
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
        }
        Thread.sleep(5000);
        additionalDetailsPage.clickOnNextButton();
    }
}
