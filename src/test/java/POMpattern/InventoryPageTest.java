package POMpattern;

import POMpatternPages.CartPage;
import POMpatternPages.InventoryPage;
import POMpatternPages.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InventoryPageTest extends TestBaseAbstract {
    private InventoryPage inventoryPage;

    private void login() {
        bot.navigateTo("https://www.saucedemo.com/");
        bot.type(By.id("user-name"), "standard_user");
        bot.type(By.id("password"), "secret_sauce");
        bot.click(By.id("login-button"));
    }


    @Test

    public void VerifyAllProductsAreDisplayed() {
        InventoryPage inventoryPage = new InventoryPage(bot);
        LoginPage loginPage = new LoginPage(bot); // Instantiate LoginPage
        loginPage.navigateToandLoginWithValidCredentials();
        Assert.assertTrue(inventoryPage.verifyInventoryPageIsLoaded());
        Assert.assertEquals(inventoryPage.countTotalNumberOfProductsDisplayed(), 6);
        //Verify each product has: image, title, description, price, "Add to cart" button

    }

    @Test
    public void sortProductsbyPriceLowToHigh() {
        InventoryPage inventoryPage = new InventoryPage(bot);
        LoginPage loginPage = new LoginPage(bot);
        loginPage.navigateToandLoginWithValidCredentials();
        inventoryPage.clickonSortDropdownList();
        inventoryPage.selectPriceLowtoHigh();

        Assert.assertTrue(inventoryPage.verifyProductsareSortedinAscendingOrderbyPrice());
        Assert.assertTrue(inventoryPage.verifyFirstProducthasLowestPrice());
        Assert.assertTrue(inventoryPage.verifyLastProducthashighestPrice());
    }

    @Test
    public void addProducttoCartfromInventory() {
        InventoryPage inventoryPage = new InventoryPage(bot);
        LoginPage loginPage = new LoginPage(bot);
        CartPage cartPage = new CartPage(bot);
        loginPage.navigateToandLoginWithValidCredentials();
        cartPage.addSauceLabsBackpackToCart();
        Assert.assertTrue(inventoryPage.verifyButtonTextChangestoRemove());
        Assert.assertTrue(cartPage.VerifyCartBadgeStillShowsAddedProductCount());
        inventoryPage.clickRemoveButton();
        Assert.assertTrue(inventoryPage.verifiyProductRemovedAfterClickRemoveButton());

    }
}