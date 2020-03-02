package com.pom;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.autodesk.crm.commonlib.FileLib;
import com.autodesk.crm.commonlib.WebDriverUtils;

public class ContactModule {

	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
	} 
	@Test
	public void data() throws IOException{
		FileInputStream fil = new FileInputStream("./Data/commondata.properties4");
		Properties pobj = new Properties();
		pobj.load(fil);
		String browser = pobj.getProperty("browser");
		String url = pobj.getProperty("url");
		String username = pobj.getProperty("username");
		String password = pobj.getProperty("password");
		WebDriver driver=null;
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
	
           WebDriverUtils ut = new WebDriverUtils();
          ut.switchtonewtab(driver,"Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM");
           if(driver.getTitle().equals("Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM")){
        	   driver.findElement(By.xpath("//a[text()='Contacts']")).click();
        	   driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
        	   WebElement element = driver.findElement(By.name("salutationtype"));
        		ut.select(element, 1);
        		FileLib fi = new FileLib();
        		String firstname = fi.getExcelData("sheet1", 1, 0);
        		driver.findElement(By.name("firstname")).sendKeys(firstname);
        		String lastname = fi.getExcelData("sheet1", 1, 1);
        		driver.findElement(By.name("lastname")).sendKeys(lastname);
        		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
        		driver.findElement(By.xpath("(//input[@name='Delete'])[1]")).click();
        		driver.switchTo().alert().dismiss();
        		WebElement mov = driver.findElement(By.xpath("(//img[@src='themes/softed/images/user.PNG'])"));
                Actions act = new Actions(driver);
                act.moveToElement(mov).perform();
                driver.findElement(By.xpath("//a[text()='Sign Out']")).click();   
           }
	}
	

	}

