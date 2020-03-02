import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.autodesk.crm.commonlib.FileLib;
import com.autodesk.crm.commonlib.WebDriverUtils;

public class SelectContactAndDeleteOneContactWithHeaderDeleteAndCancel {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
	}
	@Test
	public void data() throws IOException{
		FileInputStream fil=new FileInputStream("./Data/commondata.properties3");
		Properties pobj = new Properties();
		pobj.load(fil);
		 String browser = pobj.getProperty("browser");
		 String url = pobj.getProperty("url");
		 String username = pobj.getProperty("username");
		 String password = pobj.getProperty("password");
		System.out.println(browser+""+url+""+username+""+password);
		WebDriver driver=null;
		 
		 if(browser.equals("chrome")){
			 driver = new ChromeDriver();
		 }
		 else{
			 driver=new FirefoxDriver();
		 }
		 WebDriverUtils ut = new WebDriverUtils();
		 ut.waitforelement(driver);
	driver.get(url);
	driver.findElement(By.name("user_name")).sendKeys(username);
	driver.findElement(By.name("user_password")).sendKeys(password);
	driver.findElement(By.id("submitButton")).click();
	driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
	driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	//driver.findElement(By.className("crmbutton small save")).click();
	WebElement element = driver.findElement(By.name("salutationtype"));
	ut.select(element, 1);
	
	FileLib fi = new FileLib();
	String firstname = fi.getExcelData("sheet1", 1, 0);
	driver.findElement(By.name("firstname")).sendKeys(firstname);
	String lastname = fi.getExcelData("sheet1", 1, 1);
	driver.findElement(By.name("lastname")).sendKeys(lastname);
	
	driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();
	
	
	
	//public void switchtonewtab(WebDriver driver, String pagetitle) {
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows)
		{
			driver.switchTo().window(window);
			String currentUrl = driver.getCurrentUrl();
			System.out.println(currentUrl);
			String expectedUrl = "http://localhost:8888/index.php?module=Accounts&action=Popup&popuptype=specific_contact_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid=";
			if (currentUrl.contains(expectedUrl)) 
			{
				WebElement table = driver.findElement(By.xpath("(//table[@class='small'])[3]/tbody/tr[2]/td[1]/a"));
				table.click();
			}
			driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		}
		
	}
	
	
	
	}


