package POMpattern;

import POMpatternPages.InventoryPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InventoryPageTest extends TestBaseAbstract {
    private InventoryPage inventoryPage;

    // Assuming you have a LoginPage; if not, add it or handle login here
    // For simplicity, I'll add a basic login method in the test
    private void login() {
        bot.navigateTo("https://www.saucedemo.com/");
        bot.type(By.id("user-name"), "standard_user");
        bot.type(By.id("password"), "secret_sauce");
        bot.click(By.id("login-button"));
    }

    @Test
    public void testInventoryPageLoads() {
        login();
        inventoryPage = new InventoryPage(bot);
        Assert.assertTrue(inventoryPage.isInventoryPageVisible(), "Inventory page should be visible");
        Assert.assertTrue(inventoryPage.getNumberOfProduct() > 0, "There should be items on the page");
    }

    @Test
    public void testAddItemToCart() {
        login();
        inventoryPage = new InventoryPage(bot);
        String itemName = "Sauce Labs Backpack"; // Example item
        inventoryPage.addItemToCart(itemName);
        Assert.assertEquals(inventoryPage.getCartBadgeCount(), "1", "Cart should have 1 item");
    }

    @Test
    public void testRemoveItemFromCart() {
        login();
        inventoryPage = new InventoryPage(bot);
        String itemName = "Sauce Labs Backpack";
        inventoryPage.addItemToCart(itemName);
        Assert.assertEquals(inventoryPage.getCartBadgeCount(), "1", "Cart should have 1 item");
        inventoryPage.removeItemFromCart(itemName);
        Assert.assertEquals(inventoryPage.getCartBadgeCount(), "0", "Cart should be empty");
    }

    @Test
    public void testSortItemsAZ() {
        login();
        inventoryPage = new InventoryPage(bot);
        inventoryPage.sortProducts("a to z");
        // Verify first item is alphabetically first (e.g., "Sauce Labs Backpack")
        Assert.assertTrue(inventoryPage.getFirstProductName().startsWith("Sauce"),
                "First item should be sorted A-Z");
    }

    @Test
    public void testSortProductsPriceLowToHigh() {
        login();
        inventoryPage = new InventoryPage(bot);
        inventoryPage.sortProducts("low to high");
        // Verify first item has the lowest price (e.g., "$7.99")
        Assert.assertTrue(inventoryPage.getFirstProductPrice().contains("$7.99"), "First product should have lowest price");
    }

    @Test
    public void testNavigateToCart() {
        login();
        inventoryPage = new InventoryPage(bot);
        inventoryPage.addItemToCart("Sauce Labs Backpack");
        inventoryPage.openCart();
        Assert.assertTrue(bot.currentURL().contains("cart.html"), "Should navigate to cart page");
    }
}

