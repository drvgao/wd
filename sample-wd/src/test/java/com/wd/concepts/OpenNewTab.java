package com.wd.concepts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Augmenter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OpenNewTab {
	WebDriver driver;
	WebDriver augmentedDriver;

	@BeforeClass
	public void init() {
		driver = new FirefoxDriver();
		augmentedDriver = new Augmenter().augment(driver);
	}

	@Test
	public void newTabTest() {
		driver.get("http://www.google.com/");
		String newTab = "window.open('about:blank','_blank');";
		((JavascriptExecutor) driver).executeScript(newTab);

	}

	@Test
	public void NewTabTestType2() {
		driver.get("http://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("stackoverflow webdriver");
		driver.findElement(By.name("btnK")).click();

		//Method #1 The code below will open the link in new Tab.
		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
		driver.findElement(By.xpath("//*[@id=\"rso\"]/div/div/div[1]/div/div/h3/a")).sendKeys(selectLinkOpeninNewTab);

		//Method #2 The code below will open empty new Tab.
		// String selectLinkOpeninNewTab2 = Keys.chord(Keys.CONTROL,"t");
		// driver.findElement(By.xpath("//*[@id=\"rso\"]/div/div/div[1]/div/div/h3/a")).sendKeys(selectLinkOpeninNewTab2);
	}
	
	
	@Test
	public void newTab3() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-extensions");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.navigate().to("https://google.com");     
		Robot robot;
		try {
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_T);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_T);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	/***
	 * working with multiple tabs
	 */
	public void newTabN() {
		driver.findElement(By.name("q")).sendKeys(Keys.CONTROL+ "t");        
		
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
