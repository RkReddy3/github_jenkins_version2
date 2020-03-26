package orangeHRM.Testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import orangeHRM.baseclass.TestBase;
import orangeHRM.pages.Homepage;
import orangeHRM.pages.Loginpage;

public class deletesimpleemploeforpractice extends TestBase {
	
	Loginpage loginpage;
	Homepage homepage;
	@Test
	public void simpledelete() {
		intialize();
		loginpage=new Loginpage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		driver.switchTo().frame("rightMenu");
		driver.findElement(By.xpath("//input[@value='8680']")).click();
		driver.findElement(By.xpath("//input[@value='8681']")).click();
		driver.findElement(By.xpath("//input[@value='Delete']")).click();
		
	}
	
	

}
