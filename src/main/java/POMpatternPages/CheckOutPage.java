package POMpatternPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

public class CheckOutPage {
    //  Locators
    By firstItemLocator = By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]']");
    By cartButtonLocator = By.xpath("//*[@id=\"shopping_cart_container\"]/a']");
    By checkoutButtonLocator = By.xpath("//*[@id=\"checkout\"]");
    By firstnameFieldLocator = By.xpath("//*[@id=\"first-name\"]");
    By lastnameFieldLocator = By.xpath("//*[@id=\"last-name\"]]");
    By zipCodeFieldLocator = By.xpath("//*[@id=\"postal-code\"]");
    By submitButtonLocator = By.xpath("//*[@id=\"continue\"]");


    // Variables
    String loginPageURL = "https://www.saucedemo.com/";
    String firstname = "Ahmed";
    String lastName = "Abu-Madawy";
    int zipCode = 4331;
}

