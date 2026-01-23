package askomdch.utils;

import org.openqa.selenium.WebDriver;


public class WebsiteStateManager {
    private final WebDriver driver;
    public WebsiteStateManager(WebDriver driver){
        this.driver = driver;
    }
    public void loadPage(String endPoint) {
        driver.get(ConfigLoader.getInstance().getBaseUrl()+endPoint);
        driver.manage().window().maximize();
    }
}
