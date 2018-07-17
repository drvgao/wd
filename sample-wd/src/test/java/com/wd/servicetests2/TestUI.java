package com.wd.servicetests2;

import java.awt.Toolkit;
import java.io.File;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class TestUI {
	private WebDriver driver;

	public TestUI(Environment.DriverToUse drv) {
		switch (drv) {
		case CHROME: {
			ChromeDriverService service = ChromeDriverService.createDefaultService();
			File file;
			try {
				file = new File(TestUI.class.getResource("drivers/chromedriver.exe").toURI());
			
			System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, file.getAbsolutePath());
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			driver = new ChromeDriver(service, options);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			break;
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
		}
		case FIREFOX: {
			driver = new FirefoxDriver();
			driver.manage().window().setPosition(new Point(0, 0));
			java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			Dimension dim = new Dimension((int) screenSize.getWidth(), (int) screenSize.getHeight());
			driver.manage().window().setSize(dim);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			break;
		}
		}

	}

	public WebDriver getDriver() {
		return driver;
	}
}
