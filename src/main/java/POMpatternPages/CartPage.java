package POMpatternPages;

import engine.Bot;
import org.openqa.selenium.By;

public class CartPage {
    // variables initialization

    String URL = "https://www.saucedemo.com/";
    String userName = "standard_user";
    String password = "secret_sauce";
    String expectedTitle = "Your Cart";
    String expectedNumofItems = "2";
    String expectedBackPackTitle = "Sauce Labs Backpack";
    String expectedBackPackDesc = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";
    String expectedBackPackPrice = "$29.99";
    String expectedBikeLighTitle = "Sauce Labs Bike Light";
    String expectedBikeLighDesc = "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.";
    String expectedBikeLighPrice = "$9.99";
    String expectedInventoryPageTitle ="Products";
    String expectedNumofProduct1 = "1";

    //Locators
    //Login Locators
    By userNameLocator = By.id("user-name");
    By passwordLocator = By.id("password");
    By loginButtonLocator = By.id("login-button");

    //Backpack item locator
    By sauceLabsBackpackLocator = By.id("add-to-cart-sauce-labs-backpack");
    By backPackTitleLocator = By.xpath("//a[@id='item_4_title_link']//div[@class='inventory_item_name']");
    By backPackDescLocator = By.xpath("(//div[@class='inventory_item_desc'])[1]");
    By backPackPriceLocator = By.xpath("(//div[@class='inventory_item_price'])[1]");

    //BikeLightLocator
    By sauceLabsBikeLightLocator = By.id("add-to-cart-sauce-labs-bike-light");
    By bikeLightTitleLocator = By.xpath("(//div[@class='inventory_item_name'])[2]");
    By bikeLightDescLocator = By.xpath("(//div[@class='inventory_item_desc'])[2]");
    By bikeLightPriceLocator = By.xpath("(//div[@class='inventory_item_price'])[2]");

    // rest of locators
    By cartIconLocator = By.xpath("//a[@class='shopping_cart_link']");
    By cartPageTitleLocator = By.xpath("//span[@class='title']");
    By numofItemsonCartLocator = By.xpath("//span[@class='shopping_cart_badge']");
    By continueShoppingLocator = By.id("continue-shopping");
    By checkoutLocator = By.id("checkout");
    By sauceLabsBoltTshirt = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    By emptyCartIcontLocator = By.xpath("//a[@class='shopping_cart_link']");
    By removeButtonLocator = By.id("remove-sauce-labs-bolt-t-shirt");
    By titleofBoltTshirtLocator = By.xpath("//div[@class='inventory_item_name']");
    By removedCartItem = By.xpath("//div[@class='removed_cart_item']");
    By inventoryPageTitle = By.xpath("//span[@class='title']");

    Bot cartBot;

    public CartPage(Bot bot){
        cartBot = bot;
    }
    public void navigateToLoginPage(){
        cartBot.navigateTo(URL);
    }
    public void enterUserNAme(){
        cartBot.type(userNameLocator,userName);
    }
    public void enterPassword(){
        cartBot.type(passwordLocator,password);
    }
    public void clickLoginButton(){
        cartBot.click(loginButtonLocator);
    }
    public void addSauceLabsBackpackToCart(){
        cartBot.click(sauceLabsBackpackLocator);
    }
    public void addSauceLabsBikeLightToCart(){
        cartBot.click(sauceLabsBikeLightLocator);
    }
    public void clickOnCartIcon(){
        cartBot.click(cartIconLocator);
    }
    public boolean checkCartPAgeLanding(){
        return cartBot.displayedText(cartPageTitleLocator).contains(expectedTitle);
    }
    public boolean checkThatTwoElementsInCart(){
        return cartBot.displayedText(numofItemsonCartLocator).contains(expectedNumofItems);
    }
    public boolean checkBackpackTitle(){
        // verify the backpack title text matches expected value
        return cartBot.displayedText(backPackTitleLocator).contains(expectedBackPackTitle);
    }
    public boolean checkBackpackDesc(){
        return cartBot.displayedText(backPackDescLocator).contains(expectedBackPackDesc);
    }
    public boolean checkBackpackPrice(){
        return cartBot.displayedText(backPackPriceLocator).contains(expectedBackPackPrice);
    }

    public boolean checkBikeLightTitle(){
        // verify the bike light title text matches expected value
        return cartBot.displayedText(bikeLightTitleLocator).contains(expectedBikeLighTitle);
    }
    public boolean checkBikeLightDesc(){
        return cartBot.displayedText(bikeLightDescLocator).contains(expectedBikeLighDesc);
    }
    public boolean checkBikeLightPrice(){
        return cartBot.displayedText(bikeLightPriceLocator).contains(expectedBikeLighPrice);
    }
    public boolean checkoutButtonVisibility(){
        return cartBot.checkVisibility(checkoutLocator);
    }
    public boolean continueShoppingVisibility(){
        return cartBot.checkVisibility(continueShoppingLocator);
    }


}
