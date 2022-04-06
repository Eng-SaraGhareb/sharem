package tests;



import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.github.javafaker.Faker;

import data.LoadProperties;
import pages.CareersPage;
import pages.HomePage;


public class CareersTest extends TestBase
{
	HomePage homeObject ; 
	CareersPage careerObject;
	String URL;
	
 
	String email = LoadProperties.userData.getProperty("email"); 
	String mobile = LoadProperties.userData.getProperty("mobile");
	
	@Test(priority=0) 
	public void Careercommon()
	{
		homeObject = new HomePage(driver); 
		homeObject.CareerPage();
	}
	@Test(priority=1,dependsOnMethods= {"Careercommon"})
	public void Careersfind() throws AWTException
	{
		careerObject = new CareersPage(driver);
		careerObject.Careerfind();
		URL= driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.musala.com/careers/join-us/");
		careerObject.Locationchoose();
		Assert.assertTrue(careerObject.Sectioncheck().equals(true));
		careerObject.Formsubmit();
		careerObject.Jobapply(email);
		Assert.assertTrue(careerObject.namemsg.getText().contains("The field is required."));
		Assert.assertTrue(careerObject.emailmsg.getText().contains("The e-mail address entered is invalid.."));
		Assert.assertTrue(careerObject.mobilemsg.getText().contains("The field is required."));
		Assert.assertTrue(careerObject.messagemsg.getText().contains("The field is required."));
		careerObject.closeformbtn.click();
		 
	}
	
	
	
	  @Test(priority=2,dependsOnMethods= {"Careercommon"}) 
	  public void Careercityfilter()
	  { 
	  careerObject = new CareersPage(driver);
	  careerObject.Careerfind(); 
	  careerObject.Citychoose();
	  URL= driver.getCurrentUrl();
	  Assert.assertEquals(URL, "https://www.musala.com/careers/join-us/?location=Sofia");
	  
	  }
	 
}
