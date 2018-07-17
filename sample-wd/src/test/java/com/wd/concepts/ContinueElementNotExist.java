package com.wd.concepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ContinueElementNotExist {
	WebDriver driver;

	@BeforeClass
	public void init() {
		driver = new FirefoxDriver();
	}

	@Test
	public void isElementPresentTest() {
		driver.get("http://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("stackoverflow webdriver");

		// if btnK is present then only execute below if condition else after if code.
		Boolean isPresent = driver.findElements(By.name("btnK")).size() > 0;
		if (isPresent) {
			driver.findElement(By.name("btnK")).click();
		}
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
