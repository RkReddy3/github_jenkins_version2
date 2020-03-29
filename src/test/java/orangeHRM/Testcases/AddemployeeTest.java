package orangeHRM.Testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import orangeHRM.baseclass.TestBase;
import orangeHRM.pages.Addemployeepage;
import orangeHRM.pages.Homepage;
import orangeHRM.pages.Loginpage;

public class AddemployeeTest extends TestBase {
	Loginpage loginpage;
	Homepage homepage;
	Addemployeepage addemployee;
	
	 public AddemployeeTest() {
		 super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		intialize();
		loginpage=new Loginpage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		addemployee=homepage.clickaddemp();
					
	}
	
	@Test
	public void Addemployee() throws InterruptedException {
		addemployee.addemp("Reddy","Ramkrishna");
		
	}
	
	@AfterMethod
	public void close() {
		driver.quit();
	}

}
