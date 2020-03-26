package orangeHRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import orangeHRM.baseclass.TestBase;

public class Employeelistpage extends TestBase{
	
	@FindBy(linkText="PIM")
	WebElement pim;
	
	@FindBy(linkText="Employee List")
	WebElement employeelist;
	
	@FindBy(xpath="//form[@id='standardView']//h2")
	WebElement empinfo;
	
	@FindBy(xpath="//form[@id='standardView']//h2")
	WebElement employeedisply;
	
	
	public Employeelistpage() {
		PageFactory.initElements(driver, this);
		}
	public void verifyemployeelist() throws InterruptedException {
		driver.switchTo().parentFrame();
		mouseover();
		Thread.sleep(2000);
		act.moveToElement(pim).perform();
		Thread.sleep(2000);
		employeelist.click();
		Thread.sleep(2000);
		driver.switchTo().frame("rightMenu");
	}
	public void verifyempinfoheading() {
		String info=empinfo.getText();
		Assert.assertEquals(info, "Employee Information","notmatched with required info");
		empinfo.isDisplayed();
	}
	
		
	public void selectcheckboxbyempid(String name) {
		driver.findElement(By.xpath("//*[@id='standardView']//input[@value='"+name+"']")).click();
		
	}
	
	
	
	
	
	
	
	
	
	

}
