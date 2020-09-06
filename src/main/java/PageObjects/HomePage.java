package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public WebDriver driver;
    @FindBy(xpath = "//a[contains(text(),'Sign')]")
    WebElement SignIn;

    @FindBy(xpath ="//a[@title='Women']")
    WebElement NavElement;

    @FindBy(xpath = "//a[@title='T-shirts']")
    WebElement TShirtsLink;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getTShirtsLink() {
        return TShirtsLink;
    }

    public WebElement getSignIn() {
        return SignIn;
    }
    public WebElement getNavElement() {
        return NavElement;
    }
}
