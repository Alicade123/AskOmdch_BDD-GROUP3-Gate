package askomdch.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private final WebDriverWait wait;
    public HomePage(WebDriver driver){
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void clickLink(String link){
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText(link))).click();
    }

}
