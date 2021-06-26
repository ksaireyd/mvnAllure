package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends  BasePage{
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "q")
    private WebElement searchField;
    @FindBy(xpath = "//a/h3[contains(text(),'Zebra')]")
    private WebElement wikiLink;

    @Step("Enter key word {0} in searching filed")
    public void enterQuery(String query){
        searchField.sendKeys(query, Keys.ENTER);
    }
    @Step("Open wikipedia page")
    public void clickWiki(){
        wikiLink.click();
    }
}
