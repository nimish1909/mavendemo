package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	@FindBy(xpath="(//a[text()='Leads'])[1]")
	private WebElement clickonLeads;

	public Homepage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	
	public void ClickOnleadModule(){
		clickonLeads.click();
	}

	
	
	

}
