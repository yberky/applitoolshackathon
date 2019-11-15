
package utilities.AIHackathon;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import com.applitools.eyes.RectangleSize;

public class Constants_AIHackathon {

	public static int failedMethodsCount;
	// Parameters for Excel Sheet
	public static final String Excel_File_Path = "/Users/byavuz/Automation/ExcelSheets/";
	public static final String Excel_File_Name = "ExcelData.xlsx";
	public static final String Excel_Sheet_Name_List = "List";
	// Parameters for Screenshot
	public static final String directoryForScreenShots = "/Users/byavuz/Automation/ScreenShots/";
	// Parameters for ExtentReport
	public static final String ExtentReport_File_Path = "/Users/byavuz/Automation/ExtentReports/";
	public static final String ExtentReport_File_Name = getReportName();

	public static String getReportName() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH-mm");
		// For Istanbul/TURKEY Time Zone
		LocalDateTime localDate = LocalDateTime.now(ZoneId.of("GMT+03:00"));
		String reportName = "AIHackathonAutomationReport_" + dtf.format(localDate) + ".html";
		return reportName;
	}

	public static String getRandomName() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyyHHmm");
		LocalDateTime localDate = LocalDateTime.now();
		String randomName = dtf.format(localDate);
		return randomName;
	}

	// Parameters for Google Chrome Driver
	public static final String Set_Google_Driver_Property = "webdriver.chrome.driver";
	public static final String Set_Google_Driver_Path = "/Users/byavuz/Automation/Downloads/Chrome Driver mac x64/v78/chromedriver";
	// Parameters for Firefox Driver
	public static final String Set_Firefox_Driver_Property = "webdriver.gecko.driver";
	public static final String Set_Firefox_Driver_Path = "/Users/byavuz/Automation/Downloads/Firefox Driver x64/geckodriver";
	// Parameters for Applitools
	public static String ApplitoolsAPIKey = "KDUowFqx5HtRlnfP9H9We0jBSs0e198Xtm7102wv105WjWY110";
	public static RectangleSize viewportSize = new RectangleSize(/* width */ 1024, /* height */ 768);
	// Parameters for Implicit Wait
	public static final int explicitTime = 10;
	public static final int timeOutMethod = 30000;

}
