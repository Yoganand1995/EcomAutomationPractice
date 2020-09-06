package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartSummaryShipping {
    public WebDriver Driver;
    @FindBy(xpath = "//button[@name='processCarrier']")
    WebElement CheckoutButtonShipping;

    @FindBy(xpath = "//input[@name='cgv']")
    WebElement ShippingCheckBox;

    public WebElement getShippingCheckBox() {
        return ShippingCheckBox;
    }

    public CartSummaryShipping(WebDriver driver) {
        Driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getCheckoutButtonShipping() {
        return CheckoutButtonShipping;
    }
}

