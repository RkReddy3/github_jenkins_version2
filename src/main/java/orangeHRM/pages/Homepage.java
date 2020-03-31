package orangeHRM.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;
import orangeHRM.baseclass.TestBase;

public class Homepage extends TestBase {
	
	@FindBy(id="companyLogoHeader")
	WebElement homepagelogo;
	
	@FindBy(linkText="PIM")
	WebElement pim;
	
	@FindBy(linkText="Add Employee")
	WebElement addemployee;
	
	@FindBy(name="txtEmployeeId")
	WebElement Empcode;
	
	@FindBy(xpath="//ul[@id='option-menu']/li")
	WebElement welcome;
	
	@FindBy(linkText="Change Password")
	WebElement ChangePwd;

	@FindBy(id="Logout")
	WebElement Logout;
	
	public Homepage() {
		PageFactory.initElements(driver, this);
		}
	@Step("verifyhomepagetitle")
	public String verifyhomepagetitle() {
		return driver.getTitle();
	}
	
	@Step("verifycorrectPIM")
	public boolean verifycorrectPIM() {
		return pim.isDisplayed();
	}
	
	@Step("clickaddemp")
	public Addemployeepage clickaddemp() throws InterruptedException {
		mouseover();
		Thread.sleep(2000);
		act.moveToElement(pim).perform();
		Thread.sleep(2000);
		addemployee.click();
		Thread.sleep(2000);
		driver.switchTo().frame("rightMenu");
		return new Addemployeepage();
		
		
	}
}
