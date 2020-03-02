package com.invoice_module;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.autodesk.crm.commonlib.FileLib;
import com.autodesk.crm.commonlib.WebDriverUtils;
import com.vendor_module.Pom_loginpage;

public class Invoice_module {
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
     String pw = driver.getWindowHandle();
     wb.switchtonewtab(driver, expectedtitle);
      if(driver.getTitle().equals(expectedtitle)){
    	  pom_Create_invoice1 m1 = new pom_Create_invoice1(driver);
    	  WebElement mor = m1.getMore();
    	  wb.movetoelement(mor, driver);
    	  m1.invoice();
    	  m1.createinvoice();
    	  m1.namefield();
    	  m1.organization();
      Set<String> whs = driver.getWindowHandles();
    	  for(String w:whs){
    		  if(pw.equals(w)){
    			  System.out.println(w);
    	  }else{
    		  driver.switchTo().window(w);
    		  m1.getTcs().click();
    		  wb.acceptAlert(driver);
    	  }
    		  driver.switchTo().window(pw);
    		  	  
    	  }
    	  //invoice2 naam se kiya h yeh prog
    	  

}
}}