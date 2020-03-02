package groupForMethod;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CompatibilityTest {
	WebDriver driver;
	@Parameters("browser")
	@BeforeMethod
	public void openBrowser(String browser){
		
		if(browser.equalsIgnoreCase("chrome")){
			//System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	    driver=new ChromeDriver();
	}
	else if(browser.equalsIgnoreCase("firefox")){
		//System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
	    driver=new FirefoxDriver();
		
	}
	}
@Test
public void test()
{
	Reporter.log("Browser  opened",true);
}
@AfterMethod
public void  closebroser(){
	driver.close();
}
}
	

	
