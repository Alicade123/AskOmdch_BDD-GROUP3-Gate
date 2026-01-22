package askomdch.pages;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class CheckoutPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    public CheckoutPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    public void fillBillingDetails(DataTable dataTable) {
        Map<String, String> shippingDetails = dataTable.asMap(String.class, String.class);
        String fName = shippingDetails.get("firstName");
        String lName = shippingDetails.get("lastName");
        String country = shippingDetails.get("country");
        String streetNum = shippingDetails.get("streetAddress");
        String town = shippingDetails.get("town");
        String state = shippingDetails.get("state");
        String zipCode = shippingDetails.get("postCode");
        String phoneNum = shippingDetails.get("phone");
        String emailAddress = shippingDetails.get("email");

        WebElement fNameField = driver.findElement(By.id("billing_first_name"));
        WebElement lNameField = driver.findElement(By.id("billing_last_name"));
        WebElement streetAddressField = driver.findElement(By.id("billing_address_1"));
        WebElement townField = driver.findElement(By.id("billing_city"));
        WebElement zipCodeField = driver.findElement(By.id("billing_postcode"));
        WebElement phoneNumField = driver.findElement(By.id("billing_phone"));
        WebElement emailField = driver.findElement(By.id("billing_email"));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", fNameField);
        fNameField.sendKeys(fName);
        lNameField.sendKeys(lName);
        new Select(driver.findElement(By.id("billing_country"))).selectByValue(country);
        streetAddressField.sendKeys(streetNum);
        townField.sendKeys(town);
        new Select(driver.findElement(By.id("billing_state"))).selectByValue(state);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", zipCodeField);
        zipCodeField.sendKeys(zipCode);
        phoneNumField.sendKeys(phoneNum);
        emailField.sendKeys(emailAddress);
    }
    public void setPaymentMethod(DataTable  paymentMethod){
        List<String> pMethod = paymentMethod.asList();
        List<WebElement> labels = driver.findElements(By.cssSelector("ul[class='wc_payment_methods payment_methods methods'] label"));
        for (WebElement label : labels) {
            System.out.println(label.getText());
            if (label.getText().contains(pMethod.get(0))) {
                String forId = label.getAttribute("for");
                driver.findElement(By.id(forId)).click();
            }
        }
    }
    public  String getOrderConfirmationMessage(){
        By statusMessage = By.cssSelector(".woocommerce-order p");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(statusMessage)).getText();
    }
}
