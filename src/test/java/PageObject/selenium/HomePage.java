package PageObject.selenium;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.LandingPage;
import PageObjects.LoginPage;
import Resources.Base;

public class HomePage extends Base {
	public WebDriver driver;
	
	@BeforeTest()
	public void initialise() throws IOException
	{
		driver=InitializeDriver();
		
		logger.info("Driver is initialised");
		
		
	
		
	}
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String username,String pass,String txt) throws Exception
	{
		
		driver.get(prop.getProperty("url"));
		logger.info("URL launched");
		LandingPage l = new LandingPage(driver);
		l.getLogin();
		LoginPage lp= new LoginPage(driver);
		lp.getEmail(username);
		lp.getPassword(pass);
		System.out.println(txt);
		lp.getLogin();
	}
	
	@DataProvider
	public Object[][] getData()
	{
		
		Object[][] obj=new Object[2][3];
		obj[0][0]="nonres@aw";
		obj[0][1]="123456";
		obj[0][2]="nonRestricted user";
		
		obj[1][0]="res@aw";
		obj[1][1]="1234567";
		obj[1][2]="Restricted user";
		
		return obj;
		
	}
	
	@AfterTest
	public void tearDown()
	{
		
		driver.close();
	}

}
