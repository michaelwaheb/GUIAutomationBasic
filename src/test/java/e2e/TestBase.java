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


    @BeforeMethod(alwaysRun = true)
    public void initializeNewDriverSession()
    {
        driver = Factory.initiateSession();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownDriverSession()
    {
        Factory.terminateSession();

    }
}
