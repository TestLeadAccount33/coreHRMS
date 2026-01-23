package com.orangeHR.playwright.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class KeyboardActionsCopyPast {
	Page page;
  @Test
  public void useCoptPastFromKeyboard() {
	    page.navigate("http://127.0.0.1/orangehrm-2.5.0.2/login.php");
	    page.locator("[name='txtUserName']").fill("playright");
	    page.keyboard().press("Control+A");
	    page.keyboard().press("Control+C");
	    page.keyboard().press("Tab");
	    page.keyboard().press("Control+V");
	    page.keyboard().press("Tab");
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
