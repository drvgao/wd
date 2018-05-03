package com.wd.samples;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.SessionId;

public class SampleTest {
	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		final Logger logger = Logger.getLogger(SampleTest.class);
		// SessionId session;
		// Setting the location of the Internet Explorer driver in the system
		// properties
		// System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
		// WebDriver webDriver = new ChromeDriver();
		WebDriver webDriver = new FirefoxDriver();

		SessionId session = ((FirefoxDriver) webDriver).getSessionId();
		System.out.println("Session id: " + session.toString());
		logger.info("session id is-------: " + session.toString());
		try {
			int i = 10;
			i = i / 0;
		} catch (ArithmeticException e) {
			logger.error("asd", e);
		}

		// Setting the browser size
		webDriver.manage().window().setSize(new Dimension(1024, 768));

		// Go to wikipedia
		webDriver.navigate().to("https://en.wikipedia.org/wiki/Main_Page");

		// Type in the search-field: "WebDriver"
		webDriver.findElement(By.id("searchInput")).sendKeys("WebDriver");

		// submitting the search query
		webDriver.findElement(By.id("searchInput")).submit();

		// Test if Wikipedia redirects to the correct article:
		// "Selenium (software)"
		String textFound = webDriver.findElement(By.cssSelector("h1")).getText();
		if (textFound.contains("Selenium (software)")) {
			System.out.println("Test passes!");
		} else {
			System.out.println("Test fails!");
		}

		// Waiting a little bit before closing
		Thread.sleep(7000);

		// Closing the browser and webdriver

		try {
			session = ((FirefoxDriver) webDriver).getSessionId();
			System.out.println("Session id: " + session.toString());
//			webDriver.quit();
			Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
			Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe");
			Runtime.getRuntime().exec("taskkill /F /IM firefox.exe");
		} catch (RuntimeException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}

	}
}
