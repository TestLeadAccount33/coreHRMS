package com.orangeHR.playwright.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.MouseButton;

public class RightClickByAtions {
	Page page;
  @Test
  public void f() {
	  page.navigate("https://demoqa.com/buttons");
	  page.locator("#rightClickBtn").click(new Locator.ClickOptions().setButton(MouseButton.RIGHT));
	  String text =  page.locator("#rightClickMessage").textContent(); //You have done a right click
	  System.out.println(text);
	  if(text.equals("You have done a right click"))
	  {
		  System.out.println("right click text is verified");
	  }
	  else
	  {
		  System.out.println("right click text is not verified");
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
