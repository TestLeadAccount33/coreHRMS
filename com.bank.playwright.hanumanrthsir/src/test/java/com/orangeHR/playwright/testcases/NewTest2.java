package com.orangeHR.playwright.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class NewTest2 {
	Page  driver;
  @Test
  public void verifyTitle() {
	// Verify tittle[get,print and verify]
      // 1. get
   String  title = driver.title();  //OrangeHRM - New Level of HR Management
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
   driver.locator("[name ='txtUserName']").fill("playwright");
//Identify and Enter password
   driver.locator("[name ='txtPassword']").fill("playwright");
//Identify and click on login
   driver.locator("[name ='Submit']").click();
   
// verify welcome page[identify,get,print and verify]
   // idetify and get text
  String text = driver.locator("xpath=//*[@id=\"option-menu\"]/li[1]").textContent();
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
// logout orangeHrm
    // Identify and click on logout
    driver.locator("xpath=//*[@id=\"option-menu\"]/li[3]/a").click();
	  
	  
  }
  @BeforeClass
  public void loginBrowser() {
// Start Playwright engine
	  Playwright playwright = Playwright.create();//
// lanuch browser(firefox) 
       Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
// Open a newPage (tab) in firefox browser
        driver =browser.newPage();
// Navigate the application Url
      driver.navigate("http://127.0.0.1/orangehrm-2.5.0.2/login.php");

	  
	  
  }

  @AfterClass
  public void closeBroeser() {
	  driver.close();
  }

}
