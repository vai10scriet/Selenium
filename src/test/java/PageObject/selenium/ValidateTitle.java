package PageObject.selenium;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.LandingPage;
import PageObjects.LoginPage;
import Resources.Base;

public class ValidateTitle extends Base {	
	
	public WebDriver driver;
	@BeforeTest()
	public void initialise() throws IOException
	{
		driver=InitializeDriver();
		logger.debug("Title Mismatch");
		driver.get(prop.getProperty("url"));
		
		
	}
	
	@Test
	public void validateTitleMethod() throws Exception
	{
		
		LandingPage l = new LandingPage(driver);
	
		System.out.println(l.getTexts());
		
		Assert.assertTrue(l.getTexts().equalsIgnoreCase("FEATURED COURSE"));
		
		
		//Assert.assertTrue(l.getNav());
		
		
	}
	
	@AfterTest
	public void teatDown()
	{
		
		driver.close();
	}

}
