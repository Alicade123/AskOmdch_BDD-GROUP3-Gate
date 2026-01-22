package askomdch.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

}
