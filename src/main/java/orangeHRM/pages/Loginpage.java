package orangeHRM.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import orangeHRM.baseclass.TestBase;

public class Loginpage extends TestBase{

	//page Factory-OR;
	@FindBy(name="txtUserName")
	WebElement username;
	
	@FindBy(name="txtPassword")
	WebElement password;
	
	@FindBy(name="Submit")
	WebElement login;
	
	@FindBy(linkText="PIM")
	WebElement PIM;
	
	@FindBy(xpath="//*[@id=\"Table_01\"]/tbody/tr/td[1]/img")
	WebElement logo;
	
	//intializing the page objects
	public Loginpage() {
		PageFactory.initElements(driver, this);
	}
	//Actions
	public String validatetitle() {

		return driver.getTitle();
			
	}
	public boolean validatelogo() {
		return logo.isDisplayed();
		
	}
	public Homepage login(String un,String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		login.click();
		return new Homepage();
	}
	
	
	
	
	
	
}
