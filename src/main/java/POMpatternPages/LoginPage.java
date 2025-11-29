package POMpatternPages;

import engine.Bot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    //  Locators
    By usernameFieldLocator = By.xpath("//input[@id='user-name']");
    By passwordFieldLocator = By.xpath("//input[@id='password']");
    By loginButtonLocator = By.xpath("//input[@id='login-button']");
    By errorMessageLocator = By.xpath("//h3[@data-test='error']");
    // Variables
    String loginPageURL = "https://www.saucedemo.com/";
    String validUserName = "standard_user";
    String validPassword = "secret_sauce";
    String invalidUserName = "Test_Name";
    String invalidPassword = "Test_Password";

    // bot instance
    Bot loginbot;

    public LoginPage(Bot bot) {
        this.loginbot = bot;
    }

    // Constructor method
    public LoginPage(WebDriver driver) {

    }

    public void navigateToLoginPage() {
        loginbot.navigateTo(loginPageURL);
    }

    public void enterValidUserName() {
        loginbot.type(usernameFieldLocator, validUserName);
    }

    public void enterValidPassword() {
        loginbot.type(passwordFieldLocator, validPassword);

    }

    public void enterInvalidUserName() {
        loginbot.type(usernameFieldLocator, invalidUserName);
    }

    public void enterInvalidPassword() {
        loginbot.type(passwordFieldLocator, invalidPassword);
    }

    public void clickOnLoginButton() {
        loginbot.click(loginButtonLocator);
    }

    public String currentURL() {
        return loginbot.currentURL();
    }

    public String ErrorMsgText() {

        return loginbot.getText(errorMessageLocator);
    }
    // New method to perform login with given credentials
    public void login(String validUserName, String validPassword) {
        loginbot.type(usernameFieldLocator, validUserName);
        loginbot.type(passwordFieldLocator, validPassword);
        loginbot.click(loginButtonLocator);
    }
    public void navigateToLoginWithValidCredentials() {
        login("standard_user", "secret_sauce");
    }
}
