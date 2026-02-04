package com.orangeHR.playwright.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class MultipleCheckboxesAndRadioButtons {
	Page page;
  @Test
  public void multipleCheckboxes() {
	   //Identify multiple same type elements by taking type attribute by using xpath 
	Locator checkboxes = page.locator("//input[@type='checkbox']");
	   // Count the chechboxes to know how many are there
	System.out.println("Count of the checkboxed :"+checkboxes.count());
	  // select and verify continuously or one by one what's why i use for loop
	for(int i=0;i<checkboxes.count();i =i+1)
	{
		  // get and click one by one
		checkboxes.nth(i).click();
		  // Verify if the check box is selected or not after click on element
		if(checkboxes.nth(i).isChecked())
		{
			System.out.println("CheckBox is selected");
		}
		else
		{
			System.out.println("CheckBox is not selected");
		}
	}
  }
  @Test
  
  public void multipleRadioButtons()
  {
	Locator  radioButtons =page.locator("//input[@type='radio']");
	System.out.println(radioButtons.count());
	for(int i=0; i<radioButtons.count(); i=i+1)
	{
		radioButtons.nth(i).click();
		
		if(radioButtons.nth(i).isChecked())
		{
			System.out.println("RadioButton is selected");
		}
		else
		{
			System.out.println("RadioButton is not selected");
		}
	}
  }
  @BeforeClass
  public void beforeClass() {
	  Playwright playwright = Playwright.create();
		Browser browser =playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
		page =browser.newPage();
		page.navigate("https://demo.guru99.com/test/radio.html");
  }

  @AfterClass
  public void afterClass() {
	  page.close();
  }

}
