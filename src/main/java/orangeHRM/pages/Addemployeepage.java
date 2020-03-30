package orangeHRM.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import orangeHRM.baseclass.TestBase;

public class Addemployeepage extends TestBase{
	
	//page Factory-OR;
		@FindBy(name="txtUserName")
		WebElement username;
		
		@FindBy(name="txtPassword")
		WebElement password;
		
		@FindBy(name="Submit")
		WebElement login;
		
		@FindBy(linkText="PIM")
		WebElement pim;
		
		@FindBy(linkText="Add Employee")
		WebElement addemployee;
		
		@FindBy(id="txtEmployeeId")
		static
		WebElement Empcode;
		
		@FindBy(name="txtEmpLastName")
		WebElement lastname;
		
		@FindBy(name="txtEmpFirstName")
		WebElement firstname;
		
		@FindBy(id="btnEdit")
		WebElement save;
		
		public Addemployeepage() {
		PageFactory.initElements(driver, this);
		}
		public void movetoaddemployee() throws InterruptedException {
			act.moveToElement(pim).perform();
			addemployee.click();
			Thread.sleep(2000);
			driver.switchTo().frame("rightMenu");
			
		}
		
		public String getempcode() {
			String adempid=Empcode.getAttribute("value");
			return adempid;
		}
		
		public Employeelistpage addemp(String ln,String fn) throws InterruptedException {
			Thread.sleep(2000);
			lastname.sendKeys(ln);
			firstname.sendKeys(fn);
			save.click();
			return new Employeelistpage();
		}
		
		
		
		
}
