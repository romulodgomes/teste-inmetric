package br.com.inmetrics.teste.support;

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
		DriverFactory.shutDown();
	}
}