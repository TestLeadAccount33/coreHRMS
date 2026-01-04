package com.Hrms.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.Hrms.pages.LoginPage;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.MouseButton;
import com.microsoft.playwright.options.SelectOption;
import com.microsoft.playwright.options.WaitForSelectorState;

public class CommonUtils {

	public static Playwright playwright;
	public static Browser browser;
	public static BrowserContext context;
	public static Page page;
	public static Properties config;
	public static FileInputStream fis;
	public static LoginPage loginPage;

	// ================= PROPERTIES =================

	public static void readPropertiesFile() {
		try {
			 fis = new FileInputStream("C:\\Users\\Hanumanthu\\OneDrive\\Pictures\\New folder (6)\\latest_paywright_POM\\coreHRMS\\src\\test\\resources\\config.properties");
			config = new Properties();
			config.load(fis);
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
	}

	// ================= BROWSER =================

	public static void startBrowser() throws InterruptedException {

		String browserName = config.getProperty("browser");
		
		
		switch (browserName.toUpperCase()) {

		case "CHROME":
			playwright = Playwright.create();
			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;

		case "FIREFOX":
			playwright = Playwright.create();
			browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;

		case "EDGE":
			playwright = Playwright.create();
			browser = playwright.chromium()
					.launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false));
			break;

		default:
			TestNGUtility.assertFail("Invalid browser name");
		}

	
		page = browser.newPage();
		page.navigate(config.getProperty("url"));
		//return page;
		
		
	}

	

	// ================= BASIC ACTIONS =================

	public static Locator findElement(String selector) {
		Locator element = null;
		try {
			element = page.locator(selector);
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
		return element;
	}

	public static List<Locator> findElements(String selector) {
		List<Locator> elements = null;
		try {
			elements = page.locator(selector).all();
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
		return elements;
	}

	public static String getElementText(String selector) {
		String text = null;
		try {
			text = page.locator(selector).textContent().trim();
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());

		}
		return text;
	}

	public static String getElementAttribute(String selector, String attribute) {
		String attrValue = null;
		try {
			attrValue = page.locator(selector).getAttribute(attribute);
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());

		}
		return attrValue;
	}

	public static void clickElement(Locator locator) {
		try {
			locator.click();
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
	}

	
	public static void switchToParentFrame() {
		try {
			page.mainFrame();
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
	}

	public static FrameLocator switchToFrame(String selector) {
		FrameLocator frame = null;
		try {
			Locator iframe = page.locator(selector);
			//frame = iframe.contentFrame();
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
		return frame;
	}
	/*
	public static Frame switchToFrameUsingElement(Locator iframe) {
		Frame frame = null;
		try {
			frame = iframe.contentFrame();
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
		return frame;
	}
*/
	public static Frame switchToFrameUsingIndex(int index) {
		Frame frame = null;
		try {
			List<Frame> frames = page.frames();
			frame = frames.get(index);
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
		return frame;
	}

	public static Page switchToParentWindow(Page parentPage) {
		try {
			parentPage.bringToFront();
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
		return parentPage;
	}

	public static void clickElement(String selector) {
		try {
			Locator element = page.locator(selector);
			element.click();
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
	}

	public static void enterValue(String selector, String value) {
		try {
			Locator element = findElement(selector);
			element.fill(value);
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
	}
	// ================= VERIFICATIONS =================

	public static void clickElementIfVisible(String selector) {
		try {
			Locator element = page.locator(selector);
			if (element.isVisible()) {
				element.click();
			}
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
	}

	public static void clickElementIfEnabled(String selector) {
		try {
			Locator element = page.locator(selector);
			if (element.isEnabled()) {
				element.click();
			}
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
	}

	public static void clearWholeText(String selector) {
		try {
			Locator element = page.locator(selector);
			element.fill("");
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
	}

	public static void selectDropDownValue(String selector, String option) {
		try {
			page.locator(selector).selectOption(option);
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
	}

	public static void selectDropDownIndex(String dropDownSelector, int index) {
		try {
			page.locator(dropDownSelector).selectOption(new SelectOption().setIndex(index));
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
	}

	public static void selectDropDownVisibleText(String dropDownSelector, String visibleText) {
		try {
			page.locator(dropDownSelector).selectOption(new SelectOption().setLabel(visibleText));
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
	}

	public static void verifySelectedValue(Locator dropdown, String expectedValue) {
		try {
			String actualValue = dropdown.inputValue().trim();

			if (actualValue.equals(expectedValue)) {
				System.out.println("PASS : Selected value verified → " + actualValue);
			} else {
				System.out.println("FAIL : Expected → " + expectedValue + " | Found → " + actualValue);
			}
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
	}

	public static void printAllDropdownValues(Locator dropdown) {
		try {
			List<String> options = dropdown.locator("option").allTextContents();

			System.out.println("Total options in dropdown: " + options.size());

			for (int i = 0; i < options.size(); i++) {
				System.out.println("Option: " + options.get(i).trim());
			}
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
	}

	public static void uploadFile(String selector, String filePath) {
		try {
			page.locator(selector).setInputFiles(Paths.get(filePath));
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
	}

	public static Download downloadFile(Locator locator) {
		Download download = null;
		try {
			download = page.waitForDownload(() -> locator.click());
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
		return download;
	}

	public static void isFileDownloaded(Download download, String expectedFileName) {
		try {
			Path filePath = download.path();
			File file = filePath.toFile();

			if (file.exists() && file.getName().equals(expectedFileName)) {
				System.out.println("File downloaded successfully: " + expectedFileName);
			} else {
				TestNGUtility.assertFail("Downloaded file validation failed");
			}
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
	}

	public static void uploadFile(Locator locator, String filePath) {
		try {
			locator.setInputFiles(Paths.get(filePath));
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
	}

	public static void selectDateFromCalendar(Locator dateElements, String dateValue) {
		try {
			List<Locator> dates = dateElements.all();

			for (int i = 0; i < dates.size(); i++) {
				String text = dates.get(i).innerText().trim();

				if (text.equals(dateValue)) {
					dates.get(i).click();
					break;
				}
			}
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
	}
/*
	public static void verifyListBoxMultipleSelection(Locator listBox, String value1, String value2) {
		try {
			// Select options by visible text
			listBox.selectOption(new SelectOption().setLabel(value1));
			listBox.selectOption(new SelectOption().setLabel(value2));

			// Check if the <select> allows multiple selections
			boolean isMultiple = listBox.evaluate("el => el.multiple").asBoolean();

			if (isMultiple) {
				System.out.println("Multiple selections are allowed.");
			} else {
				System.out.println("Multiple selections are NOT allowed.");
			}

		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
	}
*/
	public static void verifyElementSelected(Locator locator, String elementName) {
		try {
			if (locator.isChecked()) {
				System.out.println(elementName + " is selected.");
			} else {
				System.out.println(elementName + " is NOT selected.");
			}
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
	}

	public static void verifyMultipleSelection(Locator elements, String elementType) {
		try {
			List<Locator> allElements = elements.all();

			System.out.println("Total " + elementType + "s : " + allElements.size());

			for (int i = 0; i < allElements.size(); i++) {

				allElements.get(i).check();

				if (allElements.get(i).isChecked()) {
					System.out.println(elementType + " " + (i + 1) + " selected successfully");
				} else {
					System.out.println(elementType + " " + (i + 1) + " not selected");
				}
			}

		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
	}

	public static void verifyTooltipText(Locator locator, String expectedTooltip) {
		try {
			String actualTooltip = locator.getAttribute("title").trim();

			if (actualTooltip.equals(expectedTooltip)) {
				System.out.println("PASS : Tooltip text verified → " + actualTooltip);
			} else {
				System.out.println("FAIL : Expected → " + expectedTooltip + " | Found → " + actualTooltip);
			}

		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
	}

	public static void verifyDropdownUsingExcel(Locator dropdown, String excelPath, String sheetName) {

		try {
			// -------- Read dropdown values --------
			List<String> ddValues = dropdown.locator("option").allTextContents();

			ArrayList<String> dropdownValues = new ArrayList<>();
			for (String value : ddValues) {
				dropdownValues.add(value.trim());
			}

			// -------- Read Excel values --------
			FileInputStream fis = new FileInputStream(excelPath);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(sheetName);

			int totalRows = sheet.getLastRowNum() + 1;

			ArrayList<String> excelValues = new ArrayList<>();
			for (int i = 0; i < totalRows; i++) {
				excelValues.add(sheet.getRow(i).getCell(0).getStringCellValue().trim());
			}

			workbook.close();
			fis.close();

			// -------- Compare --------
			if (excelValues.size() == dropdownValues.size()) {

				for (int i = 0; i < excelValues.size(); i++) {

					if (excelValues.get(i).equals(dropdownValues.get(i))) {
						System.out.println("MATCH → " + excelValues.get(i));
					} else {
						System.out.println(
								"MISMATCH → Excel: " + excelValues.get(i) + " != Dropdown: " + dropdownValues.get(i));
					}
				}

			} else {
				System.out.println(
						"Size Mismatch → Excel: " + excelValues.size() + " Dropdown: " + dropdownValues.size());
			}

		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
	}

	public static void pressEnterKey(Locator locator) {
		try {
			locator.press("Enter");
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
	}

	public static void pressTabKey(Locator locator) {
		try {
			locator.press("Tab");
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
	}

	public static void doubleClickElement(Locator locator) {
		try {
			locator.dblclick();
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
	}

	public static void rightClickElement(Locator locator) {
		try {
			locator.click(new Locator.ClickOptions().setButton(MouseButton.RIGHT));
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
	}

	public static void clickElementUsingJS(Locator locator) {
		try {
			locator.evaluate("el => el.click()");
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
	}

	public static void enterValueUsingJS(Locator locator, String value) {
		try {
			locator.evaluate("(el, val) => el.value = val", value);
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
	}

	public static void scrollByPixel(int x, int y) {
		try {
			page.evaluate("window.scrollBy(" + x + "," + y + ")");
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
	}

	public static void scrollToTop() {
		try {
			page.evaluate("window.scrollTo(0, 0)");
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
	}

	public static void scrollToBottom() {
		try {
			page.evaluate("window.scrollTo(0, document.body.scrollHeight)");
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
	}

	public static void acceptAlert() {
		try {
			page.onceDialog(dialog -> dialog.accept());
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
	}

	public static void dismissAlert() {
		try {
			page.onceDialog(dialog -> dialog.dismiss());
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
	}

	public static String getAlertText() {
		final String[] alertText = new String[1];
		try {
			page.onceDialog(dialog -> {
				alertText[0] = dialog.message();
				dialog.dismiss();
			});
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
		return alertText[0];
	}

	public static void enterAlertText(String text) {
		try {
			page.onceDialog(dialog -> dialog.accept(text));
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
	}

	public static Page switchToWindow() {
		Page newPage = null;
		try {
			newPage = page.context().waitForPage(() -> {
			});
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
		return newPage;
	}

	public static void closeCurrentWindow() {
		try {
			page.close();
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
	}

	public static void closeAllWindows() {
		try {
			page.context().close();
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
	}

	public static Locator getCommonLocatorUsingText(String value) {
		Locator locator = null;
		try {
			locator = page.locator("xpath=//*[text()='" + value + "']");
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
		return locator;
	}

	public static String getWindowTitle() {
		String title = null;
		try {
			title = page.title();
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
		return title;
	}

	public static String getCurrentPageUrl() {
		String url = null;
		try {
			url = page.url();
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
		return url;
	}

	public static String getElementText(Locator locator) {
		String text = null;
		try {
			text = locator.innerText().trim();
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
		return text;
	}

	public static String getElementAttributeValue(Locator locator, String attributeName) {
		String value = null;
		try {
			value = locator.getAttribute(attributeName);
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
		return value;
	}

	public static void hardWait(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
	}

	public static Boolean isElementDisplayed(Locator locator) {
		Boolean result = false;
		try {
			result = locator.isVisible();
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
		return result;
	}

	public static Boolean isElementSelected(Locator locator) {
		Boolean result = false;
		try {
			result = locator.isChecked();
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
		return result;
	}

	public static void scrollToElement(Locator locator) {
		try {
			locator.scrollIntoViewIfNeeded();
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
	}

	public static boolean waitForElementToBeVisible(Locator locator, int timeoutSeconds) {
		boolean flag = false;
		try {
			locator.waitFor(new Locator.WaitForOptions().setTimeout(timeoutSeconds * 1000)
					.setState(WaitForSelectorState.VISIBLE));
			flag = true;
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
		return flag;
	}

	public static void dragAndDrop(Locator source, Locator target) {
		try {
			source.dragTo(target);
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
	}

	public static void moveToElement(Locator locator) {
		try {
			locator.hover();
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
	}

	public static void refreshCurrentPage() {
		try {
			page.reload();
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
	}

	public static void goBack() {
		try {
			page.goBack();
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
	}

	public static void moveForward() {
		try {
			page.goForward();
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
	}

	public static void verifyDropdownValuesWithExcel(Locator dropdown, String excelPath, String sheetName) {
		try {
			List<String> optionsText = dropdown.locator("option").allTextContents();
			System.out.println("Dropdown Size : " + optionsText.size());

			// Read Excel values
			FileInputStream fis = new FileInputStream(excelPath);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			int totalRows = sheet.getLastRowNum() + 1;
			System.out.println("Excel Size : " + totalRows);

			ArrayList<String> excelValues = new ArrayList<>();
			for (int i = 0; i < totalRows; i++) {
				excelValues.add(sheet.getRow(i).getCell(0).getStringCellValue().trim());
			}
			workbook.close();
			fis.close();

			if (optionsText.size() != excelValues.size()) {
				System.out.println(
						"SIZE MISMATCH → Dropdown = " + optionsText.size() + " | Excel = " + excelValues.size());
				return;
			}

			for (int i = 0; i < optionsText.size(); i++) {
				if (optionsText.get(i).equals(excelValues.get(i))) {
					System.out.println("MATCH → " + optionsText.get(i));
				} else {
					System.out
							.println("MISMATCH → Excel: " + excelValues.get(i) + " != Dropdown: " + optionsText.get(i));
				}
			}

		} catch (Exception e) {
			TestNGUtility.assertFail("Error in Dropdown Compare: " + e.getMessage());
		}
	}

	public static void loginWithMultipleRecordsUsingExcel(String sheetName) throws IOException {
		String excelPath = config.getProperty("excelFilePath");
		FileInputStream fis = new FileInputStream(excelPath);
		HSSFWorkbook workbook = new HSSFWorkbook(fis);
		HSSFSheet sheet = workbook.getSheet(sheetName);

		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			String username = sheet.getRow(i).getCell(1).getStringCellValue().trim();
			String password = sheet.getRow(i).getCell(2).getStringCellValue().trim();

			CommonUtils.hardWait(1);
			CommonUtils.enterValue(loginPage.enterUsername(), username);
			CommonUtils.enterValue(loginPage.enterPassword(), password);
			CommonUtils.clickElement(loginPage.clickLoginButton());

			try {
				String title = page.title();
				if (title.equals("OrangeHRM")) {
					sheet.getRow(i).createCell(3).setCellValue("Login Successful");
					System.out.println("Login Successful for: " + username);
					 CommonUtils.clickElement(loginPage.clickLogout());
				} else {
					System.out.println("Invalid login for: " + username);
				}
			} catch (Exception e) {
				sheet.getRow(i).createCell(3).setCellValue("Login Failed");
				System.out.println("Login Failed for: " + username);
				captureScreenshot(username);
			}
		}

		FileOutputStream fos = new FileOutputStream(excelPath);
		workbook.write(fos);
		fos.close();
		workbook.close();
	}

	public static void captureScreenshot(String username) {
		try {
			String screenshotPath = config.getProperty("ScreenshortFilePath");
			String fileName = username + "_" + System.currentTimeMillis() + ".png";
			page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(screenshotPath + fileName)));
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
	}

	public static boolean isElementDisplayed(String selector) {
		return page.locator(selector).isVisible();
	}

	public static boolean isElementSelected(String selector) {
		return page.locator(selector).isChecked();
	}

	// ================= WAIT =================

	public static boolean waitForElementToBeVisible(String selector) {
		try {
			page.locator(selector).waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
			return true;
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
		return false;
	}

	// ================= MOUSE ACTIONS =================
	public static void moveToElement(String selector) {
		try {
			page.locator(selector).hover();
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
	}

	public static void doubleClickElement(String selector) {
		try {
			page.locator(selector).dblclick();
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
	}

	public static void rightClickElement(String selector) {
		try {
			page.locator(selector).click(new Locator.ClickOptions().setButton(MouseButton.RIGHT));
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
	}

	// ================= KEYBOARD =================

	public static void pressEnterKey() {
		try {
			page.keyboard().press("Enter");
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
	}

	public static void pressTabKey() {
		try {
			page.keyboard().press("Tab");
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
	}

}