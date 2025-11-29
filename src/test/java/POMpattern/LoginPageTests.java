package POMpattern;

import POMpatternPages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTests extends TestBaseAbstract {

    @Test
    public void successfulLogin()
    {

        //LoginPage loginPage=new LoginPage(driver,wait,options);
        LoginPage loginPage=new LoginPage(bot);
        loginPage.navigateToLoginPage();
        loginPage.enterValidUserName();
        loginPage.enterValidPassword();
        loginPage.clickOnLoginButton();
        String productListingPageURL="https://www.saucedemo.com/inventory.html";
       // String currentURL=loginPage.currentURL();

       // Assert.assertEquals(currentURL,productListingPageURL);
    }



    @Test
    public void unsuccessfulLogin_BothFieldsEmpty()
    {
        LoginPage loginPage=new LoginPage(bot);
        loginPage.navigateToLoginPage();
        loginPage.clickOnLoginButton();
        String actual= loginPage.ErrorMsgText();
        Assert.assertTrue(actual.contains("Username is required"));


    }

    @Test
    public void unsuccessfulLogin_OnlyPasswordFieldEmpty()
    {
        LoginPage loginPage=new LoginPage(bot);
        loginPage.navigateToLoginPage();
        loginPage.enterInvalidUserName();
        loginPage.clickOnLoginButton();

        Assert.assertTrue(loginPage.ErrorMsgText().contains("Password is required"));


    }

    @Test
    public void unsuccessfulLogin_InvalidCredentials()
    {
        LoginPage loginPage=new LoginPage(bot);
        loginPage.navigateToLoginPage();
        loginPage.enterInvalidUserName();
        loginPage.enterInvalidPassword();
        loginPage.clickOnLoginButton();

        Assert.assertTrue(loginPage.ErrorMsgText().contains("do not match"));


    }

}
