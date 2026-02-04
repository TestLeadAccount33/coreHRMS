package com.orangeHR.playwright.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class SingleCheckBoxAndRadioButton {
	Page page;
  @Test
  public void singleCheckBox() {
	  //Identify Slected checkBox
	Locator checkBox1= page.locator("//input[@id='vfb-6-0']");
	  //click on it
	checkBox1.click();
	  //Verify whether the checkbox is selected or not by using isChecked() and using if else for verification
	if(checkBox1.isChecked())
	{
		System.out.println("CheckBox1 is selected");
	}
	else
	{
		System.out.println("CheckBox1 is not selected");
	}
	  
  }
  @Test
  public void singleRadioButton()
  {
	Locator radioButton1 = page.locator("//input[@id='vfb-7-1']");
	radioButton1.click();
	if(radioButton1.isChecked())
	{
		System.out.println("RadiButton1 is selected");
	}
	else
	{
		System.out.println("RadiButton1 is not selected");
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
