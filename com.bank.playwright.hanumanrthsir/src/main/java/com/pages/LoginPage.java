package com.pages;

import com.basepack.BasePage;
import com.util.CommonUtils;
import com.util.TestngUtils;

public class LoginPage{
	
	private String usernameInputLocator ="input[name='txtUserName']";
	private String passwordInputLocator ="input[name='txtPassword']";
	private String loginButtonLocator = "input[name='Submit']";
	private String verifywelcomeText = "xpath=//*[@id=\"option-menu\"]/li[1]";
	private String logout ="xpath=//*[@id=\"option-menu\"]/li[3]/a";
	
	public void login()
	{
		try
		{
			CommonUtils.enterValue(enterUserName(),"playwright");
			CommonUtils.enterValue(enterPassword(),"playwright");
			CommonUtils.clickElement(clickLoginButton());
		}
		catch (Exception e)
		{
			TestngUtils.assertFail(e.getMessage());
		}
	}
	
	public String enterUserName()
	{
		return usernameInputLocator;
	}
	public String enterPassword()
	{
		return passwordInputLocator;
	}
	public String clickLoginButton()
	{
		return loginButtonLocator;
	}
	public String verifyWelcomeText()
	{
		return verifywelcomeText;
	}
	public String clickLogout()
	{
		return logout;
	}

}
