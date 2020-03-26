package orangeHRM.Testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import orangeHRM.baseclass.TestBase;
import orangeHRM.pages.Addemployeepage;
import orangeHRM.pages.Homepage;
import orangeHRM.pages.Loginpage;
import orangeHRM.utilities.SimpleDatautil;
import orangeHRM.utilities.Testdata;

public class Data_Driven_Test extends TestBase{
	
	Loginpage loginpage;
	Homepage homepage;
	Addemployeepage addemployee;
	
	public Data_Driven_Test() {
		 super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException{
		intialize();
		loginpage=new Loginpage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	//===========================================================================
	@DataProvider
	public Object[][] datafromexcel() throws IOException, InterruptedException{
	Object data[][]=Testdata.getTestData("rkreddy");
	return data;
	}
	@Test(dataProvider="datafromexcel")
	public void addempdetails(String lastname,String firstname) throws InterruptedException{
	addemployee=homepage.clickaddemp();
	addemployee.addemp(lastname,firstname);
	}
	//============================================================================	
	
	@AfterMethod
	public void close() {
		driver.quit();
	}
}
