package com.zerobank.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json"
                ,"html:target/myReports",
                "rerun:target/rerun.txt"
        },
        features = "src/test/resources/features",
        glue="com/zerobank/stepdefinitions",
        dryRun = false,
        tags= "@new"
)
public class CukesRunner {


}
