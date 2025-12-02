package POMpattern;

import POMpatternPages.CartPage;
import POMpatternPages.CheckOutPage;
import POMpatternPages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckOutTests extends TestBaseAbstract  {
//TODO: ADD logging for each step and complete the rest of the checkout tests
    @Test
    public void completeCheckoutFlow(){
        LoginPage login = new LoginPage(bot);
        CartPage cart = new CartPage(bot);
        CheckOutPage checkout = new CheckOutPage(bot);
        login.navigateToandLoginWithValidCredentials();
        cart.addSauceLabsBackpackToCart();
        cart.clickOnCartIcon();
        cart.clickCheckoutButton();
        checkout.enterFirstName("Ahmed");
        checkout.enterLastName("Abu-Madawy");
        checkout.enterZip(12345);
        checkout.clickContinue();
        checkout.clickFinish();
        Assert.assertTrue(checkout.isSuccessMessageDisplayed(), "Success message text did not match");
    }

    @Test
    public void checkoutValidationMissingFirstName(){
        LoginPage login = new LoginPage(bot);
        CartPage cart = new CartPage(bot);
        CheckOutPage checkout = new CheckOutPage(bot);

        login.navigateToandLoginWithValidCredentials();
        cart.addSauceLabsBackpackToCart();
        cart.clickOnCartIcon();
        cart.clickCheckoutButton();

        // Leave first name empty
        checkout.enterLastName("Abu-Madawy");
        checkout.enterZip(12345);
        checkout.clickContinue();

        Assert.assertTrue(checkout.isErrorMessageDisplayed(), "Expected error message for missing first name was not displayed");
    }

    @Test
    public void cancelCheckoutReturnsToCart(){
        LoginPage login = new LoginPage(bot);
        CartPage cart = new CartPage(bot);
        CheckOutPage checkout = new CheckOutPage(bot);

        login.navigateToandLoginWithValidCredentials();
        cart.addSauceLabsBackpackToCart();
        cart.clickOnCartIcon();
        cart.clickCheckoutButton();

        // Click cancel and verify we are back on cart page
        checkout.clickCancel();
        Assert.assertTrue(cart.checkCartPAgeLanding(), "User was not redirected back to the cart page after cancelling checkout");
    }
}
