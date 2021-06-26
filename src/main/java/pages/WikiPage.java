package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WikiPage extends BasePage{
    public WikiPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//a[@class='mw-wiki-logo']")
    private WebElement wikiLogo;
    @Step("Check if URL contain searched word {0}")
    public boolean checkPlace(String url){
        waitForVis(wikiLogo);
        return getCurrentURL().contains(url);
    }
}
