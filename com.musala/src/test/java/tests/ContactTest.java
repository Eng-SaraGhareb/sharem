package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import data.LoadProperties;
import pages.ContactPage;
import pages.HomePage;


public class ContactTest extends TestBase
{
	HomePage homeObject ;
	ContactPage contactObject;

	
	Faker f = new Faker();
	String name = f.name().firstName();
	String email = "e.g. test@test";
	String mobile = f.phoneNumber().cellPhone();
	String subject = f.name().title();
	String message =f.lorem().sentence();
	
	@Test(priority=1)
	public void Contactsend() 
	{
		homeObject = new HomePage(driver); 
		homeObject.ContactPage();
		contactObject = new ContactPage(driver);
		contactObject.Contactform(name, email, mobile, subject, message);
		Assert.assertTrue(contactObject.ErrorMsg.getText().contains("The e-mail address entered is invalid"));
		 		 
	}
}
