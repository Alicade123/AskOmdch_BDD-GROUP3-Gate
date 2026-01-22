package askomdch.stepdefinitions.login;

import askomdch.constants.EndPoint;
import askomdch.dependencyinjection.UtilClass;
import askomdch.pages.AccountPage;
import askomdch.pages.DashboardPage;
import askomdch.utils.DriverFactory;
import askomdch.utils.WebsiteStateManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginStepDefinitions {

    private final WebDriver driver = DriverFactory.getDriver();
    private final AccountPage accountPage = new AccountPage(driver);
    private final DashboardPage dashboardPage = new DashboardPage(driver);
    private final WebsiteStateManager websiteStateManager = new WebsiteStateManager(driver);

    @Given("As I'm on the AskOmDch Account Page")
    public void goToAccountPage() {
        websiteStateManager.loadPage(EndPoint.ACCOUNT.url);
    }

    @When("I enter valid credentials {string} and {string}")
    public void enterCredentials(String username, String password) {
        accountPage.setCredentials(username, password);
    }

    @And("I click the {string} button")
    public void clickBtn(String button) {
        accountPage.hitBtn(button);
    }

    @Then("I get redirected to Dashboard Page")
    public void getAccessToDashboard() {
        Assert.assertTrue("The Dashboard Tab not found!", dashboardPage.getDashboardAccess());
    }

    @And("I should see welcome message")
    public void checkWelcomeMessage() {
        String expectedResult = "Hello " + UtilClass.username + " (not " + UtilClass.username + "? Log out)";
        Assert.assertEquals("Something went wrong", expectedResult, dashboardPage.getWelcomeMessage());
    }

    @Then("I should see error {string}")
    public void i_should_see_login_error(String expectedResult) {
        String actualResult = accountPage.getErrorMessageOnLoginFailure();
        Assert.assertEquals("The Actual Error Message is different from expected Error Message!",
                expectedResult, actualResult
        );
    }
}
