package org.seleniumtest.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AdditionalDetailsPage extends HomePage{

    protected WebDriver driver;
    private String airPortDeparture = "Al Ain"; // departure airPort variable
    private String airPortDestination = "Olkhovka"; // destination airPort variable
    int maxAttempts = 5; // variable in try catch

    @FindBy(id = "select2-dialcodes-container")
    private WebElement countryCodeclick;

    @FindBy(className = "select2-search__field")
    private WebElement sendCountryCode;

    @FindBy(xpath = "//ul[@id='select2-dialcodes-results']/li")
    private List<WebElement> countryCodeList;

    @FindBy(name = "email")
    private WebElement userEmail;

    @FindBy(name = "passanger_title[]")
    private WebElement userTitle;

    @FindBy(name = "first_name[]")
    private WebElement userName;

    @FindBy(name = "last_name[]")
    private WebElement userLastName;

    @FindBy(name = "dob[]")
    private WebElement userDateOfBirth;

    @FindBy(xpath = "//span[@title='Nationality']")
    private WebElement nationality;

    @FindBy(name = "contact_number")
    private WebElement contactNumber;

    @FindBy(className = "mb-2")
    private WebElement nextButton;

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

    public void selectAndClickOnCorrectCountryCode(String country) {
        countryCodeList.stream().filter(element -> element.getText().contains(country))
                .forEach(element -> element.click());
    }

    public void sendContactNumber(String mobileNumber) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .ignoring(StaleElementReferenceException.class)
                .until((WebDriver d) -> {
                    contactNumber.sendKeys(mobileNumber);
                    return true;
                });
    }

    public void sendUserEmail(String email) {
        userEmail.sendKeys(email);
    }

    public void chooseUserTitleAndClick() {
        Select select = new Select(userTitle);
        List<WebElement> names = select.getOptions();
        for (WebElement nam : names) {
            if (nam.getText().equals("Mr")) {
                nam.click();
            }
        }
    }

    public void sendUserNameAndSurname(String name, String surname) {
        userName.sendKeys(name);
        userLastName.sendKeys(surname);
    }

    public void userDateOfBirthClickField() {
        userDateOfBirth.click();
    }

    public void sendNationality(String userNationality) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Actions actions = new Actions(driver);
        actions.click(nationality).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='select2-search__field']")));
        driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(userNationality);
    }

    public void chooseNationalityFromListAndClick() {
        int attempt = 0;
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        while (attempt <= maxAttempts) {
            List<WebElement> countries = driver.findElements(By.xpath("//ul[@class='select2-results__options']//li"));
            for (WebElement userCountry : countries) {
                try {
                    attempt++;
                    System.out.println("Attempt: " + attempt);
                    wait.until(ExpectedConditions.elementToBeClickable(userCountry));
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[text()='Poland']")));
                    if (userCountry.getText().endsWith("and")) {
                        userCountry.click();
                        System.out.println("Element clickable after: " + attempt);
                        break;
                    }
                } catch (StaleElementReferenceException exception) {
                    if (attempt == maxAttempts) {
                        System.out.println("Element not clickable");
                        throw exception;

                    }
                }
            }
            break;
        }
    }

    public void clickOnNextButton() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click();", nextButton);
    }
}
