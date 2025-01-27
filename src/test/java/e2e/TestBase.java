package e2e;

import Engine.Bot;
import Engine.Factory;
import Engine.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class  TestBase
{
    public static WebDriver driver;

    @BeforeMethod

        public void initiateSession(String url)
        {
            // Initialize the ChromeDriver
            driver = new ChromeDriver();
            // Navigate to a website
            driver.navigate().to(url);
            //Maximize current window
            driver.manage().window().maximize();
        }


    @AfterMethod
    public void tearDownDriverSession()
    {
        Factory.terminateSession();

    }
}
