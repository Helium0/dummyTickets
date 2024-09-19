package org.seleniumtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.seleniumtest.funcionaltests.AdditionalDetails;


import java.util.List;


public class PaymentPage  {

    protected WebDriver driver;

    @FindBy(name = "state")
    private List<WebElement> stateList;

    @FindBy(name = "state")
    private WebElement state;

    @FindBy(name = "submit")
    private WebElement submitClick;

    @FindBy(xpath = "(//button[@name='submit'])[3]")
    private WebElement submitXpathButton;

    @FindBy(xpath = "//input[@value='bank']")
    private WebElement bankRadiobutton;

    @FindBy(xpath = "//label[@class='swicthbutton']")
    private WebElement changeCurrencyButton;

    @FindBy(xpath = "//input[@value='bank_usd']")
    private WebElement usdBank;

    @FindBy(xpath = "//h3[text()='Make Payment']")
    private WebElement makePaymentText;

    @FindBy(xpath = "//strong[text()='Bank Information']")
    private WebElement bankInformation;

    @FindBy(xpath = "//title[text()='Zaloguj się do swojego konta PayPal']" )
    private String paypalTitle;

    @FindBy(xpath = "(//th[text()='Cannaught Place, New Delhi-110001'])[2]")
    private WebElement branchBank;

    public PaymentPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public AdditionalDetails additionalDetails() {
        return new AdditionalDetails();

    }

    public Select select() {
        return new Select(state);
    }

    public void chooseState(String myState) {
        select().getOptions().stream()
                .filter(element -> element.getText().equals(myState))
                .forEach(element -> element.click());
    }

    public void submitButton() {
        submitClick.click();
    }

    public void bankButton() {
        bankRadiobutton.click();
    }

    public void changeCurrency() {
        changeCurrencyButton.click();
    }

    public void chooseUSDBank() {
        usdBank.click();
    }

    public void submitXpathButton() {
        submitXpathButton.click();
    }

    public WebElement getPaymentText() {
        return makePaymentText;
    }

    public String getBankInformation() {
        return bankInformation.getText();
    }

    public String getPaypalTitle() {
        return paypalTitle;
    }

    public String getBranchBank() {
        return branchBank.getText();
    }

}
