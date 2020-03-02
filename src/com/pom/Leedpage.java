package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Leedpage {
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement CreateLeads;

	@FindBy(name="salutationtype")
	private WebElement Salutation;
	
	@FindBy(name="firstname")
	private WebElement FirstName;
	
	public WebElement getSalutation() {
		return Salutation;
	}
	@FindBy(name="lastname")
	private WebElement LastName;
	
	@FindBy(name="company")
	private WebElement Company;
	
	@FindBy(xpath="(//input[@type='submit'])[1]")
	private WebElement xpath;
	
	@FindBy(xpath="(//img[@src='themes/softed/images/user.PNG'])")
    private WebElement xpath1;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signout;


	

	public WebElement getClickOnFirstName() {
		return FirstName;
	}

	public WebElement getClickOnLastName() {
		return LastName;
	}

	public WebElement getClickOnCompany() {
		return Company;
	}
	
	
		
		public Leedpage(WebDriver driver){
	    	PageFactory.initElements(driver, this);
			
	}
		public void leadinformation(String firstname,String lastname,String company){
			
		    FirstName.sendKeys(firstname);
			LastName.sendKeys(lastname);
			Company.sendKeys(company);
			
		}
	
		public void createlead(){
			CreateLeads.click();
			}
		public void savebtn(){
			xpath.click();
		}
		public void actionsign(){
			xpath1.click();
		}
		public void logout(){
			signout.click();
		}
	
}
