package askomdch.pages;

import io.opentelemetry.api.common.Value;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.beans.Visibility;
import java.time.Duration;

public class CartPage {
    private  final WebDriver driver;
    private  final WebDriverWait wait;

    public  CartPage(WebDriver driver){
     this.driver   = driver;
     this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

        public String getProductName (){
           WebElement productNameField =driver.findElement(By.cssSelector("td[class=\"product-name\"]"));
            return wait.until(ExpectedConditions.visibilityOf(productNameField)).getText();
        }

        public int getProductQuantity (){
           WebElement productQuantityField = driver.findElement(By.cssSelector("input[type='number']")) ;
            return Integer.parseInt(wait.until(ExpectedConditions.visibilityOf(productQuantityField)).getAttribute("value"));
    }
    public int updateQuantity(int quantity){
        By input  = By.cssSelector("input[type=\"number\"]");
        By updateBtn = By.cssSelector("button[name=\"update_cart\"]");
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(input));
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", element, "value", quantity);
        driver.findElement(updateBtn).click();
        int newQuantity = Integer.parseInt(wait.until(ExpectedConditions.visibilityOfElementLocated(input)).getAttribute("value"));
        return newQuantity;
    }

}
