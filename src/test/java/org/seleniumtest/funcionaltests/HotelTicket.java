package org.seleniumtest.funcionaltests;

import org.openqa.selenium.By;
import org.seleniumtest.pages.HomePage;
import org.seleniumtest.tests.BaseTest;
import org.testng.annotations.Test;




public class HotelTicket extends BaseTest {

    private String hotelName = "Londonderr";
    private String xpath = "//ul[@class='suggestions-cities-list']//p";
    private String nextArrowCalendar = "//span[text()='Next']";
    private String prevArrowCalendar = "//span[text()='Prev']";


    @Test
    public void hotelTicketFutureDate() {
        HomePage homePage = new HomePage(driver);
        homePage.pickCityHotel("Londo");
        homePage.waitMethodForXpath(xpath);
        homePage.searchHotelFromDynamicListMethod(hotelName);
        homePage.clickActionOnTheElement(driver.findElement(By.name("checkin[]")));
        homePage.waiMethod2();
        homePage.hotelDatePickerMethod("2026", "Apr", "26", nextArrowCalendar);
        homePage.hotelCheckout();
        homePage.hotelDatePickerMethod("2027", "Apr", "26", nextArrowCalendar);

    }

    @Test
    public void hotelTicketPastDate() {
        HomePage homePage = new HomePage(driver);
        homePage.pickCityHotel("Londo");
        homePage.waitMethodForXpath(xpath);
        homePage.searchHotelFromDynamicListMethod(hotelName);
        homePage.clickActionOnTheElement(driver.findElement(By.name("checkin[]")));
        homePage.waiMethod2();
        homePage.hotelDatePickerMethod("2022", "Dec", "15", prevArrowCalendar);
        homePage.hotelCheckout();
        homePage.hotelDatePickerMethod("2023", "Jun", "9", prevArrowCalendar);

    }

    @Test
    public void addAnotherHotels() {
        HomePage homePage = new HomePage(driver);
        homePage.pickCityHotel("Londo");
        homePage.waitMethodForXpath(xpath);
        homePage.searchHotelFromDynamicListMethod(hotelName);
        homePage.clickActionOnTheElement(driver.findElement(By.name("checkin[]")));
        homePage.waiMethod2();
        homePage.hotelDatePickerMethod("2026", "Apr", "26", nextArrowCalendar);
        homePage.hotelCheckout();
        homePage.hotelDatePickerMethod("2027", "Apr", "26", nextArrowCalendar);
        homePage.addAnotherHotel();
        homePage.addAnotherHotel();

    }

    @Test
    public void addAnotherHotelsAndDelete() {
        HomePage homePage = new HomePage(driver);
        homePage.pickCityHotel("Londo");
        homePage.waitMethodForXpath(xpath);
        homePage.searchHotelFromDynamicListMethod(hotelName);
        homePage.clickActionOnTheElement(driver.findElement(By.name("checkin[]")));
        homePage.waiMethod2();
        homePage.hotelDatePickerMethod("2026", "Apr", "26", nextArrowCalendar);
        homePage.hotelCheckout();
        homePage.hotelDatePickerMethod("2027", "Apr", "26", nextArrowCalendar);
        homePage.addAnotherHotel();
        homePage.waitMethodForElementToBeClickable("(//span[@class='close p-3'])[1]");

    }
}
