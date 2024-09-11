package org.seleniumtest.funcionaltests;

import org.openqa.selenium.By;
import org.seleniumtest.pages.HomePage;
import org.seleniumtest.tests.BaseTest;
import org.seleniumtest.tests.ReadingProperties;
import org.testng.annotations.Test;
import java.io.IOException;



public class HotelTicket extends BaseTest {


    private String xpath = "//ul[@class='suggestions-cities-list']//p";



    @Test
    public void hotelTicketFutureDate() throws IOException {
        HomePage homePage = new HomePage(driver);
        ReadingProperties readingProperties = new ReadingProperties();
        homePage.pickCityHotel(readingProperties.getValues("hotelToSend"));
        homePage.waitMethodForXpath(xpath);
        homePage.searchHotelFromDynamicListMethod(readingProperties.getValues("hotelNameOne"));
        homePage.clickActionOnTheElement();
        homePage.waiMethod2();
        homePage.hotelDatePickerMethod(readingProperties.getValues("futureYearHotel"), readingProperties.getValues("futureMonthHotel"),
                readingProperties.getValues("futureDayHotel"), readingProperties.getValues("nextArrowCalendar"));
        homePage.hotelCheckout();
        homePage.hotelDatePickerMethod(readingProperties.getValues("futureYearHotel"), readingProperties.getValues("futureMonthHotel"),
                readingProperties.getValues("futureDayHotel"), readingProperties.getValues("nextArrowCalendar"));

    }

    @Test
    public void hotelTicketPastDate() throws IOException {
        HomePage homePage = new HomePage(driver);
        ReadingProperties readingProperties = new ReadingProperties();
        homePage.pickCityHotel(readingProperties.getValues("hotelToSend"));
        homePage.waitMethodForXpath(xpath);
        homePage.searchHotelFromDynamicListMethod(readingProperties.getValues("hotelNameOne"));
        homePage.clickActionOnTheElement();
        homePage.waiMethod2();
        homePage.hotelDatePickerMethod(readingProperties.getValues("pastYearHotel"), readingProperties.getValues("pastMonthHotel"),
                readingProperties.getValues("pastDayHotel"), readingProperties.getValues("prevArrowCalendar"));
        homePage.hotelCheckout();
        homePage.hotelDatePickerMethod(readingProperties.getValues("pastYearHotel"), readingProperties.getValues("pastMonthHotel"),
                readingProperties.getValues("pastDayHotel"), readingProperties.getValues("prevArrowCalendar"));

    }

    @Test
    public void addAnotherHotels() throws IOException {
        HomePage homePage = new HomePage(driver);
        ReadingProperties readingProperties = new ReadingProperties();
        homePage.pickCityHotel(readingProperties.getValues("hotelToSend"));
        homePage.waitMethodForXpath(xpath);
        homePage.searchHotelFromDynamicListMethod(readingProperties.getValues("hotelNameOne"));
        homePage.clickActionOnTheElement();
        homePage.waiMethod2();
        homePage.hotelDatePickerMethod(readingProperties.getValues("futureYearHotel"), readingProperties.getValues("futureMonthHotel"),
                readingProperties.getValues("futureDayHotel"), readingProperties.getValues("nextArrowCalendar"));
        homePage.hotelCheckout();
        homePage.hotelDatePickerMethod(readingProperties.getValues("futureYearHotel"), readingProperties.getValues("futureMonthHotel"),
                readingProperties.getValues("futureDayHotel"), readingProperties.getValues("nextArrowCalendar"));
        homePage.addAnotherHotel();
        homePage.addAnotherHotel();

    }

    @Test
    public void addAnotherHotelsAndDelete() throws IOException {
        HomePage homePage = new HomePage(driver);
        ReadingProperties readingProperties = new ReadingProperties();
        homePage.pickCityHotel(readingProperties.getValues("hotelToSend"));
        homePage.waitMethodForXpath(xpath);
        homePage.searchHotelFromDynamicListMethod(readingProperties.getValues("hotelNameOne"));
        homePage.clickActionOnTheElement();
        homePage.waiMethod2();
        homePage.hotelDatePickerMethod(readingProperties.getValues("futureYearHotel"), readingProperties.getValues("futureMonthHotel"),
                readingProperties.getValues("futureDayHotel"), readingProperties.getValues("nextArrowCalendar"));
        homePage.hotelCheckout();
        homePage.hotelDatePickerMethod(readingProperties.getValues("futureYearHotel"), readingProperties.getValues("futureMonthHotel"),
                readingProperties.getValues("futureDayHotel"), readingProperties.getValues("nextArrowCalendar"));
        homePage.addAnotherHotel();
        homePage.waitMethodForElementToBeClickable("(//span[@class='close p-3'])[1]");

    }
}
