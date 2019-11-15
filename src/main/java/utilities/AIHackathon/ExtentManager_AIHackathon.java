package utilities.AIHackathon;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.NetworkMode;

public class ExtentManager_AIHackathon {

	private static ExtentReports extent;

	public synchronized static ExtentReports getReporter() {
		if (extent == null) {
			extent = new ExtentReports(
					Constants_AIHackathon.ExtentReport_File_Path + Constants_AIHackathon.ExtentReport_File_Name, true,
					NetworkMode.ONLINE);

			extent.addSystemInfo("Selenium Version", "3.0.0").addSystemInfo("Platform", "MAC");
		}

		return extent;
	}

}
