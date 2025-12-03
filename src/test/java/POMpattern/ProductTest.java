package POMpattern;

import POMpatternPages.InventoryPage;
import POMpatternPages.ProductPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest extends TestBaseAbstract {
    private InventoryPage inventoryPage;
    private ProductPage productPage;

    // Basic login method
    private void login() {
        bot.navigateTo("https://www.saucedemo.com/");
        bot.type(By.id("user-name"), "standard_user");
        bot.type(By.id("password"), "secret_sauce");
        bot.click(By.id("login-button"));
    }

//    @Test
//    public void testProductPageLoads() {
//        login();
//        inventoryPage = new InventoryPage(bot);
//        // Click on a product name to navigate to Product Page (e.g., Backpack)
//        bot.click(By.id("item_4_title_link")); // Locator for Backpack name
//        productPage = new ProductPage(bot);
//        Assert.assertTrue(productPage.isProductPageVisible(), "Product page should be displayed");
//        Assert.assertEquals(productPage.getProductName(), "Sauce Labs Backpack", "Product name should match");
//    }

    @Test
    public void testAddProductToCartFromProductPage() {
        login();
        inventoryPage = new InventoryPage(bot);
        bot.click(By.id("item_4_title_link")); // Navigate to Backpack
        productPage = new ProductPage(bot);
        productPage.addToCart();
        Assert.assertEquals(productPage.getCartBadgeCount(), "1", "Cart should have 1 item");
    }

//    @Test
//    public void testRemoveProductFromCartFromProductPage() {
//        login();
//        inventoryPage = new InventoryPage(bot);
//        bot.click(By.id("item_4_title_link")); // Navigate to Backpack
//        productPage = new ProductPage(bot);
//        productPage.addToCart();
//        Assert.assertEquals(productPage.getCartBadgeCount(), "1", "Cart should have 1 item");
//        productPage.removeFromCart();
//        Assert.assertEquals(productPage.getCartBadgeCount(), "0", "Cart should be empty");
//    }

    @Test
    public void testBackToProducts() {
        login();
        inventoryPage = new InventoryPage(bot);
        bot.click(By.id("item_4_title_link")); // Navigate to Backpack
        productPage = new ProductPage(bot);
        productPage.backToProducts();
        Assert.assertTrue(inventoryPage.isInventoryPageVisible(), "Should return to Inventory page");
    }
}

//    @Test
//    public void testProductDetails() {
//        login();
//        inventoryPage = new InventoryPage(bot);
//        bot.click(By.id("item_4_title_link")); // Navigate to Backpack
//        productPage = new ProductPage(bot);
//        Assert.assertNotNull(productPage.getProductName(), "Product name should be present");
//        Assert.assertNotNull(productPage.getProductPrice(), "Product price should be present");
//        Assert.assertNotNull(productPage.getProductDescription(), "Product description should be present");
//    }
//}
