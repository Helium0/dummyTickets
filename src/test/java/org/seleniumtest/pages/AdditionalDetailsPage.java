package org.seleniumtest.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class AdditionalDetailsPage extends HomePage {

    protected WebDriver driver;
    private String airPortDeparture = "Al Ain"; // departure airPort variable
    private String airPortDestination = "Olkhovka"; // destination airPort variable
    int maxAttempts = 10; // variable in try catch
    int attempt = 0; // variable in try catch

    String passengerTitleOne = "Mr";
    String passengerTitleTwo = "Ms";
    String passengerNameOne = "Patryk";
    String passengerNameTwo = "Asia";
    String passengerLastNameOne = "Tester";
    String passengerLastNameTwo = "Testerka";
    String passengerDateOfBirthOne = "10-01-1970";
    String passengerDateOfBirthTwo = "18-04-1960";
    String passengerNationalityOne = "Poland";
    String passengerNationalityTwo = "Poland";

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

    @FindBy(xpath = "//select[@name='passanger_title[]']")
    private List<WebElement> userTitles;

    @FindBy(name = "first_name[]")
    private WebElement userName;

    @FindBy(xpath = "//input[@name='first_name[]']")
    private List<WebElement> userNames;

    @FindBy(name = "last_name[]")
    private WebElement userLastName;

    @FindBy(xpath = "//input[@name='last_name[]']")
    private List<WebElement> userLastNames;

    @FindBy(name = "dob[]")
    private WebElement userDateOfBirth;

    @FindBy(xpath = "//input[@name='dob[]']")
    private List<WebElement> usersDateOfBirth;

    @FindBy(xpath = "//span[@title='Nationality']")
    private WebElement nationality;
    @FindBy(xpath = "//span[@title='Nationality']")
    private List<WebElement> usersNationality;
    @FindBy(xpath = "//ul[@class='select2-results__options']//li")
    private List<WebElement> usersCountry;

    @FindBy(name = "contact_number")
    private WebElement contactNumber;

    @FindBy(xpath = "//input[@value='Next']")
    private WebElement nextButton;

    @FindBy(className = "addcityfh")
    private WebElement addPassenger;
    @FindBy(xpath = "//span[@onclick='removeItem(2)']")
    private WebElement removePassenger;
    @FindBy(xpath = "//input[@value='receive_now']")
    private WebElement receiveNowRadioButton;
    @FindBy(id = "select2-purpose-container")
    private WebElement purposeDummyTickets;
    @FindBy(xpath = "//ul[@id='select2-purpose-results']//li")
    private List<WebElement> purposeList;
    @FindBy(name = "message")
    private WebElement fieldToSendText;

    public WebDriverWait waitDriver() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait;
    }

    public Actions actionsMethod() {
        Actions actions = new Actions(driver);
        return actions;
    }

    public AdditionalDetailsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
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
        homePage.datePicker(10, "2025", "26");
        homePage.flightOneWayButton();
    }

    public void waitForCountryCodeIdElement(String id) {
        waitDriver().until(ExpectedConditions.elementToBeClickable(By.id(id)));
    }

    public void selectAndTypeCountryCode(String country) {
        waitDriver().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Country Code']")));
        actionsMethod().click(countryCodeclick).perform();
        sendCountryCode.sendKeys("Pol");
        countryCodeList.stream().filter(element -> element.getText().contains(country))
                .forEach(element -> element.click());
    }


    public void sendContactNumber(String mobileNumber) {
        waitDriver()
                .ignoring(StaleElementReferenceException.class)
                .until((WebDriver d) -> {
                    contactNumber.sendKeys(mobileNumber);
                    return true;
                });
    }

    public void sendUserEmail(String email) {
        userEmail.sendKeys(email);
    }

    public void chooseUserTitleAndClick(String title) {
        Select select = new Select(userTitle);
        List<WebElement> names = select.getOptions();
        for (WebElement nam : names) {
            if (nam.getText().equals(title)) {
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
        actionsMethod().click(nationality).perform();
        waitDriver().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='select2-search__field']")));
        driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(userNationality);
    }

    public void chooseNationalityFromListAndClick() {
        while (attempt <= maxAttempts) {
            List<WebElement> countries = driver.findElements(By.xpath("//ul[@class='select2-results__options']//li"));
            for (WebElement userCountry : countries) {
                try {
                    attempt++;
                    System.out.println("Attempt: " + attempt);
                    waitDriver().until(ExpectedConditions.elementToBeClickable(userCountry));
                    waitDriver().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[text()='Poland']")));
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

    public void setAddPassenger() {
        addPassenger.click();
    }

    public void setRemovePassenger() {
        removePassenger.click();
    }

    public void clickOnNextButton() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click();", nextButton);
    }

    public List<String> setPassengersTitles() {
        List<String> addTitles = new ArrayList<>();
        addTitles.add(passengerTitleOne);
        addTitles.add(passengerTitleTwo);
        return addTitles;
    }

    public void passengersTitle() {
        for (int i = 0; i < userTitles.size(); i++) {
            userTitles.get(i).sendKeys(setPassengersTitles().get(i));
        }
    }

    public List<String> setPassengersName() {
        List<String> addNames = new ArrayList<>();
        addNames.add(passengerNameOne);
        addNames.add(passengerNameTwo);
        return addNames;
    }

    public void passengersName() {
        for (int i = 0; i < userNames.size(); i++) {
            userNames.get(i).sendKeys(setPassengersName().get(i));
        }
    }

    public List<String> setPassengersLastName() {
        List<String> addLastNames = new ArrayList<>();
        addLastNames.add(passengerLastNameOne);
        addLastNames.add(passengerLastNameTwo);
        return addLastNames;
    }

    public void passengersLastName() {
        for (int i = 0; i < userLastNames.size(); i++) {
            userLastNames.get(i).sendKeys(setPassengersLastName().get(i));
        }
    }

    public List<String> setPassengersDateOfBirth() {
        List<String> addDatesOfBirth = new ArrayList<>();
        addDatesOfBirth.add(passengerDateOfBirthOne);
        addDatesOfBirth.add(passengerDateOfBirthTwo);
        return addDatesOfBirth;
    }

    public void passengersDatesOfBirth() {
        for (int i = 0; i < usersDateOfBirth.size(); i++) {
            usersDateOfBirth.get(i).sendKeys(setPassengersDateOfBirth().get(i));
        }
    }

    public List<String> setPassengersNationality() {
        List<String> addNationalities = new ArrayList<>();
        addNationalities.add(passengerNationalityOne);
        addNationalities.add(passengerNationalityTwo);
        return addNationalities;
    }

    public void passengersNationality() {
        List<WebElement> nationality = driver.findElements(By.xpath("//span[@title='Nationality']"));
        for (int i = 0; i < nationality.size(); i++) {
            Actions actions = new Actions(driver);
            actions.click(nationality.get(i)).sendKeys(setPassengersNationality().get(i)).build().perform();
            waitDriver().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Nationality']")));
            for (WebElement pel : usersCountry) {
                try {
                    attempt++;
                    System.out.println("Attempt: " + attempt);
//                    pel.getText().equals("Poland");
                    pel.isDisplayed();
                    pel.click();
                } catch (StaleElementReferenceException exception) {
                    if (attempt == maxAttempts) {
                        System.out.println("Element not clickable");
                        throw exception;
                    }
                }
            }
        }
    }

    public void selectReceiveNow() {
        waitDriver().until(ExpectedConditions.elementToBeClickable(receiveNowRadioButton));
        receiveNowRadioButton.click();
    }

    public void clickOnPurposeToBuyDummyTickets() {
        purposeDummyTickets.click();
    }

    public void selectRightPurposeFromDropDown(String purposeText) {
        while (attempt < maxAttempts)
            try {
                attempt++;
                System.out.println("Attempt number: " + attempt);
                purposeList.stream().filter(element -> element.getText().equals(purposeText))
                        .forEach(element -> element.click());
                break;
            } catch (StaleElementReferenceException e) {
                if (attempt == maxAttempts) {
                    System.out.println("Couldn`t click on right element after: " + maxAttempts);
                    throw e;
                }
            }
    }

    public void sendText(String text){
        fieldToSendText.sendKeys(text);
    }

}
