package com.Hrms.tests;

import org.testng.annotations.Test;
import com.Hrms.base.BasePage;
import com.Hrms.pages.LoginPage;
import com.Hrms.utils.CommonUtils;
import com.Hrms.utils.TestNGUtility;
import com.microsoft.playwright.Page;

public class TestLoginPage extends BasePage {

	
	LoginPage loginPage = new LoginPage();

	@Test(description = "Verify LoginPage", priority = 0)
	public void verifyLoginPage() {

		// Perform login
		loginPage.login();

		// Optional wait (Playwright auto-waits in most cases)
		CommonUtils.hardWait(3);

		// Assertion
		TestNGUtility.assertTrue(CommonUtils.getElementText(loginPage.getWelcomeText()), "Welcome selenium");

		System.out.println("verifyLoginPage executed successfully");
	}
}
