package com.orangeHR.playwright.testcases;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class NewTest1 {
	Page driver;	
  @Test
  public void verifyWelcomePage() {
	  //oparational code
	  String title = driver.title();//OrangeHRM - New Level of HR Management
	  System.out.println(title);
	  //verification code
	  if(title.equals("OrangeHRM - New Level of HR Management"))
	  {
		  System.out.println("title page is succesfull");
	  }
	  else
	  {
		 System.out.println("not successfull"); 
	  }
	  driver.locator("[name='txtUserName']").fill("playwright");
	  driver.locator("[name='txtPassword']").fill("playwright");
	  driver.locator("[name='Submit']").click();
	 
	 String text = driver.locator("xpath=//*[@id=\"option-menu\"]/li[1]").textContent();//Welcome playwright
	 System.out.println(text); 
	 if(text.equals("Welcome playwright"))
	 {
		 System.out.println("Verified welcome page");
	 }
	 else
	 {
		 System.out.println(" Not verified welcome page ");
	 }
	 driver.locator("xpath=//*[@id=\"option-menu\"]/li[3]/a").click();
  }
  @BeforeClass
  public void beforeClass() {
	   Playwright playwright = Playwright.create() ; 
	   Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions()

               .setHeadless(false)




);
	    driver =browser.newPage();
	   driver.navigate("http://127.0.0.1/orangehrm-2.5.0.2/login.php");
	                                                  
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
