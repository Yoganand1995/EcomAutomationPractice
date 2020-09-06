package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ForgotPassword {
    public WebDriver Driver;
    @FindBy(xpath = "//div[@class='alert alert-danger']//child::li")
    List<WebElement> ErrorMessages;

    @FindBy(xpath = "//input[@name='email']")
    WebElement EmailBox;

    @FindBy(xpath = "//button[@class='btn btn-default button button-medium']")
    WebElement EmailSubmit;

    @FindBy(xpath = "//p[@class='alert alert-success']")
    WebElement Confirmation;

    public WebElement getConfirmation() {
        return Confirmation;
    }

    public WebElement getEmailBox() {
        return EmailBox;
    }

    public WebElement getEmailSubmit() {
        return EmailSubmit;
    }

    public ForgotPassword(WebDriver driver) {
        Driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getErrorMessages() {
        return ErrorMessages;
    }
}
