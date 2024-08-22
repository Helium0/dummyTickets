package org.seleniumtest.funcionaltests;

import org.seleniumtest.pages.HomePage;
import org.seleniumtest.tests.BaseTest;
import org.testng.annotations.Test;


public class FlightOneWayTicket extends BaseTest {

    String airPortDeparture = "Al Ain";
    String airPortDestination = "Olkhovka";

    @Test
    public void dummyFlightTicketFutureDate() {
        HomePage homePage = new HomePage(driver);
        homePage.fromWhereWeGo("Po");
        homePage.waitMethod("//ul[@class='suggestions-list']//p");
        homePage.airPortPicker(airPortDeparture);
        homePage.whereWeGo("Ol");
        homePage.waitMethod("//input[@name='destination[]']/following-sibling::ul//p");
        homePage.airPortPicker(airPortDestination);
        homePage.datePicker(10,"2025","26");
        homePage.flightOneWayButton();

    }

    @Test
    public void dummyFlightTicketOldDate() {
        HomePage homePage = new HomePage(driver);
        homePage.fromWhereWeGo("Po");
        homePage.waitMethod("//ul[@class='suggestions-list']//p");
        homePage.airPortPicker(airPortDeparture);
        homePage.whereWeGo("Ol");
        homePage.waitMethod("//input[@name='destination[]']/following-sibling::ul//p");
        homePage.airPortPicker(airPortDestination);
        homePage.datePicker(2,"2023", "10");
        homePage.flightOneWayButton();

    }
}
