package TestComponents;

import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
public static WebDriver driver;
	
	public WebDriver initializeDriver() throws IOException {
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")
				+"/src/main/java/Resources/globalData.properties");
		prop.load(fis);
		String getbrowser=prop.getProperty("browser");
		WebDriver driver=new ChromeDriver(); 	
		if(getbrowser.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			
		}
		else if(getbrowser.equalsIgnoreCase("firefox")) {
			
		}
		else if(getbrowser.equalsIgnoreCase("edge")) {
			
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
		
	}
	
	public String getScrennShot(String testcasename,WebDriver driver) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File file=new File(System.getProperty("user.dir")+"//reports//"+ testcasename+".png");
		FileUtils.copyFile(source,file);
		return System.getProperty("user.dir")+"//reports//"+ testcasename+".png";
	}
	
	
	@BeforeMethod(alwaysRun=true)
	public void LaunchApp() throws IOException {
		driver=initializeDriver();	
		driver.get("https://dev-new.cloptify.com/");
	}
	@AfterMethod(alwaysRun=true)
	public void tearDown()
	{
	//	driver.close();
	}


	
}
