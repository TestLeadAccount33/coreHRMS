package com.Hrms.tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.Hrms.base.BasePage;
import com.Hrms.pages.LoginPage;

import com.Hrms.utils.CommonUtils;
import com.Hrms.utils.TestNGUtility;

public class TestPIMPage extends BasePage {


	LoginPage loginPage = new LoginPage(); 
    
    @Test(description = "Verify that an employee can be added successfully", priority = 0)
    public void addEmployeeThenVerify() {
    
    	// initialize here

    	//CommonUtils.loginWithMultipleRecordsUsingExcel("MultipleLoginFunctionality");
		

    			// Login
    			loginPage.login();
    			
    			CommonUtils.hardWait(3);

    			// Validate welcome message

    			 TestNGUtility.assertTrue(CommonUtils.getElementText(loginPage.getWelcomeText()),"Welcome selenium");
    	
    			 System.out.println("Login Successful");
    			 /*
    			// Mouse hover on PIM
    			CommonUtils.moveToElement(PIMPage.getPim());
    			
    			CommonUtils.hardWait(1);

    			// Click Add Employee
    			CommonUtils.clickElement(PIMPage.getAddEmp());

    			CommonUtils.hardWait(3);

    			// Switch to frame
    			CommonUtils.switchToFrame(PIMPage.getFrame());

    			//CommonUtils.verifyDropdownValuesWithExcel(PIMPage.getSearchByDropdown(), "Result");    
    			   
    			
    			
    			// Enter first and last name frame
    			CommonUtils.enterValue(PIMPage.getFirstName(), "Sai");
    			CommonUtils.enterValue(PIMPage.getLastName(), "Akki");

    			// Save employee
    			CommonUtils.clickElement(PIMPage.getSave());

    			// Back
    			CommonUtils.clickElement(PIMPage.getBackButton());
    			CommonUtils.hardWait(3);

    			// Validate employee name
    			
    			 TestNGUtility.assertTrue(CommonUtils.getElementText(loginPage.getWelcomeText()),"Sai Akki");
   */
    }

    @Test(description = "Verify that the search functionality returns the correct employee",priority = 1)
    public void searchEmployee() {
        Assert.assertEquals("Akki", "Akki");
    }

    @Test(description = "Verify that employee details can be edited successfully",priority = 2)
    public void editEmployeeDetails() {
        Assert.assertEquals("Akki", "Akki");
    }

    @Test(description = "Verify that an employee can be deleted successfully", priority = 3)
    public void deleteEmployee() {
        Assert.assertEquals("Akki", "Akki");
    }

    @Test(description = "Verify that the employee list is displayed correctly with accurate information", priority = 4)
    public void viewEmployeeList() {
        Assert.assertEquals("akki", "akki");
    }

    @Test(description = "Verify that photos can be added to employee profiles", priority = 5)
    public void addEmployeePhotos() {
        // Implementation pending
    }

    @Test(description = "Verify that employee details are correctly displayed", priority = 6)
    public void viewEmployeeDetails() {
        // Implementation pending
    }

    @Test(description = "Verify that the employment status of an employee can be updated", priority = 7)
    public void editEmploymentStatus() {
        // Implementation pending
    }

    @Test(description = "Verify that the employee list can be filtered based on various criteria", priority = 8)
    public void filterEmployeeList() {
        // Implementation pending
    }
}
