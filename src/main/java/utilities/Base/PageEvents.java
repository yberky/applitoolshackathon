package utilities.Base;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class PageEvents {

	public WebDriver driver;
	public ExtentTest test;

	public PageEvents(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	// Click Event
	public void clickElement(WebElement element, int explicitTime, String elementException, String passLogMessage,
			String failLogMessage) throws Exception {
		waitForPageLoaded();
		wait_element_visible(element, explicitTime);
		Boolean elementStatus = null;
		try {
			Boolean elementClickable = isElementClickable(element, explicitTime);
			test.log(LogStatus.INFO,
					Thread.currentThread().getStackTrace()[1].getMethodName() + "_Element Is Clickable...");
			elementStatus = elementClickable;
		} catch (Exception a) {
			test.log(LogStatus.INFO, Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + elementException
					+ "/Exception:" + a);
			elementStatus = false;
		}

		if (elementStatus == true) {
			scrollToElement(element);
			element.click();
			test.log(LogStatus.PASS, passLogMessage);
			Assert.assertTrue(true);
		} else {
			test.log(LogStatus.FAIL,
					Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + failLogMessage + "Current URL:"
							+ driver.getCurrentUrl() + test.addScreenCapture(
									ScreenShots.takeScreenshot(driver, String.valueOf(System.currentTimeMillis()))));
			throw new Exception(elementException);
		}
		waitForPageLoaded();
	}

	// Set Element
	public void setElement(WebElement element, int explicitTime, String setValue, String elementException)
			throws Exception {

		waitForPageLoaded();
		wait_element_visible(element, explicitTime);
		if (isElementClickable(element, explicitTime) == true) {
			scrollToElement(element);
			element.click();
			element.clear();
			element.sendKeys(setValue);
		} else {
			throw new Exception(elementException);
		}
		waitForPageLoaded();
	}

	// Element Is Displayed
	public Boolean elementIsDisplayed(WebElement element, int explicitTime, String infoLogMessage)
			throws InterruptedException, IOException {
		waitForPageLoaded();
		Thread.sleep(explicitTime * 1000);
		try {
			Boolean linkDisplayed = element.isDisplayed();
			test.log(LogStatus.INFO,
					Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + infoLogMessage + linkDisplayed);
			return linkDisplayed;
		} catch (Exception a) {
			test.log(LogStatus.FAIL,
					Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + infoLogMessage + "false"
							+ "_Current URL:" + driver.getCurrentUrl() + test.addScreenCapture(
									ScreenShots.takeScreenshot(driver, String.valueOf(System.currentTimeMillis()))));
			return false;
		}

	}

	// Get Element Text
	public String getElementText(WebElement element, int explicitTime, String elementException) throws Exception {
		waitForPageLoaded();
		wait_element_visible(element, explicitTime);
		if (isElementPresent(element, explicitTime) == true) {
			String gotTextValue = element.getText().replaceAll("\\r\\n|\\r|\\n| - ", " ");
			return gotTextValue;
		} else {
			throw new Exception(elementException);
		}
	}

	// Get Element Attribute
	public String getElementAttribute(WebElement element, int explicitTime, String elementException,
			String attributeTag) throws Exception {
		waitForPageLoaded();
		wait_element_visible(element, explicitTime);
		if (isElementPresent(element, explicitTime) == true) {
			String gotAttributeValue = element.getAttribute(attributeTag);
			test.log(LogStatus.INFO, Thread.currentThread().getStackTrace()[1].getMethodName() + "_Looking Attribute:"
					+ attributeTag + " comes as " + gotAttributeValue);
			return gotAttributeValue;
		} else {
			test.log(LogStatus.FAIL,
					Thread.currentThread().getStackTrace()[1].getMethodName()
							+ "_Looking Attribute couldn't be found..." + "_Current URL:" + driver.getCurrentUrl()
							+ test.addScreenCapture(
									ScreenShots.takeScreenshot(driver, String.valueOf(System.currentTimeMillis()))));
			throw new Exception(elementException);
		}
	}

	// Get Direct Attribute
	public String getDirectAttribute(WebElement element, int explicitTime, String elementException, String attributeTag)
			throws Exception {
		waitForPageLoaded();
		try {
			String gotAttributeValue = element.getAttribute(attributeTag);
			test.log(LogStatus.INFO, Thread.currentThread().getStackTrace()[1].getMethodName() + "_Looking Attribute:"
					+ attributeTag + " comes as " + gotAttributeValue);
			return gotAttributeValue;
		} catch (Exception a) {
			test.log(LogStatus.FAIL, Thread.currentThread().getStackTrace()[1].getMethodName()
					+ "_Looking Attribute couldn't be found..." + "_Current URL:" + driver.getCurrentUrl());
			return elementException;
		}

	}

	// Get Elements Count
	public int getElementsCount(List<WebElement> elements, int explicitTime, String elementException) throws Exception {
		waitForPageLoaded();
		try {
			int size = elements.size();
			return size;
		} catch (Exception a) {
			test.log(LogStatus.FAIL, Thread.currentThread().getStackTrace()[1].getMethodName()
					+ "_Looking Element List couldn't be found..." + "_Current URL:" + driver.getCurrentUrl());
			return 0;
		}
	}

	// *********************************************************************************************************
	// *********************************Sub-Element-Methods*****************************************************
	// *********************************************************************************************************

	// Wait Page Load
	public void waitForPageLoaded() throws InterruptedException {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};
		try {
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(expectation);
		} catch (Throwable error) {
			Assert.fail("Timeout waiting for Page Load Request to complete.");
		}
	}

	// Is Element Present
	public boolean isElementPresent(WebElement element, int timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// Is Element Clickable
	public boolean isElementClickable(WebElement element, int timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// Scroll To Element
	public void scrollToElement(final WebElement element) throws InterruptedException {
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
		Thread.sleep(500);
	}

	// Wait Element Visible
	public void wait_element_visible(WebElement waitedElement, int explicitTime) {
		WebDriverWait wait = new WebDriverWait(driver, explicitTime);
		wait.until(ExpectedConditions.visibilityOf(waitedElement));
	}

	// Hover Element
	public void hoverElement(WebElement elementHover, WebElement elementWaited, int explicitTime) throws Exception {
		// Hover Element
		Actions action = new Actions(driver);
		action.moveToElement(elementHover).perform();
		wait_element_visible(elementWaited, explicitTime);
	}

}
