package orangeHRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import orangeHRM.baseclass.TestBase;

public class Empdeletepage extends TestBase {
	Addemployeepage addemployee;
	
	
	
	@FindBy(xpath="//input[@value='Delete']")
	WebElement deletebutton;
	
	public Empdeletepage() {
		PageFactory.initElements(driver, this);
		}
		
	public void clickoncheckbox() throws InterruptedException {
		Thread.sleep(5000);
		String empid=addemployee.getempcode();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@value='"+empid+"']")).click();
		Thread.sleep(5000);
	}
	public void deleteemployee() throws InterruptedException  {
		Thread.sleep(5000);
		System.out.println("entered into delete");
		Thread.sleep(5000);
		deletebutton.click();
		
	}

}
