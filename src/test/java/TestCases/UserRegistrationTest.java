package TestCases;

import PageObjects.*;
import Resources.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;

public class UserRegistrationTest extends BaseClass {
    public WebDriver Driver;

    @BeforeMethod(alwaysRun = true)
    public void Initialize() throws IOException {
        Driver = InitializeBrowser();
        Driver = getURL();
    }

    @Test(groups = {"Regression"})
    public void UserRegistration() {
        HomePage homePage = new HomePage(Driver);
        homePage.getSignIn().click();
        RegistrationAndSignIn Reg = new RegistrationAndSignIn(Driver);
        Reg.getCreateEmailAddress().sendKeys("Test11020@gmail.com");
        Reg.getCreateEmailAddressButton().click();
        CreateAccountPage create = new CreateAccountPage(Driver);
        create.getFirstName().sendKeys("Test");
        create.getLastName().sendKeys("Tester");
        create.getPassword().sendKeys("Test@123");
        create.getDateOfBirth("23");
        create.getMonthOfBirth("5");
        create.getYearOfBirth("1995");
        create.getAddressLine1().sendKeys("address1");
        create.getAddressLine2().sendKeys("address2");
        create.getCity().sendKeys("bglr");
        create.getState("Alabama");
        create.getZipcode().sendKeys("30005");
        create.getCountry("United States");
        create.getAdditionalInfo().sendKeys("This is the Test");
        create.getPhoneNumber().sendKeys("9999999999");
        create.getMobileNumber().sendKeys("1234567890");
        create.getAssignAlias().sendKeys("Test");
        create.getRegisterButton().click();
        MyAccount myAccount = new MyAccount(Driver);
        Assert.assertEquals(myAccount.getAccountText(), "Welcome to your account. Here you can manage all of your personal information and orders.");
    }

    @Test
    public void InvalidEmailAddress() {
        HomePage homePage = new HomePage(Driver);
        homePage.getSignIn().click();
        RegistrationAndSignIn Reg = new RegistrationAndSignIn(Driver);
        Reg.getCreateEmailAddress().sendKeys("Test1564");
        Reg.getCreateEmailAddressButton().click();
        Assert.assertEquals(Reg.getEmailAddressText(), "Invalid email address.");
    }

    @Test(groups = {"Regression"})
    public void MandatoryFieldsError() {
        HomePage homePage = new HomePage(Driver);
        homePage.getSignIn().click();
        RegistrationAndSignIn Reg = new RegistrationAndSignIn(Driver);
        Reg.getCreateEmailAddress().sendKeys("Test2579@gmail.com");
        Reg.getCreateEmailAddressButton().click();
        CreateAccountPage create = new CreateAccountPage(Driver);
        create.getRegisterButton().click();
        List<WebElement> Errors = create.getErrorMessages();
        for (WebElement error : Errors) {
            System.out.println(error.getText());
            if (error.getText().contains("firstname")) {
                Assert.assertEquals(error.getText(), "firstname is required.");
            } else if (error.getText().contains("lastname")) {
                Assert.assertEquals(error.getText(), "lastname is required.");
            } else if (error.getText().contains("address1")) {
                Assert.assertEquals(error.getText(), "address1 is required.");
            } else if (error.getText().contains("passwd")) {
                Assert.assertEquals(error.getText(), "passwd is required.");
            } else if (error.getText().contains("city")) {
                Assert.assertEquals(error.getText(), "city is required.");
            } else if (error.getText().contains("Zip")) {
                Assert.assertEquals(error.getText(), "The Zip/Postal code you've entered is invalid. It must follow this format: 00000");
            } else if (error.getText().contains("State")) {
                Assert.assertEquals(error.getText(), "This country requires you to choose a State.");
            } else {
                Assert.assertEquals(error.getText(), "You must register at least one phone number.");
            }
        }

    }

    @Test
    public void InCorrectValueValidation() {
        HomePage homePage = new HomePage(Driver);
        homePage.getSignIn().click();
        RegistrationAndSignIn Reg = new RegistrationAndSignIn(Driver);
        Reg.getCreateEmailAddress().sendKeys("Test25@gmail.com");
        Reg.getCreateEmailAddressButton().click();
        CreateAccountPage create = new CreateAccountPage(Driver);
        create.getFirstName().sendKeys("567890");
        create.getRegisterButton().click();
        List<WebElement> Errors = create.getErrorMessages();
        for (WebElement error : Errors) {
            if (error.getText().contains("firstname")) {
                Assert.assertEquals(error.getText(), "firstname is invalid.");
                break;
            }

        }
    }

    @Test
    public void InvalidSignIn(){
        HomePage homePage = new HomePage(Driver);
        homePage.getSignIn().click();
        RegistrationAndSignIn Reg = new RegistrationAndSignIn(Driver);
        Reg.getSignInButton().click();
        List<WebElement> Errors = Reg.getErrorMessages();
        for (WebElement error : Errors){
            if (error.getText().contains("required")) {
                Assert.assertEquals(error.getText(), "An email address required.");
                break;
            }
        }
    }

    @Test
    public void InvalidEmail(){
        HomePage homePage = new HomePage(Driver);
        homePage.getSignIn().click();
        RegistrationAndSignIn Reg = new RegistrationAndSignIn(Driver);
        Reg.getSignInEmail().sendKeys("Test");
        Reg.getSignInButton().click();
        List<WebElement> Errors = Reg.getErrorMessages();
        for (WebElement error : Errors){
            if (error.getText().contains("Invalid")) {
                Assert.assertEquals(error.getText(), "Invalid email address.");
                break;
            }
        }
    }

    @Test
    public void InvalidPassword(){
        HomePage homePage = new HomePage(Driver);
        homePage.getSignIn().click();
        RegistrationAndSignIn Reg = new RegistrationAndSignIn(Driver);
        Reg.getSignInEmail().sendKeys("Test123@gmail.com");
        Reg.getSignInPwd().sendKeys("test");
        Reg.getSignInButton().click();
        List<WebElement> Errors = Reg.getErrorMessages();
        for (WebElement error : Errors){
            if (error.getText().contains("Invalid")) {
                Assert.assertEquals(error.getText(), "Invalid password.");
                break;
            }
        }
    }

    @Test(groups = {"Regression"})
    public void SignIn(){
        HomePage homePage = new HomePage(Driver);
        homePage.getSignIn().click();
        RegistrationAndSignIn Reg = new RegistrationAndSignIn(Driver);
        Reg.getSignInEmail().sendKeys("Test9608@gmail.com");
        Reg.getSignInPwd().sendKeys("Test@123");
        Reg.getSignInButton().click();
        MyAccount myAccount = new MyAccount(Driver);
        Assert.assertEquals(myAccount.getAccountText(), "Welcome to your account. Here you can manage all of your personal information and orders.");
    }

    @Test
    public void ForgotPassword(){
        HomePage homePage = new HomePage(Driver);
        homePage.getSignIn().click();
        RegistrationAndSignIn Reg = new RegistrationAndSignIn(Driver);
        Reg.getForgotPasswordLink().click();
        Assert.assertEquals(Reg.Driver.getTitle(),"Forgot your password - My Store");
    }

    @Test
    public void InvalidEmailForgotPassword(){
        HomePage homePage = new HomePage(Driver);
        homePage.getSignIn().click();
        RegistrationAndSignIn Reg = new RegistrationAndSignIn(Driver);
        Reg.getForgotPasswordLink().click();
        ForgotPassword FP = new ForgotPassword(Driver);
        FP.getEmailSubmit().click();
        List<WebElement> Error =  FP.getErrorMessages();
        for (WebElement error : Error){
            if (error.getText().contains("Invalid")) {
                Assert.assertEquals(error.getText(), "Invalid email address.");
                break;
            }
        }
        FP.getEmailBox().sendKeys("Test9608@gmail.com");
        FP.getEmailSubmit().click();
        Assert.assertEquals(FP.getConfirmation().getText(),"A confirmation email has been sent to your address: Test9608@gmail.com");
    }


    @AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        Driver.quit();
    }
}
