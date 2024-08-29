package org.seleniumtest.funcionaltests;

import org.seleniumtest.pages.AdditionalDetailsPage;
import org.seleniumtest.tests.BaseTest;
import org.testng.annotations.Test;



public class AdditionalDetails extends BaseTest {

    // variables used in methods parameters
    String countryCode = "select2-dialcodes-container";
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
        additionalDetailsPage.waitForCountryCodeIdElement(countryCode);
        additionalDetailsPage.selectAndTypeCountryCode(countryName);
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
    public void formDetailsAndAddPassenger() {
        AdditionalDetailsPage additionalDetailsPage = new AdditionalDetailsPage(driver);
        additionalDetailsPage.orderFlyTicket();
        additionalDetailsPage.waitForCountryCodeIdElement(countryCode);
        additionalDetailsPage.selectAndTypeCountryCode(countryName);
        additionalDetailsPage.sendContactNumber(mobileNumber);
        additionalDetailsPage.sendUserEmail(userEmail);
        additionalDetailsPage.setAddPassenger();
        additionalDetailsPage.passengersTitle();
        additionalDetailsPage.passengersName();
        additionalDetailsPage.passengersLastName();
        additionalDetailsPage.passengersDatesOfBirth();
        additionalDetailsPage.passengersNationality();
        additionalDetailsPage.clickOnNextButton();
    }

    @Test
    public void formDetailsAddAndRemovePassenger() {
        AdditionalDetailsPage additionalDetailsPage = new AdditionalDetailsPage(driver);
        additionalDetailsPage.orderFlyTicket();
        additionalDetailsPage.waitForCountryCodeIdElement(countryCode);
        additionalDetailsPage.selectAndTypeCountryCode(countryName);
        additionalDetailsPage.sendContactNumber(mobileNumber);
        additionalDetailsPage.sendUserEmail(userEmail);
        additionalDetailsPage.chooseUserTitleAndClick(title);
        additionalDetailsPage.sendUserNameAndSurname(userName, userSurname);
        additionalDetailsPage.userDateOfBirthClickField();
        additionalDetailsPage.datePicker(month, year, day);
        additionalDetailsPage.sendNationality(userNationality);
        additionalDetailsPage.chooseNationalityFromListAndClick();
        additionalDetailsPage.setAddPassenger();
        additionalDetailsPage.setRemovePassenger();
    }

    @Test
    public void formDetailsAddPassengerFillDetailsAndRemovePassenger() {
        AdditionalDetailsPage additionalDetailsPage = new AdditionalDetailsPage(driver);
        additionalDetailsPage.orderFlyTicket();
        additionalDetailsPage.waitForCountryCodeIdElement(countryCode);
        additionalDetailsPage.selectAndTypeCountryCode(countryName);
        additionalDetailsPage.sendContactNumber(mobileNumber);
        additionalDetailsPage.sendUserEmail(userEmail);
        additionalDetailsPage.setAddPassenger();
        additionalDetailsPage.passengersTitle();
        additionalDetailsPage.passengersName();
        additionalDetailsPage.passengersLastName();
        additionalDetailsPage.passengersDatesOfBirth();
        additionalDetailsPage.passengersNationality();
        additionalDetailsPage.setRemovePassenger();
    }
}
