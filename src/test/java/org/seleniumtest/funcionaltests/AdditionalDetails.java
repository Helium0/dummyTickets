package org.seleniumtest.funcionaltests;

import org.seleniumtest.pages.AdditionalDetailsPage;
import org.seleniumtest.tests.BaseTest;
import org.seleniumtest.tests.ReadingProperties;
import org.testng.annotations.Test;

import java.io.IOException;


public class AdditionalDetails extends BaseTest {

    // variables used in methods parameters
    private String countryCode = "select2-dialcodes-container";
    private int month = 3;
    private String year = "2024";
    private String day = "12";
    private String monthForCompare = "January";
    private String textToSend = "THIS IS MY TEST !ąć99";


    @Test
    public void formDetails() throws IOException {
        AdditionalDetailsPage additionalDetailsPage = new AdditionalDetailsPage(driver);
        ReadingProperties readingProperties = new ReadingProperties();
        additionalDetailsPage.flightTicket().oneWayTicketFutureDate();
        additionalDetailsPage.waitForCountryCodeIdElement(countryCode);
        additionalDetailsPage.selectAndTypeCountryCode(readingProperties.getValues("countryName"));
        additionalDetailsPage.sendContactNumber(readingProperties.getValues("mobileNumber"));
        additionalDetailsPage.sendUserEmail(readingProperties.getValues("userEmail"));
        additionalDetailsPage.chooseUserTitleAndClick(readingProperties.getValues("title"));
        additionalDetailsPage.sendUserNameAndSurname(readingProperties.getValues("passengerNameOne"), readingProperties.getValues("userSurname"));
        additionalDetailsPage.userDateOfBirthClickField();
        additionalDetailsPage.datePicker(month, year, day);
        additionalDetailsPage.sendNationality(readingProperties.getValues("userNationality"));
        additionalDetailsPage.chooseNationalityFromListAndClick();
        additionalDetailsPage.clickOnNextButton();
    }


    @Test
    public void formDetailsAndAddPassenger() throws IOException {
        AdditionalDetailsPage additionalDetailsPage = new AdditionalDetailsPage(driver);
        ReadingProperties readingProperties = new ReadingProperties();
        additionalDetailsPage.flightTicket().oneWayTicketFutureDate();
        additionalDetailsPage.waitForCountryCodeIdElement(countryCode);
        additionalDetailsPage.selectAndTypeCountryCode(readingProperties.getValues("countryName"));
        additionalDetailsPage.sendContactNumber(readingProperties.getValues("mobileNumber"));
        additionalDetailsPage.sendUserEmail(readingProperties.getValues("userEmail"));
        additionalDetailsPage.setAddPassenger();
        additionalDetailsPage.passengersTitle();
        additionalDetailsPage.passengersName();
        additionalDetailsPage.passengersLastName();
        additionalDetailsPage.passengersDatesOfBirth();
        additionalDetailsPage.passengersNationality();
        additionalDetailsPage.chooseNationalityFromListAndClick();
        additionalDetailsPage.clickOnNextButton();
    }

    @Test
    public void formDetailsAddAndRemovePassenger() throws IOException {
        AdditionalDetailsPage additionalDetailsPage = new AdditionalDetailsPage(driver);
        ReadingProperties readingProperties = new ReadingProperties();
        additionalDetailsPage.flightTicket().oneWayTicketFutureDate();
        additionalDetailsPage.waitForCountryCodeIdElement(countryCode);
        additionalDetailsPage.selectAndTypeCountryCode(readingProperties.getValues("countryName"));
        additionalDetailsPage.sendContactNumber(readingProperties.getValues("mobileNumber"));
        additionalDetailsPage.sendUserEmail(readingProperties.getValues("userEmail"));
        additionalDetailsPage.chooseUserTitleAndClick(readingProperties.getValues("title"));
        additionalDetailsPage.sendUserNameAndSurname(readingProperties.getValues("passengerNameOne"), readingProperties.getValues("userSurname"));
        additionalDetailsPage.userDateOfBirthClickField();
        additionalDetailsPage.datePicker(month, year, day);
        additionalDetailsPage.sendNationality(readingProperties.getValues("userNationality"));
        additionalDetailsPage.chooseNationalityFromListAndClick();
        additionalDetailsPage.setAddPassenger();
        additionalDetailsPage.setRemovePassenger();
        additionalDetailsPage.clickOnNextButton();
    }

    @Test
    public void formDetailsAddPassengerFillDetailsAndRemovePassenger() throws IOException {
        AdditionalDetailsPage additionalDetailsPage = new AdditionalDetailsPage(driver);
        ReadingProperties readingProperties = new ReadingProperties();
        additionalDetailsPage.flightTicket().oneWayTicketFutureDate();
        additionalDetailsPage.waitForCountryCodeIdElement(countryCode);
        additionalDetailsPage.selectAndTypeCountryCode(readingProperties.getValues("countryName"));
        additionalDetailsPage.sendContactNumber(readingProperties.getValues("mobileNumber"));
        additionalDetailsPage.sendUserEmail(readingProperties.getValues("userEmail"));
        additionalDetailsPage.setAddPassenger();
        additionalDetailsPage.passengersTitle();
        additionalDetailsPage.passengersName();
        additionalDetailsPage.passengersLastName();
        additionalDetailsPage.passengersDatesOfBirth();
        additionalDetailsPage.passengersNationality();
        additionalDetailsPage.setRemovePassenger();
        additionalDetailsPage.clickOnNextButton();
    }

    @Test
    public void additionalDetailsReceiveNowOption() throws IOException {
        AdditionalDetailsPage additionalDetailsPage = new AdditionalDetailsPage(driver);
        ReadingProperties readingProperties = new ReadingProperties();
        additionalDetailsPage.flightTicket().oneWayTicketFutureDate();
        additionalDetailsPage.waitForCountryCodeIdElement(countryCode);
        additionalDetailsPage.selectAndTypeCountryCode(readingProperties.getValues("countryName"));
        additionalDetailsPage.sendContactNumber(readingProperties.getValues("mobileNumber"));
        additionalDetailsPage.sendUserEmail(readingProperties.getValues("userEmail"));
        additionalDetailsPage.chooseUserTitleAndClick(readingProperties.getValues("title"));
        additionalDetailsPage.sendUserNameAndSurname(readingProperties.getValues("passengerNameOne"), readingProperties.getValues("userSurname"));
        additionalDetailsPage.userDateOfBirthClickField();
        additionalDetailsPage.datePicker(month, year, day);
        additionalDetailsPage.sendNationality(readingProperties.getValues("userNationality"));
        additionalDetailsPage.chooseNationalityFromListAndClick();
        additionalDetailsPage.clickOnNextButton();
        additionalDetailsPage.selectReceiveNow();
        additionalDetailsPage.clickOnPurposeToBuyDummyTickets();
        additionalDetailsPage.selectRightPurposeFromDropDown(readingProperties.getValues("purposeText"));
        additionalDetailsPage.sendText(textToSend);
        additionalDetailsPage.clickOnNextButtonTwo();
    }

    @Test
    public void additionalDetailsReceiveLaterOption() throws IOException {
        AdditionalDetailsPage additionalDetailsPage = new AdditionalDetailsPage(driver);
        ReadingProperties readingProperties = new ReadingProperties();
        additionalDetailsPage.flightTicket().oneWayTicketFutureDate();
        additionalDetailsPage.waitForCountryCodeIdElement(countryCode);
        additionalDetailsPage.selectAndTypeCountryCode(readingProperties.getValues("countryName"));
        additionalDetailsPage.sendContactNumber(readingProperties.getValues("mobileNumber"));
        additionalDetailsPage.sendUserEmail(readingProperties.getValues("userEmail"));
        additionalDetailsPage.chooseUserTitleAndClick(readingProperties.getValues("title"));
        additionalDetailsPage.sendUserNameAndSurname(readingProperties.getValues("passengerNameOne"), readingProperties.getValues("userSurname"));
        additionalDetailsPage.userDateOfBirthClickField();
        additionalDetailsPage.datePicker(month, year, day);
        additionalDetailsPage.sendNationality(readingProperties.getValues("userNationality"));
        additionalDetailsPage.chooseNationalityFromListAndClick();
        additionalDetailsPage.clickOnNextButton();
        additionalDetailsPage.selectReceiveLater();
        additionalDetailsPage.pickDate();
        additionalDetailsPage.monthsCompare(monthForCompare,day);
        additionalDetailsPage.clickOnPurposeToBuyDummyTickets();
        additionalDetailsPage.selectRightPurposeFromDropDown(readingProperties.getValues("anotherPurposeText"));
        additionalDetailsPage.whichAirline(readingProperties.getValues("airlineName"));
        additionalDetailsPage.sendText(textToSend);
        additionalDetailsPage.clickOnNextButtonTwo();
    }

    @Test
    public void additionalDetailsWithoutTextInMessageField() throws IOException {
        AdditionalDetailsPage additionalDetailsPage = new AdditionalDetailsPage(driver);
        ReadingProperties readingProperties = new ReadingProperties();
        additionalDetailsPage.flightTicket().oneWayTicketFutureDate();
        additionalDetailsPage.waitForCountryCodeIdElement(countryCode);
        additionalDetailsPage.selectAndTypeCountryCode(readingProperties.getValues("countryName"));
        additionalDetailsPage.sendContactNumber(readingProperties.getValues("mobileNumber"));
        additionalDetailsPage.sendUserEmail(readingProperties.getValues("userEmail"));
        additionalDetailsPage.chooseUserTitleAndClick(readingProperties.getValues("title"));
        additionalDetailsPage.sendUserNameAndSurname(readingProperties.getValues("passengerNameOne"), readingProperties.getValues("userSurname"));
        additionalDetailsPage.userDateOfBirthClickField();
        additionalDetailsPage.datePicker(month, year, day);
        additionalDetailsPage.sendNationality(readingProperties.getValues("userNationality"));
        additionalDetailsPage.chooseNationalityFromListAndClick();
        additionalDetailsPage.clickOnNextButton();
        additionalDetailsPage.selectReceiveNow();
        additionalDetailsPage.clickOnPurposeToBuyDummyTickets();
        additionalDetailsPage.selectRightPurposeFromDropDown(readingProperties.getValues("purposeText"));
        additionalDetailsPage.clickOnNextButtonTwo();
    }
}
