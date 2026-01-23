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
  public void addEmployeeThenVerify() throws InterruptedException {
	  
	  loginPage.login();
	  
	 


	 TestngUtils.assertTrue(CommonUtils.getElementText(loginPage.verifyWelcomeText()),"Welcome playwright");
	 System.out.println("Successfully");
	 
	// pimPage.getPIM();  // code meaning is "//*[@id=\"pim\"]"
     CommonUtils.moveToElement(pimPage.getPIM());  //identify and  mousehover on pim page
     
    // pimPage.getAddEmp();// code meaning is "//*[@id=\"pim\"]/ul/li[2]/a/span"
     CommonUtils.clickElement(pimPage.getAddEmp()); // identify and click
     Thread.sleep(5000);
     
  }
}
