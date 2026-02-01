package askomdch.hooks;

import askomdch.utils.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

public class Hooks {
    @After
    public void tearDown(Scenario scenario) {
        if(scenario.isFailed()){
            byte[] screenshotByte= ((TakesScreenshot)DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("failed step",new ByteArrayInputStream(screenshotByte));
        }
        DriverFactory.quitDriver();
    }
}
