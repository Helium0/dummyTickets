package org.seleniumtest.funcionaltests;

import org.openqa.selenium.By;
import org.seleniumtest.pages.HomePage;
import org.seleniumtest.tests.BaseTest;
import org.seleniumtest.tests.ReadingProperties;
import org.testng.annotations.Test;
import java.io.IOException;



public class HotelTicket extends BaseTest {


    private String xpath = "//ul[@class='suggestions-cities-list']//p";
    private String nextArrowCalendar = "//span[text()='Next']";
    private String prevArrowCalendar = "//span[text()='Prev']";
    private String checkin = "checkin[]";


    @Test
    public void hotelTicketFutureDate() throws IOException {
        HomePage homePage = new HomePage(driver);
        ReadingProperties readingProperties = new ReadingProperties();
        homePage.pickCityHotel("Londo");
        homePage.waitMethodForXpath(xpath);
        homePage.searchHotelFromDynamicListMethod(readingProperties.getValues("hotelNameOne"));
        homePage.clickActionOnTheElement(driver.findElement(By.name(checkin)));
        homePage.waiMethod2();
        homePage.hotelDatePickerMethod(readingProperties.getValues("futureYearHotel"), readingProperties.getValues("futureMonthHotel"),
                readingProperties.getValues("futureDayHotel"), nextArrowCalendar);
        homePage.hotelCheckout();
        homePage.hotelDatePickerMethod(readingProperties.getValues("futureYearHotel"), readingProperties.getValues("futureMonthHotel"),
                readingProperties.getValues("futureDayHotel"), nextArrowCalendar);

    }

    @Test
    public void hotelTicketPastDate() throws IOException {
        HomePage homePage = new HomePage(driver);
        ReadingProperties readingProperties = new ReadingProperties();
        homePage.pickCityHotel("Londo");
        homePage.waitMethodForXpath(xpath);
        homePage.searchHotelFromDynamicListMethod(readingProperties.getValues("hotelNameOne"));
        homePage.clickActionOnTheElement(driver.findElement(By.name(checkin)));
        homePage.waiMethod2();
        homePage.hotelDatePickerMethod(readingProperties.getValues("pastYearHotel"), readingProperties.getValues("pastMonthHotel"),
                readingProperties.getValues("pastDayHotel"), prevArrowCalendar);
        homePage.hotelCheckout();
        homePage.hotelDatePickerMethod(readingProperties.getValues("pastYearHotel"), readingProperties.getValues("pastMonthHotel"),
                readingProperties.getValues("pastDayHotel"), prevArrowCalendar);

    }

    @Test
    public void addAnotherHotels() throws IOException {
        HomePage homePage = new HomePage(driver);
        ReadingProperties readingProperties = new ReadingProperties();
        homePage.pickCityHotel("Londo");
        homePage.waitMethodForXpath(xpath);
        homePage.searchHotelFromDynamicListMethod(readingProperties.getValues("hotelNameOne"));
        homePage.clickActionOnTheElement(driver.findElement(By.name(checkin)));
        homePage.waiMethod2();
        homePage.hotelDatePickerMethod(readingProperties.getValues("futureYearHotel"), readingProperties.getValues("futureMonthHotel"),
                readingProperties.getValues("futureDayHotel"), nextArrowCalendar);
        homePage.hotelCheckout();
        homePage.hotelDatePickerMethod(readingProperties.getValues("futureYearHotel"), readingProperties.getValues("futureMonthHotel"),
                readingProperties.getValues("futureDayHotel"), nextArrowCalendar);
        homePage.addAnotherHotel();
        homePage.addAnotherHotel();

    }

    @Test
    public void addAnotherHotelsAndDelete() throws IOException {
        HomePage homePage = new HomePage(driver);
        ReadingProperties readingProperties = new ReadingProperties();
        homePage.pickCityHotel("Londo");
        homePage.waitMethodForXpath(xpath);
        homePage.searchHotelFromDynamicListMethod(readingProperties.getValues("hotelNameOne"));
        homePage.clickActionOnTheElement(driver.findElement(By.name(checkin)));
        homePage.waiMethod2();
        homePage.hotelDatePickerMethod(readingProperties.getValues("futureYearHotel"), readingProperties.getValues("futureMonthHotel"),
                readingProperties.getValues("futureDayHotel"), nextArrowCalendar);
        homePage.hotelCheckout();
        homePage.hotelDatePickerMethod(readingProperties.getValues("futureYearHotel"), readingProperties.getValues("futureMonthHotel"),
                readingProperties.getValues("futureDayHotel"), nextArrowCalendar);
        homePage.addAnotherHotel();
        homePage.waitMethodForElementToBeClickable("(//span[@class='close p-3'])[1]");

    }
}
