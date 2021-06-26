package tests;

import io.qameta.allure.*;
import listener.Listener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.SearchPage;
import pages.WikiPage;

@Epic("Functionality testing")
@Feature("Searching zebra test")
@Listeners(Listener.class)
public class SearchTest extends BaseTest{
    private final String query = "hippotigris";
    private String url = "wiki/Zebra";
    private String wrongUrl = "wiki/NotZebra";
    SearchPage searchPage;
    WikiPage wikiPage;



    @Severity(SeverityLevel.MINOR)
    @Description("Check if this test opens zebra wiki page")
    @Story(value = "Test for opening wiki page end right check URL")
    @Test
    public void checkOpeningZebra(){
        searchPage = new SearchPage(getDriver());
        wikiPage = new WikiPage(getDriver());
        searchPage.enterQuery(query);
        searchPage.clickWiki();
        Assert.assertTrue(wikiPage.checkPlace(url));
    }


    @Severity(SeverityLevel.NORMAL)
    @Description("Check if this test opens zebra wiki page and compare with wrong URL")
    @Story(value = "Test for opening wiki page end wrong check URL")
    @Test
    public void checkOpeningZebraForFailure(){
        searchPage = new SearchPage(getDriver());
        wikiPage = new WikiPage(getDriver());
        searchPage.enterQuery(query);
        searchPage.clickWiki();
        Assert.assertTrue(wikiPage.checkPlace(wrongUrl));
    }

}
