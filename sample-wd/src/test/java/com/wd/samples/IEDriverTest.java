package com.wd.samples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class IEDriverTest {
  @Test
  public void f() {
	//System.setProperty("webdriver.ie.driver",path of executable file "IEDriverServer.exe")
      System.setProperty("webdriver.ie.driver", "drivers/IEDriverServer.exe");
      //Initialize InternetExplorerDriver Instance.
      WebDriver driver = new InternetExplorerDriver();
      driver.get("https://www.softwaretestingmaterial.com/software-testing-interview-questions-free-ebook/");
      System.out.println("Selenium Webdriver Script in Internet Explorer browser | Software Testing Material");
      driver.close();
  }
}
