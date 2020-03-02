package com.invoice_module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.autodesk.crm.commonlib.WebDriverUtils;

public class pom_Create_invoice1 extends WebDriverUtils{
	
   WebDriver driver;
   public pom_Create_invoice1(WebDriver driver){
	this.driver = driver;
	PageFactory.initElements(driver, this);
}

	@FindBy(xpath="//a[text()='More']")
	private WebElement Moreac;
	@FindBy(name="Invoice")
	private WebElement invoice;
	@FindBy(xpath="//img[@title='Create Invoice...']")
	private WebElement Createinvoice;
	@FindBy(name="subject")
	private WebElement Namefield;
	@FindBy(xpath="(//img[@src='themes/softed/images/select.gif'])[3]")
	private WebElement Organization;
	@FindBy(id="2")
	private WebElement tcs;
	@FindBy(xpath="(//img[@src='themes/softed/images/select.gif'])[1]")
	private WebElement sales;
	@FindBy(id="1")
	private WebElement salestcs;
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement savebtn;
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement Adminstration;
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement Logout;
	
	
	public void logout() {
		movetoelement(Adminstration, driver);
		Logout.click();
	}
	
	
//	public WebElement getAdminstration() {
//		return Adminstration;
//	}


//	public WebElement getLogout() {
//		return Logout;
//	}


	public WebElement getSavebtn() {
		return savebtn;
	}


	public WebElement getSalestcs() {
		return salestcs;
	}


	public WebElement getSales() {
		return sales;
	}


	public WebElement getTcs() {
		return tcs;
	}


	public WebElement getOrganization() {
		return Organization;
	}


	public WebElement getNamefield() {
		return Namefield;
	}


//	public pom_Create_invoice(WebDriver driver){
//		PageFactory.initElements(driver, this);
//	}
//	

	public WebElement getMore() {
		return Moreac;
	}
	public WebElement getInvoice() {
		return invoice;
	}
    public void invoice(){
	invoice.click();
    }
    public void createinvoice(){
    	Createinvoice.click();
    }
    public void namefield(){
    	Namefield.sendKeys("nimish");
    }
    public void organization(){
    	Organization.click();
    }
    public void tcsselect(){
    	tcs.click();
    }
}
