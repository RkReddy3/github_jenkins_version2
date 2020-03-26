package orangeHRM.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import orangeHRM.baseclass.TestBase;
import orangeHRM.pages.Homepage;
import orangeHRM.pages.Loginpage;

public class Homepagetest extends TestBase{
	Loginpage loginpage;
	Homepage homepage;
	
	 public Homepagetest() {
		 super();
	}
	 
	 @BeforeMethod
		public void setup() {
			intialize();
			loginpage=new Loginpage();
			homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		}
	 
	 @Test
	 public void verifyhomepagetittleTest() {
		 String homepagetitle=homepage.verifyhomepagetitle();
		 Assert.assertEquals(homepagetitle, "OrangeHRM","home page title not matched");		 
	 }
	 @Test
	 public void verifyPIMtest() {
		 homepage.verifycorrectPIM();
		 Assert.assertTrue(homepage.verifycorrectPIM());
	 }
	 
	 @Test
	 public void addemplyclicktest() throws InterruptedException {
		 homepage.clickaddemp();
	 }
	 
	 
	 @AfterMethod
		public void close() {
			driver.quit();
		}
	 
}
