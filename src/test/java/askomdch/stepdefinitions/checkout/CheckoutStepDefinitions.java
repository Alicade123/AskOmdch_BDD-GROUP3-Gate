package askomdch.stepdefinitions.checkout;

import askomdch.pages.CheckoutPage;
import askomdch.pages.StorePage;
import askomdch.utils.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutStepDefinitions {

    private final WebDriver driver = DriverFactory.getDriver();
    private final StorePage storePage = new StorePage(driver);
    private final CheckoutPage checkoutPage = new CheckoutPage(driver);

    @When("I add {string} in my cart")
    public void addingProductToCart(String productName) {
    storePage.addProductToCart(productName);
    }

    @And("I am on the checkout page")
    public void goToCheckoutPage() {
        storePage.proceedToCheckout();
    }

    @When("I provide valid shipping details")
    public void i_provide_valid_shipping_details(DataTable dataTable) {
       checkoutPage.fillBillingDetails(dataTable);
    }

    @And("I select")
    public void paymentMethod(DataTable paymentMethod) {
        checkoutPage.setPaymentMethod(paymentMethod);
    }

    @When("I place the order")
    public void i_place_the_order() {
        WebElement placeOrderBtn = driver.findElement(By.id("place_order"));
        placeOrderBtn.click();
    }

    @Then("I should see an order confirmation message")
    public void i_should_see_an_order_confirmation_message() {
        String expectedResult = "Thank you. Your order has been received.";
        Assert.assertEquals("The expected Results is diff from actual Result", expectedResult, checkoutPage.getOrderConfirmationMessage());
    }
}
