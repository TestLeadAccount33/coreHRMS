package com.util;

import java.io.FileInputStream;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.pages.LoginPage;

public class CommonUtils {
	public static FileInputStream fil;
	public static Properties config;
	public static Playwright playwright;
	public static Browser browser;
	public static Page page;
	public static LoginPage loginpage;
	
	
	// ---------------------Read the propertie file -----------------------------
	public static void readPropertiesFile()//(Discretion: read the config.properties file)
	{
		try
		{
			// Access the config.properties file into working environment
		   fil = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\util\\CommonUtils.java");
		   // Create a memory for that config.properties file
		 config =  new Properties();
		   // Store config.properties file in an memory space
		 config.load(fil);
		}
		catch(Exception e)
		{
			
		}
		
	}
	 // ---------------- Browser-------------------------
	public static void launchBrowser()
	{
		// Launch the browser
		String browserName = config.getProperty("browser");// output : "firefox"
		
		switch(browserName.toUpperCase())
		{
		case "CHROME" :
			 playwright =Playwright.create();
			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			 break;
		case "FIREFOX" :
			 playwright =Playwright.create();
			 browser =playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
			 break;
		case "EDGE" :
			 playwright =Playwright.create();
			 browser =playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			 break;
		default:
			TestngUtils.assertFail("Invaild browser name");
			
		}
	
		 page = browser.newPage();
		page.navigate(config.getProperty("TestSiteName"));
	}
		//-------------------Basic Action---------------------------------
		
		
		public static void enterValue(String selector, String value)
		{
			
			 
			try {
				 findElement(selector).clear();
				findElement(selector).fill(value);
			}
			catch (Exception e)
			{
				TestngUtils.assertFail(e.getMessage());
			}
	
		
			
		}
		
		public static Locator findElement(String selector)
		{
			Locator element = null;
			
			try
			{
				 element = page.locator(selector); 
			}
			catch (Exception e)
			{
				TestngUtils.assertFail(e.getMessage());
			}
			return element;
		}
		
		public static void clickElement(String selector)
		{
			try
			{
				findElement(selector).click();
			}
			catch(Exception e)
			{
				TestngUtils.assertFail(e.getMessage());
			}
		}
		
		public static String getElementText(String selector)
		{
			String elementText =null;
			try
			{
				elementText = findElement(selector).textContent();
			}
			catch(Exception e)
			{
				TestngUtils.assertFail(e.getMessage());
			}
			return elementText;
		}
		
		
		
	

			
	

	
		
	}
	
	

	
	


