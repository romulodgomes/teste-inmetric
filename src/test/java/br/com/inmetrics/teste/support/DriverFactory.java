package br.com.inmetrics.teste.support;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	private static WebDriver driver;
	
	public static WebDriver getChromeDriver() {
		if (driver == null) {
			WebDriverManager.chromedriver().setup();
//			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tassilo\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(600, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		return driver;
	}

	public static WebDriver getFirefoxDriver() {
		if (driver == null) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(600, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		return driver;
	}
	
	public static void shutDown() {
		if (driver!= null) driver.quit();
		driver = null;
	}
}
