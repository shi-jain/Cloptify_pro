package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {
	WebDriver driver;
	public SignupPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath = "//input[@placeholder='Enter email']")
	WebElement emailid;
	@FindBy(xpath = "//input[@placeholder='Enter first name']")
	WebElement firstname;
	@FindBy(xpath = "//input[@placeholder='Enter last name']")
	WebElement lastname;
	@FindBy(xpath = "//input[@placeholder='Enter original name']")
	WebElement orgname;
	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement ppcheckbox;
	@FindBy(xpath="//a[text()='Sign Up']")
	WebElement su;

	public void Signup() {
		su.click();
		emailid.sendKeys("test12@yopmail.com");
		firstname.sendKeys("test");
		lastname.sendKeys("test");
		orgname.sendKeys("cloptify22");
		ppcheckbox.click();
	}
	

}
