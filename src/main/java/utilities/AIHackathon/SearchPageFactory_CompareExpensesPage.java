package utilities.AIHackathon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.Base.PageEvents;

public class SearchPageFactory_CompareExpensesPage extends PageEvents {

	WebDriver driver;
	ExtentTest test;

	@FindBy(xpath = "//button[@id=\"addDataset\"]")
	WebElement compareExpensesPage_showDataForNextYearButton;

	// All Methods With Elements
	public SearchPageFactory_CompareExpensesPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.test = test;
	}

	// ************************************************************************************************
	// *******************************Home-Page-Methods************************************************
	// ************************************************************************************************

	public void click_compareExpensesPage_showDataForNextYearButton() throws Exception {
		clickElement(compareExpensesPage_showDataForNextYearButton, Constants_AIHackathon.explicitTime,
				"Show Data For Next Year Button on Compare Expenses Page Element is not Clickable...",
				"Click Show Data For Next Year Button on Compare Expenses Page in Given Explicit Time...",
				"Could Not Click Show Data For Next Year Button on Compare Expenses Page in Given Explicit Time...");
	}

}
