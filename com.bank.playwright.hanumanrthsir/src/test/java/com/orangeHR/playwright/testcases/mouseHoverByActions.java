package com.orangeHR.playwright.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class mouseHoverByActions {
	Page page;
  @Test
  public void mouseHoverByMouse() throws InterruptedException {
	// Verify tittle[get,print and verify]
      // 1. get
   String  title = page.title();  //OrangeHRM - New Level of HR Management
     //  2. print
   System.out.println("Print title : "+title);
    // 3. verify
   if(title.equals("OrangeHRM - New Level of HR Management"))
   {
	   System.out.println("Verify title is successfull");
   }
   else
   {
	   System.out.println("Not Verify title is successfull");
   }
  
// Identify and Enter username
   page.locator("[name ='txtUserName']").fill("playwright");
//Identify and Enter password
   page.locator("[name ='txtPassword']").fill("playwright");
//Identify and click on login
   page.locator("[name ='Submit']").click();
   
// verify welcome page[identify,get,print and verify]
   // idetify and get text
  String text = page.locator("xpath=//*[@id=\"option-menu\"]/li[1]").textContent();
  // print
  System.out.println("Print text :"+text);
  //verify
    if(text.equals("Welcome playwright"))
    {
    	System.out.println(" text verify successfully");
    }
    else
    {
    	System.out.println("text verify not successfully");
    }

//---------------------mouse hover---------------------------
    page.locator("#pim").hover();
    //wait 5 seconds
    Thread.sleep(5000);
    //identify add employee & click
    page.locator("xpath=/html/body/div[4]/ul/li[2]/ul/li[2]/a/span").click();
    
 // --------------------logout orangeHrm-----------------------
    // Identify and click on logout
    page.locator("xpath=//*[@id=\"option-menu\"]/li[3]/a").click();
    
  }
  @BeforeClass
  public void beforeClass() {
	// Start Playwright engine
		  Playwright playwright = Playwright.create();//
	// lanuch browser(firefox) 
	       Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
	// Open a newPage (tab) in firefox browser
	        page =browser.newPage();
	// Navigate the application Url
	      page.navigate("http://127.0.0.1/orangehrm-2.5.0.2/login.php");

		    
  }

  @AfterClass
  public void afterClass() {
	  page.close();
  }

}
