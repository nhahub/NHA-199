package POMpattern;

import POMpatternPages.InventoryPage;
import POMpatternPages.LoginPage;
import POMpatternPages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest extends TestBaseAbstract {

    @Test
    public void viewProductDetails() {
        ProductPage productPage = new ProductPage(bot);
        LoginPage loginPage = new LoginPage(bot);
        loginPage.navigateToandLoginWithValidCredentials();
        productPage.clickonBackpackProductTitle();
        Assert.assertTrue(productPage.verifyUserRedirecttoBackPackProductPage());
        Assert.assertTrue(productPage.verifyBackpackProductImageDisplayed());
        Assert.assertTrue(productPage.verifyProductName());
        Assert.assertTrue(productPage.verifyBackpackDescDisplayed());
        Assert.assertTrue(productPage.verifyBackpackPriceDisplayed());
        Assert.assertTrue(productPage.verifyAddtoCartButtonDisplayed());
    }

    @Test
    public void addProducttoCartfromDetailsPage() {
        ProductPage productPage = new ProductPage(bot);
        LoginPage loginPage = new LoginPage(bot);
        loginPage.navigateToandLoginWithValidCredentials();
        productPage.navigatetoBikeLightProductPage();
        productPage.clickonBikeLightAddtoCartButton();
        Assert.assertTrue(productPage.verifyButtonTextChangestoRemove());
        Assert.assertTrue(productPage.verifyCartBadgeDisplays1());
        productPage.clickBacktoProductsButton();
        Assert.assertTrue(productPage.verifyUserReturnstoInventoryPage());
    }

    @Test
    public void navigateBacktoInventoryfromProductPage() {
        ProductPage productPage = new ProductPage(bot);
        LoginPage loginPage = new LoginPage(bot);
        InventoryPage inventoryPage = new InventoryPage(bot);
        loginPage.navigateToandLoginWithValidCredentials();
        productPage.navigatetoBikeLightProductPage();
        productPage.verifyBikeLightpageisdisplayed();
        productPage.clickBacktoProductsButton();
        Assert.assertEquals(inventoryPage.countTotalNumberOfProductsDisplayed(), 6);


    }
}
