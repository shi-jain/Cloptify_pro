package TestCases;

import static org.junit.Assert.*;
import org.testng.annotations.Test;

import com.aventstack.extentreports.util.Assert;

import PageObject.SigninPage;
import PageObject.SignupPage;
import TestComponents.BaseTest;


public class SigninTest extends BaseTest {
	
	@Test
	public void signin() throws InterruptedException {
		SigninPage signin=new SigninPage(BaseTest.driver);
Thread.sleep(5);
	signin.signinAction();
	String title=driver.getTitle();
	System.out.println(title);
	org.testng.Assert.assertEquals(title, "Dashboard");
}
	
	public void signup() {
		SignupPage signup=new SignupPage(BaseTest.driver);
		signup.Signup();
		
	}
}
