package com.Hrms.base;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.Hrms.utils.CommonUtils;
import com.microsoft.playwright.Page;

public class BasePage {
	
	public Page page;


	@BeforeTest
	public void setup() throws InterruptedException {

		// Load config properties
		CommonUtils.readPropertiesFile();

		// Start Playwright browser
		CommonUtils.startBrowser();
	}

	@AfterTest
	public void tearDown() {

		// Close Playwright browser
	//	page.close();
	}
}
