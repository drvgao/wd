package com.wd.concepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Navigations {
	WebDriver driver;

	@BeforeClass
	public void init() {
		driver = new FirefoxDriver();
	}

	@Test(description = "navigations")
	public void navigations() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.nasa.gov/mission_pages/msl/videos/index.html");
		WebElement element = driver.findElement(By.xpath("//*[@id=\"ember1095\"]"));
		element.click();

		// navigate back
		driver.navigate().back();

		// navigate forward
		driver.navigate().forward();

		// refresh
		driver.navigate().refresh();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
