package com.basepack;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.util.CommonUtils;

public class BasePage {
	 
	@BeforeTest
	public void setUp()
	{ 
		// read the properties file
		CommonUtils.readPropertiesFile();
		//
		CommonUtils.launchBrowser();
	}
	
	@AfterTest
	public void teardown()
	{
		
	}
	

	

}
