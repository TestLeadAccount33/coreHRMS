package com.orangeHR.playwright.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class dragAndDropByActions {
	Page page;
  @Test
  public void dragAndDrop(){
	  
	  //operation code, use dragTo() for drag and drop
	  page.locator("#draggable").dragTo(page.locator("#droppable"));
	  // identify text ,get it from application
	  String text = page.locator("xpath=//*[@id=\"droppable\"]/p").textContent();
	 
	  //print it
	  System.out.println(text); //Dropped!
	  
	  // verification code ,verify it whether the text is matched with expected text
	  if(text.equals("Dropped!"))
	  {
		  System.out.println("DragAndDrop is successfully done");
	  }
	  else
	  {
		  System.out.println("DragAndDrop is not successfully done");
	  }
	  
  }
  @BeforeClass
  public void beforeClass() {
	Playwright playwright = Playwright.create();
	Browser browser= playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
    page = browser.newPage();
    page.navigate("https://jqueryui.com/resources/demos/droppable/default.html");
	
  }

  @AfterClass
  public void afterClass() {
	  page.close();
  }

}
