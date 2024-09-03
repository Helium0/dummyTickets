package org.seleniumtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FlightAndHotelTicketPage {

    protected WebDriver driver;




    public FlightAndHotelTicketPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

}
