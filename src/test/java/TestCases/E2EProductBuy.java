package TestCases;

import PageObjects.*;
import Resources.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class E2EProductBuy extends BaseClass {
    public WebDriver Driver;
    @BeforeMethod(alwaysRun = true)
    public void Initialize() throws IOException {
        Driver = InitializeBrowser();
        Driver = getURL();
    }
    @Test(groups = {"Regression"})
    public void FullBuyProduct() throws InterruptedException {
        HomePage homePage = new HomePage(Driver);
        homePage.getSignIn().click();
        RegistrationAndSignIn Reg = new RegistrationAndSignIn(Driver);
        Reg.getSignInEmail().sendKeys("Test9608@gmail.com");
        Reg.getSignInPwd().sendKeys("Test@123");
        Reg.getSignInButton().click();
        Actions MouseHover = new Actions(Driver);
        MouseHover.moveToElement(homePage.getNavElement()).build().perform();
        homePage.getTShirtsLink().click();
        TShirtsPage TS = new TShirtsPage(Driver);
        MouseHover.moveToElement(TS.getFirstProductTitle()).build().perform();
        Thread.sleep(1000L);
        TS.getMoreButton().click();
        ProductPage PG = new ProductPage(Driver);
        PG.getSize("M");
        PG.getAddToCartButton().click();
        PG.getProceedToCheckOut().click();
        CartSummaryPage CP = new CartSummaryPage(Driver);
        CP.getCheckoutButton().click();
        CartSummaryAddress CS = new CartSummaryAddress(Driver);
        CS.getCheckoutButton().click();
        CartSummaryShipping CSS = new CartSummaryShipping(Driver);
        CSS.getShippingCheckBox().click();
        CSS.getCheckoutButtonShipping().click();
        PaymentPage PP = new PaymentPage(Driver);
        PP.getBankWirePayment().click();
        CP.getConfirmOrder().click();
        Assert.assertEquals(CP.getOrderConf().getText(),"Your order on My Store is complete.");

    }

    @Test
    public void WishlistError() throws InterruptedException {
        HomePage homePage = new HomePage(Driver);
        Actions MouseHover = new Actions(Driver);
        MouseHover.moveToElement(homePage.getNavElement()).build().perform();
        homePage.getTShirtsLink().click();
        TShirtsPage TS = new TShirtsPage(Driver);
        MouseHover.moveToElement(TS.getFirstProductTitle()).build().perform();
        Thread.sleep(1000L);
        TS.getMoreButton().click();
        ProductPage PG = new ProductPage(Driver);
        PG.getAddToWishList().click();
        Assert.assertEquals(PG.getWishlistError().getText(),"You must be logged in to manage your wishlist.");

    }

    @Test
    public void PriceCheck() throws InterruptedException {
        HomePage homePage = new HomePage(Driver);
        homePage.getSignIn().click();
        RegistrationAndSignIn Reg = new RegistrationAndSignIn(Driver);
        Reg.getSignInEmail().sendKeys("Test9608@gmail.com");
        Reg.getSignInPwd().sendKeys("Test@123");
        Reg.getSignInButton().click();
        Actions MouseHover = new Actions(Driver);
        MouseHover.moveToElement(homePage.getNavElement()).build().perform();
        homePage.getTShirtsLink().click();
        TShirtsPage TS = new TShirtsPage(Driver);
        MouseHover.moveToElement(TS.getFirstProductTitle()).build().perform();
        Thread.sleep(1000L);
        TS.getMoreButton().click();
        ProductPage PG = new ProductPage(Driver);
        PG.getSize("M");
        PG.getAddToCartButton().click();
        PG.getProceedToCheckOut().click();
        CartSummaryPage CP = new CartSummaryPage(Driver);
        double ProductAmount = Double.parseDouble(CP.getProductPrice().getText().substring(1));
        CP.getAddIcon().click();
        double TotalPrice = Double.parseDouble(CP.getTotalPrice().getText().substring(1));
        int qty = Integer.parseInt(CP.getQTY().getAttribute("value"));
        Assert.assertEquals(TotalPrice,(qty*ProductAmount));
    }


    @AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        Driver.quit();

    }
}
