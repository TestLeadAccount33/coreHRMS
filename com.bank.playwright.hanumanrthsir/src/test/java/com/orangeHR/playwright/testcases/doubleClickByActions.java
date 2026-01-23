package com.orangeHR.playwright.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class doubleClickByActions {
	Page page;
  @Test
  public void f() {
	  Playwright playwright = Playwright.create();
		Browser browser= playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
	    page = browser.newPage();
	    page.navigate("file:///C:/Users/Dell/Downloads/doubleClickMe.html");
	    page.locator("xpath=/html/body/button").dblclick();
	   String text = page.locator("#field2").inputValue(); //Hello World!
	   System.out.println(text);
	   if(text.equals("Hello World!"))
	   {
		   System.out.println("dublclilk is perform sucessfully");
	   }
	   else
	   {
		   System.out.println("dublclilk is perform  not sucessfully");
	   }
		   
		   
	   
	    
	    }
  @BeforeClass
  public void beforeClass() {
	  Playwright playwright = Playwright.create();
		Browser browser= playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
	    page = browser.newPage();
	    
	  
  }

  @AfterClass
  public void afterClass() {
	  page.close();
  }

}
