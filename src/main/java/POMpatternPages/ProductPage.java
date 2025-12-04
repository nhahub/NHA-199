package POMpatternPages;

import engine.Bot;
import org.openqa.selenium.By;

public class ProductPage {
    Bot productBot;

    //Backpack item Locators
    By backPackTitleLocator = By.xpath("//a[@id='item_4_title_link']");
    By backPackNameLocator = By.xpath("//div[@class='inventory_details_name large_size']");
    By backPackImageLocator = By.xpath("//img[@class='inventory_details_img']");
    By backPackDesLocator = By.xpath("//div[@class='inventory_details_desc large_size']");
    By backPackPriceLocator = By.xpath("//div[@class='inventory_details_price']");
    By backPackAddtoCartButtonLocator = By.xpath("//button[@id='add-to-cart']");
    //Bike light item Locators
    By bikeLightItemLocator = By.xpath("//a[@id='item_0_title_link']");
    By bikeLightAddtoCartLocator = By.xpath("//button[@id='add-to-cart']");
    By bikeLightRemoveButtonLocator = By.xpath("//button[@id='remove']");
    By cartPageLocator = By.xpath("//span[@class='shopping_cart_badge']");
    By backtoProductsLocator = By.xpath("//button[@id='back-to-products']");
    By inventoryPageTitle = By.xpath("//span[@class='title']");
    By bikeLightPageTitle = By.xpath("//div[@class='inventory_details_name large_size']");

    // Constructor
    public ProductPage(Bot bot) {

        productBot = bot;
    }

    public void clickonBackpackProductTitle() {
        productBot.click(backPackTitleLocator);
    }

    public boolean verifyUserRedirecttoBackPackProductPage() {
        return productBot.getText(backPackNameLocator).contains("Backpack");
    }

    public boolean verifyBackpackProductImageDisplayed() {

        return productBot.checkVisibility(backPackImageLocator);
    }

    public boolean verifyProductName() {

        return productBot.getText(backPackNameLocator).contains("Labs Backpack");
    }

    public boolean verifyBackpackDescDisplayed() {

        return productBot.checkVisibility(backPackDesLocator);
    }

    public boolean verifyBackpackPriceDisplayed() {

        return productBot.checkVisibility(backPackPriceLocator);
    }

    public boolean verifyAddtoCartButtonDisplayed() {

        return productBot.checkVisibility(backPackAddtoCartButtonLocator);
    }

    public void navigatetoBikeLightProductPage() {
        productBot.click(bikeLightItemLocator);
    }

    public void clickonBikeLightAddtoCartButton() {
        productBot.click(bikeLightAddtoCartLocator);
    }

    public boolean verifyButtonTextChangestoRemove() {
        return productBot.getText(bikeLightRemoveButtonLocator).contains("Remove");
    }

    public boolean verifyCartBadgeDisplays1() {
        return productBot.getText(cartPageLocator).contains("1");
    }

    public void clickBacktoProductsButton() {
        productBot.click(backtoProductsLocator);
    }

    public boolean verifyUserReturnstoInventoryPage() {
        return productBot.getText(inventoryPageTitle).contains("Products");
    }

    public boolean verifyBikeLightpageisdisplayed() {
        return productBot.getText(bikeLightPageTitle).contains("Bike Light");
    }
}
// fix