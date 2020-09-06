package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class RegistrationAndSignIn {
    public WebDriver Driver;

    @FindBy(xpath = "//input[@id='email_create']")
    WebElement CreateEmailAddress;

    @FindBy(xpath = "//button[@id='SubmitCreate']")
    WebElement CreateEmailAddressButton;

    @FindBy(xpath = "//input[@id='email']")
    WebElement SignInEmail;

    @FindBy(xpath = "//input[@id='passwd']")
    WebElement SignInPwd;

    @FindBy(xpath = "//a[@title='Recover your forgotten password']")
    WebElement ForgotPasswordLink;

    @FindBy(xpath = "//button[@id='SubmitLogin']")
    WebElement LoginButton;

    @FindBy(xpath = "//a[@title='Women']")
    WebElement NavBarWomen;

    @FindBy(xpath = "//a[@title='T-shirts']")
    WebElement NavBarTShirts;

    @FindBy(xpath = "//div[@id='create_account_error']//child::li")
    WebElement EmailAddressText;

    @FindBy(xpath = "//div[@class='alert alert-danger']//child::li")
    List<WebElement> ErrorMessages;

    @FindBy(xpath = "//button[@id='SubmitLogin']")
    WebElement SignInButton;


    public RegistrationAndSignIn(WebDriver driver) {
        Driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getSignInButton() {
        return SignInButton;
    }

    public List<WebElement> getErrorMessages() {
        return ErrorMessages;
    }

    public String getEmailAddressText() {
        return EmailAddressText.getText();
    }

    public WebElement getCreateEmailAddress() {
        return CreateEmailAddress;
    }

    public WebElement getCreateEmailAddressButton() {
        return CreateEmailAddressButton;
    }

    public WebElement getSignInEmail() {
        return SignInEmail;
    }

    public WebElement getSignInPwd() {
        return SignInPwd;
    }

    public WebElement getForgotPasswordLink() {
        return ForgotPasswordLink;
    }

    public WebElement getLoginButton() {
        return LoginButton;
    }

    public WebElement getNavBarWomen() {
        return NavBarWomen;
    }

    public WebElement getNavBarTShirts() {
        return NavBarTShirts;
    }
}
