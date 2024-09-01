package org.seleniumtest.e2e;

import org.seleniumtest.funcionaltests.Payment;
import org.seleniumtest.tests.BaseTest;
import org.testng.annotations.Test;

public class OrderTickets extends BaseTest {

    @Test
    public void orderTickets() {
        Payment payment = new Payment();
        payment.paymentThroughCreditCardDebitInINRCurrency();
    }

    @Test
    public void orderTicketsThroughBank() {
        Payment payment = new Payment();
        payment.paymentThroughBankTransferINRCurrency();
    }

    @Test
    public void orderTicketsInUSDThroughPaypal() {
        Payment payment = new Payment();
        payment.paymentInUSDCurrencyPaypal();
    }

    @Test
    public void orderTicketsInUSDThroughBank() {
        Payment payment = new Payment();
        payment.paymentInUSDCurrencyBankTransfer();
    }
}
