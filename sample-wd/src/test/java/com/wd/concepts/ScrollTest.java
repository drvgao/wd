package com.wd.concepts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ScrollTest {
	WebDriver driver;

	@BeforeClass
	public void init() {
		driver = new FirefoxDriver();
	}

	@Test(description = "scroll vertically")
	public void verticalScroll() {
		driver.get("http://openmaterials.org/");
		String xpath = "//*[@id=\"content_container\"]/div[2]/p/span/a/img";
		WebElement element = driver.findElement(By.xpath(xpath));
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,200)");
		element.click();
	}

	@Test(description = "scroll to the element view")
	public void scrollTest() {
		driver.get("http://openmaterials.org/");
		String xpath = "//*[@id=\"content_container\"]/div[2]/p/span/a/img";
		WebElement element = driver.findElement(By.xpath(xpath));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

		/*
		 * int headrVerticalSize = 1; Actions actions = new Actions(driver);
		 * actions.moveToElement(element, 0, -1 * headrVerticalSize).perform();
		 */

		element.click();
	}

	// other methods
	// 1.
	// https://www.360logica.com/blog/multiple-ways-to-scroll-a-page-using-selenium-webdriver/
	// 2.
	// https://stackoverflow.com/questions/12293158/page-scroll-up-or-down-in-selenium-webdriver-selenium-2-using-java

	@Test(description = "scrcoll to bottom of the page")
	public void scrollToBottomOrTop() {
		driver.get("http://openmaterials.org/");
		String xpath = "//*[@id=\"content_container\"]/div[2]/p/span/a/img";
		WebElement element = driver.findElement(By.xpath(xpath));

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		// scroll to bottom
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		// scroll to top
		js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");

		// scroll to top antoher method
		((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight,0)");

		element.click();
	}

	@Test
	public void scrollHorizontally() {
		// If you want to scroll horizontally in the right direction, use the following
		// JavaScript.
		((JavascriptExecutor) driver).executeScript("window.scrollBy(2000,0)");

		// If you want to scroll horizontally in the left direction, use the following
		// JavaScript.
		((JavascriptExecutor) driver).executeScript("window.scrollBy(-2000,0)");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
