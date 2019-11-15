package testcases.AIHackathon;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utilities.AIHackathon.HtmlChecks_AIHackathon;
import utilities.AIHackathon.PageInitialize_AIHackathon;
import utilities.Base.ExcelUtility;

public class TraditionalTests extends PageInitialize_AIHackathon {

	SoftAssert sa = new SoftAssert();

	/*
	 * Login Page UI Elements Test
	 * 
	 * >> Open the login page and write assertions to ensure everything looks OK on
	 * that page. i.e. add assertions to ensure all the fields, labels and all other
	 * items exist.
	 * 
	 * Notes: In the traditional approach, if you can’t test this or any other test,
	 * please write an empty test with a comment explaining your reason. For the
	 * visual testing suite, when you run the same test against V2, you’ll see
	 * differences. Mark bugs in the Applitools dashboard using the "Bug regions"
	 * feature and save the test as a failure. If you are confused about some part
	 * of the difference and not know if that’s a bug or a feature, in the real
	 * world, you’ll add a "Remark" region to collaborate with the development team
	 * and ask questions. In this hackathon, create a Remark region in the
	 * Applitools dashboard for any differences you’re not sure about.
	 */
	@Test(priority = 10, enabled = true)
	public void Login_Page_UI_Elements_Test() throws Exception {

		sa.assertTrue(loginPage.isDisplayed_loginPage_pageLogo() == true);
		sa.assertEquals(loginPage.getAttribute_loginPage_pageLogo(), "https://demo.applitools.com/img/logo-big.png");
		sa.assertTrue(loginPage.isDisplayed_loginPage_formHeaderLabel() == true);
		sa.assertTrue(loginPage.isDisplayed_loginPage_usernameLabel() == true);
		sa.assertTrue(loginPage.isDisplayed_loginPage_usernameLogo() == true);
		sa.assertTrue(loginPage.isDisplayed_loginPage_usernameTextbox() == true);
		sa.assertEquals(loginPage.getAttribute_loginPage_usernameTextbox(), "Enter your username");
		sa.assertTrue(loginPage.isDisplayed_loginPage_passwordLabel() == true);
		sa.assertTrue(loginPage.isDisplayed_loginPage_passwordLogo() == true);
		sa.assertTrue(loginPage.isDisplayed_loginPage_passwordTextbox() == true);
		sa.assertEquals(loginPage.getAttribute_loginPage_passwordTextbox(), "Enter your password");
		sa.assertTrue(loginPage.isDisplayed_loginPage_passwordTextbox() == true);
		sa.assertTrue(loginPage.isDisplayed_loginPage_loginButton() == true);
		sa.assertTrue(loginPage.isDisplayed_loginPage_rememberMeCheckbox() == true);
		sa.assertTrue(loginPage.isDisplayed_loginPage_twitterLogo() == true);
		sa.assertTrue(loginPage.isDisplayed_loginPage_facebookLogo() == true);
		sa.assertTrue(loginPage.isDisplayed_loginPage_facebookLogo() == true);

		sa.assertAll();
	}

	/*
	 * Data-Driven Test >> Test the following login functionality by entering
	 * different values to username and password fields. If you don’t enter the
	 * username and password and click the login button, it should throw an error If
	 * you only enter the username and click the login button, it should throw an
	 * error If you only enter the password and click the login button, it should
	 * throw an error If you enter both username (any value) and password (any
	 * value), it should log you in.
	 * 
	 * Notes: For the visual testing suite, to test functionality (functional
	 * testing), you simply need to use Applitools to take a screenshot after the
	 * functionality is done (i.e. the end-state of the feature) to verify. You will
	 * need to use the Batching feature to group multiple tests into a single
	 * suite/batch. When you use eyes.open, give different test names (with numbers
	 * or something dynamic) so that Applitools can create four new screenshot
	 * (baselines) for each of the 4 sub tests instead of overriding each screenshot
	 * with the next sub-test’s screenshot and creating just one baseline.
	 */
	@DataProvider(name = "userList")
	public Object[][] dataProviderUser() {
		Object[][] testData = ExcelUtility.getTestData("User_List");
		return testData;
	}

	@Test(priority = 20, dataProvider = "userList", enabled = true)
	public void Data_Driven_Test(String username, String password, String alertText) throws Exception {

		if ("N/A".equals(username)) {
			username = "";
		}

		if ("N/A".equals(password)) {
			password = "";
		}

		loginPage.set_loginPage_usernameTextbox(username);
		loginPage.set_loginPage_passwordTextbox(password);
		loginPage.click_loginPage_loginButton();

		if (!"N/A".equals(alertText)) {
			sa.assertEquals(loginPage.getText_loginPage_alertLabel(), alertText);
		} else {
			sa.assertEquals(homePage.getText_homePage_loggedUsernameLabel(), username);
		}

		sa.assertAll();
	}

	/*
	 * Table Sort Test >> Once logged in (use any username and password to login),
	 * view the Recent Transactions table. Your test should click on the "Amounts"
	 * header, and verify that the column is in ascending order and that each row’s
	 * data stayed in tact after the sorting.
	 * 
	 * Notes: For the visual testing suite, if your viewport is too small and you
	 * see a scrollbar, you need to use Applitools "Full page screenshot" to capture
	 * a screenshot of the entire window. Alternatively, you may try increasing the
	 * viewport size to avoid this.
	 */
	@Test(priority = 30, enabled = true)
	public void Table_Sort_Test() throws Exception {
		// It is really hard to write assertion for this one. You need store all line
		// data in Array which includes 2 index as Array[][].
		// Instead I prefer to store all OuterHTML inside one of the string and Compare
		// Both :)

		homePage.click_homePage_amountColumnHeaderOfTable();
		sa.assertEquals(homePage.getAttribute_homePage_transactionTable(), HtmlChecks_AIHackathon.Table_HTLM_After);

		sa.assertAll();
	}

	/*
	 * Canvas Chart Test >> Once logged in, click on the "Compare Expenses" button
	 * on the toolbar. This will display a bar chart comparing the expenses for the
	 * year 2017 and 2018. Assume the values of the chart are coming from a test
	 * data and the test data will not change across versions. Validate that the bar
	 * chart and representing that data (number of bars and their heights). They
	 * should remain the same across versions.
	 * 
	 * Then click on the "Show data for next year" button. This should add the data
	 * for the year 2019. Verify that this data set is added for the year 2019.
	 */
	@Test(priority = 40, enabled = true)
	public void Canvas_Chart_Test() throws Exception {
		// Again this one is quite difficult in terms of you could never be sure by
		// looking. It is dynamic java script laying on background
		homePage.click_homePage_compareExpensesButton();
	}

	/*
	 * Dynamic Content Test >> Test for the existence of a display ad that’s dynamic
	 * and at times might go missing by using this URL:
	 * https://demo.applitools.com/hackathon.html?showAd=true. Log in by entering
	 * any username and password. Once logged in, you should see two different
	 * "Flash sale" gifs. Make sure both gifs exists.
	 * 
	 * Notes: When you run the same test with the V2 version of the app (
	 * https://demo.applitools.com/hackathonV2.html?showAd=true), one of the gifs
	 * won’t be displayed and the other will be a different gif (because ads can
	 * change). Your tests need to be smart enough to find the missing gif (bug) and
	 * also beware of the different gif (feature). For the visual test, It’s
	 * recommended that you use a Layout region annotation. When you take a
	 * screenshot of a page with dynamic content. It’ll constantly change so can’t
	 * create a baseline. If you use the "Ignore region", then you can create a
	 * baseline. However, you won’t know if the dynamic content goes completely
	 * missing. That’s where the "Layout Region" comes in. It’s like an ignore
	 * region but doesn’t completely ignore the contents in the region. It only
	 * ignore as long as there is some content and structure(or the layout) remains
	 * the same but fails if dynamic region is blank.
	 */
	@Test(priority = 50, enabled = true)
	@Parameters({ "url" })
	public void Dynamic_Content_Test(String url) throws Exception {
		// "src" attribute link can change so I better only put ADs count under this
		// test
		driver.navigate().to(url + "?showAd=true");
		loginPage.set_loginPage_usernameTextbox("Jack Gomez");
		loginPage.set_loginPage_passwordTextbox("Pass");
		loginPage.click_loginPage_loginButton();

		sa.assertTrue(homePage.getAttribute_homePage_adsBanners() == 2);

		sa.assertAll();
	}
}
