package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {
    public WebDriver Driver;
    @FindBy(xpath = "//i[@class='icon-plus']")
    WebElement AddButton;

    @FindBy(xpath = "//select[@class='form-control attribute_select no-print']")
    WebElement Size;

    @FindBy(xpath = "//button[@name='Submit']")
    WebElement AddToCartButton;

    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    WebElement ProceedToCheckOut;

    @FindBy(xpath = "//a[@id='wishlist_button']")
    WebElement AddToWishList;

    @FindBy(xpath = "//div[@class='fancybox-inner']//p")
    WebElement WishlistError;

    public WebElement getWishlistError() {
        return WishlistError;
    }

    public WebElement getAddButton() {
        return AddButton;
    }

    public WebElement getAddToWishList() {
        return AddToWishList;
    }

    public WebElement getSize(String size) {
        Select SizeSelect = new Select(Size);
        SizeSelect.selectByVisibleText(size);
        return Size;
    }

    public WebElement getAddToCartButton() {
        return AddToCartButton;
    }

    public WebElement getProceedToCheckOut() {
        return ProceedToCheckOut;
    }

    public ProductPage(WebDriver driver) {
        Driver = driver;
        PageFactory.initElements(driver, this);
    }
}
