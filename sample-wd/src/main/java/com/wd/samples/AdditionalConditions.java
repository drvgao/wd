package com.wd.samples;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class AdditionalConditions {
	 public static ExpectedCondition<Boolean> angularHasFinishedProcessing() {
	        return new ExpectedCondition<Boolean>() {
	            @Override
	            public Boolean apply(WebDriver driver) {
	            	System.out.println("I'm here................");
	            	return Boolean.valueOf(((JavascriptExecutor) driver).executeScript("angular.getTestability(document.body).whenStable(function(){console.log('completed')})").toString());
	            }
	        };
	    }
}
