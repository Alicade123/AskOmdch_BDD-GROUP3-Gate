package askomdch.stepdefinitions.cart;

import askomdch.constants.EndPoint;
import askomdch.dependencyinjection.UtilClass;
import askomdch.domainobject.Product;
import askomdch.pages.CartPage;
import askomdch.pages.StorePage;
import askomdch.utils.DriverFactory;
import askomdch.utils.WebsiteStateManager;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class AddProductToCart {
    private final WebDriver driver = DriverFactory.getDriver();
    private final CartPage cartPage = new CartPage(driver);
    private final StorePage storePage = new StorePage(driver);
    private final WebsiteStateManager websiteStateManager = new  WebsiteStateManager(driver);


    @Then("On Cart Page I should see {int} {product} in the cart")
    public void checkProductInCart(int productQuantity, Product product){
        Assert.assertEquals("Not much", product.getName(),cartPage.getProductName());
        Assert.assertEquals("Not much", productQuantity, cartPage.getProductQuantity());
    }

    @Given("I'm on the Cart Page with {product} in the cart")
    public void i_m_on_the_cart_page(Product product) {
        websiteStateManager.loadPage(EndPoint.STORE.url);
        storePage.addProductToCart(product.getName());

    }

    @When("I do update of product quantity to {int}")
    public void i_do_update_of_product_quantity_to(int quantity) {
        UtilClass.productQuantity=quantity;
        cartPage.updateQuantity(quantity);
    }

    @Then("I should see the product quantity updated to {int} successful")
    public void i_should_see_the_product_quantity_updated_successful(int quantity) {
        Assert.assertEquals(UtilClass.productQuantity ,cartPage.updateQuantity(quantity));
    }
}
