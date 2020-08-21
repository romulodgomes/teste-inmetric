package br.com.inmetrics.teste.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features"
		,glue={"br.com.inmetrics.teste.steps", "br.com.inmetrics.teste.support"}
		,tags = "@webservice or @funcional"
		,plugin = { "pretty", "html:target/cucumber-reports/html/report.html",
				"json:target/cucumber-reports/json/cucumber.json"
				}
		,dryRun = false
		)
public class RunCucumberTest {
	
	
}
