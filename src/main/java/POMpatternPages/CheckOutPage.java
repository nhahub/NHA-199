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

    // New locators for cancel and error handling / overview
    By cancelButtonLocator = By.xpath("//*[@id=\"cancel\"]");
    By errorMessageLocator = By.xpath("//*[@id=\"checkout_info_container\"]/div/form/div[1]/div[4]/h3");
    By overviewTitleLocator = By.xpath("//span[@class='title']");

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

    // Accepts int zip codes and sends the correct string representation
    public void enterZip(int zip){
        bot.type(zipCodeFieldLocator, String.valueOf(zip));
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

    // Click the cancel button on the checkout information page
    public void clickCancel(){
        bot.click(cancelButtonLocator);
    }

    // Return true if an error message about missing first name is shown
    public boolean isErrorMessageDisplayed(){
        return bot.getText(errorMessageLocator).contains("Error: First Name is required");
    }

    // Verify that the checkout overview page is displayed (title)
    public boolean isOnCheckoutOverview(){
        return bot.getText(overviewTitleLocator).contains("Checkout: Overview");
    }
}
