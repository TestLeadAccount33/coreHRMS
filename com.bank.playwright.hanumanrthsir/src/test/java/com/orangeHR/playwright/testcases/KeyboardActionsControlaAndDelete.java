package com.orangeHR.playwright.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class KeyboardActionsControlaAndDelete {
	Page page;
	Browser browser;
  @Test
  public void ctrlADeleteFromKeyBoard() {
	  
	    page.navigate("http://127.0.0.1/orangehrm-2.5.0.2/login.php");
	    page.locator("[name='txtUserName']").fill("playright");
	    page.keyboard().press("Control+A"); //select all
	    page.keyboard().press("Delete");    //delete
	    page.locator("[name='txtUserName']").fill("playright"); // type
	    page.locator("[name='txtPassword']").fill("playwright");
	    page.locator("[name='Submit']").press("Enter"); //click();
	    
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
