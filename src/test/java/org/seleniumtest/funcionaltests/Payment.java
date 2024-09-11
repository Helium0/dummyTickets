package org.seleniumtest.funcionaltests;


import org.seleniumtest.pages.PaymentPage;
import org.seleniumtest.tests.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;


public class Payment extends BaseTest {

    String userState = "Jharkhand";

    @Test
    public void paymentThroughCreditCardDebitInINRCurrency() throws IOException {
        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.additionalDetails().additionalDetailsReceiveNowOption();
        paymentPage.select();
        paymentPage.chooseState(userState);
        paymentPage.submitButton();

    }


    @Test
    public void paymentThroughBankTransferINRCurrency() throws IOException {

        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.additionalDetails().additionalDetailsReceiveNowOption();
        paymentPage.bankButton();

    }


    @Test
    public void paymentInUSDCurrencyPaypal() throws IOException {
        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.additionalDetails().additionalDetailsReceiveNowOption();
        paymentPage.changeCurrency();
        paymentPage.submitXpathButton();

    }

    @Test
    public void paymentInUSDCurrencyBankTransfer() throws IOException {
        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.additionalDetails().additionalDetailsReceiveNowOption();
        paymentPage.changeCurrency();
        paymentPage.chooseUSDBank();

    }
}
