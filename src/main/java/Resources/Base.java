package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	
	public WebDriver driver;
	public Properties prop;
	
	public static Logger logger = Logger.getLogger(Base.class);
	
	public WebDriver InitializeDriver() throws IOException
	{
		
		String log4jConfpath=System.getProperty("user.dir")+"//src//main//java//Resources//log4j.properties";
		PropertyConfigurator.configure(log4jConfpath);
		 prop = new Properties();
		FileInputStream fis= new FileInputStream("C:\\Users\\itadmin\\eclipse-workspace\\Selenium\\src\\main\\java\\Resources\\data.properties");
	    prop.load(fis);
	    String browserName=prop.getProperty("browser");
	    
	    if(browserName.equals("chrome"))
	    {
	    	WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
	    	
	    }
	    
	    else if(browserName.equals("firefox"))
	    {
	    	
	    	
	    }
	    
	    
	    else if(browserName.equalsIgnoreCase("IE"))
	    {
	    	
	    	
	    }
	    
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	    
	    return driver;
	    
	}
	
	public void getScreenShotPath(String TestCaseName,WebDriver driver) throws IOException
	{
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destinationFile=System.getProperty("user.dir")+"\\reports\\"+TestCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
	}
	
	
	    

}
