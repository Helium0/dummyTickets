package org.seleniumtest.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class HomePage extends AdditionalDetailsPage {

    protected WebDriver driver;

    int maxAttempts = 5; // variable used in pickCityHotel method

    @FindBy(name = "departure[]")
    private WebElement planeDeparture;

    @FindBy(xpath = "//input[@value='roundtripmain']")
    private WebElement flightRoundTripRadioButton;

    @FindBy(className = "ui-datepicker-month")
    private WebElement monthElementttt;

    @FindBy(className = "ui-datepicker-year")
    private WebElement yearElementttt;

    @FindBy(xpath = "//table//td/a")
    private List<WebElement> dayssss;

    @FindBy(xpath = "//ul[@class='suggestions-list']//p")
    private List<WebElement> airPorts;

    @FindBy(xpath = "//ul[@class='suggestions-cities-list']//p")
    private List<WebElement> cities;

    @FindBy(name = "source[]")
    private WebElement sourceAirPort;

    @FindBy(name = "destination[]")
    private WebElement destinationAirPort;

    @FindBy(id = "flight_oneway_btn")
    private WebElement button;

    @FindBy(xpath = "//input[@name='destination[]']/following-sibling::ul//p")
    private List<WebElement> airports;

    @FindBy(xpath = "//a[text()='Hotel']")
    private WebElement hotel;

    @FindBy(className = "addcityh")
    private WebElement anotherHotel;

    @FindBy(xpath = "//a[text()='Both']")
    private WebElement both;

    @FindBy(name = "city[]")
    private WebElement city;

    @FindBy(name = "checkin[]")
    private WebElement checkin;

    @FindBy(name = "checkout[]")
    private WebElement checkout;

    @FindBy(xpath = "//span[text()='Next']")
    private WebElement nextArrow;

    @FindBy(xpath = "//input[@value='multicityfh']")
    private WebElement multitrip;




    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public void datePicker(int monthh, String year, String day) {
        WebElement monthElement = monthElementttt;
        Select monthValue = new Select(monthElement);
        monthValue.selectByIndex(monthh);

        WebElement yearElement = yearElementttt;
        Select desiredYear = new Select(yearElement);
        desiredYear.selectByValue(year);

        List<WebElement> days = dayssss;
        days.stream().filter(webElement -> webElement.getText().equals(day))
                .forEach(webElement -> webElement.click());

    }

    public void hotelDatePickerMethod(String year, String month, String day, String nextOrPrev)  {
        while(true){
            String actualYear = yearElementttt.getText();
            driver.findElement(By.xpath(nextOrPrev)).click();
            if(actualYear.equals(year)){
                break;
            }
        }

        WebElement datepickerMonth= monthElementttt;
        Select monthList = new Select(datepickerMonth);
        monthList.selectByVisibleText(month);

        List<WebElement> daysList = dayssss;
        for(WebElement findDay : daysList){
            if(findDay.getText().equals(day)){
                findDay.click();
                break;
            }
        }
    }

    public void flightRoundTrip() {
        flightRoundTripRadioButton.click();
    }

    public void setPlaneDeparture() {
        planeDeparture.click();
    }

    public void airPortPicker(String place) {
        List<WebElement> source = airPorts;
        source.stream().filter(webElement -> webElement.getText().contains(place))
                .forEach(webElement -> webElement.click());
    }

    public void searchHotelFromDynamicListMethod(String city) {
        List<WebElement> hotels = cities;
        hotels.stream().filter(webElement -> webElement.getText().contains(city)).collect(Collectors.toList())
                .forEach(webElement -> webElement.click());
    }

    public void ticketForAirportAndHotel() {
        both.click();
    }

    public void fromWhereWeGo(String source) {
        sourceAirPort.sendKeys(source);
    }

    public void whereWeGo(String destination) {
        destinationAirPort.sendKeys(destination);
    }

    public void flightOneWayButton() {
        button.click();
    }

    public void hotelCheckIn() {
        checkin.click();
    }

    public void hotelCheckout() {
        checkout.click();
    }

    public void addAnotherHotel() {
        anotherHotel.click();
    }

    public void bothMultiTrip() {
        multitrip.click();
    }

    public void waitMethodForXpath(String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }
    public void waitMethodForXpath() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='suggestions-list']//p")));
    }

    public void waiMethod2() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(yearElementttt));
    }

    public void waitMethodForElementToBeClickable(String xpath) {
        int attempt = 0;
        while (attempt < maxAttempts) {
            try {
                attempt++;
                System.out.println("Proba numer: " + attempt);
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();
                break;
            } catch (TimeoutException e) {
                System.out.println("Proba znalezienia elementu: " + attempt);
                if(attempt == maxAttempts) {
                    System.out.println("Nie udalo sie znalezc elementu po 5 probach");
                    throw e;
                }
            }
        }
    }

    public void clickActionOnTheElement() {
        Actions actions = new Actions(driver);
        actions.click(checkin).build().perform();
    }

    public void pickCityHotel(String hotelToSend) throws TimeoutException {
        int attempt = 0;
        hotel.click();
        city.click();
        city.sendKeys(hotelToSend);
        while (attempt < maxAttempts) {
            try {
                attempt ++;
                System.out.println("Attempt number: "+attempt);
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
                wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//ul[@class='suggestions-cities-list']//p"), "London"));
                break;
            } catch (TimeoutException e) {
                System.out.println("Couldn`t find the element: "+attempt);
                city.clear();
                city.sendKeys(hotelToSend);
                if(attempt == maxAttempts) {
                    System.out.println("Couldn`t find the element after: "+attempt);
                    throw e;
                }
            }
        }
    }



}
