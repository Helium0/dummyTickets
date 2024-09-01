package org.seleniumtest.funcionaltests;


import org.seleniumtest.pages.PaymentPage;
import org.seleniumtest.tests.BaseTest;
import org.testng.annotations.Test;



public class Payment extends BaseTest {

    String userState = "Jharkhand";

    @Test
    public void paymentThroughCreditCardDebitInINRCurrency() {
        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.additionalDetails().additionalDetailsReceiveNowOption();
        paymentPage.select();
        paymentPage.chooseState(userState);
        paymentPage.submitButton();

    }


    @Test
    public void paymentThroughBankTransferINRCurrency() {

        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.additionalDetails().additionalDetailsReceiveNowOption();
        paymentPage.bankButton();

    }


    @Test
    public void paymentInUSDCurrencyPaypal() {
        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.additionalDetails().additionalDetailsReceiveNowOption();
        paymentPage.changeCurrency();
        paymentPage.submitXpathButton();

    }

    @Test
    public void paymentInUSDCurrencyBankTransfer() {
        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.additionalDetails().additionalDetailsReceiveNowOption();
        paymentPage.changeCurrency();
        paymentPage.chooseUSDBank();

    }
}
