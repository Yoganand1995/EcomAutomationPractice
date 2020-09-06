package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class CreateAccountPage {
    public WebDriver driver;
    @FindBy(xpath = "//input[@name='customer_firstname']")
    WebElement FirstName;
    @FindBy(xpath = "//input[@name='customer_lastname']")
    WebElement LastName;
    @FindBy(xpath = "//input[@name='passwd']")
    WebElement Password;
    @FindBy(xpath = "//input[@name='firstname']")
    WebElement AddressFirstName;
    @FindBy(xpath = "//input[@name='lastname']")
    WebElement AddressLastName;
    @FindBy(xpath = "//input[@name='company']")
    WebElement Company;
    @FindBy(xpath = "//input[@name='address1']")
    WebElement AddressLine1;
    @FindBy(xpath = "//input[@name='address2']")
    WebElement AddressLine2;
    @FindBy(xpath = "//input[@name='city']")
    WebElement City;
    @FindBy(xpath = "//input[@name='postcode']")
    WebElement Zipcode;
    @FindBy(xpath = "//textarea[@name='other']")
    WebElement AdditionalInfo;
    @FindBy(xpath = "//input[@name='phone']")
    WebElement PhoneNumber;
    @FindBy(xpath = "//input[@name='phone_mobile']")
    WebElement MobileNumber;
    @FindBy(xpath = "//input[@name='alias']")
    WebElement AssignAlias;
    @FindBy(xpath = "//button[@name='submitAccount']")
    WebElement RegisterButton;
    @FindBy(xpath = "//select[@id='days']")
    WebElement DateOfBirth;
    @FindBy(xpath = "//select[@id='months']")
    WebElement MonthOfBirth;
    @FindBy(xpath = "//select[@id='years']")
    WebElement YearOfBirth;
    @FindBy(xpath = "//select[@id='id_state']")
    WebElement Stat;
    @FindBy(xpath = "//select[@id='id_country']")
    WebElement Country;
    @FindBy(xpath = "//label[contains(.,'Receive special offers from our partners!')]")
    WebElement checkbox;
    @FindBy(xpath = "//div[@class='alert alert-danger']//child::li")
    List<WebElement> ErrorMessages;


    public WebElement getFirstName() {
        return FirstName;
    }

    public WebElement getLastName() {
        return LastName;
    }

    public WebElement getPassword() {
        return Password;
    }

    public WebElement getAddressFirstName() {
        return AddressFirstName;
    }

    public WebElement getAddressLastName() {
        return AddressLastName;
    }

    public WebElement getCompany() {
        return Company;
    }

    public WebElement getAddressLine1() {
        return AddressLine1;
    }

    public WebElement getAddressLine2() {
        return AddressLine2;
    }

    public WebElement getCity() {
        return City;
    }

    public WebElement getZipcode() {
        return Zipcode;
    }

    public WebElement getAdditionalInfo() {
        return AdditionalInfo;
    }

    public WebElement getPhoneNumber() {
        return PhoneNumber;
    }

    public WebElement getMobileNumber() {
        return MobileNumber;
    }

    public WebElement getAssignAlias() {
        return AssignAlias;
    }

    public WebElement getRegisterButton() {
        return RegisterButton;
    }

    public WebElement getDateOfBirth(String date) {
        Select Date = new Select(DateOfBirth);
        Date.selectByValue(date);
        return DateOfBirth;
    }

    public WebElement getMonthOfBirth(String month) {
        Select Month = new Select(MonthOfBirth);
        Month.selectByValue(month);
        return MonthOfBirth;
    }

    public WebElement getYearOfBirth(String year) {
        Select Year = new Select(YearOfBirth);
        Year.selectByValue(year);
        return YearOfBirth;
    }

    public WebElement getState(String state) {
        Select State = new Select(Stat);
        State.selectByVisibleText(state);
        return Stat;
    }

    public WebElement getCountry(String country) {
        Select CountrySelect = new Select(Country);
        CountrySelect.selectByVisibleText(country);
        return Country;
    }

    public WebElement getCheckbox() {
        return checkbox;
    }

    public List<WebElement> getErrorMessages() {
        return ErrorMessages;
    }

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
