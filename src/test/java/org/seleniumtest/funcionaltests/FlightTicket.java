package org.seleniumtest.funcionaltests;

import org.openqa.selenium.By;
import org.seleniumtest.pages.HomePage;
import org.seleniumtest.tests.BaseTest;
import org.testng.annotations.Test;


public class FlightTicket extends BaseTest {

    String airPortDeparture = "Al Ain";
    String airPortDestination = "Olkhovka";

    @Test
    public void oneWayTicketFutureDate() {
        HomePage homePage = new HomePage(driver);
        homePage.fromWhereWeGo("Po");
        homePage.waitMethodForXpath("//ul[@class='suggestions-list']//p");
        homePage.airPortPicker(airPortDeparture);
        homePage.whereWeGo("Ol");
        homePage.waitMethodForXpath("//input[@name='destination[]']/following-sibling::ul//p");
        homePage.airPortPicker(airPortDestination);
        homePage.setPlaneDeparture();
        homePage.datePicker(10,"2025","26");
        homePage.flightOneWayButton();

    }

    @Test
    public void oneWayTicketOldDate() {
        HomePage homePage = new HomePage(driver);
        homePage.fromWhereWeGo("Po");
        homePage.waitMethodForXpath("//ul[@class='suggestions-list']//p");
        homePage.airPortPicker(airPortDeparture);
        homePage.whereWeGo("Ol");
        homePage.waitMethodForXpath("//input[@name='destination[]']/following-sibling::ul//p");
        homePage.airPortPicker(airPortDestination);
        homePage.setPlaneDeparture();
        homePage.datePicker(2,"2023", "10");
        homePage.flightOneWayButton();

    }

}