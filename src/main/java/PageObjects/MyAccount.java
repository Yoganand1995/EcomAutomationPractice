package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccount {
    public WebDriver Driver;
    @FindBy(xpath = "//p[@class='info-account']")
    WebElement AccountText;

    public MyAccount(WebDriver driver) {
        Driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getAccountText() {
        return AccountText.getText();
    }
}
