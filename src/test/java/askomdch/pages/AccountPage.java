package askomdch.pages;

import askomdch.dependencyinjection.UtilClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }


    public void setCredentials(String username, String passcode) {
        UtilClass.username = username;

        WebElement name = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("username"))
        );
        WebElement password = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("password"))
        );

        name.clear();
        name.sendKeys(username);
        password.clear();
        password.sendKeys(passcode);
    }

    public void hitBtn(String button) {
        By btn = By.cssSelector("button[value='" + button + "']");
        wait.until(ExpectedConditions.elementToBeClickable(btn)).click();
    }

    public String getErrorMessageOnLoginFailure() {
        By loginFailError = By.cssSelector("ul.woocommerce-error");
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(loginFailError)
        ).getText();
    }


    public void setCredentials_Register(String username, String email, String passcode) {
        UtilClass.username = username;

        WebElement usernameField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("reg_username"))
        );
        usernameField.clear();
        usernameField.sendKeys(username);

        WebElement emailField = driver.findElement(By.id("reg_email"));
        emailField.clear();
        emailField.sendKeys(email);

        WebElement passwordField = driver.findElement(By.id("reg_password"));
        passwordField.clear();
        passwordField.sendKeys(passcode);
    }



    public void clickLostPasswordLink(String linkText) {
        By lostPasswordLink = By.linkText(linkText);
        wait.until(
                ExpectedConditions.elementToBeClickable(lostPasswordLink)
        ).click();
    }

    public void enterLostPasswordEmail(String email) {
        By emailField = By.id("user_login");
        WebElement emailInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(emailField)
        );
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public String getPasswordResetConfirmationMessage() {
        By confirmationMessage = By.cssSelector("div.woocommerce-message");
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(confirmationMessage)
        ).getText();
    }
}
