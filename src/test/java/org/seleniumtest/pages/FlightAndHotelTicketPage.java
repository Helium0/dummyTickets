package org.seleniumtest.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;
import java.util.stream.Collectors;

public class FlightAndHotelTicketPage extends AdditionalDetailsPage {

    protected WebDriver driver;
    int attempt = 0;
    int maxAttempt = 10;

    @FindBy(xpath = "//input[@value='multicityfh']")
    private WebElement multiTripRadiobutton;
    @FindBy(xpath = "(//input[@name='source[]'])[last()]")
    private WebElement departureAirport;
    @FindBy(xpath = "(//input[@name='destination[]'])[last()]")
    private WebElement destinationAirport;
    @FindBy(xpath = "(//input[@name='departure[]'])[last()]")
    private WebElement airPortDepartureClick;
    @FindBy(xpath = "(//input[@name='city[]'])[last()]")
    private WebElement cityHotel;
    @FindBy(xpath = "(//input[@name='checkin[]'])[last()]")
    private WebElement checkinCalendarDate;
    @FindBy(xpath = "(//input[@name='checkout[]'])[last()]")
    private WebElement checkoutCalendarDate;
    @FindBy(xpath = "(//input[@value='Buy Dummy Ticket'])[last()]")
    private WebElement buyDummyTicketButton;
    @FindBy(css = ".addroutefh")
    private WebElement addAnotherRoute;
    @FindBy(css = ".addcityfh")
    private WebElement addAnotherHotel;
    @FindBy(xpath = "//small[text()='Route 2']//following::input[@name='source[]']")
    private WebElement routeTwoDepartureAirport;
    @FindBy(xpath = "//small[text()='Route 2']/following::ul[@class='suggestions-list']//p")
    private List<WebElement> airPortsRouteTwo;
    @FindBy(xpath = "//small[text()='Hotel 2']/following::input[@name='city[]']")
    private WebElement anotherHotel;
    @FindBy(xpath = "//small[text()='Hotel 2']//following::ul[@class='suggestions-cities-list']//p")
    private List<WebElement> cityHotelsPartTwo;



    public FlightAndHotelTicketPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public void clickMultiTripRadiobuttonAndMoveToAnotherElement() {
        multiTripRadiobutton.click();
        multiTripRadiobutton.sendKeys(Keys.TAB);
    }


    public void sendAirPortDeparture() {
        departureAirport.sendKeys("Mala");
    }

    public void clickOnAirPortDestination() {
        destinationAirport.sendKeys("Ka");
    }

    public void clickOnAirPortDeparture() {
        airPortDepartureClick.click();
    }

    public void sendSendCityHotel() {
        cityHotel.sendKeys("Londo");
    }
    public void sendAnotherCityHotel() {
        anotherHotel.sendKeys("Ab");
    }

    public void clickCheckinCalendarDate () {
        checkinCalendarDate.click();
    }

    public void clickCheckoutCalendarDate () {
        checkoutCalendarDate.click();
    }

    public void clickBuyTicketsButton() {
        buyDummyTicketButton.click();
    }

    public void clickToAddAnotherRoute() {
        addAnotherRoute.click();
    }
    public void clickToAddAnotherHotel() {
        addAnotherHotel.click();
    }

    public void clickOnRouteTwoDepartureAirport() {
        routeTwoDepartureAirport.click();
    }

    public void searchAirportCitiesRoundTwo(String airPort) {
        List<WebElement> hotels = airPortsRouteTwo;
        hotels.stream().filter(webElement -> webElement.getText().contains(airPort)).collect(Collectors.toList())
                .forEach(webElement -> webElement.click());
    }

    public void waitForTextToBePresented(String suggestionList, String xpath, String text) {
        waitDriver().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(suggestionList)));
        while (attempt < maxAttempt) {
            try {
                attempt++;
                System.out.println("Attempt: " + attempt);
                waitDriver().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(xpath),text));
                break;
            } catch (TimeoutException e) {
                System.out.println("Number of attempts: " + attempt);
                departureAirport.clear();
                departureAirport.sendKeys("Mala");
                if (attempt == maxAttempt) {
                    System.out.println("Couldn`t find the element after: "+maxAttempt);
                    throw e;
                }
            }

        }
    }

    public void waitForCityHotelTextToBePresented() {
        while (attempt < maxAttempts) {
            try {
                attempt++;
                System.out.println("Attempt: " + attempt);
                waitDriver().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//ul[@class='suggestions-cities-list']//p[text()='Londonderry']"),"Londonderry"));
                break;
            } catch (TimeoutException e) {
                System.out.println("Number of attempts: " + attempt);
                cityHotel.clear();
                cityHotel.sendKeys("Londo");
                if (attempt == maxAttempt) {
                    System.out.println("Couldn`t find the element after: "+maxAttempt);
                    throw e;
                }
            }

        }
    }
    public void waitForCityHotelTextToBePresentedRouteTwo(String xpathHotelCityRouteTwo, String hotelCityName) {
        while (attempt < maxAttempts) {
            try {
                attempt++;
                System.out.println("Attempt: " + attempt);
                waitDriver().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(xpathHotelCityRouteTwo),hotelCityName));
                break;
            } catch (TimeoutException e) {
                System.out.println("Number of attempts: " + attempt);
                cityHotel.clear();
                cityHotel.sendKeys("Londo");
                if (attempt == maxAttempt) {
                    System.out.println("Couldn`t find the element after: "+maxAttempt);
                    throw e;
                }
            }

        }
    }



}
