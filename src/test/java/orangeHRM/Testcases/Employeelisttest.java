package orangeHRM.Testcases;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import orangeHRM.baseclass.TestBase;
import orangeHRM.pages.Addemployeepage;
import orangeHRM.pages.Employeelistpage;
import orangeHRM.pages.Homepage;
import orangeHRM.pages.Loginpage;
import orangeHRM.utilities.Util;

public class Employeelisttest extends TestBase{
	Loginpage loginpage;
	Homepage homepage;
	Addemployeepage addemployee;
	Employeelistpage emplist;
	Util util;
	
	 public Employeelisttest() {
		 super();
	}
	 
	 @BeforeMethod
		public void setup() throws InterruptedException {
			intialize();
			loginpage=new Loginpage();
			homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
			addemployee=homepage.clickaddemp();
//			String empid=addemployee.getempcode();
//			System.out.println(empid);
			emplist=addemployee.addemp("ramkrishna","reddy");	
			
		}
	 @Test
	 public void verifyemployeeinfotest() throws InterruptedException {
		 //String empid=addemployee.getempcode();
		 emplist.verifyemployeelist();
		 emplist.verifyempinfoheading();
		 Thread.sleep(5000);
		 //driver.findElement(By.xpath("//input[@value='"+empid+"']")).click();
		 Thread.sleep(5000);
		 //System.out.println(empid);
	 }
	 
	 @AfterMethod
		public void close() {
			driver.quit();
		}
}
