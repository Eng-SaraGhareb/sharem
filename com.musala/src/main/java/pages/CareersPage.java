package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class CareersPage extends PageBase {

	public CareersPage(WebDriver driver) {
		super(driver);
			jse = (JavascriptExecutor) driver; 
			 
	}
	
	@FindBy(css="button.contact-label.contact-label-code.btn.btn-1b")
	WebElement Checktxt; 
	
	@FindBy(name="get_location")
	WebElement Locationdrop; 
	
	@FindBy(xpath="//*[@id=\"content\"]/section/div[2]/article[3]/div/a/div/div[1]/h2")
	 WebElement Positionlbl; 
	
	@FindBy(xpath="//*[@id=\"post-1501\"]/div/div[2]/div[1]/div[1]/div[1]/div[2]")
	 WebElement Generallbl; 
	
	@FindBy(xpath="//*[@id=\"post-1501\"]/div/div[2]/div[1]/div[1]/div[2]/div[2]")
	 WebElement Reqlbl;
	
	@FindBy(xpath="//*[@id=\"post-1501\"]/div/div[2]/div[1]/div[2]/div[1]/div[2]")
	 WebElement Reslbl;
	
	@FindBy(xpath="//*[@id=\"post-1501\"]/div/div[2]/div[1]/div[2]/div[2]/div[2]")
	 WebElement offerlbl;
	
	@FindBy(xpath="/html/body/main/div/div/section/article/div/div[2]/div[2]/a/input")
	 WebElement Applybtn;
	
	@FindBy(id="uploadtextfield")
     WebElement uploadbtn;
	
	@FindBy(css="input.wpcf7-form-control.has-spinner.wpcf7-submit.btn-cf-submit")
    WebElement submitbtn;
	
	@FindBy(id="cf-2")
	 WebElement emailtxt;
	
	@FindBy(id="cf-3")
	WebElement mobiletxt;
	
	@FindBy(css="input#adConsentChx")
	 WebElement agreecheck;
	
	@FindBy(css="button.close-form")
	 WebElement closebtn;
	
	@FindBy(xpath="//*[@id=\"wpcf7-f880-o1\"]/form/p[2]/span/span")
	public WebElement namemsg;
	
	@FindBy(xpath="//*[@id=\"wpcf7-f880-o1\"]/form/p[3]/span/span")
	public WebElement emailmsg;
	
	@FindBy(xpath="//*[@id=\"wpcf7-f880-o1\"]/form/p[4]/span/span")
	public WebElement mobilemsg;
	
	@FindBy(xpath="//*[@id=\"wpcf7-f880-o1\"]/form/p[6]/span/span")
	public WebElement messagemsg;
	
	@FindBy(id="fancybox-close")
	public WebElement closeformbtn;
	
	@FindBy(id="file-upload")
	 WebElement fileUploader ; 
	
	@FindBy(id="file-submit")
    WebElement fileSubmit ;
	
	@FindBy(id="uploaded-files")
	 WebElement uploadedFiles; 
	
	
	
	public Select s ;
	
	public void Careerfind() 
	{
		clickButton(Checktxt);
	}
	
	
	public void Locationchoose() 
	{  
		s=new Select(Locationdrop);
		s.selectByVisibleText("Anywhere");
		scrollToBottom();
		clickButton(Positionlbl);	
	}
	
	public Boolean Sectioncheck()
	{
		scrollToBottom();
		if (Generallbl.isDisplayed() &
		Reqlbl.isDisplayed() &
		Reslbl.isDisplayed() & 
		offerlbl.isDisplayed() &
		Applybtn.isDisplayed())
		{
		
		return true;
		}
		
		return false;
		
	}
	
	public void Formsubmit() 
	{
		clickButton(Applybtn);
	}
	
	public void Jobapply(String email) throws AWTException
	{
		scrollToBottom();
		emailtxt.sendKeys(email);
		upload();
		clickButton(agreecheck);
	    clickButton(submitbtn);
        clickButton(closebtn);
	}
	
	public void Citychoose()
	{
		s=new Select(Locationdrop);
		s.selectByVisibleText("Sofia");
		List<WebElement> datas = drvier.findElements(By.className("card-container"));
		for (WebElement data : datas) {
			System.out.println(data.getAttribute("href"));
			System.out.println(data.getAttribute("h2"));
			System.out.println(data.getAttribute("img"));
		}
	}
	 
	public void upload() throws AWTException
	{
		String cvName = "Sara Ghareb-SRqc.pdf";
		String cvPath = System.getProperty("user.dir")+"\\Uploads\\"+cvName;
		uploadbtn.click();
		Robot robot = new Robot();
		StringSelection selection = new StringSelection(cvPath);
		System.out.println(cvPath);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(selection, null);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(2000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
}
