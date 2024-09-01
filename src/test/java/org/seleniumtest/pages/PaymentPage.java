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

}
