package com.weborders.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/weborders/step_definitions",
        tags = "",
        dryRun = false,
        plugin = {"json:target/cucumber1.json",
        "rerun:target/rerun.txt"}
)
public class CucumberRunner {



}
