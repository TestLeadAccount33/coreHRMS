package com.Hrms.pages;

import com.Hrms.utils.CommonUtils;
import com.Hrms.utils.TestNGUtility;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage {



    // Locators (NON-static)
    private String usernameInputLocator="input[name='txtUserName']";
    private String passwordInputLocator="input[name='txtPassword']";
    private String loginButtonLocator="input[name='Submit']";
    private String welcomeTextLocator= "xpath=//li[text()='Welcome selenium']";
    private String logoutLocator= "xpath=//li[text()='Logout']";

    /*
    // Constructor
    public LoginPage(Page page) {
        this.page = page;

        usernameInputLocator = "input[name='txtUserName']";
        passwordInputLocator ="input[name='txtPassword']";
        loginButtonLocator ="input[name='Submit']";
        welcomeTextLocator = "xpath=//li[text()='Welcome selenium']";
        logoutLocator = "xpath=//li[text()='Logout']";
    }
*/
    // ---------------- Helping functions ----------------

    public void login() {
        try {
            CommonUtils.enterValue(enterUsername(), "selenium");
            CommonUtils.enterValue(enterPassword(), "selenium");
            CommonUtils.clickElement(clickLoginButton());
        } catch (Exception e) {
            TestNGUtility.assertFail(e.getMessage());
        }
    }

    public String enterUsername() {
        return usernameInputLocator;
    }

    public String enterPassword() {
        return passwordInputLocator;
    }

    public String clickLoginButton() {
        return loginButtonLocator;
    }

    public String getWelcomeText() {
        return welcomeTextLocator;
    }

    public String clickLogout() {
        return logoutLocator;
    }
}
