package POMpatternPages;

import engine.Bot;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Arrays;
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
    private final By cartBadge = By.id("shopping_cart_badge"); // Added for cart count

    // Product Name Locators (By.id) - List for dynamic access
    private final List<By> productNameLocators = Arrays.asList(
            By.id("item_4_title_link"), // 0: Sauce Labs Backpack
            By.id("item_0_title_link"), // 1: Sauce Labs Bike Light
            By.id("item_1_title_link"), // 2: Sauce Labs Bolt T-Shirt
            By.id("item_5_title_link"), // 3: Sauce Labs Fleece Jacket
            By.id("item_2_title_link"), // 4: Sauce Labs Onesie
            By.id("item_3_title_link")  // 5: Test.allTheThings() T-Shirt (Red)
     );

    // Add to Cart Button Locators (By.id) - List for dynamic access
    private final List<By> addToCartLocators = Arrays.asList(
            By.id("add-to-cart-sauce-labs-backpack"),       // 0
            By.id("add-to-cart-sauce-labs-bike-light"),     // 1
            By.id("add-to-cart-sauce-labs-bolt-t-shirt"),   // 2
            By.id("add-to-cart-sauce-labs-fleece-jacket"),  // 3
            By.id("add-to-cart-sauce-labs-onesie"),         // 4
            By.id("add-to-cart-test.allthethings()-t-shirt-(red)") // 5
    );

    // Remove from Cart Button Locators (for after adding) - List for dynamic access
    private final List<By> removeFromCartLocators = Arrays.asList(
            By.id("remove-sauce-labs-backpack"),       // 0
            By.id("remove-sauce-labs-bike-light"),     // 1
            By.id("remove-sauce-labs-bolt-t-shirt"),   // 2
            By.id("remove-sauce-labs-fleece-jacket"),  // 3
            By.id("remove-sauce-labs-onesie"),         // 4
            By.id("remove-test.allthethings()-t-shirt-(red)") // 5
    );

    private final By productPriceLocator = By.className("inventory_item_price"); // General locator for prices

    // Sort Options
    private final By sortOptionAZ = By.xpath("//option[@value='a to z']");
    private final By sortOptionZA = By.xpath("//option[@value='z to a']");
    private final By sortOptionLowHigh = By.xpath("//option[@value='lo to high']");
    private final By sortOptionHighLow = By.xpath("//option[@value='high to low']");

    // Constructor
    public InventoryPage(Bot bot) {
        this.bot = bot;
    }

    // Filter Values (Constants)
    public static final String NAME_A_TO_Z = "a to z";
    public static final String NAME_Z_TO_A = "z to a";
    public static final String PRICE_LOW_TO_HIGH = "low to high";
    public static final String PRICE_HIGH_TO_LOW = "high to low";

    // Check if Inventory Page is Loaded
    public boolean isInventoryPageVisible() {
        return bot.checkVisibility(inventoryContainer);
    }

    // Get Page Title (using driver.getTitle() instead of locator)
    public boolean verifyInventoryPageTitle() {
        return bot.driver.getTitle().contains(expectedInventoryPageTitle);
    }

    // Get Product Name by Index
    public static String getProductName(int i) {
        List<String> productNames = Arrays.asList(
                "Sauce Labs Backpack",
                "Sauce Labs Bike Light",
                "Sauce Labs Bolt T-Shirt",
                "Sauce Labs Fleece Jacket",
                "Sauce Labs Onesie",
                "Test.allTheThings() T-Shirt (Red)"
        );
        if (i >= 0 && i < productNames.size()) {
            return productNames.get(i);
        }
        throw new IndexOutOfBoundsException("Invalid product index: " + i);
    }

    // Add Product to Cart by Index
    public void addProductToCartByIndex(int i) {
        if (i >= 0 && i < addToCartLocators.size()) {
            bot.click(addToCartLocators.get(i));
        } else {
            throw new IndexOutOfBoundsException("Invalid product index: " + i);
        }
    }

    // Add Backpack to Cart (specific method)
    public void addBackpackToCart() {
        addProductToCartByIndex(0);
    }

    // Remove Product from Cart by Index
    public void removeProductFromCartByIndex(int i) {
        if (i >= 0 && i < removeFromCartLocators.size()) {
            bot.click(removeFromCartLocators.get(i));
        } else {
            throw new IndexOutOfBoundsException("Invalid product index: " + i);
        }
    }

    // Get Cart Badge Count
    public String getCartBadgeCount() {
        if (bot.checkVisibility(cartBadge)) {
            return bot.getText(cartBadge);
        }
        return "0"; // If no badge, assume 0
    }

    // Open Cart Page
    public void openCart() {
        bot.click(cartIcon);
    }

    // Sort Items
    public void sortItems(String sortOption) {
        bot.click(sortDropdown);
        switch (sortOption) {
            case NAME_A_TO_Z:
                bot.click(sortOptionAZ);
                break;
            case NAME_Z_TO_A:
                bot.click(sortOptionZA);
                break;
            case PRICE_LOW_TO_HIGH:
                bot.click(sortOptionLowHigh);
                break;
            case PRICE_HIGH_TO_LOW:
                bot.click(sortOptionHighLow);
                break;
            default:
                throw new IllegalArgumentException("Invalid sort option: " + sortOption);
        }
    }

    // Get First Product Name (for sorting verification)
    public String getFirstProductName() {
        return bot.getText(productNameLocators.getFirst());
    }

    // Get First Product Price (for sorting verification)
    public String getFirstProductPrice() {
        return bot.getText(productPriceLocator); // Assumes first item
    }

    // Get Number of Items
    public int getNumberOfItems() {
        return bot.driver.findElements(By.className("inventory_item")).size();
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
