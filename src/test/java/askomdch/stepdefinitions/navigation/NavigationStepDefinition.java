package askomdch.stepdefinitions.navigation;

import askomdch.constants.EndPoint;
import askomdch.pages.HomePage;
import askomdch.utils.DriverFactory;
import askomdch.utils.WebsiteStateManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;


public class NavigationStepDefinition {
    private WebDriver driver = DriverFactory.getDriver();
    private final WebsiteStateManager websiteStateManager = new WebsiteStateManager(driver);
    private final HomePage homePage = new HomePage(driver);


    @Given("I'm On any page of the AskOmDch website")
    public void openSite() {
        websiteStateManager.loadPage(EndPoint.HOMEPAGE.url);
    }

    @When("I click on {string}")
    public void clickLink(String link) {
        homePage.clickLink(link);
    }

    @Then("I should be directed to the page with {string}")
    public void checkPage(String pageTitle) {
        Assert.assertEquals(pageTitle, driver.getTitle());
    }
}
