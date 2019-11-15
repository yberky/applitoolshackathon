package utilities.AIHackathon;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.Base.PageEvents;

public class SearchPageFactory_HomePage extends PageEvents {

	WebDriver driver;
	ExtentTest test;

	@FindBy(xpath = "//div[@id=\"logged-user-name\"]")
	WebElement homePage_loggedUsernameLabel;

	@FindBy(xpath = "//table[@id=\"transactionsTable\"]//td/span/ancestor::tr/td/span")
	List<WebElement> homePage_tableRows;

	@FindBy(xpath = "//table[@id=\"transactionsTable\"]")
	WebElement homePage_transactionTable;

	@FindBy(xpath = "//th[@id=\"amount\"]")
	WebElement homePage_amountColumnHeaderOfTable;

	@FindBy(xpath = "//a[@id=\"showExpensesChart\"]")
	WebElement homePage_compareExpensesButton;

	@FindBy(xpath = "//div[@class=\"balance hidden-mobile\"]/img")
	List<WebElement> homePage_adsBanners;

	// All Methods With Elements
	public SearchPageFactory_HomePage(WebDriver driver, ExtentTest test) {
		super(driver, test);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.test = test;
	}

	// ************************************************************************************************
	// *******************************Home-Page-Methods************************************************
	// ************************************************************************************************

	public String getText_homePage_loggedUsernameLabel() throws Exception {
		String Result = getElementText(homePage_loggedUsernameLabel, Constants_AIHackathon.explicitTime,
				"Could Not Find Logged Username Label on Home Page...");
		return Result;
	}

	public String getAttribute_homePage_transactionTable() throws Exception {
		String Result = getElementAttribute(homePage_transactionTable, Constants_AIHackathon.explicitTime,
				"Couldn't find element to check attributes...", "outerHTML");
		return Result;
	}

	public void click_homePage_amountColumnHeaderOfTable() throws Exception {
		clickElement(homePage_amountColumnHeaderOfTable, Constants_AIHackathon.explicitTime,
				"Amount Column Header of Table on Home Page Element is not Clickable...",
				"Click Amount Column Header of Table on Home Page in Given Explicit Time...",
				"Could Not Click Amount Column Header of Table on Home Page in Given Explicit Time...");
	}

	public void click_homePage_compareExpensesButton() throws Exception {
		clickElement(homePage_compareExpensesButton, Constants_AIHackathon.explicitTime,
				"Compare Expenses Button on Home Page Element is not Clickable...",
				"Click Compare Expenses Button on Home Page in Given Explicit Time...",
				"Could Not Click Compare Expenses Button on Home Page in Given Explicit Time...");
	}

	public int getAttribute_homePage_adsBanners() throws Exception {
		int Result = getElementsCount(homePage_adsBanners, Constants_AIHackathon.explicitTime,
				"Couldn't find element to check attributes...");
		return Result;
	}

}
