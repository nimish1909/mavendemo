package com.invoice_module;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.autodesk.crm.commonlib.FileLib;
import com.autodesk.crm.commonlib.WebDriverUtils;
import com.vendor_module.Pom_loginpage;

public class Invoice2way {
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
	     
	      driver.get(url);
	      
	      Pom_loginpage po = new Pom_loginpage(driver);
	      po.logintoapp(user, password);
	      po.getLoginbtn();
	      //String expectedtitle = "Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM";
          String pw = driver.getWindowHandle();
	      pom_Create_invoice1 inv = new pom_Create_invoice1(driver);
          WebElement more = inv.getMore();
          wb.movetoelement(more, driver);
          inv.invoice();
          inv.createinvoice();
          inv.namefield();
          inv.organization();
          
          wb.window(driver);//windowhandle
          inv.getTcs().click();
          wb.acceptAlert(driver);
       		  
       	  driver.switchTo().window(pw);
          inv.getSales().click();
          
          wb.window(driver);
          inv.getSalestcs().click();
          driver.switchTo().window(pw);
          inv.getSavebtn().click();
          
//          WebElement admin = inv.getAdminstration();
//          wb.movetoelement(admin, driver);
//          inv.getLogout().click();
          inv.logout();
          
	      
	      
}
}