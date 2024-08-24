package org.seleniumtest.funcionaltests;

import org.openqa.selenium.By;
import org.seleniumtest.pages.HomePage;
import org.seleniumtest.tests.BaseTest;
import org.testng.annotations.Test;




public class HotelTicket extends BaseTest {

    String hotelName = "Londonderr";
    String xpath = "//ul[@class='suggestions-cities-list']//p";

    @Test
    public void hotelTicketFutureDate() {
        HomePage homePage = new HomePage(driver);
        homePage.pickCityHotel("Londo");
        homePage.waitMethod(xpath);
        homePage.searchHotelFromDynamicListMethod(hotelName);
        homePage.clickActionOnTheElement(driver.findElement(By.name("checkin[]")));
        homePage.waiMethod2();
        homePage.hotelDatePickerMethod("2026", "Apr", "26", "//span[text()='Next']");
        homePage.hotelCheckout();
        homePage.hotelDatePickerMethod("2027", "Apr", "26", "//span[text()='Next']");

    }

    @Test
    public void hotelTicketPastDate() {
        HomePage homePage = new HomePage(driver);
        homePage.pickCityHotel("Londo");
        homePage.waitMethod(xpath);
        homePage.searchHotelFromDynamicListMethod(hotelName);
        homePage.clickActionOnTheElement(driver.findElement(By.name("checkin[]")));
        homePage.waiMethod2();
        homePage.hotelDatePickerMethod("2022", "Dec", "15", "//span[text()='Prev']");
        homePage.hotelCheckout();
        homePage.hotelDatePickerMethod("2023", "Jun", "9", "//span[text()='Prev']");

    }

    @Test
    public void addAnotherHotels() {
        HomePage homePage = new HomePage(driver);
        homePage.pickCityHotel("Londo");
        homePage.waitMethod(xpath);
        homePage.searchHotelFromDynamicListMethod(hotelName);
        homePage.clickActionOnTheElement(driver.findElement(By.name("checkin[]")));
        homePage.waiMethod2();
        homePage.hotelDatePickerMethod("2026", "Apr", "26", "//span[text()='Next']");
        homePage.hotelCheckout();
        homePage.hotelDatePickerMethod("2027", "Apr", "26", "//span[text()='Next']");
        homePage.addAnotherHotel();
        homePage.addAnotherHotel();

    }

    @Test
    public void addAnotherHotelsAndDelete() {
        HomePage homePage = new HomePage(driver);
        homePage.pickCityHotel("Londo");
        homePage.waitMethod(xpath);
        homePage.searchHotelFromDynamicListMethod(hotelName);
        homePage.clickActionOnTheElement(driver.findElement(By.name("checkin[]")));
        homePage.waiMethod2();
        homePage.hotelDatePickerMethod("2026", "Apr", "26", "//span[text()='Next']");
        homePage.hotelCheckout();
        homePage.hotelDatePickerMethod("2027", "Apr", "26", "//span[text()='Next']");
        homePage.addAnotherHotel();
        homePage.waitMethodForElementToBeClickable("(//span[@class='close p-3'])[1]");

    }
}
