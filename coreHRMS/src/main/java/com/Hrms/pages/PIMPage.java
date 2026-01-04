package com.Hrms.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class PIMPage {

    private Page page;

    // -------- Locators (NON-static) --------
    private Locator pim;
    private Locator addEmp;
    private Locator firstName;
    private Locator lastName;
    private Locator iframe;
    private Locator save;
    private Locator back;
    private Locator empName;

    private Locator singleCheckbox;
    private Locator singleRadio;

    private Locator countryDropdown;
    private Locator searchByDropdown;
    private Locator listBox;

    private Locator doubleClick;
    private Locator rightClick;
    private Locator dragSource;
    private Locator dragTarget;

    private Locator uploadFile;
    private Locator downloadFile;
    private Locator scrollTarget;

    // -------- Constructor --------
    public PIMPage(Page page) {
        this.page = page;

        this.pim = page.locator("//li[@id='pim']");
        this.addEmp = page.locator("//*[@id='pim']/ul/li[2]/a");
        this.firstName = page.locator("//input[@id='txtEmpFirstName']");
        this.lastName = page.locator("//input[@id='txtEmpLastName']");
        this.iframe = page.locator("//iframe[@id='rightMenu']");
        this.save = page.locator("//input[@id='btnEdit']");
        this.back = page.locator("//input[@class='backbutton']");
        this.empName = page.locator("//a[contains(text(),'Sai')]");

        this.singleCheckbox = page.locator("//input[@type='checkbox' and @id='chkSingle']");
        this.singleRadio = page.locator("//input[@type='radio' and @id='radioSingle']");

        this.countryDropdown = page.locator("//select[@id='country']");
        this.searchByDropdown = page.locator("//select[@id='loc_code']");
        this.listBox = page.locator("//select[@id='multiSelect']");

        this.doubleClick = page.locator("//button[@id='doubleClickMe']");
        this.rightClick = page.locator("//button[@id='rightClickMe']");
        this.dragSource = page.locator("//div[@id='dragSource']");
        this.dragTarget = page.locator("//div[@id='dragTarget']");

        this.uploadFile = page.locator("//input[@id='uploadFile']");
        this.downloadFile = page.locator("//a[@id='downloadBtn']");
        this.scrollTarget = page.locator("//div[@id='footerSection']");
    }

    // -------- GETTERS --------

    public Locator getPim() {
        return pim;
    }

    public Locator getAddEmp() {
        return addEmp;
    }

    public Locator getFirstName() {
        return firstName;
    }

    public Locator getLastName() {
        return lastName;
    }

    public Locator getFrame() {
        return iframe;
    }

    public Locator getSave() {
        return save;
    }

    public Locator getBackButton() {
        return back;
    }

    public Locator getEmpName() {
        return empName;
    }

    public Locator getSingleCheckbox() {
        return singleCheckbox;
    }

    public Locator getSingleRadio() {
        return singleRadio;
    }

    public Locator getCountryDropdown() {
        return countryDropdown;
    }

    public Locator getSearchByDropdown() {
        return searchByDropdown;
    }

    public Locator getListBox() {
        return listBox;
    }

    public Locator getDoubleClickElement() {
        return doubleClick;
    }

    public Locator getRightClickElement() {
        return rightClick;
    }

    public Locator getDragSource() {
        return dragSource;
    }

    public Locator getDragTarget() {
        return dragTarget;
    }

    public Locator getUploadFile() {
        return uploadFile;
    }

    public Locator getDownloadFile() {
        return downloadFile;
    }

    public Locator getScrollTarget() {
        return scrollTarget;
    }
}
