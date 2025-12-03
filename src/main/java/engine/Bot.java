package engine;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class Bot {
    public WebDriver driver;
    Wait<WebDriver> wait;

    public Bot() {
        ChromeOptions options = new ChromeOptions(); // added chrome options to disable password manager
        // Disable Chrome password manager & credential service
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);
        options.addArguments(
                "--incognito",
                "--disable-features=PasswordLeakDetection,PasswordManagerOnboarding",
                "--disable-blink-features=AutomationControlled"
        );
        options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);
        ;
        // Initialize ChromeDriver (consider configuring options externally if needed)
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class);
    }

    public void navigateTo(String url) {
        driver.navigate().to(url);
        System.out.println("Navigated to: " + url);
    }

    public void click(By locator) {
        wait.until(d -> {
            d.findElement(locator).click();
            return true;
        });
        System.out.println("Clicked on element: " + locator.toString());
    }

    public void type(By locator, String text) {
        wait.until(d -> {
            d.findElement(locator).click();
            d.findElement(locator).clear();
            d.findElement(locator).sendKeys(text);
            return true;
        });
        System.out.println("Typed " + text + " into element: " + locator.toString());
    }

    public String displayedText(By locator) {
        return wait.until(d -> d.findElement(locator).getText());
    }

    public boolean checkVisibility(By locator) {
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
    public boolean checkItemRemoved(By locator) {
        return wait.until(d -> !d.findElements(locator).isEmpty());
    }

    public void quit() {
        driver.quit();
        System.out.println("Bot quit and driver closed.");
    }

    public int countItems(By locator) {
        return driver.findElements(locator).size();
    }
}

//Dua