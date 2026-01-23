package com.pages;

public class PIMPage{
	private String pim = "//*[@id=\"pim\"]";
	private String add_emp="//*[@id=\"pim\"]/ul/li[2]/a/span";
	
	public String getPIM()
	{
		return pim;
	}
	public String getAddEmp()
	{
		return add_emp;
	}

}
