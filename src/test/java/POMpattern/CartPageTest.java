package POMpattern;

import POMpatternPages.CartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartPageTest extends TestBaseAbstract{

    @Test
    public void viewCartWithAddedProducts(){
        CartPage cart = new CartPage(bot);
        cart.navigateToLoginPage();
        cart.enterUserNAme();
        cart.enterPassword();
        cart.clickLoginButton();
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
}
