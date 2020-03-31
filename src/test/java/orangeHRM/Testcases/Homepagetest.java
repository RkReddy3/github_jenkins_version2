package orangeHRM.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ExtentReports.TestAllureListener;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import orangeHRM.baseclass.TestBase;
import orangeHRM.pages.Homepage;
import orangeHRM.pages.Loginpage;

@Listeners(TestAllureListener.class)
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
	 
	 @Test(priority=1,description="first test")
	 @Severity(SeverityLevel.NORMAL)
	 @Description("verify home page title test")
	 @Story("check title")
	 public void verifyhomepagetittleTest() {
		 String homepagetitle=homepage.verifyhomepagetitle();
		 Assert.assertEquals(homepagetitle, "OrangeHRM","home page title not matched");		 
	 }
	 @Test(priority=2,description="second test")
	 @Severity(SeverityLevel.NORMAL)
	 @Description("verify PIM Click test")
	 @Story("check title")
	 public void verifyPIMtest() {
		 homepage.verifycorrectPIM();
		 Assert.assertTrue(homepage.verifycorrectPIM());
	 }
	 
	 @Test(priority=3,description="third test")
	 @Severity(SeverityLevel.NORMAL)
	 @Description("verify add employee test")
	 @Story("check title")
	 public void addemplyclicktest() throws InterruptedException {
		 homepage.clickaddemp();
	 }
	 
	 
	 @AfterMethod
		public void close() {
			driver.quit();
		}
	 
}
