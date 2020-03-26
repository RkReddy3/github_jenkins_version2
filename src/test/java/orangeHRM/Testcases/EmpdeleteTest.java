package orangeHRM.Testcases;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import orangeHRM.baseclass.TestBase;
import orangeHRM.pages.Addemployeepage;
import orangeHRM.pages.Empdeletepage;
import orangeHRM.pages.Employeelistpage;
import orangeHRM.pages.Homepage;
import orangeHRM.pages.Loginpage;
import orangeHRM.utilities.Util;

public class EmpdeleteTest extends TestBase {
	Loginpage loginpage;
	Homepage homepage;
	Addemployeepage addemployee;
	Employeelistpage emplist;
	Empdeletepage delemp;
	Util util;
	
	 public EmpdeleteTest() {
		 super();
	}
	 
	 @BeforeMethod
		public void setup() throws InterruptedException {
			intialize();
			loginpage=new Loginpage();
			homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
			addemployee=homepage.clickaddemp();
			emplist=addemployee.addemp("ramkrishna","reddy");	
			String empid=addemployee.getempcode();
			emplist.verifyemployeelist();
			emplist.verifyempinfoheading();
			
			Thread.sleep(5000);
			driver.findElement(By.xpath("//input[@value='"+empid+"']")).click();
			
		}
	 @Test
	 public void deleteemployeetest() throws InterruptedException {
		 Thread.sleep(5000);
		 driver.findElement(By.xpath("//input[@value='Delete']")).click();
		 Thread.sleep(5000);
	 }
	
	 
	 @AfterMethod
		public void close() {
			driver.quit();
		}
}



