package com.util;

import java.io.FileInputStream;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.MouseButton;
import com.pages.LoginPage;

public class CommonUtils {
	public static FileInputStream fil;
	public static Properties config;
	public static Browser browser;
	public static Playwright playwright;
	
	public static Page page;
	public static LoginPage loginpage;
	
	
	// ---------------------Read the propertie file -----------------------------
	public static void readPropertiesFile()//(Discretion: read the config.properties file)
	{
		try
		{
			
			// Access the config.properties file into working environment
		   fil = new FileInputStream("C:\\Users\\Dell\\git\\localrepository\\com.bank.playwright.hanumanrthsir\\src\\test\\resource\\config.properties");
		   // Create a memory for that config.properties file
		   config =  new Properties();
		  
		   // Store config.properties file in an memory space
		 config.load(fil);
		}
		catch(Exception e)
		{
			TestngUtils.assertFail(e.getMessage());
		}
		
	}
	 // ---------------- Browser-------------------------
	public static void launchBrowser() throws  InterruptedException{
	
		// Launch the browser
		String browserName = config.getProperty("browser");// output : "firefox"
		
		switch(browserName)
		{
	/*	case "CHROME" :
			 playwright =Playwright.create();
			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			 break; */
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
		
		//----------------------Mouse Movement-----------------------------------//
		      //----------------MouseHover---------------//
		public static void moveToElement(String selector)
		{
			try 
			{
				findElement(selector).hover();
			}
			catch(Exception e)
			{
				TestngUtils.assertFail(e.getMessage());
			}
			
		}
		      //---------------doubleClick--------------//
		public static void doubleClickElement(String selector)
		{
			try
			{
				findElement(selector).dblclick();
			}
			catch(Exception e)
			{
				TestngUtils.assertFail(e.getMessage());
			}
		} 
		     //---------------rightClick-------------//
		public static void rightClickElement(String selector)
		{
			try
			{
				findElement(selector).click(new Locator.ClickOptions().setButton(MouseButton.RIGHT));
			}
			catch(Exception e)
			{
				TestngUtils.assertFail(e.getMessage());
			}
		}
		     //------------------dragAndDrop-----------//
		public static void drapAndDrop(String selector1 , String selector2)
		{
			try
			{
				findElement(selector1).dragTo(findElement(selector2));
			}
			catch(Exception e)
			{
				TestngUtils.assertFail(e.getMessage());
			}
		}
		
		//-------------------------------Keyboard Actions----------------------------------//
		    //--------------------pressEnterKey------------------------//
		public static void pressEnterKey()
		{
			try
			{
				page.keyboard().press("Enter");
			}
			catch(Exception e)
			{
				TestngUtils.assertFail(e.getMessage());
			}
		}
		    //----------------------pressTabKey---------------------//
		public static void pressTabKey()
		{
			try
			{
				page.keyboard().press("Tab");
			}
			catch(Exception e)
			{
				TestngUtils.assertFail(e.getMessage());
			}
		}
		 public static void pressDelect()
		 {
			 try
			 {
				 page.keyboard().press("Delete");
			 }
			 catch(Exception e)
			 {
				 TestngUtils.assertFail(e.getMessage());
			 }
		 }
		 
		 public static void pressBackspace()
		 {
			 try
			 {
				 page.keyboard().press("Backspace");
			 }
			 catch(Exception e)
			 {
				 TestngUtils.assertFail(e.getMessage());
			 }
		 }
		 
		 public static void pressArrowDown()
		 {
			 try
			 {
				 page.keyboard().press("ArrowDown");
			 }
			 catch(Exception e)
			 {
				 TestngUtils.assertFail(e.getMessage());
			 }
		 }
		 public static void pressArrowUp()
		 {
			 try
			 {
				 page.keyboard().press("ArrowUp");
			 }
			 catch(Exception e)
			 {
				 TestngUtils.assertFail(e.getMessage());
			 }
		 }
			 public static void pressControlA()
			 {
				 try
				 {
					 page.keyboard().press("Control+A");
				 }
				 catch(Exception e)
				 {
					 TestngUtils.assertFail(e.getMessage());
				 }
			 }
			 
			 public static void pressControlC()
			 {
				 try
				 {
					 page.keyboard().press("Control+C");
				 }
				 catch(Exception e)
				 {
					 TestngUtils.assertFail(e.getMessage());
				 }
			 }
			 public static void pressControlv()
			 {
				 try
				 {
					 page.keyboard().press("Control+V");
				 }
				 catch(Exception e)
				 {
					 TestngUtils.assertFail(e.getMessage());
				 }
			 }
			 public static void pressShiftA()
			 {
				 try
				 {
					 page.keyboard().press("Shift+a");
				 }
				 catch(Exception e)
				 {
					 TestngUtils.assertFail(e.getMessage());
				 }
			 }
			 public static void pressDownShift()
			 {
				 try
				 {
					 page.keyboard().down("Shift");
				 }
				 catch(Exception e)
				 {
					 TestngUtils.assertFail(e.getMessage());
				 }
			 }
			 public static void pressUpShift()
			 {
				 try
				 {
					 page.keyboard().up("Shift");
				 }
				 catch(Exception e)
				 {
					 TestngUtils.assertFail(e.getMessage());
				 }
			 }
	
		 
		 
		
		
		
		
	

			
	

	
		
}
	
	

	
	


