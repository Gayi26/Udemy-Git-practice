package frameworkexample.copy;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class reports {
	static ExtentReports extentreports;
	@Test
	public static ExtentReports config()
	{
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		extentreports=new ExtentReports();
		extentreports.attachReporter(reporter);
		extentreports.setSystemInfo("Tester", "Gayi");
		return extentreports;
	}

}
