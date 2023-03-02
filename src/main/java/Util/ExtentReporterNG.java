package Util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	public static ExtentReports getReportObject()
	{
		String path = System.getProperty("user.dir") + "/src/test/resources/reports/index.html";
		
		ExtentSparkReporter sparker = new ExtentSparkReporter(path);
		
		sparker.config().setReportName("Web Automation Result");
		sparker.config().setDocumentTitle("Tests Results");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(sparker);
		extent.setSystemInfo("Tester","Swapnil Bobade");
		extent.setSystemInfo("Sprint :", "Sprint no : 9");
		extent.setSystemInfo("Build", "Build no : 2" );
		
		return extent;
	}
	
}
