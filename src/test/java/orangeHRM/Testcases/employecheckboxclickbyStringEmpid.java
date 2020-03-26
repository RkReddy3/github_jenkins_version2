package orangeHRM.Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class employecheckboxclickbyStringEmpid {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\rkreddy\\rkrworkspace\\drivers\\src\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		Actions act=new Actions(driver);
		driver.get("http://apps.qaplanet.in/hrm/login.php");
		driver.findElement(By.name("txtUserName")).sendKeys("qaplanet1");
		driver.findElement(By.name("txtPassword")).sendKeys("lab1");
		driver.findElement(By.name("Submit")).click();
		act.moveToElement(driver.findElement(By.linkText("PIM"))).perform();
		driver.findElement(By.linkText("Add Employee")).click();
		driver.switchTo().frame("rightMenu");
		Thread.sleep(2000);
		String empid=driver.findElement(By.id("txtEmployeeId")).getAttribute("value");
		System.out.println(empid);
		
		driver.findElement(By.name("txtEmpLastName")).sendKeys("reddy checkbox test");
		driver.findElement(By.name("txtEmpFirstName")).sendKeys("Ramkrishna checkbox test");
		driver.findElement(By.id("btnEdit")).click();
		driver.switchTo().parentFrame();
		act.moveToElement(driver.findElement(By.linkText("PIM"))).perform();
		driver.findElement(By.linkText("Employee List")).click();
		Thread.sleep(2000);
		driver.switchTo().frame("rightMenu");
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//*[@id=\"standardView\"]/table/tbody/tr[4]/td[1]/input")).click();
		//driver.findElement(By.xpath("//input[@value='8632']")).click();
		driver.findElement(By.xpath("//input[@value='"+empid+"']")).click();
		driver.findElement(By.xpath("//input[@value='Delete']")).click();
	}

}
