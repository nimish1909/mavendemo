package com.vendor_module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pomvendore {
	@FindBy(xpath="//a[contains(text(),'Create Filter')]")
	private WebElement Createfilter;
	@FindBy(name="viewName")
	private WebElement Viewname;
	@FindBy(id="column2")
	private WebElement column;
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement Adminstration;
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement Logout;
	
	public Pomvendore(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getCreatefilter() {
		return Createfilter;
	}
	public WebElement getSignout() {
		return Adminstration;
	}

	public WebElement getLogout() {
		return Logout;
	}

	public WebElement getColumn() {
		return column;
	}

	public WebElement getViewname() {
		return Viewname;
	}
	public void viewnametxt(){
		Viewname.sendKeys("nimish");
	}
   public void cretaefilter(){
	   Createfilter.click();  
   }
   public void cloumn(){
	column.click();
  }
  public void logout(){
	  Logout.click();
  }
}
