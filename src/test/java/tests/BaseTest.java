package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.SearchPage;


import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        String downloadFilepath = System.getProperty("downloadFilepath");
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadFilepath);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--no-sandbox");
        options.addArguments("--headless"); //should be enabled for Jenkins
        options.addArguments("--disable-dev-shm-usage"); //should be enabled for Jenkins
        options.addArguments("--window-size=1920x1080"); //should be enabled for Jenkins
        driver = new ChromeDriver(options);
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
