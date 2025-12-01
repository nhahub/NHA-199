package POMpatternPages;

import engine.Bot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class InventoryPage {
    Bot bot;
    WebDriverWait wait;

    // Expected Data
    private static final String expectedInventoryPageTitle = "Products";

    // Locators
    private final By inventoryContainer = By.xpath("//div[@class='inventory_container']");
    private final By sortDropdown = By.xpath("//select[@class='product_sort_container']");
    private final By cartIcon = By.id("shopping_cart_container");
    private final By menuButton = By.xpath("//button[@id='react-burger-menu-btn']");
    private final By logoutButton = By.xpath("//a[@id='logout_sidebar_link']");
    private final By inventoryPageTitleLocator = By.xpath("title");

    // Product Name Locators (By.id)
    private final By backpackName = By.id("item_4_title_link");
    private final By bikeLightName = By.id("item_0_title_link");
    private final By boltTshirtName = By.id("item_1_title_link");
    private final By fleeceJacketName = By.id("item_5_title_link");
    private final By onesieName = By.id("item_2_title_link");
    private final By redTshirtName = By.id("item_3_title_link");

    // Add to Cart Button Locators (By.id)
    private final By addBackpack = By.id("add-to-cart-sauce-labs-backpack");
    private final By addBikeLight = By.id("add-to-cart-sauce-labs-bike-light");
    private final By addBoltTshirt = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private final By addFleeceJacket = By.id("add-to-cart-sauce-labs-fleece-jacket");
    private final By addOnesie = By.id("add-to-cart-sauce-labs-onesie");
    private final By addRedTshirt = By.id("add-to-cart-test.allthethings()-t-shirt-(red)");

    private final By ProductPriceLocator = By.className("inventory_item_price");
    private final By addToCartButtonLocator = By.id("add-to-cart-sauce-labs-backpack");


    //  Constructor

    public InventoryPage(Bot bot) {
        this.bot = bot;
    }

    // Filter Values
    public static final String NAME_A_TO_Z = "a to z";
    public static final String NAME_Z_TO_A = "z to a";
    public static final String PRICE_LOW_TO_HIGH = "low to high";
    public static final String PRICE_HIGH_TO_LOW = "high to low";


    // Check Inventory Page Loaded
    public boolean isInventoryPageVisible() {
        return bot.checkVisibility(inventoryContainer);
    }

    // Get Page Title
    public boolean verifyInventoryPageTitle() {
        return bot.getText(inventoryPageTitleLocator)
                .contains(expectedInventoryPageTitle);
    }


    // Open Cart Page
    public void openCart() {
        bot.click(cartIcon);
    }

    // Logout
    public void clickMenuButton() {
        bot.click(menuButton);
    }

    public void clickLogoutButton() {
        bot.click(logoutButton);
    }

    public void logout() {
        clickMenuButton();
        clickLogoutButton();
    }

}
