package POMpatternPages;

import engine.Bot;
import org.openqa.selenium.By;

public class CheckOutPage {
    //  Locators - corrected XPaths/locators
    By firstItemLocator = By.id("add-to-cart-sauce-labs-backpack");
    By cartButtonLocator = By.xpath("//a[@class='shopping_cart_link']");
    By checkoutButtonLocator = By.id("checkout");
    By firstnameFieldLocator = By.id("first-name");
    By lastnameFieldLocator = By.id("last-name");
    By zipCodeFieldLocator = By.id("postal-code");
    By submitButtonLocator = By.id("continue");
    By finishButtonLocator = By.id("finish");
    By successmessageLocator = By.xpath("//h2");

    Bot bot;

    public CheckOutPage(Bot bot) {
        this.bot = bot;
    }

    public void enterFirstName(String first){
        bot.type(firstnameFieldLocator, first);
    }

    public void enterLastName(String last){
        bot.type(lastnameFieldLocator, last);
    }

    public void enterZip(int zip){
        bot.type(zipCodeFieldLocator,  "zip");
    }

    public void clickContinue(){
        bot.click(submitButtonLocator);
    }

    public void clickFinish(){
        bot.click(finishButtonLocator);
    }

    public boolean isSuccessMessageDisplayed(){
        return bot.getText(successmessageLocator).contains("Thank you for your order!");
    }
}
