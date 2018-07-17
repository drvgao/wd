package com.wd.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class InvisibleElementTest {
	WebDriver driver;

	@BeforeClass
	public void init() {
		driver = new FirefoxDriver();
	}

	/***
	 * check that an element is either invisible or not present on the DOM.
	 */
	@Test(description = "ExpectedCondition to test element invisible.")
	public void isElementInvisible() {
		driver.get("http://openmaterials.org/");
		String xpath = "//*[@id=\"content_container\"]/div[2]/p/span/a/img";
		WebElement element = driver.findElement(By.xpath(xpath));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

		WebDriverWait wait = new WebDriverWait(driver, 10);
		// then click on element
		element.click();

		// after clicking the element should not be visible
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
	}

	@Test(description = "below method is need to be tested")
	public void otherInvisibleTests() {
		driver.get("http://openmaterials.org/");
		String xpath = "//*[@id=\"content_container\"]/div[2]/p/span/a/img";
		WebElement element = driver.findElement(By.xpath(xpath));

		//TODO check this.
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath(xpath), "element-text"));
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
