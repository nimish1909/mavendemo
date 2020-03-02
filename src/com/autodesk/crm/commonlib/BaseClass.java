package com.autodesk.crm.commonlib;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.invoice_module.pom_Create_invoice1;
import com.pom.Login;

public class BaseClass {
	public WebDriverUtils lib = new WebDriverUtils();    //Global 
	public FileLib flib = new FileLib();
	public WebDriver driver;
	
	@BeforeSuite 
	public void configBs() {
		System.out.println("connect to db");
	}
	
	@BeforeClass
	public void configBC() throws IOException {
		
		  String BROWSERNAME = flib.getPropertyKeyValue("browser");
		  
		  System.out.println("=======launch the Browser===========");
		  if(BROWSERNAME.equals("chrome")) {
		     driver = new ChromeDriver();
		  }else if(BROWSERNAME.equals("firefox")) {
			 driver = new FirefoxDriver(); 
		  }
		  
	}
	
	
	@BeforeMethod
	public void configBM() throws IOException {
		 String URL = flib.getPropertyKeyValue("url");
		 String USERNAME = flib.getPropertyKeyValue("username");
		 String PASSWORD = flib.getPropertyKeyValue("password");
		  System.out.println("login");
	  Login lp = new Login(driver);
	  lib.waitforelement(driver);
	  driver.get(URL);
	  lp.loginToApp(USERNAME, PASSWORD);
		  
	}
	
	
    @AfterMethod
	public void configAM() {
		  System.out.println("logout");
		  pom_Create_invoice1 hp =new pom_Create_invoice1(driver);
	        hp.logout();
		  
	}
	@AfterClass
	public void configAC() {
		  System.out.println("close the browser");
		  driver.close();
	}
	

	@AfterSuite
	public void configAs() {
		System.out.println("close the da connection");
	}


}
