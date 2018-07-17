package com.wd.servicetests2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestUI_Test {
	public static final Environment.DriverToUse USED_DRIVER = Environment.DriverToUse.CHROME;

	@Test
	public void testVersionNumber() throws Exception{

	    TestUI testUI= new TestUI(USED_DRIVER);
	    testUI.getDriver().get("http://www.google.com");
	    WebElement version = testUI.getDriver().findElement(By.name("btnI"));
	    version.click();
	}
	
	@Test
	public void testVersionNumber2() throws Exception{

	    TestUI testUI= new TestUI(USED_DRIVER);
	    testUI.getDriver().get("http://www.google.com");
	    WebElement version = testUI.getDriver().findElement(By.name("btnI"));
	    version.click();
	}
}
