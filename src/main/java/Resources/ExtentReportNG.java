package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportNG {
	
	public static ExtentHtmlReporter htmlReporter;
	 public static  ExtentReports extent;
	 //public static ExtentTest test;
	 
	 public static ExtentReports setExtent() {

		 
		 htmlReporter= new ExtentHtmlReporter(System.getProperty("user.dir")+"/reports/myReport.html");
		 htmlReporter.config().setDocumentTitle("Automation Report");
		 htmlReporter.config().setReportName("Functional Testing");
		  htmlReporter.config().setTheme(Theme.DARK);
		  
		  extent = new ExtentReports();
		  extent.attachReporter(htmlReporter);
		  extent.setSystemInfo("Environemnt", "QA");
		  extent.setSystemInfo("user", "vaibhav");
		  return extent;

	 }
}
