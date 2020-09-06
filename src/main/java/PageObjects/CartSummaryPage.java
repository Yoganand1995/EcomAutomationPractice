package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartSummaryPage {
    public WebDriver Driver;
    @FindBy(xpath = "//div[@id='center_column']/child::p[2]/a[1]")
    WebElement CheckoutButton;

    @FindBy(xpath = "//p[@id='cart_navigation']/child::button")
    WebElement ConfirmOrder;

    @FindBy(xpath = "//p[@class='cheque-indent']/child::strong")
    WebElement OrderConf;

    @FindBy(xpath = "//td[@class='cart_unit']//span//span")
    WebElement ProductPrice;

    @FindBy(xpath = "//td[@id='total_product']")
    WebElement TotalPrice;

    @FindBy(xpath = "//a[@title='Add']")
    WebElement AddIcon;

    @FindBy(xpath = "//input[@class='cart_quantity_input form-control grey']")
    WebElement QTY;

    public WebElement getQTY() {
        return QTY;
    }

    public WebElement getAddIcon() {
        return AddIcon;
    }

    public WebElement getTotalPrice() {
        return TotalPrice;
    }

    public WebElement getProductPrice() {
        return ProductPrice;
    }

    public WebElement getOrderConf() {
        return OrderConf;
    }

    public WebElement getConfirmOrder() {
        return ConfirmOrder;
    }

    public WebElement getCheckoutButton() {
        return CheckoutButton;
    }

    public CartSummaryPage(WebDriver driver) {
        Driver = driver;
        PageFactory.initElements(driver, this);
    }
}
