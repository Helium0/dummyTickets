package org.seleniumtest.funcionaltests;

import org.openqa.selenium.By;
import org.seleniumtest.pages.AdditionalDetailsPage;
import org.seleniumtest.tests.BaseTest;
import org.testng.annotations.Test;


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
        additionalDetailsPage.sendUserNameAndSurname(userName,userSurname);
        additionalDetailsPage.userDateOfBirthClickField();
        additionalDetailsPage.datePicker(month,year,day);
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
        additionalDetailsPage.chooseUserTitleAndClick(title);
        additionalDetailsPage.sendUserNameAndSurname(userName,userSurname);
        additionalDetailsPage.userDateOfBirthClickField();
        additionalDetailsPage.datePicker(month,year,day);
        additionalDetailsPage.sendNationality(userNationality);
        additionalDetailsPage.chooseNationalityFromListAndClick();
        additionalDetailsPage.clickOnNextButton();

    }
}

