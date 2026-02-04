package com.pages;

public class PIMPage{
	private String pim = "//*[@id=\"pim\"]";
	private String add_emp="//*[@id=\"pim\"]/ul/li[2]/a/span";
	private String iframe = "#rightMenu";
	private String firstName = "//input[@id='txtEmpFirstName']";
	private String lastName = "//input[@id='txtEmpLastName']";
	
	private String saveButton = "//input[@id='btnEdit']";
	private String editButton = "//input[@id='btnEditPers']";
	private String smokeCheckBox="//input[@id='chkSmokeFlag']";
	private String radioButtonsonGender="//input[@class='formRadio']";
	private String saveInPersonalDetails="//input[@id='btnEditPers']";
	private String backButton = "//input[@class='backbutton']";
	private String searchByDropdown ="//select[@id='loc_code']";
	private String searchFor="//input[@id='loc_name']";
	private String searchButton="//input[@value='Search']";
	private String addEmployeeText="//a[contains(text(),'k')]";
	public String getPIM()
	{
		return pim;
	}
	public String getAddEmp()
	{
		return add_emp;
	}
	public String getFrame()
	{
		return iframe;
	}
	public String getFirstName() 
	{
		
		return firstName ;
		
	}
	public String getLastName()
	{
		
		return lastName;
	}
	
	public String getSaveButton()
	{
		
		return saveButton;
	}
	public String getEditbutton()
	{
		return editButton;
	}
	public String getSmokerChkBox()
	{
		return smokeCheckBox;
	}
	public String getRadioButtonsOnGender()
	{
		return radioButtonsonGender;
	}
	public String getSavaInPersonalDetails()
	{
		return saveInPersonalDetails;
	}
	public String getBackButton()
	{
		return backButton;
	}
	public String getSearchByDropdown()
	{
		return searchByDropdown;
	}
	public String getSearchFor()
	{
		return searchFor;
	}
	public String getSearchButton()
	{
		return searchButton;
	}
	public String verifyAddEmployeeText() 
	{
		return addEmployeeText;
	}

}
