package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SigninPage {
	WebDriver driver;
	public SigninPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath ="//*[@id=\"email\"]")
	WebElement Email;
	@FindBy(xpath ="//*[@id=\"password\"]")
	WebElement password;
	@FindBy(xpath ="//button[@type='submit']")
	WebElement submit;
	//@FindBy(xpath="//a[@class='decoration-none' and @href='/forget-password']/h2[text()='Forgot your password?']")
	WebElement fp;
	
	
	public void signinAction() {
	Email.sendKeys("shikha.j@gopherslab.com");
		password.sendKeys("Test@123");
		submit.click();
	//	fp.click();
	}
}
