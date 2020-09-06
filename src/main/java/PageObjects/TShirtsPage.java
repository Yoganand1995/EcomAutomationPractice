package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TShirtsPage {
    public WebDriver driver;
    @FindBy(xpath = "//h5[@itemprop='name']//a")
    WebElement FirstProductTitle;
    @FindBy(xpath = "//input[@name='search_query']")
    WebElement ProductSearchBox;
    @FindBy(xpath = "//button[@name='submit_search']")
    WebElement SearchProductButton;
    @FindBy(xpath = "//a[@class='button lnk_view btn btn-default']")
    WebElement MoreButton;

    public WebElement getMoreButton() {
        return MoreButton;
    }

    public WebElement getProductSearchBox() {
        return ProductSearchBox;
    }

    public WebElement getSearchProductButton() {
        return SearchProductButton;
    }

    public WebElement getFirstProductTitle() {
        return FirstProductTitle;
    }

    public TShirtsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
