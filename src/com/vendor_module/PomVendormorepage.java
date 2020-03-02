package com.vendor_module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomVendormorepage {
	@FindBy(xpath="//a[text()='More']")
	private WebElement More;
	@FindBy(name="Vendors")
	private WebElement vendore;
	
	public WebElement getVendore() {
		return vendore;
	}

	public PomVendormorepage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	public WebElement getMore() {
		return More;
	}
	public void vendore(){
		vendore.click();
	}
}
