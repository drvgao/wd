package com.wd.servicetests2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestUI_Test2 {
	public static final Environment.DriverToUse USED_DRIVER = Environment.DriverToUse.FIREFOX;

	@Test
	public void testVersionNumber() throws Exception{

	    TestUI testUI= new TestUI(USED_DRIVER);
	    WebElement version = testUI.getDriver().findElement(By.id("the Id of element"));
	    version.click();
	}
	
	@Test
	public void testVersionNumber2() throws Exception{

	    TestUI testUI= new TestUI(USED_DRIVER);
	    WebElement version = testUI.getDriver().findElement(By.id("the Id of element"));
	    version.click();
	}
}
