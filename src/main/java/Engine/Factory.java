package Engine;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class Factory
{
    public static WebDriver driver;

    public static void terminateSession() {

        driver.quit();

//Start then stop Allure serve after test finish
        try {
            Utils.startAndStopAllureServe();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
