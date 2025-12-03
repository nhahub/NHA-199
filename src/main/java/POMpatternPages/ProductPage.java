package POMpatternPages;

import engine.Bot;
import org.openqa.selenium.By;

public class ProductPage {
    private Bot bot;

    // Locators
    private final By productName = By.xpath("//div[@class='inventory_details_name']");
    private final By productPrice = By.xpath("//div[@class='inventory_details_price']");
    private final By productDescription = By.xpath("//div[@class='inventory_details_desc']");
    private final By addToCartButton = By.xpath("//button[text()='Add to cart']");
    private final By removeFromCartButton = By.xpath("//button[text()='Remove']");
    private final By backToProductsButton = By.id("back-to-products");
    private final By cartBadge = By.xpath("//span[@class='shopping_cart_badge']");

    // Constructor
    public ProductPage(Bot bot) {
        this.bot = bot;
    }

    // Check if Product Page is loaded
    public boolean isProductPageVisible() {
        return bot.checkVisibility(productName);
    }

    // Get Product Name
    public String getProductName() {
        return bot.getText(productName);
    }

    // Get Product Price
    public String getProductPrice() {
        return bot.getText(productPrice);
    }

    // Get Product Description
    public String getProductDescription() {
        return bot.getText(productDescription);
    }

    // Add Product to Cart
    public void addToCart() {
        bot.click(addToCartButton);
    }

    // Remove Product from Cart
    public void removeFromCart() {
        bot.click(removeFromCartButton);
    }

    // Get Cart Badge Count
    public String getCartBadgeCount() {
        if (bot.checkVisibility(cartBadge)) {
            return bot.getText(cartBadge);
        }
        return "0";
    }

    // Go Back to Products (Inventory Page)
    public void backToProducts() {
        bot.click(backToProductsButton);
    }
}
