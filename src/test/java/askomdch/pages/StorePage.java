package askomdch.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class StorePage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private By dropdownField = By.id("product_cat");
    private By rangeForm = By.id("woocommerce_price_filter-3");
    By filterButton = By.cssSelector(".price_slider_amount button");

    public StorePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void chooseOptionFromDropDown(String category) {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(dropdownField));
        dropdown.click();
        String xpathExpression = "//option[contains(text(), '" + category + "')]";
        driver.findElement(By.xpath(xpathExpression)).click();
    }

    public boolean checkResults(String expected) {
        return wait.until(ExpectedConditions.urlContains(expected.toLowerCase()));

    }

    public void enterPriceRanges(double min, double max) {
        WebElement priceForm = wait.until(ExpectedConditions.visibilityOfElementLocated(rangeForm));
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});" +
                        "document.getElementById('min_price').value=arguments[1];" +
                        "document.getElementById('max_price').value=arguments[2];", priceForm, min, max);
    }

    public void clickFilterBtn() {
        driver.findElement(filterButton).click();
    }

    public boolean checkFilteredPriceRange(double min, double max) {
        By filteredProductsPrices = By.cssSelector(".astra-shop-summary-wrap .woocommerce-Price-amount.amount bdi");
        List<WebElement> pricesFound = driver.findElements(filteredProductsPrices);
        List<Double> validatedPrices = new ArrayList<>();
        for (WebElement prc : pricesFound) {
            validatedPrices.add(Double.parseDouble(prc.getText().replaceAll("[^0-9.]", "")));
        }
        return validatedPrices.stream().allMatch(e -> e >= min && e <= max);
    }

    public void addProductToCart(String productName) {
        By viewCart = By.cssSelector("a[title=\"View cart\"]");
        By addToCartBtn = By.cssSelector("a[aria-label=\"Add “" + productName + "” to your cart\"]");
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(viewCart)).click();
    }

    public void proceedToCheckout() {
        WebElement proceedToCheckoutBtn = driver.findElement(By.cssSelector("a[class='checkout-button button alt wc-forward']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", proceedToCheckoutBtn);
        proceedToCheckoutBtn.click();
    }
}