package groupForMethod;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Group { 
	
	
	@Test(groups="smoke")
	public void test_createuser(){
		Reporter.log("user is created",true);
	}
	@Test(groups="smoke")
	public void test_deleteuser(){
		Reporter.log("user is deletd",true);
	}
	@Test(groups="smoke")
	public void test_edituser(){
		Reporter.log("user is edited",true);
	}
	@Test(groups="regression")
	public void test_createproduct(){
		Reporter.log("product is created",true);
	}
	@Test(groups="regression")
	public void test_deleteproduct()
	{
		Reporter.log("delete is product",true);
	}

}
