package botAndAbstract;

import engine.Bot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseAbstract {
    //declaration bot object
    Bot bot;

    @BeforeMethod
    public void setup(){
        bot = new Bot();
    }
    @AfterMethod
    public void teardown(){
        bot.quit();
    }
}
