package tests;


import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.util.Properties;

import static utilities.ReadDataFromFile.readDataFromPropertiesFile;

public class BaseClass {

    public WebDriver driver;
    private Properties properties;

    @BeforeSuite
    public void setupRestRequest() throws IOException {

        properties = readDataFromPropertiesFile("\\config\\config.properties");
        RestAssured.baseURI = properties.getProperty("BASE_URL");
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    @BeforeMethod
    public WebDriver setup() throws IOException {

        Logger log = LogManager.getLogger(BaseClass.class.getName());
        properties = readDataFromPropertiesFile("\\config\\config.properties");
        String browserName = properties.getProperty("BROWSER");

        if(browserName.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
            log.info("ChromeDriver initialized");
        }
        else if(browserName.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
            log.info("FirefoxDriver initialized");
        }
        else if(browserName.equalsIgnoreCase("ie")){
            driver = new EdgeDriver();
            log.info("EdgeDriver initialized");
        }

        driver.get(properties.getProperty("URL"));
        driver.manage().window().maximize();

        return driver;
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }



}
