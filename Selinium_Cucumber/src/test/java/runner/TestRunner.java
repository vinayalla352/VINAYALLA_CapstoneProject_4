package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features = "src\\test\\java\\resource",
		glue = "stepdefinations",
		plugin = {"pretty", "html:target/cucumber-reports.html"}
		)


public class TestRunner extends AbstractTestNGCucumberTests{

}

