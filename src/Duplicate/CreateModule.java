package Duplicate;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.autodesk.crm.commonlib.BaseClass;
import com.pom.Homepage;
import com.pom.Leedpage;

public class CreateModule extends BaseClass {
	Homepage hp = new Homepage(driver);
	Leedpage lp = new Leedpage(driver);

	@Test
	public void data() throws IOException {
		/**
		 * step1: verify the home page title
		 */
		String expectedtitle = "Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedtitle);
		/**
		 * step2:create object of home page
		 */

		hp.ClickOnleadModule();
		/**
		 * step3: create an object of Lead page
		 */

		lp.createlead();
		/**
		 * step4: select the option of lead page
		 */
		WebElement selection = lp.getSalutation();
		lib.select(selection, 1);

		/**
		 * step5:taking the data from excel and put in lead page
		 */
		String firstname = flib.getExcelData("sheet2", 1, 0) + lib.getRanDomNum();
		String lastname = flib.getExcelData("sheet2", 1, 1) + lib.getRanDomNum();
		String company = flib.getExcelData("sheet2", 1, 2) + lib.getRanDomNum();

		/**
		 * step6:putting the data into lead page
		 */

		lp.leadinformation(firstname, lastname, company);
		lp.savebtn();

		// ld.getClickOnFirstName();
		// ld.getClickOnLastName();
		// ld.getClickOnCompany();
	}
}
