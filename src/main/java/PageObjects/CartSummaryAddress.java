package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartSummaryAddress {
    public WebDriver Driver;
    @FindBy(xpath = "//button[@name='processAddress']")
    WebElement CheckoutButton;

    public WebElement getCheckoutButton() {
        return CheckoutButton;
    }

    public CartSummaryAddress(WebDriver driver) {
        Driver = driver;
        PageFactory.initElements(driver, this);
    }
}
