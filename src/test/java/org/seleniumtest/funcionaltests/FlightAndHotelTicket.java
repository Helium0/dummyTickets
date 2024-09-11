package org.seleniumtest.funcionaltests;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.seleniumtest.pages.AdditionalDetailsPage;
import org.seleniumtest.pages.FlightAndHotelTicketPage;
import org.seleniumtest.pages.HomePage;
import org.seleniumtest.tests.BaseTest;
import org.seleniumtest.tests.ReadingProperties;
import org.testng.annotations.Test;

import java.io.IOException;


public class FlightAndHotelTicket extends BaseTest {


    private String parameterForWaitMethodForXpathDestination = "//input[@name='destination[]']/following-sibling::ul//p";
    private String airPortDeparture = "Malaga Air";
    private String airPortDestination = "Kabri Dar";
    private String hotelName = "Brampton";
    private String hotelNameTwo = "Abakan";
    private String xpathAirportDeparture = "//ul[@class='suggestions-list']//p[text()='Malaga Airport, ']";
    private String textForXpathAirportDeparture = "Malaga Airport";
    private String xpathAirportDepartureRouteTwo = "//small[text()='Route 2']/following::ul[@class='suggestions-list']//p[text()='Malaga Airport, ']";
    private String suggestionList = "//ul[@class='suggestions-list']//p";
    private String suggestionListRouteTwo = "//small[text()='Route 2']/following::ul[@class='suggestions-list']//p";
    private String xpathCityHotelRouteTwo = "//ul[@class='suggestions-cities-list']//p[text()='Brampton']";
    private String nextArrowCalendar = "//span[text()='Next']";
    private String prevArrowCalendar = "//span[text()='Prev']";

    @Test
    public void flightAndHotelMultiTripFutureDate() throws IOException {
        HomePage homePage = new HomePage(driver);
        FlightAndHotelTicketPage flightAndHotelTicketPage = new FlightAndHotelTicketPage(driver);
        ReadingProperties readingProperties = new ReadingProperties();
        homePage.ticketForAirportAndHotel();
        homePage.bothMultiTrip();
        flightAndHotelTicketPage.clickMultiTripRadiobuttonAndMoveToAnotherElement();
        flightAndHotelTicketPage.sendAirPortDeparture();
        flightAndHotelTicketPage.waitForTextToBePresented(suggestionList,xpathAirportDeparture,textForXpathAirportDeparture);
        homePage.airPortPicker(readingProperties.getValues("airPortDeparture"));
        flightAndHotelTicketPage.sendAirPortDeparture();
        flightAndHotelTicketPage.clickOnAirPortDestination();
        homePage.waitMethodForXpath(parameterForWaitMethodForXpathDestination);
        homePage.airPortPicker(readingProperties.getValues("airPortDestination"));
        flightAndHotelTicketPage.clickOnAirPortDeparture();
        homePage.datePicker(5,"2025","9");
        flightAndHotelTicketPage.sendSendCityHotel();
        flightAndHotelTicketPage.waitForCityHotelTextToBePresented();
        homePage.searchHotelFromDynamicListMethod(readingProperties.getValues("hotelNameOne"));
        flightAndHotelTicketPage.clickCheckinCalendarDate();
        homePage.hotelDatePickerMethod(readingProperties.getValues("futureYearHotel"),readingProperties.getValues("futureMonthHotel"),
                readingProperties.getValues("futureDayHotel"),readingProperties.getValues("nextArrowCalendar"));
        flightAndHotelTicketPage.clickCheckoutCalendarDate();
        homePage.hotelDatePickerMethod(readingProperties.getValues("futureYearHotel"),readingProperties.getValues("futureMonthHotel"),
                readingProperties.getValues("futureDayHotel"),readingProperties.getValues("nextArrowCalendar"));
        flightAndHotelTicketPage.clickBuyTicketsButton();

    }

    @Test
    public void flightAndHotelMultiTripPastDate() throws IOException {
        HomePage homePage = new HomePage(driver);
        FlightAndHotelTicketPage flightAndHotelTicketPage = new FlightAndHotelTicketPage(driver);
        ReadingProperties readingProperties = new ReadingProperties();
        homePage.ticketForAirportAndHotel();
        homePage.bothMultiTrip();
        flightAndHotelTicketPage.clickMultiTripRadiobuttonAndMoveToAnotherElement();
        flightAndHotelTicketPage.sendAirPortDeparture();
        flightAndHotelTicketPage.waitForTextToBePresented(suggestionList,xpathAirportDeparture,textForXpathAirportDeparture);
        homePage.airPortPicker(readingProperties.getValues("airPortDeparture"));
        flightAndHotelTicketPage.sendAirPortDeparture();
        flightAndHotelTicketPage.clickOnAirPortDestination();
        homePage.waitMethodForXpath(parameterForWaitMethodForXpathDestination);
        homePage.airPortPicker(readingProperties.getValues("airPortDestination"));
        flightAndHotelTicketPage.clickOnAirPortDeparture();
        homePage.datePicker(9,"2023","11");
        flightAndHotelTicketPage.sendSendCityHotel();
        flightAndHotelTicketPage.waitForCityHotelTextToBePresented();
        homePage.searchHotelFromDynamicListMethod(readingProperties.getValues("hotelNameOne"));
        flightAndHotelTicketPage.clickCheckinCalendarDate();
        homePage.hotelDatePickerMethod(readingProperties.getValues("pastYearHotel"),readingProperties.getValues("pastMonthHotel")
                ,readingProperties.getValues("pastDayHotel"),readingProperties.getValues("prevArrowCalendar"));
        flightAndHotelTicketPage.clickCheckoutCalendarDate();
        homePage.hotelDatePickerMethod(readingProperties.getValues("pastYearHotel"),readingProperties.getValues("pastMonthHotel")
                ,readingProperties.getValues("pastDayHotel"),readingProperties.getValues("prevArrowCalendar"));
        flightAndHotelTicketPage.clickBuyTicketsButton();

    }

    @Test
    public void futureDateAddAnotherRoute() {
        HomePage homePage = new HomePage(driver);
        FlightAndHotelTicketPage flightAndHotelTicketPage = new FlightAndHotelTicketPage(driver);
        AdditionalDetailsPage additionalDetailsPage = new AdditionalDetailsPage(driver);
        homePage.ticketForAirportAndHotel();
        homePage.bothMultiTrip();
        flightAndHotelTicketPage.clickMultiTripRadiobuttonAndMoveToAnotherElement();
        flightAndHotelTicketPage.sendAirPortDeparture();
        flightAndHotelTicketPage.waitForTextToBePresented(suggestionList,xpathAirportDeparture,textForXpathAirportDeparture);
        homePage.airPortPicker(airPortDeparture);
        flightAndHotelTicketPage.sendAirPortDeparture();
        flightAndHotelTicketPage.clickOnAirPortDestination();
        homePage.waitMethodForXpath(parameterForWaitMethodForXpathDestination);
        homePage.airPortPicker(airPortDestination);
        flightAndHotelTicketPage.clickOnAirPortDeparture();
        homePage.datePicker(5,"2025","9");
        flightAndHotelTicketPage.clickToAddAnotherRoute();
        flightAndHotelTicketPage.clickOnRouteTwoDepartureAirport();
        flightAndHotelTicketPage.sendAirPortDeparture();
        flightAndHotelTicketPage.waitForTextToBePresented(suggestionListRouteTwo,xpathAirportDepartureRouteTwo,textForXpathAirportDeparture);
        homePage.airPortPicker(airPortDestination);
        flightAndHotelTicketPage.searchHotelCitiesRoundTwo(airPortDeparture);
        flightAndHotelTicketPage.clickOnAirPortDestination();
        additionalDetailsPage.waitDriver().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//small[text()='Route 2']/following::ul[@class='suggestions-list']//p[text()='Kabri Dar, ']"), "Kabri Dar"));
        homePage.airPortPicker(airPortDestination);
        flightAndHotelTicketPage.clickOnAirPortDeparture();
        homePage.datePicker(5,"2025","9");
        flightAndHotelTicketPage.sendSendCityHotel();
        flightAndHotelTicketPage.waitForCityHotelTextToBePresentedRouteTwo(xpathCityHotelRouteTwo,hotelName);
        homePage.searchHotelFromDynamicListMethod(hotelName);
        flightAndHotelTicketPage.clickCheckinCalendarDate();
        homePage.hotelDatePickerMethod("2025","Apr","10",nextArrowCalendar);
        flightAndHotelTicketPage.clickCheckoutCalendarDate();
        homePage.hotelDatePickerMethod("2025","Dec","26",nextArrowCalendar);
        flightAndHotelTicketPage.clickBuyTicketsButton();

    }

    @Test
    public void pastDateAddAnotherRoute() {
        HomePage homePage = new HomePage(driver);
        FlightAndHotelTicketPage flightAndHotelTicketPage = new FlightAndHotelTicketPage(driver);
        AdditionalDetailsPage additionalDetailsPage = new AdditionalDetailsPage(driver);
        homePage.ticketForAirportAndHotel();
        homePage.bothMultiTrip();
        flightAndHotelTicketPage.clickMultiTripRadiobuttonAndMoveToAnotherElement();
        flightAndHotelTicketPage.sendAirPortDeparture();
        flightAndHotelTicketPage.waitForTextToBePresented(suggestionList,xpathAirportDeparture,textForXpathAirportDeparture);
        homePage.airPortPicker(airPortDeparture);
        flightAndHotelTicketPage.sendAirPortDeparture();
        flightAndHotelTicketPage.clickOnAirPortDestination();
        homePage.waitMethodForXpath(parameterForWaitMethodForXpathDestination);
        homePage.airPortPicker(airPortDestination);
        flightAndHotelTicketPage.clickOnAirPortDeparture();
        homePage.datePicker(1,"2023","9");
        flightAndHotelTicketPage.clickToAddAnotherRoute();
        flightAndHotelTicketPage.clickOnRouteTwoDepartureAirport();
        flightAndHotelTicketPage.sendAirPortDeparture();
        flightAndHotelTicketPage.waitForTextToBePresented(suggestionListRouteTwo,xpathAirportDepartureRouteTwo,textForXpathAirportDeparture);
        homePage.airPortPicker(airPortDestination);
        flightAndHotelTicketPage.searchHotelCitiesRoundTwo(airPortDeparture);
        flightAndHotelTicketPage.clickOnAirPortDestination();
        additionalDetailsPage.waitDriver().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//small[text()='Route 2']/following::ul[@class='suggestions-list']//p[text()='Kabri Dar, ']"), "Kabri Dar"));
        homePage.airPortPicker(airPortDestination);
        flightAndHotelTicketPage.clickOnAirPortDeparture();
        homePage.datePicker(5,"2023","9");
        flightAndHotelTicketPage.sendSendCityHotel();
        flightAndHotelTicketPage.waitForCityHotelTextToBePresentedRouteTwo(xpathCityHotelRouteTwo,hotelName);
        homePage.searchHotelFromDynamicListMethod(hotelName);
        flightAndHotelTicketPage.clickCheckinCalendarDate();
        homePage.hotelDatePickerMethod("2023","Jul","10",prevArrowCalendar);
        flightAndHotelTicketPage.clickCheckoutCalendarDate();
        homePage.hotelDatePickerMethod("2023","Dec","11",prevArrowCalendar);
        flightAndHotelTicketPage.clickBuyTicketsButton();

    }

    @Test
    public void futureDateAddRouteAndAnotherHotel() {
        HomePage homePage = new HomePage(driver);
        FlightAndHotelTicketPage flightAndHotelTicketPage = new FlightAndHotelTicketPage(driver);
        AdditionalDetailsPage additionalDetailsPage = new AdditionalDetailsPage(driver);
        homePage.ticketForAirportAndHotel();
        homePage.bothMultiTrip();
        flightAndHotelTicketPage.clickMultiTripRadiobuttonAndMoveToAnotherElement();
        flightAndHotelTicketPage.sendAirPortDeparture();
        flightAndHotelTicketPage.waitForTextToBePresented(suggestionList,xpathAirportDeparture,textForXpathAirportDeparture);
        homePage.airPortPicker(airPortDeparture);
        flightAndHotelTicketPage.sendAirPortDeparture();
        flightAndHotelTicketPage.clickOnAirPortDestination();
        homePage.waitMethodForXpath(parameterForWaitMethodForXpathDestination);
        homePage.airPortPicker(airPortDestination);
        flightAndHotelTicketPage.clickOnAirPortDeparture();
        homePage.datePicker(5,"2025","9");
        flightAndHotelTicketPage.clickToAddAnotherRoute();
        flightAndHotelTicketPage.clickOnRouteTwoDepartureAirport();
        flightAndHotelTicketPage.sendAirPortDeparture();
        flightAndHotelTicketPage.waitForTextToBePresented(suggestionListRouteTwo,xpathAirportDepartureRouteTwo,textForXpathAirportDeparture);
        homePage.airPortPicker(airPortDestination);
        flightAndHotelTicketPage.searchHotelCitiesRoundTwo(airPortDeparture);
        flightAndHotelTicketPage.clickOnAirPortDestination();
        additionalDetailsPage.waitDriver().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//small[text()='Route 2']/following::ul[@class='suggestions-list']//p[text()='Kabri Dar, ']"), "Kabri Dar"));
        homePage.airPortPicker(airPortDestination);
        flightAndHotelTicketPage.clickOnAirPortDeparture();
        homePage.datePicker(5,"2025","9");
        flightAndHotelTicketPage.sendSendCityHotel();
        flightAndHotelTicketPage.waitForCityHotelTextToBePresentedRouteTwo(xpathCityHotelRouteTwo,hotelName);
        homePage.searchHotelFromDynamicListMethod(hotelName);
        flightAndHotelTicketPage.clickCheckinCalendarDate();
        homePage.hotelDatePickerMethod("2025","Apr","10",nextArrowCalendar);
        flightAndHotelTicketPage.clickCheckoutCalendarDate();
        homePage.hotelDatePickerMethod("2025","Dec","26",nextArrowCalendar);
        flightAndHotelTicketPage.clickToAddAnotherHotel();
        flightAndHotelTicketPage.sendAnotherCityHotel();
        flightAndHotelTicketPage.waitForCityHotelTextToBePresentedRouteTwo("//small[text()='Hotel 2']//following::ul[@class='suggestions-cities-list']//p[text()='Abakan']",hotelNameTwo);
        additionalDetailsPage.waitDriver().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//small[text()='Hotel 2']//following::ul[@class='suggestions-cities-list']//p[text()='Abakan']"), "Abakan"));
        additionalDetailsPage.waitDriver().until(ExpectedConditions.elementToBeClickable(By.xpath("//small[text()='Hotel 2']//following::ul[@class='suggestions-cities-list']//p[text()='Abakan']")));
        homePage.searchHotelFromDynamicListMethod(hotelNameTwo);
        flightAndHotelTicketPage.clickCheckinCalendarDate();
        homePage.hotelDatePickerMethod("2025","Jul","10",nextArrowCalendar);
        flightAndHotelTicketPage.clickCheckoutCalendarDate();
        homePage.hotelDatePickerMethod("2025","Dec","11",nextArrowCalendar);
        flightAndHotelTicketPage.clickBuyTicketsButton();

    }


}
