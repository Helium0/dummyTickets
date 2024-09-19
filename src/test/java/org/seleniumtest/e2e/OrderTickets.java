package org.seleniumtest.e2e;

import org.seleniumtest.funcionaltests.Payment;
import org.seleniumtest.pages.PaymentPage;
import org.seleniumtest.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class OrderTickets extends BaseTest {

    @Test
    public void orderTickets() throws IOException {
        Payment payment = new Payment();
        PaymentPage paymentPage = new PaymentPage(driver);
        payment.paymentThroughCreditCardDebitInINRCurrency();


        Assert.assertEquals(paymentPage.getPaymentText().getText(), "Make Payment");


    }

    @Test
    public void orderTicketsThroughBank() throws IOException {
        Payment payment = new Payment();
        PaymentPage paymentPage = new PaymentPage(driver);
        payment.paymentThroughBankTransferINRCurrency();


        Assert.assertEquals(paymentPage.getBankInformation(), "Bank Information");



    }

    @Test
    public void orderTicketsInUSDThroughPaypal() throws IOException {
        Payment payment = new Payment();
        PaymentPage paymentPage = new PaymentPage(driver);
        payment.paymentInUSDCurrencyPaypal();


        Assert.assertTrue(true, paymentPage.getPaypalTitle());

    }

    @Test
    public void orderTicketsInUSDThroughBank() throws IOException {
        Payment payment = new Payment();
        PaymentPage paymentPage = new PaymentPage(driver);
        payment.paymentInUSDCurrencyBankTransfer();


        Assert.assertEquals(paymentPage.getBranchBank(),"Cannaught Place, New Delhi-110001");
    }
}
