package frontend.pop;

import frontend.genericsMethods.ActionMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "userEmail")
    @CacheLookup
    WebElement email;

    @FindBy(id = "userPassword")
    @CacheLookup
    WebElement password;

    @FindBy(id = "login")
    @CacheLookup
    WebElement loginButton;

    public void sendTextToEmailField(String text){
        ActionMethods.sendText(email,text,driver);
    }

    public void sendTextToPasswordField(String text){
        ActionMethods.sendText(password,text,driver);
    }

    public void clickLoginButton(){
        ActionMethods.clickWebElement(loginButton,driver);
    }

}
