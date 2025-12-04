package engine;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import java.time.Duration;



public class Bot {
    WebDriver driver;
    Wait<WebDriver> wait;

    public Bot() {
        // Initialize ChromeDriver (consider configuring options externally if needed)
        driver = new ChromeDriver();
        // Increased timeout to 10 seconds to reduce flakiness in CI/slow machines
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class);
    }

    public void navigateTo(String url){
        driver.navigate().to(url);
        System.out.println("Navigated to: " + url);
    }
    public void click(By locator){
        wait.until(d -> { d.findElement(locator).click(); return true; });
        System.out.println("Clicked on element: " + locator.toString());
    }
    public void type(By locator, String text){
        wait.until(d -> { d.findElement(locator).clear(); d.findElement(locator).sendKeys(text); return true; });
        System.out.println("Typed "+ text+ " into element: " + locator.toString());
    }
    public String displayedText(By locator) {
        return wait.until(d -> d.findElement(locator).getText());
    }
    public boolean checkVisibility (By locator) {
        return wait.until(d -> d.findElement(locator).isDisplayed());
    }
    public String currentURL() {
        return driver.getCurrentUrl();
    }
    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }
    // this method used for catch an element exist in the DOM but not visible
    // use findElements will returns an empty list if not found
    public boolean checkItemRemoved(By locator){
        return wait.until(d-> !d.findElements(locator).isEmpty());
    }
    public void quit() {
        driver.quit();
        System.out.println("Bot quit and driver closed.");
    }
}
