package askomdch.stepdefinitions.productfilterbycategory;

import askomdch.constants.EndPoint;
import askomdch.pages.StorePage;
import askomdch.utils.DriverFactory;
import askomdch.utils.WebsiteStateManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;


public class ProductFilterByCategory {
    private WebDriver driver = DriverFactory.getDriver();
    private final WebsiteStateManager websiteStateManager = new WebsiteStateManager(driver);
    private final StorePage storePage = new StorePage(driver);


    @Given("I am on the store page")
    public void i_am_on_the_store_page() {
        websiteStateManager.loadPage(EndPoint.STORE.url);
    }

    @When("I select category {string}")
    public void i_select_category(String category) {
        storePage.chooseOptionFromDropDown(category);
    }

    @Then("I should see {string} in the url")
    public void i_should_see_in_the_url(String expected) {
        Assert.assertTrue(storePage.checkResults(expected));

    }
}
