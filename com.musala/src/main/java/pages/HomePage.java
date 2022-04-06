package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase
{
	public HomePage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver; 
		
	}
	
	@FindBy(linkText="COMPANY")
	WebElement Companylbl; 

	@FindBy(linkText="CAREERS")
	WebElement Careerslbl; 
	
	@FindBy(css="button.contact-label.btn.btn-1b")
	WebElement Contactbtn; 
	
	@FindBy(css="span.musala.musala-icon-facebook")
	WebElement Facebookbtn ; 
	
	@FindBy(partialLinkText="https://scontent.fcai20-1.fna.fbcdn.net/v/t1.6435-1/158325737_3926723744014946_1132226306152824042_n.jpg?stp=dst-jpg_p148x148&_nc_cat=100&ccb=1-5&_nc_sid=1eb0c7&_nc_eui2=AeGWqkzEfxPSFgknyMXke6_4QwD9dGvLb7lDAP10a8tvudOmMvWASvaejarYJNjdTqc&_nc_ohc=5DZlPX7_5m8AX__xsYi&_nc_ht=scontent.fcai20-1.fna&oh=00_AT9CYt0jSIotPish1Mq6bw7UZaHC5g4BlXHisRYZkhQvMw&oe=62654C36")
	 public WebElement Facebookimg ;
	
	
	
	@FindBy(xpath="//*[@id=\"content\"]/div[2]/section[3]/div/h2")
	public WebElement Namelbl; 
	
	
	public void ContactPage() 
	{
		scrollToBottom();
		clickButton(Contactbtn);
	}
	
	
	public void CompanyPage() 
	{
		clickButton(Companylbl);
	}
	
	public void FacebookPage() 
	{
		clickButton(Facebookbtn);
	}
	
	public void CareerPage() 
	{
		clickButton(Careerslbl);
	}
	
	
	
	
	
	

	

}
