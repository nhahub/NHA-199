package POMpattern;

import POMpatternPages.CartPage;
import POMpatternPages.InventoryPage;
import engine.Bot;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class InventoryPageTest {

    private Bot bot;
    private InventoryPage inventoryPage;
    private CartPage cartPage;
    private final String expectedNumofItems = "1";
    @BeforeClass
    public void setUp() {
        bot = new Bot();
        inventoryPage = new InventoryPage(bot);
        cartPage = new CartPage(bot);

        bot.navigateTo("https://www.saucedemo.com/");
        bot.type(By.id("user-name"), "standard_user");
        bot.type(By.id("password"), "secret_sauce");
        bot.click(By.id("login-button"));
    }

    @Test
    public void testInventoryPageVisible() {
        assertTrue(inventoryPage.isInventoryPageVisible(), "Inventory Page is not visible");
    }



    @Test
    public void testLogout() {
        inventoryPage.logout();
        assertTrue(bot.checkVisibility(By.id("login-button")), "Logout failed");
    }

    @AfterClass
    public void tearDown() {
        bot.quit();
    }
}

