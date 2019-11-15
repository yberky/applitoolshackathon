package utilities.AIHackathon;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentFactory_AIHackathon {

	public static ExtentReports getInstance() {
		ExtentReports extent;
		extent = new ExtentReports(
				Constants_AIHackathon.ExtentReport_File_Path + Constants_AIHackathon.ExtentReport_File_Name, false);
		extent.addSystemInfo("Selenium Version", "3.0.0").addSystemInfo("Platform", "MAC")
				.addSystemInfo("Environment", "PROD");
		return extent;

	}
}