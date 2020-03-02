package com.autodesk.crm.commonlib;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class WebDriverUtils {
	/**
	 * get the random number with in the range 10000
	 * @return
	 */
	public int getRanDomNum() {
		Random ram = new Random();
		return ram.nextInt(10000);
	}
	
	public void waitForElemnetToVisible(WebDriver driver , WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * it's custom wait , it will always wait for element for 20 sec & click on element if exist
	 * 
	 * @param driver
	 * @param element
	 * @throws InterruptedException
	 */
	public void waitAndclickElement(WebDriver driver , WebElement element) throws InterruptedException {
		 int count =0;
	       while(count <=20) {
	    	    try {
	    	    	element.click();
			       break;
	    	    }catch (Throwable t) {
					Thread.sleep(1000);
					count++;
				}
	       }
	}
	
	/**
	 * ExplicitlyWaitElementsToBeClickable 
	 * @param element
	 * @param driver
	 */

	public void waitforelementstatus(WebElement element, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
/**
 * ExplicitlyWaitForPageTitle
 * @param title
 * @param driver
 */
	public void waitforpagetitlecontains(String title, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleContains(title));
	}
/**
 * ImplicitlyWait
 * @param driver
 */
	public void waitforelement(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	/**
	 * SelectByVisibleText
	 * @param element
	 * @param text
	 */

	public void select(WebElement element, String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
/**
 * SelectByIndex
 * @param element
 * @param index
 */
	public void select(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	/**
	 * MouseHovering
	 * @param element
	 * @param driver
	 */
	public void movetoelement(WebElement element, WebDriver driver) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
/**
 * WindowHandle
 * @param driver
 * @param pagetitle
 */
	public void switchtonewtab(WebDriver driver, String pagetitle) {
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			driver.switchTo().window(window);
			String currentpage = driver.getTitle();
			if (currentpage.contains(pagetitle)) {
				break;
			}
		}
	}
/**
 * AcceptAlertPopUp
 * @param driver
 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	/**
	 * DismissAlertPopUp
	 * @param driver
	 */
	

	public void dismissalert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	public void selectByVisibleText(String string) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * for multiple window
	 */
	public void window(WebDriver driver){
		 Set<String> whs = driver.getWindowHandles();
       for(String w:whs){
   	  if(driver.equals(w)){
    		  System.out.println(w);
    	  }
    	  else{
     		  driver.switchTo().window(w);
	}
      }       
    }
	
	/* for goto child window*/	
	static String parentWinID;
	 static String childWindowID;
	public void switchToChildWindow(WebDriver driver) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		  parentWinID =  it.next();
		  childWindowID =  it.next();
		
		driver.switchTo().window(childWindowID);
	}
	/*for goto back parent window */
	public void switchToParentWindow(WebDriver driver) {
	
		driver.switchTo().window(parentWinID);
	}
	
	}