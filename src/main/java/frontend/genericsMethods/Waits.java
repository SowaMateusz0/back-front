package frontend.genericsMethods;


import lombok.experimental.UtilityClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@UtilityClass
public final class Waits {

    private static WebDriverWait getWebDriverWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public static void waitUntilElementIsVisible(WebElement element, WebDriver driver) {
        WebDriverWait webDriverWait = getWebDriverWait(driver);
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }
    public static void waitUntilElementIsClickable(WebElement element,WebDriver driver) {
        WebDriverWait webDriverWait = getWebDriverWait(driver);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

}
