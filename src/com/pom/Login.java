package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	

	
	public WebElement getUserName(String username){
		return usernameEdt;
	}
    public WebElement getPassword(String password){
	   return passwordEdt;
    }
    public WebElement getLoginBtn(){
	   return loginBtn;
    }
    public void loginToApp(String username,String password){
    	usernameEdt.sendKeys(username);
    	passwordEdt.sendKeys(password);
    	loginBtn.click();
}
    public Login(WebDriver driver){
    	PageFactory.initElements(driver, this);
    }
}
