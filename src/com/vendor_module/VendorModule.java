package com.vendor_module;

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
import com.pom.Homepage;

public class VendorModule {
//	static {
//		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
//		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
//	      }
	@Test
	
	public void test() throws IOException, InterruptedException{
		FileLib li = new FileLib();
		String browser = li.getPropertyKeyValue("browser");
		String url = li.getPropertyKeyValue("url");
		String user = li.getPropertyKeyValue("user");
		String password = li.getPropertyKeyValue("password");
		
		WebDriver driver=null;
		if(browser.equals("chrome")){
			driver=new ChromeDriver();
		}
		else{
			driver=new FirefoxDriver();
		}
		
      WebDriverUtils wb = new WebDriverUtils();
      wb.waitforelement(driver);
      wb.waitforelement(driver);
      driver.get(url);
      
      Pom_loginpage po = new Pom_loginpage(driver);
      po.logintoapp(user, password);
      po.getLoginbtn();
      
     String expectedtitle = "Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM";
     
     wb.switchtonewtab(driver, expectedtitle);
      if(driver.getTitle().equals(expectedtitle)){
    	 PomVendormorepage wx = new PomVendormorepage(driver);
    	 Actions act = new Actions(driver);
 		act.moveToElement(wx.getMore()).perform();
    	  driver.findElement(By.name("Vendors")).click();
        }
//       WebElement vendorPage = driver.findElement(By.name("Vendors"));
//       vendorPage.click();
//      String expectedTitleVendorpage = "Administrator - Vendors - vtiger CRM 5 - Commercial Open Source CRM";  
//        String actualVendorPage = vendorPage.getText();
//        if(expectedTitleVendorpage.equals(actualVendorPage))
//        {
//        	System.out.println("vendor page verified");
//        	}else
//        	{
//        		System.out.println("vendor not  verified");
//        	}
        
     // Thread.sleep(2000);
      //wb.switchtonewtab(driver, expectedTitleVendorpage);
//       if (driver.getTitle().equals(expectedTitleVendorpage)){
    	   Pomvendore vp = new Pomvendore(driver);
    	 vp.cretaefilter();
    	 vp.viewnametxt();
    	 
    	  WebElement clm = vp.getColumn();
		    wb.select(clm, 2);
		    
		    WebElement sign = vp.getSignout();
		    wb.movetoelement(sign, driver);
		    
		    vp.logout();
      
		
	}

	}
