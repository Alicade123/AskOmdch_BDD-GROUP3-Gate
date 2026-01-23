package askomdch.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/askomdch/features/",
        glue = {"askomdch.stepdefinitions",
                "askomdch.hooks",
                "askomdch.dependencyinjection",
                "askomdch.customtype",
                "askomdch.domainobject",
                "askomdch.utils"
                },
        plugin = "pretty",
        tags = "@invalidCredentials and not @addToCart and not @updateCartQuantity and  not @checkout and not @login and not @navigation and not @filterProductsByCategory and not @filterProductsByPriceRange and @register"
)
public class TestRunner {

}
