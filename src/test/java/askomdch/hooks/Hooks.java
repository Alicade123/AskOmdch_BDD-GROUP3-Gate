package askomdch.hooks;

import askomdch.utils.DriverFactory;
import io.cucumber.java.After;

public class Hooks {
    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
