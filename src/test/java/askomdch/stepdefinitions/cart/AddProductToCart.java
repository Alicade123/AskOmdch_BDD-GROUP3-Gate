package askomdch.stepdefinitions.cart;

import askomdch.domainobject.Product;
import askomdch.pages.CartPage;
import askomdch.utils.DriverFactory;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class AddProductToCart {
    private final WebDriver driver = DriverFactory.getDriver();
    private final CartPage cartPage = new CartPage(driver);

    @Then("On Cart Page I should see {int} {product} in the cart")
    public void checkProductInCart(int productQuantity, Product product){
        Assert.assertEquals("Not much", product.getName(),cartPage.getProductName());
        Assert.assertEquals("Not much", productQuantity, cartPage.getProductQuantity());
    }
}
