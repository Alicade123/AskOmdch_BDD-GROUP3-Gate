package askomdch.hooks;

import askomdch.utils.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class Hooks {
    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshotByte = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("failed step", new ByteArrayInputStream(screenshotByte));
        }
        Path videoPath = Path.of(
                "C:\\Users\\USER\\IdeaProjects\\AskomdchBDD_GROUP3_GATE\\a_video\\testVideo.mp4"
        );

        try (InputStream fl = Files.newInputStream(videoPath)) {
            Allure.addAttachment("Test Video", "video/mp4", fl, "mp4");
        } catch (IOException e) {
            e.printStackTrace();
        }
        DriverFactory.quitDriver();
    }
}
