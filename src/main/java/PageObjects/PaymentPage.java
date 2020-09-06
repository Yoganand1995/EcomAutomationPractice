package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {
    public WebDriver Driver;
    @FindBy(xpath = "//a[@class='bankwire']")
    WebElement BankWirePayment;

    public PaymentPage(WebDriver driver) {
        Driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getBankWirePayment() {
        return BankWirePayment;
    }
}
