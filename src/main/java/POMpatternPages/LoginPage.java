package POMpatternPages;
import engine.Bot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    //Locators and variable

    By usernameFieldLocator = By.xpath("//input[@placeholder='Username']");
     By passwordFieldLocator = By.xpath("//input[@placeholder='Password']");
      By loginButtonLocator =By.xpath("//input[@type='submit']");
       By logoText = By.xpath("//div[@class='login_logo']");
        By errorMessageLocator = By.xpath("//h3[@data-test='error']");
         By menuLocator = By.xpath("//button[@id='react-burger-menu-btn']");
          By logoutLocator = By.xpath("//a[@id='logout_sidebar_link']");
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
    //constructor
    public void LoginPage(WebDriver driver){
    }

    //Method to interact with the page
    public void navigateToLoginPage(){
        loginBot.navigateTo(loginPageURL);
    }
    public void enterUserName(String username){
        loginBot.type(usernameFieldLocator,username);
    }

    public void enterPassword(String password){
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

    public void login(String validUserName, String validPassword) {
        loginBot.type(usernameFieldLocator, validUserName);
        loginBot.type(passwordFieldLocator, validPassword);
        loginBot.click(loginButtonLocator);
    }
    public void navigateToLoginWithValidCredentials() {
        login("standard_user", "secret_sauce");
    }


}







