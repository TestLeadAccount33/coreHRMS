package com.orangeHR.playwright.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;

public class HandlingSingleFrame {
	Page page;
  @Test
  public void singleFrameHandling() {
	  
	// Navigate the application Url
      page.navigate("http://127.0.0.1/orangehrm-2.5.0.2/login.php");
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
    // Switch to Frame 
      //1.print dropdown values
        //1.Get the dropDown size
      FrameLocator frame = page.frameLocator("#rightMenu"); // By using Id to identify or switch to frame
    // Identify dropDown inside the frame 
      frame.locator("#loc_code").waitFor();  // wait until the dropdown is visible
      Locator dropDown = frame.locator("#loc_code"); //1.First,Identify dropdown
    //[ How to handle dropDown:- 1.print dropdown values, 2.select the dropDown value inside a frame, 3. verify selected value, 4.verify dropDown values.]
      //Print the dropdown values:-1. get the dropdown size 2. print all the dropdown values
       // Get the size of dropdown values:-1.First,Identify dropdown, 2.Next,Identify all the values from this dropdown
      Locator  dropList = dropDown.locator("option");  //2.Next,Identify all the values from this dropdown
      System.out.println("DropList: "+dropList.count()); //get the size 9
       // 2. print all the dropdown values
      for(int i=0;  i<dropList.count(); i=i+1)
      {
    	  System.out.println(dropList.nth(i).textContent());  // First get the element next element is converted to text then only print it.
      }
      
     //2.select the dropDown value inside a frame {1.identify frame, 2.identify dropdown, 3. select the one of the value from dropdown
      dropDown.selectOption(new SelectOption().setIndex(1));  // select the value by using Index from dropList by using selectOption() 
       // dropDown.selectOption(new SelectOption().setLabel("Emp. First Name")); // select the value by using Text
       // dropDown.selectOption(new SelectOption().setValue("2"));  // select the value by using value
      
     //3. verify selected value {get the text of selected value from dropdown and verify selected value}
      String selected_value =dropDown.locator("option:checked").textContent(); //Emp. ID
      System.out.println("Selected value: "+selected_value);
     //verify the text
      if(selected_value.equals("Emp. ID"))
      {
    	  System.out.println("Selected value verify successfully");
      }
      else
      {
    	  System.out.println("Selected value verify not succeseefully");
      }
      
      
      
   /*   page.frameLocator("[name='rightMenu']")// By using Name 
     // Identify all the Frames in a web page by using Index {tagname} and switch to frame which we required by using .nth() 
    //  page.frameLocator(iframe").nth(0) ;   // 
     // Identify by using css selector tagName[name='value'] or tagName[id='value']
      page.frameLocator("iframe[id='rightMenu']");
      page.frameLocator("iframe[name='rightMenu']");
      */
  }
  @BeforeClass
  public void beforeClass() {
	// Start Playwright engine
	  Playwright playwright = Playwright.create();//
// lanuch browser(firefox) 
       Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
// Open a newPage (tab) in firefox browser
        page =browser.newPage();


  }

  @AfterClass
  public void afterClass() {
	  page.close();
  }

}
