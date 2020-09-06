package TestCases;

import PageObjects.HomePage;
import PageObjects.TShirtsPage;
import Resources.BaseClass;
import org.apache.tools.ant.taskdefs.Sleep;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class ProductSearch extends BaseClass {
    public WebDriver Driver;
    @BeforeMethod(alwaysRun = true)
    public void Initialize() throws IOException {
        Driver = InitializeBrowser();
        Driver = getURL();
    }

    @Test(groups = {"Regression"})
    public void SearchProduct() throws InterruptedException {
        HomePage homePage = new HomePage(Driver);
        Actions MouseHover = new Actions(Driver);
        MouseHover.moveToElement(homePage.getNavElement()).build().perform();
        homePage.getTShirtsLink().click();
        TShirtsPage TS = new TShirtsPage(Driver);
        String ProductName = TS.getFirstProductTitle().getText();
        TS.getProductSearchBox().sendKeys(ProductName);
        TS.getSearchProductButton().click();
        Assert.assertEquals(TS.getFirstProductTitle().getText(),ProductName);
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        Driver.quit();

    }
}
