package techniqum.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
//	ExtentReports extent;
	
	
	public static ExtentReports getReportObject() {
		
		
		String path = System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Techniqum Test Results");
		reporter.config().setDocumentTitle("Techniqum Automated Test Results");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Kan");
		return extent;
	}

}
