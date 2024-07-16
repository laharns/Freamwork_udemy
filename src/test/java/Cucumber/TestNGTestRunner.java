package Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/Cucumber",
        glue = "rahulsheety.stepDefinitions",
        monochrome = true,
        tags = "@Regression",
        plugin = {"html:target/cucumber.html"}
)

public class TestNGTestRunner extends AbstractTestNGCucumberTests {
    // You can add additional configurations or methods here if needed
}
