package POMpatternPages;
import engine.Bot;
import org.openqa.selenium.By;

public class LoginPage {
    //Locators and variable

    public static By usernameFieldLocator = By.xpath("//input[@placeholder='Username']");
    public static By passwordFieldLocator = By.xpath("//input[@placeholder='Password']");
    public static By loginButtonLocator =By.xpath("//input[@type='submit']");
    public static By logoText = By.xpath("//div[@class='login_logo']");
    public static By errorMessageLocator = By.xpath("//h3[@data-test='error']");
    public static By menuLocator = By.xpath("//button[@id='react-burger-menu-btn']");
    public static By logoutLocator = By.xpath("//a[@id='logout_sidebar_link']");
    public static String loginPageURL ="https://www.saucedemo.com/";
    public static String validUserName = "standard_user";
    public static String validPassword = "secret_sauce";
    public static String invalidUserName = "invalid_user" ;
    public static String invalidPassword = "wrong_password";
    public static String expectedHeaderText = "Swag Labs";
    public static String expectedErrorMessage ="Epic sadface: Username and password do not match any user in this service";
    public static String lockedUserName ="locked_out_user";
    public static String lockedPassword ="secret_sauce";
    public static String expectedLockedErrorMessage ="Epic sadface: Sorry, this user has been locked out.";
    public static String homePageURL ="https://www.saucedemo.com/inventory.html";


    Bot loginBot;
    public LoginPage(Bot bot){
       this.loginBot = bot;
    }

    //Method to interact with the page
    public void navigateToLoginPage(){
        loginBot.navigateTo(loginPageURL);
    }
    public void enterUserName(String username){
        loginBot.checkItemRemoved(usernameFieldLocator);
        loginBot.type(usernameFieldLocator,username);
    }

    public void enterPassword(String password){
        loginBot.checkItemRemoved(usernameFieldLocator);
        loginBot.type(passwordFieldLocator,password);
    }

    public void clickOnLoginButton(){
        loginBot.click(loginButtonLocator);
    }

    public String verifyLogo(){
        return loginBot.getText(logoText);
    }

    public String ErrorMsgText(){
        return loginBot.getText(errorMessageLocator);
    }
    public void logoutSuccessfully(){
        loginBot.click(menuLocator);
        loginBot.click(logoutLocator);
    }

    public LoginPage checkPlaceholder(By locator , String Username){
      String actualPlaceholder = loginBot.getAttribute(locator,"placeholder");
      System.out.println("Placeholder is"+" "+actualPlaceholder);
              return  this;
    }

    public String getCurrentUrl(){
        return loginBot.currentURL();
    }

    public String getPlaceholder(By locator){
        return  loginBot.getAttribute(locator,"placeholder");
    }

    public String getUserNameFieldText(By locator){
        String textField = loginBot.driver.findElement(usernameFieldLocator).getAttribute("Value");
        System.out.println("Username"+" "+ textField);
        return textField;
    }

    public String getPasswordFieldText(By locator){
        String textField = loginBot.driver.findElement(passwordFieldLocator).getAttribute("Value");
        System.out.println("Password"+" "+ textField);
        return textField;
    }

    // New method to perform login with given credentials
    public void login(String loginURL,String validUserName, String validPassword) {
        loginBot.navigateTo(loginURL);
        loginBot.type(usernameFieldLocator, validUserName);
        loginBot.type(passwordFieldLocator, validPassword);
        loginBot.click(loginButtonLocator);
    }
    public void navigateToandLoginWithValidCredentials() {
        login(loginPageURL,validUserName, validPassword);
    }
}
