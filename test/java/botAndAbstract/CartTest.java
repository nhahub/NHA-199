package botAndAbstract;

import engine.Bot;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTest extends BaseAbstract {

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
    By backPackTitleLocator = By.xpath("(//div[@class='inventory_item_name'])[1]");
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

    // 1st Test Case View Cart with Added Products
//    @Test
//    public void testCartwithAddedProduct(){
    //Login with standarduser
//        bot.navigateTo(URL);
//        bot.type(userNameLocator,userName);
//        bot.type(passwordLocator,password);
//        bot.click(loginButtonLocator);
    //Add "Sauce Labs Backpack & Sauce Labs Bike Light"" to cart
//        bot.click(sauceLabsBackpackLocator);
//        bot.click(sauceLabsBikeLightLocator);
    //Click on cart icon
//        bot.click(cartIconLocator);
    //Verify cart page is displayed
//        String actualCartTitle = bot.getText(cartPageTitleLocator);
//        Assert.assertEquals(actualCartTitle,expectedTitle);
    //Verify 2 products are shown in cart
//        String actualNuminCart = bot.getText(numofItemsonCartLocator);
//        Assert.assertEquals(actualNuminCart,expectedNumofItems);
    //Verify product names, descriptions, and prices are correct
//        String actualbackPackTitle = bot.getText(backPackTitleLocator);
//        Assert.assertEquals(actualbackPackTitle,expectedBackPackTitle);
//        String actualBackPackDesc = bot.getText(backPackDescLocator);
//        Assert.assertEquals(actualBackPackDesc,expectedBackPackDesc);
//        String actualbackPackPrice = bot.getText(backPackPriceLocator);
//        Assert.assertEquals(actualbackPackPrice,expectedBackPackPrice);
//        String actualBikeLighTitle = bot.getText(bikeLightTitleLocator);
//        Assert.assertEquals(actualBikeLighTitle,expectedBikeLighTitle);
//        String actualBikeLighDesc = bot.getText(bikeLightDescLocator);
//        Assert.assertEquals(actualBikeLighDesc,expectedBikeLighDesc);
//        String actualBikeLighPrice = bot.getText(bikeLightPriceLocator);
//        Assert.assertEquals(actualBikeLighPrice,expectedBikeLighPrice);
    //Verify "Continue Shopping" is visible
//        Boolean continueShoppingCheck = bot.checkVisibility(continueShoppingLocator);
//        Assert.assertEquals(continueShoppingCheck,true,"the continue shopping button not visible");
    //Verify "Checkout" is visible
//        Boolean checkoutCheck = bot.checkVisibility(checkoutLocator);
//        Assert.assertEquals(checkoutCheck,true,"the checkout button not visible");
//    }
    //2nd Test Case Remove Product from Cart
//    @Test
//    public void removeProductFromCart(){
    //Login with standarduser
//        bot.navigateTo(URL);
//        bot.type(userNameLocator,userName);
//        bot.type(passwordLocator,password);
//        bot.click(loginButtonLocator);
    //Add "Sauce Labs Bolt T-Shirt" to cart
//        bot.click(sauceLabsBoltTshirt);
    //Navigate to cart page
//        bot.click(cartIconLocator);
    //Verify product is in cart
//        String actualTitleofBoltTshirt = bot.getText(titleofBoltTshirtLocator);
//        Assert.assertEquals(actualTitleofBoltTshirt,"Sauce Labs Bolt T-Shirt");
    //Click "Remove" button for the product
//        bot.click(removeButtonLocator);
    //Verify product is removed from cart
//        bot.checkVisibility(removedCartItem);
//        String emptyCartNum = bot.getText(cartIconLocator);
    //Verify cart badge updates or disappears
//        Assert.assertEquals(emptyCartNum,"0");
//        bot.checkVisibility(numofItemsonCartLocator);
//
//
//    }
    // 3rd Test Case Continue Shopping from Cart
    @Test
    public void continueShoppingfromCart(){
        bot.navigateTo(URL);
        bot.type(userNameLocator,userName);
        bot.type(passwordLocator,password);
        bot.click(loginButtonLocator);
        bot.click(sauceLabsBackpackLocator);
        bot.click(cartIconLocator);
        bot.click(continueShoppingLocator);
       String actualInventoryPageTitle =  bot.getText(inventoryPageTitle);
       Assert.assertEquals(actualInventoryPageTitle,expectedInventoryPageTitle);
       String actualNumofProduct1=bot.getText(numofItemsonCartLocator);
       Assert.assertEquals(actualNumofProduct1,expectedNumofProduct1);
    }


}
