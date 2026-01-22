package askomdch.stepdefinitions.view_productdetails;

import askomdch.constants.EndPoint;
import askomdch.domainobject.Product;
import askomdch.pages.*;
import askomdch.utils.DriverFactory;
import askomdch.utils.WebsiteStateManager;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class PriductDetailsStepdefinition {
    private final WebDriver driver = DriverFactory.getDriver();
    private final StorePage storePagePage = new StorePage(driver);
    private final WebsiteStateManager websiteStateManager = new WebsiteStateManager(driver);

    @Given("the user is on a product Store page")
    public void theUserIsOnAProductStorePage() {
      new WebsiteStateManager(driver).loadPage(EndPoint.STORE.url);

    }

    @When("the user click on a {product} product")
    public void theUserClickAProduct(Product productName) {
      new StorePage(driver).clickProduct(productName.getName());
    }

    @Then("the product detail page is displayed")
    public void theProductDetailPageIsDisplayed() {
        boolean expectedData = true;
        boolean actualData = new ProductDetailsPage(driver).allDetailsPresent();
        assertEquals("All details are not displayed", expectedData, actualData);
    }




}
