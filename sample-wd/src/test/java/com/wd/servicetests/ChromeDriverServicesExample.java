package com.wd.servicetests;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChromeDriverServicesExample {

	// Browser server service
	ChromeDriverService services;
	WebDriver driver;

	@BeforeClass
	public void startServer() throws IOException {

		// Setting up server
		services = new ChromeDriverService.Builder().usingDriverExecutable(new File("drivers/chromedriver.exe"))
				.usingAnyFreePort().build();
		
		services.start();

	}

	@AfterClass
	public void stopServices() {
		// Killing server
		services.stop();
	}

	@BeforeMethod
	public void startBrowser() {
		// Launching browser
		driver = new RemoteWebDriver(services.getUrl(), new ChromeOptions());
	}

	@AfterMethod
	public void killBrowser() {
		// Killing browser
		driver.quit();
	}

	@Test
	public void launchGoogle2() {
		driver.get("http://www.google.com");
	}

	@Test
	public void launchFacebook2() {
		driver.get("http://www.facebook.com");
	}

}