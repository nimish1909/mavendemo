package TestNGExcutecountinue;

/**
 * Open the Vtiger Web application using URL	https://testing-env:8888	Login page should be display	 
2	Login to CRM with Valid data	admin/manager	Home Page Should be display	 
3	Navigate to "LEAD"	 	Lead Page Should be display	 
4	Click on Quick Create and select NewLead	 	Creat New LeadPage Should be display	 
5	Enter the mandatory details & create a new Lead	Lead Name =TESCO	New Lead should be created with below details
"[ Lead*** ] TESCO - Lead Information   Updated today (Current Date) By Administrator "
vreify the Lead name  in Lead info Page	Author By JYOTI
6	Logout	 	Login page should be display
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.autodesk.crm.commonlib.FileLib;
import com.autodesk.crm.commonlib.WebDriverUtils;
import com.pom.Homepage;
import com.pom.Leedpage;
import com.pom.Login;

public class CreateLead {

	@Test
	public void data() throws IOException {
		FileInputStream fil = new FileInputStream("./Data/commondata.properties4");
		Properties pobj = new Properties();
		pobj.load(fil);
		String browser = pobj.getProperty("browser");
		String url = pobj.getProperty("url");
		String username = pobj.getProperty("username");
		String password = pobj.getProperty("password");
		WebDriver driver = null;
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else {
			driver = new FirefoxDriver();
		}
		WebDriverUtils ut = new WebDriverUtils();
		ut.waitforelement(driver);
		driver.get(url);
		Login lg = new Login(driver);

		lg.loginToApp(username, password);
		lg.getLoginBtn();

		ut.switchtonewtab(driver, "Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM");
		if (driver.getTitle().equals("Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM")) {

			Homepage hp = new Homepage(driver);
			hp.ClickOnleadModule();

			Leedpage lp = new Leedpage(driver);
			lp.createlead();

			ut.select(driver.findElement(By.name("salutationtype")), 1);

			FileLib fi = new FileLib();
			String firstname = fi.getExcelData("sheet2", 1, 0);
			String lastname = fi.getExcelData("sheet2", 1, 1);
			String company = fi.getExcelData("sheet2", 1, 2);

			lp.leadinformation(firstname, lastname, company);
			lp.savebtn();
			WebElement mov = driver.findElement(By.xpath("(//img[@src='themes/softed/images/user.PNG'])"));
			Actions act = new Actions(driver);
			act.moveToElement(mov).perform();
			driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

			// ld.getClickOnFirstName();
			// ld.getClickOnLastName();
			// ld.getClickOnCompany();
		}
	}
}
