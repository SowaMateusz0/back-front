package frontend.genericsMethods;

import lombok.experimental.UtilityClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static frontend.genericsMethods.Waits.waitUntilElementIsClickable;
import static frontend.genericsMethods.Waits.waitUntilElementIsVisible;

@UtilityClass
public class ActionMethods {

    public static void clickWebElement(WebElement element, WebDriver driver){
        waitUntilElementIsClickable(element,driver);
        element.click();
    }

    public static void sendText(WebElement element,String text, WebDriver driver){
        waitUntilElementIsVisible(element,driver);
        element.sendKeys(text);
    }
}
