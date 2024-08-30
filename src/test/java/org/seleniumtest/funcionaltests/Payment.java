package org.seleniumtest.funcionaltests;


import org.seleniumtest.pages.PaymentPage;
import org.seleniumtest.tests.BaseTest;
import org.testng.annotations.Test;



public class Payment extends BaseTest {

    @Test
    public void paymentThroughCreditCardDebit() throws InterruptedException {
        PaymentPage paymentPage = new PaymentPage(driver);
        FlightTicket flightTicket = new FlightTicket();
        AdditionalDetails additionalDetails = new AdditionalDetails();
        flightTicket.oneWayTicketFutureDate();
        additionalDetails.formDetails();
        paymentPage.flightTicket().oneWayTicketFutureDate();
        paymentPage.additionalDetails().formDetails();
        paymentPage.formDetails();
        Thread.sleep(5000);
    }
}
