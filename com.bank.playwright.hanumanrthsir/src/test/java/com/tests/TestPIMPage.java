package com.tests;

import org.testng.annotations.Test;

import com.basepack.BasePage;
import com.pages.LoginPage;
import com.pages.PIMPage;
import com.util.CommonUtils;
import com.util.TestngUtils;

public class TestPIMPage extends BasePage {
	 LoginPage   loginPage = new LoginPage();
	 PIMPage     pimPage = new PIMPage();
	
  @Test
  public void addEmployeeThenVerify() {
	  
	  loginPage.login();
	  
	  
	 TestngUtils.assertTrue(CommonUtils.getElementText(loginPage.verifyWelcomeText()),"Welcome selenium");
	 System.out.println("Succefully");
  }
}
