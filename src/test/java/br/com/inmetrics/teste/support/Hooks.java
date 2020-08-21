package br.com.inmetrics.teste.support;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	@Before("@funcional")
	public void setUp() {
		DriverFactory.getChromeDriver();
	}

	@After("@funcional")
	public void tearDown(Scenario scenario) {
		// Take a screenshot...
		final byte[] screenshot = ((TakesScreenshot) DriverFactory.getChromeDriver()).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", "evidencia"); // ... and embed it in the report.
		DriverFactory.shutDown();
	}
	
}