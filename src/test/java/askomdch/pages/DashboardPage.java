package askomdch.pages;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class DashboardPage {

    private final WebDriverWait wait;
    private By dashboardTab = By.linkText("Dashboard");

    public  DashboardPage(WebDriver driver){
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public boolean getDashboardAccess(){

        return wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardTab)).isDisplayed();
    }
    public String getWelcomeMessage(){
        WebElement loggedUser = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".woocommerce-MyAccount-content p")));
        return loggedUser.getText();
    }

}
