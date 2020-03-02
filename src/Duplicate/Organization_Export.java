package Duplicate;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.autodesk.crm.commonlib.WebDriverUtils;

public class Organization_Export {
	@Test

	public void data() throws IOException{
			FileInputStream fis=new FileInputStream(".//Data//commondata properties2.txt");
			Properties pobj=new Properties();
			pobj.load(fis);
			String browser = pobj.getProperty("browser");
			String url = pobj.getProperty("url");
			String username = pobj.getProperty("username");
			String password = pobj.getProperty("password");
			System.out.println(browser+""+url+""+username+""+password);
			WebDriver driver =null;
			
			if(browser.equals("chrome")){
				driver=new ChromeDriver();
			}
			else{
				driver=new FirefoxDriver();
			}
			driver.get(url);
			WebElement un = driver.findElement(By.name("user_name"));
			un.sendKeys(username);
			WebElement pw = driver.findElement(By.name("user_password"));
			pw.sendKeys(password);
			driver.findElement(By.id("submitButton")).click();
			driver.findElement(By.linkText("Organizations")).click();
			//driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
			driver.findElement(By.xpath("//img[@src='themes/softed/images/tbarExport.gif']")).click();
			driver.findElement(By.xpath("//input[@value='withoutsearch']")).click();
			driver.findElement(By.xpath("//input[@value='currentpage']")).click();
			driver.findElement(By.xpath("//input[@value='Export Organizations ']")).click();
			
			WebDriverUtils utils = new WebDriverUtils();
			utils.waitforelement(driver);
		
		
	}


}
