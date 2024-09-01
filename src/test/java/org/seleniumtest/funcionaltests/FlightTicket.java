package org.seleniumtest.funcionaltests;


import org.seleniumtest.pages.HomePage;
import org.seleniumtest.tests.BaseTest;
import org.testng.annotations.Test;



public class FlightTicket extends BaseTest {

    private String airPortDeparture = "Al Ain";
    private String airPortDestination = "Olkhovka";
    private String parameterForWaitMethodForXpath = "//ul[@class='suggestions-list']//p";
    private String parameterForWaitMethodForXpathDestination = "//input[@name='destination[]']/following-sibling::ul//p";

    @Test
    public void oneWayTicketFutureDate() {
        HomePage homePage = new HomePage(driver);
        homePage.fromWhereWeGo("Po"); // you can change airportDeparture
        homePage.waitMethodForXpath(parameterForWaitMethodForXpath);
        homePage.airPortPicker(airPortDeparture);
        homePage.whereWeGo("Ol"); // you can change airportDestination
        homePage.waitMethodForXpath(parameterForWaitMethodForXpathDestination);
        homePage.airPortPicker(airPortDestination);
        homePage.setPlaneDeparture();
        homePage.datePicker(10,"2025","26"); // you can change dates
        homePage.flightOneWayButton();

    }

    @Test
    public void oneWayTicketOldDate() {
        HomePage homePage = new HomePage(driver);
        homePage.fromWhereWeGo("Po");  // you can change airportDeparture
        homePage.waitMethodForXpath(parameterForWaitMethodForXpath);
        homePage.airPortPicker(airPortDeparture);
        homePage.whereWeGo("Ol");  // you can change airportDestination
        homePage.waitMethodForXpath(parameterForWaitMethodForXpathDestination);
        homePage.airPortPicker(airPortDestination);
        homePage.setPlaneDeparture();
        homePage.datePicker(2,"2023", "10"); // you can change dates
        homePage.flightOneWayButton();

    }

}
