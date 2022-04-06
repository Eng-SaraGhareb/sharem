package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.CareersPage;

public class HomeTest extends TestBase {
	
	HomePage homeObject ;
	String URL;
	
	
	
	public void Homecommon()
	{
		homeObject = new HomePage(driver); 
	}
	
	@Test(priority=1,dependsOnMethods = {"homeCommon"})
	public void Companycheck() 
	{
		
		homeObject.CompanyPage();
		URL= driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.musala.com/company/");
		Assert.assertTrue(homeObject.Namelbl.getText().contains("Leadership"));	
		
	}
	
	// facebook icon didn't appear in this test case //
	
	@Test(priority=2,dependsOnMethods = {"homeCommon"})
	public void Facecheck()
	{
				homeObject.FacebookPage();
				Assert.assertEquals(URL, "https://www.facebook.com/MusalaSoft?fref=ts");
				homeObject.Facebookimg.isDisplayed();
	}
}
