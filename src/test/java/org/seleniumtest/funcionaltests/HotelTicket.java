package org.seleniumtest.funcionaltests;

import org.seleniumtest.pages.HomePage;
import org.seleniumtest.tests.BaseTest;
import org.testng.annotations.Test;




public class HotelTicket extends BaseTest {

    String hotelName = "Londonderr";
    String xpath = "//ul[@class='suggestions-cities-list']//p";

    @Test
    public void dummyHotelTicketFutureDate()  {
        HomePage homePage = new HomePage(driver);
        homePage.pickCityHotel("Londo");
        homePage.waitMethod(xpath);
        homePage.searchHotelFromDynamicListMethod(hotelName);
        homePage.clickActionOnTheElement();
        homePage.waiMethod2();
        homePage.hotelDatePickerMethod("2026", "Apr", "26","//span[text()='Next']");
        homePage.hotelCheckout();
        homePage.hotelDatePickerMethod("2027","Apr", "26","//span[text()='Next']");

    }

    @Test

    public void dummyHotelTicketPastDate() {
        HomePage homePage = new HomePage(driver);
        homePage.pickCityHotel("Londo");
        homePage.waitMethod(xpath);
        homePage.searchHotelFromDynamicListMethod(hotelName);
        homePage.clickActionOnTheElement();
        homePage.waiMethod2();
        homePage.hotelDatePickerMethod("2022", "Dec","15","//span[text()='Prev']");
        homePage.hotelCheckout();
        homePage.hotelDatePickerMethod("2023", "Jun","9","//span[text()='Prev']");

    }
}
