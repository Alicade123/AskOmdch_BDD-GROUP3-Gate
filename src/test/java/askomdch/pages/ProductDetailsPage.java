package askomdch.pages;

import askomdch.utils.DriverFactory;
import askomdch.utils.WebsiteStateManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductDetailsPage {
    By productTitle = By.cssSelector(".product_title.entry-title");
    By price = By.className("price");
    By productDetails = By.className("woocommerce-product-details__short-description");
    By addToCartBtn = By.cssSelector(".single_add_to_cart_button.button.alt");
    private final WebDriver driver;
    private final WebDriverWait wait;
    public ProductDetailsPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public Boolean allDetailsPresent(){
        return isAddToCartDisplayed(addToCartBtn) && isPriceDisplayed(price) && isTitleDisplayed(productTitle);
    }

    public Boolean isTitleDisplayed(By element){
        boolean title =wait.until(ExpectedConditions.visibilityOf(driver.findElement(element))).isDisplayed();
        return title;
    }

    public Boolean isPriceDisplayed(By element){
        Boolean price = wait.until(ExpectedConditions.visibilityOf(driver.findElement(element))).isDisplayed();
        return price;

    }

    public Boolean isAddToCartDisplayed(By element){
        boolean button = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(element))).isDisplayed();
        return button;
    }



}
