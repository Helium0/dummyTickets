package org.seleniumtest.funcionaltests;


import org.seleniumtest.pages.HomePage;
import org.seleniumtest.tests.BaseTest;
import org.seleniumtest.tests.ReadingProperties;
import org.testng.annotations.Test;

import java.io.IOException;


public class FlightTicket extends BaseTest {


    private String parameterForWaitMethodForXpathDestination = "//input[@name='destination[]']/following-sibling::ul//p";

    @Test
    public void oneWayTicketFutureDate() throws IOException {
        HomePage homePage = new HomePage(driver);
        ReadingProperties readingProperties = new ReadingProperties();
        homePage.fromWhereWeGo(readingProperties.getValues("airPortFromWhereWeGo"));
        homePage.waitMethodForXpath();
        homePage.airPortPicker(readingProperties.getValues("airPortDeparture"));
        homePage.whereWeGo(readingProperties.getValues("airPortToGo"));
        homePage.waitMethodForXpath(parameterForWaitMethodForXpathDestination);
        homePage.airPortPicker(readingProperties.getValues("airPortDestination"));
        homePage.setPlaneDeparture();
        homePage.datePicker(10,readingProperties.getValues("futureYearFlightTicket"),readingProperties.getValues("futureDayHotel"));
        homePage.flightOneWayButton();

    }

    @Test
    public void oneWayTicketOldDate() throws IOException {
        HomePage homePage = new HomePage(driver);
        ReadingProperties readingProperties = new ReadingProperties();
        homePage.fromWhereWeGo(readingProperties.getValues("airPortFromWhereWeGo"));
        homePage.waitMethodForXpath();
        homePage.airPortPicker(readingProperties.getValues("airPortDeparture"));
        homePage.whereWeGo(readingProperties.getValues("airPortToGo"));
        homePage.waitMethodForXpath(parameterForWaitMethodForXpathDestination);
        homePage.airPortPicker(readingProperties.getValues("airPortDestination"));
        homePage.setPlaneDeparture();
        homePage.datePicker(2,readingProperties.getValues("pastYearHotel"),readingProperties.getValues("pastDayHotel"));
        homePage.flightOneWayButton();

    }

}
