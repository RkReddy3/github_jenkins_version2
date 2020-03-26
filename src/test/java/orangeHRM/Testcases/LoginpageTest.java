package orangeHRM.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import orangeHRM.baseclass.TestBase;
import orangeHRM.pages.Homepage;
import orangeHRM.pages.Loginpage;

public class LoginpageTest extends TestBase {
	Loginpage loginpage;
	Homepage homepage;
	
	 public LoginpageTest() {
		 super();
	}
	
	@BeforeMethod
	public void setup() {
		intialize();
		loginpage=new Loginpage();
	}
	
//	@Test(priority=1)
//	public void loginpageTitleTest() {
//		String title=loginpage.validatetitle();
//		Assert.assertEquals(title, prop.getProperty("reqtitle"));
//		
//	}
//	
//	@Test(priority=2)
//	public void logoTest() {
//		boolean b1=loginpage.validatelogo();
//		Assert.assertTrue(b1);
//	}
	
	@Test
	public void logintest() {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void close() {
		driver.quit();
	}

}
