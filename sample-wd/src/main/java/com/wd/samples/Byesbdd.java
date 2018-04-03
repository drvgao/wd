package com.wd.samples;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
public class Byesbdd extends By{
	private final String essBddId;
    public Byesbdd(String essBddId)
    {
        this.essBddId = essBddId;
    }

    @Override
    public List<WebElement> findElements(SearchContext context) 
    {
         List<WebElement> mockElements = context.findElements(By.xpath(essBddId));
         return mockElements;
    }
}
