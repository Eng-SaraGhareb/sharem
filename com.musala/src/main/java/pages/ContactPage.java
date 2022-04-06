package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends PageBase {

	public ContactPage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver;
	}

	

	@FindBy(id = "cf-1")
	private WebElement UserNameTxt;
	
	@FindBy(id = "cf-2")
	private WebElement EmailTxt;
	
	@FindBy(id = "cf-3")
	public WebElement MobileTxt;

	@FindBy(id = "cf-4")
	private WebElement SubjectTxt;

	@FindBy(id = "cf-5")
	private WebElement MessageTxt;

	@FindBy(css = "input.wpcf7-form-control.has-spinner.wpcf7-submit.btn-cf-submit")
	private WebElement Sendbtn;

	@FindBy(xpath = "//*[@id=\"wpcf7-f875-o1\"]/form/p[2]/span/span")
	public WebElement ErrorMsg;

	public void Contactform(String name, String email, String mobile, String subject,String message) 
	{
		UserNameTxt.sendKeys(name);
		EmailTxt.sendKeys(email);
		MobileTxt.sendKeys(mobile);
		SubjectTxt.sendKeys(subject);
		MessageTxt.sendKeys(message);
		clickButton(Sendbtn);
		
	}

}
