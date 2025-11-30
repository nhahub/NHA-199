package POMpattern;

import POMpatternPages.CartPage;
import POMpatternPages.CheckOutPage;
import POMpatternPages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckOutTests extends TestBaseAbstract  {

    @Test
    public void completeCheckoutFlow(){
        LoginPage login = new LoginPage(bot);
        CartPage cart = new CartPage(bot);
        CheckOutPage checkout = new CheckOutPage(bot);
        login.navigateToandLoginWithValidCredentials();
        cart.addSauceLabsBackpackToCart();
        cart.clickOnCartIcon();
        cart.clickCheckoutButton();
        checkout.enterFirstName("John");
        checkout.enterLastName("Doe");
        checkout.enterZip(12345);
        checkout.clickContinue();
        checkout.clickFinish();
        Assert.assertTrue(checkout.isSuccessMessageDisplayed(), "Success message text did not match");
    }
}
