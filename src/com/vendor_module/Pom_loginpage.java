package com.vendor_module;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pom_loginpage {
	@FindBy(name="user_name")
	private WebElement usernametxt;
	@FindBy(name="user_password")
	private WebElement passwordtxt;
	@FindBy(id="submitButton")
	private WebElement loginbtn;
	
	public WebElement getUsernametxt() {
		return usernametxt;
	}


	public WebElement getPasswordtxt() {
		return passwordtxt;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}

	public Pom_loginpage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
		public void logintoapp(String user,String password){
			usernametxt.sendKeys(user);
			passwordtxt.sendKeys(password);
			loginbtn.click();
		}
	}


