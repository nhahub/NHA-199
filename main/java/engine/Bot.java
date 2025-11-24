package engine;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class Bot {
    // declaration of driver & wait
    private final WebDriver driver;
    Wait<WebDriver> wait;


    public Bot (){
        // inialize the driver to Edge driver
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        //initialize the wait to fluent wait
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(2))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(ElementNotInteractableException.class);

    }
    // methods
    public void navigateTo(String url){

        driver.navigate().to(url);
    }
    public void click(By locator){
        wait.until(d -> {
            d.findElement(locator).click();
            return true;
        });
    }
    public void type(By locator,String text){
        wait.until(d-> {
            d.findElement(locator).sendKeys(text);
            return true;
        });
    }
    public String getText(By locator){
            return driver.findElement(locator).getText();
        };
    public Boolean checkVisibility(By locator){
      return driver.findElement(locator).isDisplayed();
    };
    public void quit(){
        driver.quit();
    }

    }



