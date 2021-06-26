package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.SearchPage;


import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com.ua/?hl=ru");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    public WebDriver getDriver() {
        return driver;
    }

    @AfterMethod
    public void shutDown(){
        driver.close();
        driver = null;
    }



}
