package POMpattern;
import POMpatternPages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static POMpatternPages.LoginPage.*;


public class LoginPageTests extends TestBaseAbstract{
    @Test
    public void successfulLogin(){
        LoginPage loginPage = new LoginPage(bot);
        loginPage.navigateToLoginPage();
        String actualHeaderText = loginPage.verifyLogo();
        Assert.assertEquals(actualHeaderText,expectedHeaderText);
        loginPage.checkPlaceholder(usernameFieldLocator,"placeholder");
        loginPage.checkPlaceholder(passwordFieldLocator,"placeholder");
        String actualPlaceholder = loginPage.getPlaceholder(usernameFieldLocator);
        Assert.assertEquals(actualPlaceholder,"Username");
        loginPage.enterUserName(validUserName);
        loginPage.enterPassword(validPassword);
        loginPage.getUserNameFieldText(usernameFieldLocator);
        loginPage.getPasswordFieldText(passwordFieldLocator);
        loginPage.clickOnLoginButton();
        Assert.assertNotEquals(loginPageURL,homePageURL);
    }
    @Test
    public void  unsuccessfulLogin() {
        LoginPage loginPage = new LoginPage(bot);
        loginPage.navigateToLoginPage();
        String actualHeaderText = loginPage.verifyLogo();
        Assert.assertEquals(actualHeaderText,expectedHeaderText);
        loginPage.enterUserName(invalidUserName);
        loginPage.enterPassword(invalidPassword);
        loginPage.getUserNameFieldText(usernameFieldLocator);
        loginPage.getPasswordFieldText(passwordFieldLocator);
        loginPage.clickOnLoginButton();
        String actualErrorMessage = loginPage.ErrorMsgText();
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);
    }
    @Test
    public void  loginWithLockedOutUser(){
        LoginPage loginPage = new LoginPage(bot);
        loginPage.navigateToLoginPage();
        String actualHeaderText = loginPage.verifyLogo();
        String expectedHeaderText = "Swag Labs";
        Assert.assertEquals(actualHeaderText,expectedHeaderText);
        loginPage.enterUserName(lockedUserName);
        loginPage.enterPassword(lockedPassword);
        loginPage.getUserNameFieldText(usernameFieldLocator);
        loginPage.getPasswordFieldText(passwordFieldLocator);
        loginPage.clickOnLoginButton();
        String actualErrorMesssage = loginPage.ErrorMsgText();
        Assert.assertEquals(actualErrorMesssage,expectedLockedErrorMessage);
    }
    @Test
    public void logoutRedirectsToLoginPageWithClearedFields (){
        LoginPage loginPage = new LoginPage(bot);
        loginPage.navigateToLoginPage();
        loginPage.enterUserName(validUserName);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginButton();
        loginPage.logoutSuccessfully();
        loginPage.getUserNameFieldText(usernameFieldLocator);
        loginPage.getPasswordFieldText(passwordFieldLocator);
        String CurrentUrl= loginPage.getCurrentUrl();
        // assertion
        Assert.assertEquals(CurrentUrl,"https://www.saucedemo.com/");

    }

}


