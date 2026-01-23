package askomdch.stepdefinitions.productfilterbypricerange;

import askomdch.constants.EndPoint;
import askomdch.pages.StorePage;
import askomdch.utils.DriverFactory;
import askomdch.utils.WebsiteStateManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class ProductFilterByPriceRangeStepDefinitions {
    public WebDriver driver = DriverFactory.getDriver();

    private final WebsiteStateManager websiteStateManager = new WebsiteStateManager(driver);
    private final StorePage storePage = new StorePage(driver);


    @Given("I'm on the Store page of the AskOmDch Website")
    public void gotToStorePage() {
        websiteStateManager.loadPage(EndPoint.STORE.url);
    }

    @When("I choose the {double} range and {double} range")
    public void setPriceRange(double minValue, double maxValue) {
        storePage.enterPriceRanges(minValue, maxValue);
    }

    @And("I click filter button")
    public void filterNow() {
        storePage.clickFilterBtn();
    }

    @Then("I get products that fall in the price range I chosen {int} and {int}.")
    public void checkRetrievedProductsPrices(int minValue, int maxValue) {
        Assert.assertTrue("There's price found that are out of selected Minimum and Maximum price range",
                storePage.checkFilteredPriceRange(minValue, maxValue));
    }
}
