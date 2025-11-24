package botAndAbstract;

import engine.Bot;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTest extends BaseAbstract {

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
    By userNameLocator = By.id("user-name");
    By passwordLocator = By.id("password");
    By loginButtonLocator = By.id("login-button");
    By sauceLabsBackpackLocator = By.id("add-to-cart-sauce-labs-backpack");
    By sauceLabsBikeLightLocator = By.id("add-to-cart-sauce-labs-bike-light");
    By cartIconLocator = By.xpath("//a[@class='shopping_cart_link']");
    By cartPageTitleLocator = By.xpath("//span[@class='title']");
    By numofItemsonCartLocator = By.xpath("//span[@class='shopping_cart_badge']");
    By backPackTitleLocator = By.xpath("(//div[@class='inventory_item_name'])[1]");
    By backPackDescLocator = By.xpath("(//div[@class='inventory_item_desc'])[1]");
    By backPackPriceLocator = By.xpath("(//div[@class='inventory_item_price'])[1]");

    By bikeLightTitleLocator = By.xpath("(//div[@class='inventory_item_name'])[2]");
    By bikeLightDescLocator = By.xpath("(//div[@class='inventory_item_desc'])[2]");
    By bikeLightPriceLocator = By.xpath("(//div[@class='inventory_item_price'])[2]");
    By continueShoppingLocator = By.id("continue-shopping");
    By checkoutLocator = By.id("checkout");

    By sauceLabsBoltTshirt = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    By emptyCartIcontLocator = By.xpath("//a[@class='shopping_cart_link']");
    By removeButtonLocator = By.id("remove-sauce-labs-bolt-t-shirt");
    By titleofBoltTshirtLocator = By.xpath("//div[@class='inventory_item_name']");
    By removedCartItem = By.xpath("//div[@class='removed_cart_item']");
    By inventoryPageTitle = By.xpath("//span[@class='title']");
//    @Test
//    public void testCartwithAddedProduct(){
//        bot.navigateTo(URL);
//        bot.type(userNameLocator,userName);
//        bot.type(passwordLocator,password);
//        bot.click(loginButtonLocator);
//        bot.click(sauceLabsBackpackLocator);
//        bot.click(sauceLabsBikeLightLocator);
//        bot.click(cartIconLocator);
//        String actualCartTitle = bot.getText(cartPageTitleLocator);
//        Assert.assertEquals(actualCartTitle,expectedTitle);
//        String actualNuminCart = bot.getText(numofItemsonCartLocator);
//        Assert.assertEquals(actualNuminCart,expectedNumofItems);
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
//        Boolean continueShoppingCheck = bot.checkVisibility(continueShoppingLocator);
//        Assert.assertEquals(continueShoppingCheck,true,"the continue shopping button not visible");
//        Boolean checkoutCheck = bot.checkVisibility(checkoutLocator);
//        Assert.assertEquals(checkoutCheck,true,"the checkout button not visible");
//    }
//    @Test
//    public void removeProductFromCart(){
//        bot.navigateTo(URL);
//        bot.type(userNameLocator,userName);
//        bot.type(passwordLocator,password);
//        bot.click(loginButtonLocator);
//        bot.click(sauceLabsBoltTshirt);
//        bot.click(cartIconLocator);
//        String actualTitleofBoltTshirt = bot.getText(titleofBoltTshirtLocator);
//        Assert.assertEquals(actualTitleofBoltTshirt,"Sauce Labs Bolt T-Shirt");
//        bot.click(removeButtonLocator);
//        bot.checkVisibility(removedCartItem);
//        String emptyCartNum = bot.getText(cartIconLocator);
    //
//        Assert.assertEquals(emptyCartNum,"0");
//        bot.checkVisibility(numofItemsonCartLocator);
//
//
//    }

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
