package askomdch.stepdefinitions.productsorting;

import askomdch.constants.EndPoint;
import askomdch.utils.DriverFactory;
import askomdch.utils.WebsiteStateManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ProductSortingStepDefinitions {
    private WebDriver driver = DriverFactory.getDriver();
    WebsiteStateManager websiteStateManager = new WebsiteStateManager(driver);

    private By selectDropDownBy = By.xpath("//select[@aria-label='Shop order']");
    @Given("I am on the store page of the askomdch website")
    public void i_am_on_the_store_page_of_askomdch_website() {
        websiteStateManager.loadPage(EndPoint.STORE.url);
    }

    @When("I select {string} from the sorting dropdown")
    public void i_select_from_the_sorting_dropdown(String option) {
        Select dropDown = new Select(driver.findElement(selectDropDownBy));
        dropDown.selectByVisibleText(option);
    }

    @Then("I should see products sorted by {string}")
    public void i_should_see_products_sorted_by() {

    }
}
