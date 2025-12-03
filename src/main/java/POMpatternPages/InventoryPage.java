package POMpatternPages;

import engine.Bot;
import org.openqa.selenium.By;


public class InventoryPage {
    Bot inventoryBot;

    By inventoryPageTitleLocator = By.xpath("//*[normalize-space(text())='Products']");
    By inventoryItemLocator = By.xpath("//div[@class='inventory_item']");
    By sortDropdownMenuLocator = By.xpath("//select[@class='product_sort_container']");
    By lowtoHighOptionLocator = By.xpath("//option[@value='lohi']");
    By firstItemAfterSortingLocator = By.xpath("(//div[@class='inventory_item_price'])[1]");
    By lastItemAfterSortingLocator = By.xpath("(//div[@class='inventory_item_price'])[6]");
    By backPackRemoveButtonLocator = By.xpath("//button[@id='remove-sauce-labs-backpack']");
    By backPackAddtoCartButtonLocator = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");

    String lowesPrice = "$7.99";
    String highestPrice = "$49.99";

    // Constructor
    public InventoryPage(Bot bot) {
        inventoryBot = bot;
    }

    public boolean verifyInventoryPageIsLoaded() {
        return inventoryBot.getText(inventoryPageTitleLocator).contains("Products");
    }

    public int countTotalNumberOfProductsDisplayed() {
        return inventoryBot.countItems(inventoryItemLocator);
    }

    public void clickonSortDropdownList() {
        inventoryBot.click(sortDropdownMenuLocator);
    }

    public void selectPriceLowtoHigh() {
        inventoryBot.click(lowtoHighOptionLocator);
    }

    public boolean verifyProductsareSortedinAscendingOrderbyPrice() {
        return inventoryBot.getText(firstItemAfterSortingLocator).contains(lowesPrice);
    }

    public boolean verifyFirstProducthasLowestPrice() {
        return inventoryBot.getText(firstItemAfterSortingLocator).contains(lowesPrice);
    }

    public boolean verifyLastProducthashighestPrice() {
        return inventoryBot.getText(lastItemAfterSortingLocator).contains(highestPrice);
    }

    public boolean verifyButtonTextChangestoRemove() {
        return inventoryBot.getText(backPackRemoveButtonLocator).contains("Remove");
    }

    public void clickRemoveButton() {
        inventoryBot.click(backPackRemoveButtonLocator);
    }

    public boolean verifiyProductRemovedAfterClickRemoveButton() {
        return inventoryBot.getText(backPackAddtoCartButtonLocator).contains("Add to cart");
    }
}
//Dua