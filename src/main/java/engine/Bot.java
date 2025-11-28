package engine;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import java.time.Duration;

public class Bot {
    private final WebDriver driver;
    Wait<WebDriver> wait;

    public Bot() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(2))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(ElementNotInteractableException.class);
    }

    public void navigateTo(String url){
        driver.navigate().to(url);
        // Logging can be added here
        System.out.println("Navigated to: " + url);
    }
    public void click(By locator){
        wait.until( d -> {
            d.findElement(locator).click();
            return true;
        });
        System.out.println("Clicked on element: " + locator.toString());
    }
    public void type(By locator, String text){
        wait.until( d -> {
            d.findElement(locator).clear();
            d.findElement(locator).sendKeys(text);
            return true;
        });
        System.out.println("Typed "+ text+ " into element: " + locator.toString());
    }
    public String getDomProperty(By locator, String property) {
        System.out.println("Retrieved property "+ property + " from element: " + locator.toString()); // not accurate
        return driver.findElement(locator).getDomProperty(property);
    }
    public void quit() {
        driver.quit();
        System.out.println("Bot quit and driver closed.");
    }
}

}
