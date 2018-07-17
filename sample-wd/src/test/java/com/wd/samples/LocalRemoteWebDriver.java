package com.wd.samples;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.HttpCommandExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LocalRemoteWebDriver {
	static SessionId globalSession = null;
	static String globalWinHandle = null;
	final Logger logger = Logger.getLogger(LocalRemoteWebDriver.class);
	WebDriver driver = null;
	SessionId session;

	/*@BeforeClass
	public void init() {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("something", true);

		ChromeOptions options = new ChromeOptions();
//		options.addArguments("disable-infobars");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(capabilities);

		// ChromeDriver driver = new ChromeDriver(options);
		URL remoteWDAddress;
		try {
			remoteWDAddress = new URL("http://127.0.0.1:9517");

			CommandExecutor remoteAddress = new HttpCommandExecutor(remoteWDAddress);
			driver = new RemoteWebDriver(remoteAddress, capabilities);
			driver.navigate().to("http://www.google.com");
			SessionId session = ((RemoteWebDriver) driver).getSessionId();
			System.out.println("session id "+session);
			logger.info("driver " + driver.toString());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}*/
	
	@BeforeClass
	public void ffinit() {
		DesiredCapabilities capabilities = new DesiredCapabilities();

//		capabilities.setCapability("something", true);
//		capabilities = DesiredCapabilities.firefox();
		capabilities = DesiredCapabilities.internetExplorer();
//		capabilities.setCapability(Capabilities., value);

		URL remoteWDAddress;
		try {
			remoteWDAddress = new URL("http://127.0.0.1:9517");

			CommandExecutor remoteAddress = new HttpCommandExecutor(remoteWDAddress);
			driver = new RemoteWebDriver(remoteAddress, capabilities);
			driver.navigate().to("http://www.google.com");
			SessionId session = ((RemoteWebDriver) driver).getSessionId();
			System.out.println("session id "+session);
			logger.info("driver " + driver.toString());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void remoteWDTest1() {
		logger.info("test1" + driver.toString());
		driver.findElement(By.id("lst-ib")).sendKeys("WebDriver");
	}

	//this test use above browser instance.
	@Test
	public void remoteWDTest2() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("test2" + driver.toString());
		driver.findElement(By.name("btnK")).click();
		System.out.println("title: " + driver.getTitle());
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
