package utilities.AIHackathon;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.EyesRunner;
import com.applitools.eyes.selenium.ClassicRunner;
import com.applitools.eyes.selenium.Eyes;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.Base.ExcelUtility;

public class PageInitialize_AIHackathon {
	public WebDriver driver;
	public SearchPageFactory_HomePage homePage;
	public SearchPageFactory_LoginPage loginPage;
	public SearchPageFactory_CompareExpensesPage compareExpensesPage;

	protected ExtentTest test;
	ExtentReports report;
	ExtentReports extent;
	int failedMethods = 0;
	String randomName = Constants_AIHackathon.getRandomName();

	public EyesRunner runner;
	public Eyes eyes;
	public BatchInfo batch;

	@Parameters({ "browser", "url" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String url, final ITestContext testContext) throws Exception {
		// Must be before All tests at Class-level
		BatchInfo batch = new BatchInfo("Data_Driven_Test");
		// Initialize the Runner for your test.
		EyesRunner runner = new ClassicRunner();
		// Initialize the eyes SDK
		Eyes eyes = new Eyes(runner);

		extent = ExtentManager_AIHackathon.getReporter();
		// ExcelSetting_Location of Excel File
		ExcelUtility.setExcelFile(Constants_AIHackathon.Excel_File_Path + Constants_AIHackathon.Excel_File_Name,
				Constants_AIHackathon.Excel_Sheet_Name_List);

		test = ExtentTestManager_AIHackathon.startTest(testContext.getName());

		// driver Open With Given Browser and URL
		driver = getDriverInstance(browser, url);
		test.log(LogStatus.INFO, Thread.currentThread().getStackTrace()[1].getMethodName() + "_Browser Started...");

		homePage = new SearchPageFactory_HomePage(driver, test);
		loginPage = new SearchPageFactory_LoginPage(driver, test);
		compareExpensesPage = new SearchPageFactory_CompareExpensesPage(driver, test);

	}

	public static WebDriver getDriverInstance(String browser, String url) throws IOException {
		WebDriver driver = null;

		// Browsers
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty(Constants_AIHackathon.Set_Google_Driver_Property,
					Constants_AIHackathon.Set_Google_Driver_Path);
			driver = new ChromeDriver();
		}
		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty(Constants_AIHackathon.Set_Firefox_Driver_Property,
					Constants_AIHackathon.Set_Firefox_Driver_Path);
			driver = new FirefoxDriver();
		}

		// Maximize The Browser's Window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Open the Application
		driver.get(url);
		return driver;
	}

	@AfterClass
	public void afterClass() {
		// Close Browser
		driver.quit();
		// Close Eyes
		eyes.abortIfNotClosed();
		// ExtentReportSetting_Flush Extent Report
		ExtentTestManager_AIHackathon.endTest();
		extent.endTest(test);
		extent.flush();
	}
}
