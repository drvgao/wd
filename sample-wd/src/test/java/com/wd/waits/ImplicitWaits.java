package com.wd.waits;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/***
 * Explicit wait: WebDriverWait.until(condition-that-finds-the-element);
 * 
 * Implicit wait: driver.manage().timeouts().implicitlyWait(10,
 * TimeUnit.SECONDS);
 * 
 * In other words, explicit is associated with some condition to be held,
 * whereas implicit with some time to wait for something.
 * 
 * Fluent wait: check element for every s-sec till t-sec 's is sub set of t'.
 * 
 * @author RDURGAM
 *
 */
public class ImplicitWaits {
	WebDriver driver;

	@BeforeClass
	public void init() {
		driver = new FirefoxDriver();
	}

	/***
	 * syntax: driver.manage().timeouts().implicitlyWait(TimeOut, TimeUnit.SECONDS);
	 * 
	 * wait for a certain amount of time before throwing an exception that it cannot
	 * find the element on the page. We should note that implicit waits will be in
	 * place for the entire time the browser is open. This means that any search for
	 * elements on the page could take the time the implicit wait is set for.
	 */
	@Test(description = "Implicit Wait example.")
	public void implicitWaitTest() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/test/guru99home/");
		driver.manage().window().maximize();

		// implicit wait check, waits for 10secs to find element and click
		driver.findElement(By.name("notAvailableNameForTest")).click();
	}

	@Test(description = "Fluent wait.")
	public void fluentWaitTest() {
		findElement(driver, By.name("adf"), 10);
	}

	// fluent wait check for every 500 milliseconds till timeoutSeconds value
	private static WebElement findElement(final WebDriver driver, final By locator, final int timeoutSeconds) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(timeoutSeconds, TimeUnit.SECONDS)
				.pollingEvery(500, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);

		return wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver webDriver) {
				return driver.findElement(locator);
			}
		});
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
