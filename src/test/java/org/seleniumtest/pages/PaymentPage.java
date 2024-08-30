package org.seleniumtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.seleniumtest.funcionaltests.AdditionalDetails;
import org.seleniumtest.funcionaltests.FlightTicket;
import org.seleniumtest.tests.BaseTest;

public class PaymentPage  {

    protected WebDriver driver;
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
    String purposeText = "Visa Extension";
    String anotherPurposeText = "Proof of Return";
    String textToSend = "THIS IS MY TEST !ąć99";

    public PaymentPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public FlightTicket flightTicket() {
        return new FlightTicket();
    }
    public AdditionalDetails additionalDetails() {
        return new AdditionalDetails();

    }
    public void formDetails() {
        AdditionalDetailsPage additionalDetailsPage = new AdditionalDetailsPage(driver);
        additionalDetailsPage.flightTicket().oneWayTicketFutureDate();
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
        additionalDetailsPage.clickOnNextButton();
        additionalDetailsPage.selectReceiveNow();
        additionalDetailsPage.clickOnPurposeToBuyDummyTickets();
        additionalDetailsPage.selectRightPurposeFromDropDown(purposeText);
        additionalDetailsPage.sendText(textToSend);
        additionalDetailsPage.clickOnNextButtonTwo();
    }
}
