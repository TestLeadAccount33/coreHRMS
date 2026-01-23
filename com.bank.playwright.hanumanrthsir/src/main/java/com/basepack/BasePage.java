package com.basepack;

import org.testng.annotations.BeforeTest;

import com.util.CommonUtils;

public class BasePage {

    @BeforeTest
    public void setUp() throws InterruptedException {
        CommonUtils.readPropertiesFile();
        CommonUtils.launchBrowser();
    }

 //   @AfterTest
 /*   public void tearDown() {
        if (CommonUtils.page != null) CommonUtils.page.close();
        if (CommonUtils.browser != null) CommonUtils.browser.close();
        if (CommonUtils.playwright != null) CommonUtils.playwright.close();
    }
}*/

//	@AfterTest
//	public void teardown()
//	{
//		
//	}
}
	

	


