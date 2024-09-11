package org.seleniumtest.e2e;

import org.seleniumtest.funcionaltests.Payment;
import org.seleniumtest.tests.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class OrderTickets extends BaseTest {

    @Test
    public void orderTickets() throws IOException {
        Payment payment = new Payment();
        payment.paymentThroughCreditCardDebitInINRCurrency();
    }

    @Test
    public void orderTicketsThroughBank() throws IOException {
        Payment payment = new Payment();
        payment.paymentThroughBankTransferINRCurrency();
    }

    @Test
    public void orderTicketsInUSDThroughPaypal() throws IOException {
        Payment payment = new Payment();
        payment.paymentInUSDCurrencyPaypal();
    }

    @Test
    public void orderTicketsInUSDThroughBank() throws IOException {
        Payment payment = new Payment();
        payment.paymentInUSDCurrencyBankTransfer();
    }
}
