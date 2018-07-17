package com.wd.waits;

import java.util.List;

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

/**
 * also check https://www.seleniumhq.org/docs/04_webdriver_advanced.jsp
 * @author RDURGAM
 *
 */
public class BasicWaitTest {
	WebDriver driver;

	@BeforeClass
	public void init() {
		driver = new FirefoxDriver();
	}

	/***
	 * expected condition test with scroll.
	 * 
	 * Here WebDriver checking that an element is present on the DOM or not. That
	 * does not necessarily mean that the element is visible on the page.
	 */
	@Test(description = "ExpectedCondition test with element availability on DOM.")
	public void isElementOnDOM() {
		driver.get("http://openmaterials.org/");
		String xpath = "//*[@id=\"content_container\"]/div[2]/p/span/a/img";
		WebElement element = driver.findElement(By.xpath(xpath));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

		// ExpectedConditions will return true once the element is found in the DOM.
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));

		// then click on element
		element.click();
	}

	/***
	 * expected condition test with scroll to check element clickable.
	 * 
	 * Here WebDriver checking that an element is present on the DOM or not. That
	 * does not necessarily mean that the element is visible on the page.
	 */
	@Test(description = "ExpectedCondition test with element clickability.")
	public void isElementClickable() {
		driver.get("http://openmaterials.org/");
		String xpath = "//*[@id=\"content_container\"]/div[2]/p/span/a/img";
		WebElement element = driver.findElement(By.xpath(xpath));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

		// ExpectedConditions will return true once the element is found in the DOM.
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));

		// then click on element
		element.click();
	}

	/***
	 * check if the element is present or not on the page.
	 */
	@Test(description = "ExpectedCondition test with presence on page.")
	public void isElementOnPage() {
		driver.get("http://openmaterials.org/");
		String xpath = "//*[@id=\"content_container\"]/div[2]/p/span/a/img";
		WebElement element = driver.findElement(By.xpath(xpath));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

		// is element on page?
		List<WebElement> elements = driver.findElements(By.xpath(xpath));
		Boolean isPresent = elements.size() > 0;

		// then click on element
		element.click();
	}

	/***
	 * check if the element is present on the DOM of a page and visible. Visibility
	 * means that the element is not just displayed but also should also has a
	 * height and width that is greater than 0.
	 */
	@Test(description = "ExpectedCondition to test is element visible.")
	public void isElementVisible() {
		driver.get("http://openmaterials.org/");
		String xpath = "//*[@id=\"content_container\"]/div[2]/p/span/a/img";
		WebElement element = driver.findElement(By.xpath(xpath));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

		//method #1 is element visible
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

		//method #2 is element visible
		 wait.until(ExpectedConditions.visibilityOf(element));
		 
		 //method #2 is ALL element visible?
		 List<WebElement> linkElements = driver.findElements(By.xpath(xpath));
		  wait.until(ExpectedConditions.visibilityOfAllElements(linkElements));
		
		// then click on element
		element.click();
	}
	
	//get the element when visible
	public WebElement getWhenVisible(By locator, int timeout) {
	    WebElement element = null;
	    WebDriverWait wait = new WebDriverWait(driver, timeout);
	    element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	    return element;
	}

	//click the element when ready
	public void clickWhenReady(By locator, int timeout) {
	    WebDriverWait wait = new WebDriverWait(driver, timeout);
	    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
	    element.click();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
