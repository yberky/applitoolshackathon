package utilities.AIHackathon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.Base.PageEvents;

public class SearchPageFactory_LoginPage extends PageEvents {

	WebDriver driver;
	ExtentTest test;

	@FindBy(xpath = "//div[@class=\"logo-w\"]//img")
	WebElement loginPage_pageLogo;

	@FindBy(xpath = "//h4[@class=\"auth-header\"]")
	WebElement loginPage_formHeaderLabel;

	@FindBy(xpath = "//div[@class=\"alert alert-warning\"]")
	WebElement loginPage_alertLabel;

	@FindBy(xpath = "//div[@class=\"form-group\"]/label[text()=\"Username\"]")
	WebElement loginPage_usernameLabel;

	@FindBy(xpath = "//div//input[@id=\"username\"]")
	WebElement loginPage_usernameTextbox;

	@FindBy(xpath = "//div[@class=\"pre-icon os-icon os-icon-user-male-circle\"]")
	WebElement loginPage_usernameLogo;

	@FindBy(xpath = "//div[@class=\"form-group\"]/label[text()=\"Password\"]")
	WebElement loginPage_passwordLabel;

	@FindBy(xpath = "//div//input[@id=\"password\"]")
	WebElement loginPage_passwordTextbox;

	@FindBy(xpath = "//div[@class=\"pre-icon os-icon os-icon-fingerprint\"]")
	WebElement loginPage_passwordLogo;

	@FindBy(xpath = "//div[@class=\"buttons-w\"]/button[@id=\"log-in\"]")
	WebElement loginPage_loginButton;

	@FindBy(xpath = "//label[@class=\"form-check-label\"]/input")
	WebElement loginPage_rememberMeCheckbox;

	@FindBy(xpath = "//div//img[@src=\"img/social-icons/twitter.png\"]")
	WebElement loginPage_twitterLogo;

	@FindBy(xpath = "//div//img[@src=\"img/social-icons/facebook.png\"]")
	WebElement loginPage_facebookLogo;

	@FindBy(xpath = "//div//img[@src=\"img/social-icons/linkedin.png\"]")
	WebElement loginPage_linkedinLogo;

	// All Methods With Elements
	public SearchPageFactory_LoginPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.test = test;
	}

	// ************************************************************************************************
	// *******************************Home-Page-Methods************************************************
	// ************************************************************************************************

	public Boolean isDisplayed_loginPage_pageLogo() throws Exception {
		Boolean Result = elementIsDisplayed(loginPage_pageLogo, Constants_AIHackathon.explicitTime,
				"Page Logo on Login Page Displayed Status:");
		return Result;
	}

	public String getAttribute_loginPage_pageLogo() throws Exception {
		String Result = getElementAttribute(loginPage_pageLogo, Constants_AIHackathon.explicitTime,
				"Couldn't find element to check attributes...", "src");
		return Result;
	}

	public Boolean isDisplayed_loginPage_formHeaderLabel() throws Exception {
		Boolean Result = elementIsDisplayed(loginPage_formHeaderLabel, Constants_AIHackathon.explicitTime,
				"Form Header Label on Login Page Displayed Status:");
		return Result;
	}

	public Boolean isDisplayed_loginPage_usernameLabel() throws Exception {
		Boolean Result = elementIsDisplayed(loginPage_usernameLabel, Constants_AIHackathon.explicitTime,
				"Username Label on Login Page Displayed Status:");
		return Result;
	}

	public Boolean isDisplayed_loginPage_usernameTextbox() throws Exception {
		Boolean Result = elementIsDisplayed(loginPage_usernameTextbox, Constants_AIHackathon.explicitTime,
				"Username Textbox on Login Page Displayed Status:");
		return Result;
	}

	public String getAttribute_loginPage_usernameTextbox() throws Exception {
		String Result = getElementAttribute(loginPage_usernameTextbox, Constants_AIHackathon.explicitTime,
				"Couldn't find element to check attributes...", "placeholder");
		return Result;
	}

	public Boolean isDisplayed_loginPage_usernameLogo() throws Exception {
		Boolean Result = elementIsDisplayed(loginPage_usernameLogo, Constants_AIHackathon.explicitTime,
				"Username Logo on Login Page Displayed Status:");
		return Result;
	}

	public Boolean isDisplayed_loginPage_passwordLabel() throws Exception {
		Boolean Result = elementIsDisplayed(loginPage_passwordLabel, Constants_AIHackathon.explicitTime,
				"Password Label on Login Page Displayed Status:");
		return Result;
	}

	public Boolean isDisplayed_loginPage_passwordTextbox() throws Exception {
		Boolean Result = elementIsDisplayed(loginPage_passwordTextbox, Constants_AIHackathon.explicitTime,
				"Password Textbox on Login Page Displayed Status:");
		return Result;
	}

	public String getAttribute_loginPage_passwordTextbox() throws Exception {
		String Result = getElementAttribute(loginPage_passwordTextbox, Constants_AIHackathon.explicitTime,
				"Couldn't find element to check attributes...", "placeholder");
		return Result;
	}

	public Boolean isDisplayed_loginPage_passwordLogo() throws Exception {
		Boolean Result = elementIsDisplayed(loginPage_passwordLogo, Constants_AIHackathon.explicitTime,
				"Password Logo on Login Page Displayed Status:");
		return Result;
	}

	public Boolean isDisplayed_loginPage_loginButton() throws Exception {
		Boolean Result = elementIsDisplayed(loginPage_loginButton, Constants_AIHackathon.explicitTime,
				"Login Button on Login Page Displayed Status:");
		return Result;
	}

	public Boolean isDisplayed_loginPage_rememberMeCheckbox() throws Exception {
		Boolean Result = elementIsDisplayed(loginPage_rememberMeCheckbox, Constants_AIHackathon.explicitTime,
				"Remember Me Checkbox on Login Page Displayed Status:");
		return Result;
	}

	public Boolean isDisplayed_loginPage_twitterLogo() throws Exception {
		Boolean Result = elementIsDisplayed(loginPage_twitterLogo, Constants_AIHackathon.explicitTime,
				"Twitter Logo on Login Page Displayed Status:");
		return Result;
	}

	public Boolean isDisplayed_loginPage_facebookLogo() throws Exception {
		Boolean Result = elementIsDisplayed(loginPage_facebookLogo, Constants_AIHackathon.explicitTime,
				"Facebook Logo on Login Page Displayed Status:");
		return Result;
	}

	public Boolean isDisplayed_loginPage_linkedinLogo() throws Exception {
		Boolean Result = elementIsDisplayed(loginPage_linkedinLogo, Constants_AIHackathon.explicitTime,
				"Linkedin Logo on Login Page Displayed Status:");
		return Result;
	}

	public void set_loginPage_usernameTextbox(String username) throws Exception {
		setElement(loginPage_usernameTextbox, Constants_AIHackathon.explicitTime, username,
				"Username Textbox on Login Page Element is not Present...");
	}

	public void set_loginPage_passwordTextbox(String password) throws Exception {
		setElement(loginPage_passwordTextbox, Constants_AIHackathon.explicitTime, password,
				"Password Textbox on Login Page Element is not Present...");
	}

	public void click_loginPage_loginButton() throws Exception {
		clickElement(loginPage_loginButton, Constants_AIHackathon.explicitTime,
				"Login Button on Login Page Element is not Clickable...",
				"Click Login Button on Login Page in Given Explicit Time...",
				"Could Not Click Login Button on Login Page in Given Explicit Time...");
	}

	public String getText_loginPage_alertLabel() throws Exception {
		String Result = getElementText(loginPage_alertLabel, Constants_AIHackathon.explicitTime,
				"Could Not Find Alert Label on Login Page...");
		return Result;
	}

}
