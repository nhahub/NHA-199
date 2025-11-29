package POMpatternPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

public class CheckOutPage {
    // Locators and variables
    String url = "https://www.selenium.dev/selenium/web/dynamic.html";
    By revealInputButtonLocator = By.id("reveal");
    By revealedInputLocator = By.id("revealed");
    WebDriver driver;
    Wait<WebDriver> wait;
    String Username = "admin";
    String Password = "password";
}
