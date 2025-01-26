package Engine;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import java.io.ByteArrayInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

public class Bot
{
    private final WebDriver driver;
    private final Wait<WebDriver> wait;
    String failureMessage = "Element found by '${LOCATOR}' was not found.";
    public Bot(final WebDriver driver) {
        this.driver = driver;
        this.wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);
    }
    @Step("Click element found by {locator}")
    public Bot click(By locator){
        try{
            wait.until( d->{
                driver.findElement(locator).click();
                return true;
            });
        } catch (TimeoutException timeoutException) {
            Allure.addAttachment(failureMessage.replace("${LOCATOR}",locator.toString()), new ByteArrayInputStream(((ChromeDriver)driver).getScreenshotAs(OutputType.BYTES)));
            throw timeoutException;
        }
        return this;
    }
    @Step("Type {text} into element found by {locator}")
    public Bot type(By locator,String text){
        try{
            wait.until( d->{
                driver.findElement(locator).sendKeys(text);
                return true;
            });
        } catch (TimeoutException timeoutException) {
            Allure.addAttachment(failureMessage.replace("${LOCATOR}",locator.toString()), new ByteArrayInputStream(((ChromeDriver)driver).getScreenshotAs(OutputType.BYTES)));
            throw timeoutException;
        }
        return this;
    }

}
