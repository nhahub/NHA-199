package POMpattern;

import POMpatternPages.CartPage;
import POMpatternPages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartPageTest extends TestBaseAbstract{

    @Test
    public void viewCartWithAddedProducts(){
        CartPage cart = new CartPage(bot);
        LoginPage loginPage=new LoginPage(bot); // Instantiate LoginPage
        loginPage.navigateToLoginWithValidCredentials(); // Use method to login with valid credentials
        cart.addSauceLabsBackpackToCart();
        cart.addSauceLabsBikeLightToCart();
        cart.clickOnCartIcon();
        Assert.assertTrue(cart.checkCartPAgeLanding());
        Assert.assertTrue(cart.checkThatTwoElementsInCart());
        Assert.assertTrue(cart.checkBackpackTitle());
        Assert.assertTrue(cart.checkBackpackDesc());
        Assert.assertTrue(cart.checkBackpackPrice());
        Assert.assertTrue(cart.checkBikeLightTitle());
        Assert.assertTrue(cart.checkBikeLightDesc());
        Assert.assertTrue(cart.checkBikeLightPrice());
        Assert.assertTrue(cart.checkoutButtonVisibility());
        Assert.assertTrue(cart.continueShoppingVisibility());

    }
    @Test
    public void removeProductFromCart(){
        CartPage cart = new CartPage(bot);
        LoginPage loginPage=new LoginPage(bot); // Instantiate LoginPage
        loginPage.navigateToLoginWithValidCredentials(); // Use method to login with valid cred
        cart.addSauceLabsBoltTShirtTocCart();
        cart.navigateToCartPage();
        cart.verifyBoltTShirtIsInCart();
        cart.clickRemoveButton();
        Assert.assertTrue(cart.verifyBoltTShirtRemovedandCartPadgeUpdate());

    }
}
