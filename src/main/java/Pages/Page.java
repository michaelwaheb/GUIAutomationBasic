package Pages;

import org.openqa.selenium.WebDriver;
import Engine.Bot;

public abstract class Page
{
    public Bot bot;
    public WebDriver driver;
    public Page(WebDriver driver)
    {
        this.driver = driver;
        bot = new Bot(driver);
    }


}
