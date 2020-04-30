package com.weborders.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/weborders/step_definitions",
        tags = "@add_order",
        dryRun = true,
        plugin = "html:target/default-report"
)
public class CucumberRunner {
}
