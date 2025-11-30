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
        loginPage.enterUserName(validUserName);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginButton();
        Assert.assertNotEquals(loginPageURL,homePageURL);
        loginPage.logoutSuccessfully();

    }
    @Test
    public void  unsuccessfulLogin() {
        LoginPage loginPage = new LoginPage(bot);
        loginPage.navigateToLoginPage();
        String actualHeaderText = loginPage.verifyLogo();
        Assert.assertEquals(actualHeaderText,expectedHeaderText);
        loginPage.enterUserName(invalidUserName);
        loginPage.enterPassword(invalidPassword);
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
        loginPage.clickOnLoginButton();
        String actualErrorMesssage = loginPage.ErrorMsgText();
        Assert.assertEquals(actualErrorMesssage,expectedLockedErrorMessage);
    }

}


