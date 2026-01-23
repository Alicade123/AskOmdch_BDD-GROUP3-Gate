package askomdch.stepdefinitions.signup;

import askomdch.dependencyinjection.UtilClass;
import askomdch.pages.AccountPage;
import askomdch.utils.DriverFactory;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;


public class SignupStepDefinitions {


    private final WebDriver driver = DriverFactory.getDriver();
    private final AccountPage accountPage = new AccountPage(driver);

    @When("I enter {string} {string} and {string} in the registration form")
    public void i_enter_and_in_the_registration_form(String username, String email, String password) {
        UtilClass.username = username;
        accountPage.setCredentials_Register(username, email, password);
    }
}
