package com.wd.concepts;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Augmenter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ScreenShotTest {
	WebDriver driver;
	WebDriver augmentedDriver;

	@BeforeClass
	public void init() {
		driver = new FirefoxDriver();
		augmentedDriver = new Augmenter().augment(driver);
	}

	@Test
	public void screenshotTest() {
		driver.get("http://www.google.com/");
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("c:\\tmp\\screenshot.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void screenShotType2() {
		WebDriver augmentedDriver = new Augmenter().augment(driver);
		try {
			File scrFile = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("c:\\tmp\\screenshot2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
