package org.seleniumtest.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.seleniumtest.funcionaltests.FlightTicket;
import org.seleniumtest.tests.ReadingProperties;

import java.io.IOException;
import java.time.Duration;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AdditionalDetailsPage {

    protected WebDriver driver;
    protected int maxAttempts = 10; // variable in try catch
    protected int attempt = 0; // variable in try catch



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
    @FindBy(xpath = "(//input[@value='Next'])[2]")
    private WebElement nextButtonTwo;
    @FindBy(className = "addcityfh")
    private WebElement addPassenger;
    @FindBy(xpath = "//span[@onclick='removeItem(2)']")
    private WebElement removePassenger;
    @FindBy(xpath = "//input[@value='receive_now']")
    private WebElement receiveNowRadioButton;
    @FindBy(xpath = "//input[@value='receive_later']")
    private WebElement receiveLaterRadioButton;
    @FindBy(id = "select2-purpose-container")
    private WebElement purposeDummyTickets;
    @FindBy(xpath = "//ul[@id='select2-purpose-results']//li")
    private List<WebElement> purposeList;
    @FindBy(name = "message")
    private WebElement fieldToSendText;
    @FindBy(css = "[name='receive_date']")
    private WebElement chooseDate;
    @FindBy(xpath = "//span[@class='ui-datepicker-month']")
    private WebElement displayedMonth;
    @FindBy(xpath = "//table[@class='ui-datepicker-calendar']//td/a")
    private List<WebElement> allDays;
    @FindBy(xpath = "//a[@title='Prev']")
    private WebElement prevArrow;
    @FindBy(xpath = "//a[@title='Next']")
    private WebElement nextArrow;
    @FindBy(name = "airline")
    private WebElement airlineText;
    @FindBy(className = "ui-datepicker-month")
    private WebElement monthElementttt;
    @FindBy(className = "ui-datepicker-year")
    private WebElement yearElementttt;
    @FindBy(xpath = "//table//td/a")
    private List<WebElement> dayssss;

    public WebDriverWait waitDriver() {
        return new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public Actions actionsMethod() {
        return new Actions(driver);
    }

    public AdditionalDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public FlightTicket flightTicket() {
        return new FlightTicket();
    }

    ReadingProperties readingProperties = new ReadingProperties();

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
    public void clickOnNextButtonTwo() {
        nextButtonTwo.click();
    }

    public List<String> setPassengersTitles() throws IOException {
        List<String> addTitles = new ArrayList<>();
        addTitles.add(readingProperties.getValues("title"));
        addTitles.add(readingProperties.getValues("titleHer"));
        return addTitles;
    }

    public void passengersTitle() throws IOException {
        for (int i = 0; i < userTitles.size(); i++) {
            userTitles.get(i).sendKeys(setPassengersTitles().get(i));
        }
    }

    public List<String> setPassengersName() throws IOException {
        List<String> addNames = new ArrayList<>();
        addNames.add(readingProperties.getValues("passengerNameOne"));
        addNames.add(readingProperties.getValues("passengerNameTwo"));
        return addNames;
    }

    public void passengersName() throws IOException {
        for (int i = 0; i < userNames.size(); i++) {
            userNames.get(i).sendKeys(setPassengersName().get(i));
        }
    }

    public List<String> setPassengersLastName() throws IOException {
        List<String> addLastNames = new ArrayList<>();
        addLastNames.add(readingProperties.getValues("userSurname"));
        addLastNames.add(readingProperties.getValues("userSurname"));
        return addLastNames;
    }

    public void passengersLastName() throws IOException {
        for (int i = 0; i < userLastNames.size(); i++) {
            userLastNames.get(i).sendKeys(setPassengersLastName().get(i));
        }
    }

    public List<String> setPassengersDateOfBirth() throws IOException {
        List<String> addDatesOfBirth = new ArrayList<>();
        addDatesOfBirth.add(readingProperties.getValues("passengerDateOfBirthOne"));
        addDatesOfBirth.add(readingProperties.getValues("passengerDateOfBirthTwo"));
        return addDatesOfBirth;
    }

    public void passengersDatesOfBirth() throws IOException {
        for (int i = 0; i < usersDateOfBirth.size(); i++) {
            usersDateOfBirth.get(i).sendKeys(setPassengersDateOfBirth().get(i));
        }
    }

    public List<String> setPassengersNationality() throws IOException {
        List<String> addNationalities = new ArrayList<>();
        addNationalities.add(readingProperties.getValues("userNationality"));
        addNationalities.add(readingProperties.getValues("userNationality"));
        return addNationalities;
    }

    public void passengersNationality() throws IOException {
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

    public void selectReceiveLater() {
        waitDriver().until(ExpectedConditions.elementToBeClickable(receiveLaterRadioButton));
        receiveLaterRadioButton.click();
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

    public void sendText(String text) {
        fieldToSendText.sendKeys(text);
    }

    public void pickDate() {
        chooseDate.click();
    }

    public Month convertMonth(String month) {

        HashMap<String, Month> monthMap = new HashMap<String,Month>();
        monthMap.put("January",Month.JANUARY);
        monthMap.put("February",Month.FEBRUARY);
        monthMap.put("March",Month.MARCH);
        monthMap.put("April",Month.APRIL);
        monthMap.put("May",Month.MAY);
        monthMap.put("June",Month.JUNE);
        monthMap.put("July",Month.JULY);
        monthMap.put("August",Month.AUGUST);
        monthMap.put("September",Month.SEPTEMBER);
        monthMap.put("October",Month.OCTOBER);
        monthMap.put("November",Month.NOVEMBER);
        monthMap.put("December",Month.DECEMBER);

        Month vmonth = monthMap.get(month);
        if(vmonth == null) {
            System.out.println("Invalid month");
        }
        return vmonth;
    }

    public void monthsCompare(String month, String day) {
        while (true) {
            String displayedMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
            Month curr = convertMonth(displayedMonth);
            Month expMonth = convertMonth(month);

           int result = curr.compareTo(expMonth);

           if(result < 0) {
               prevArrow.click();
           } else if (result > 0) {
               nextArrow.click();
           } else {
               System.out.println("Months are equals");
               break;
           }
        }
        allDays.stream().filter(element -> element.getText().equals(day))
                .forEach(element -> element.click());
    }

    public void whichAirline(String airline) {
        airlineText.sendKeys(airline);
    }
}
