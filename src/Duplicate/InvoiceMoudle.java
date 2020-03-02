package Duplicate;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.autodesk.crm.commonlib.BaseClass;
import com.invoice_module.pom_Create_invoice1;

public class InvoiceMoudle extends BaseClass {
	@Test
	public void test() throws IOException, InterruptedException {
		/**
		 * step1 navigate to invoice
		 */
		String pw = driver.getWindowHandle();
		pom_Create_invoice1 inv = new pom_Create_invoice1(driver);
		WebElement more = inv.getMore();
		lib.movetoelement(more, driver);
		inv.invoice();

		inv.createinvoice();
		inv.namefield();
		inv.organization();
		/**
		 * step2: go to child window
		 */

		lib.window(driver);// windowhandle
		inv.getTcs().click();
		lib.acceptAlert(driver);

		/**
		 * step3: back to parent window
		 */
		driver.switchTo().window(pw);
		inv.getSales().click();

		/**
		 * step4: goto parent window and save it
		 */

		lib.window(driver);
		inv.getSalestcs().click();
		driver.switchTo().window(pw);
		inv.getSavebtn().click();

	}

}
