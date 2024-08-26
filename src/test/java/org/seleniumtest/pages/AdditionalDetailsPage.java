package org.seleniumtest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdditionalDetailsPage extends HomePage{

    protected WebDriver driver;
    private String airPortDeparture = "Al Ain"; // departure airPort variable
    private String airPortDestination = "Olkhovka"; // destination airPort variable

    @FindBy(id = "select2-dialcodes-container")
    private WebElement countryCodeclick;

    @FindBy(className = "select2-search__field")
    private WebElement sendCountryCode;



    public AdditionalDetailsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public void orderFlyTicket() {
        HomePage homePage = new HomePage(driver);
        homePage.fromWhereWeGo("Po");
        homePage.waitMethodForXpath("//ul[@class='suggestions-list']//p");
        homePage.airPortPicker(airPortDeparture);
        homePage.whereWeGo("Ol");
        homePage.waitMethodForXpath("//input[@name='destination[]']/following-sibling::ul//p");
        homePage.airPortPicker(airPortDestination);
        homePage.setPlaneDeparture();
        homePage.datePicker(10,"2025","26");
        homePage.flightOneWayButton();
    }

    public void waitForIdElement(String id) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
    }

    public void selectAndTypeCountryCode() {
        Actions actions = new Actions(driver);
        actions.click(countryCodeclick).perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("select2-search__field")));
        sendCountryCode.sendKeys("Pol");
        wait.until(ExpectedConditions.elementToBeClickable(By.className("select2-search__field")));
    }



}
