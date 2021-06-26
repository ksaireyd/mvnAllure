package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class WikiPage extends BasePage{
    public WikiPage(WebDriver driver) {
        super(driver);
    }

    @Step("Check if URL contain searched word {0}")
    public boolean checkPlace(String url){
        return getCurrentURL().contains(url);
    }
}
