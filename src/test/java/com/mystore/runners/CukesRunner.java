package com.mystore.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},glue = {"com/mystore/stepdefs","com/mystore/hooks"},
        plugin = {"pretty","json:target/cucumber.json"},monochrome = true,dryRun = false,
        tags = "@wip"
)
public class CukesRunner {
}
