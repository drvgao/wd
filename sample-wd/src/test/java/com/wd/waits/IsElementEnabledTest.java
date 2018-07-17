package com.wd.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class IsElementEnabledTest {
	WebDriver driver;

	@BeforeClass
	public void init() {
		driver = new FirefoxDriver();
	}

	/***
	 * check that an element is either enabled or not.
	 */
	@Test(description = "ExpectedCondition to test element enabled.")
	public void isElementEnabledTest() {
		driver.get("http://openmaterials.org/");
		String xpath = "//*[@id=\"content_container\"]/div[2]/p/span/a/img";
		WebElement element = driver.findElement(By.xpath(xpath));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		
		element.isEnabled();
		
		//returns false when the element is not present in DOM.
		element.isDisplayed();
		// then click on element
		element.click();
	}


	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
