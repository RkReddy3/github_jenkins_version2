 package orangeHRM.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import orangeHRM.utilities.Util;
import orangeHRM.utilities.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static Actions act;
	public static WebDriverWait wait;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();
	public TestBase() {
		try {
			prop= new Properties();
			FileInputStream fip=new FileInputStream("C:\\Users\\Ramakrishna\\git\\github_jenkins_version2\\src\\main\\java\\orangeHRM\\configuration\\config.properties");
			prop.load(fip);
		}catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
		public static void intialize() {
		String browsername=prop.getProperty("browser");
		if(browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\rkreddy\\rkrworkspace\\drivers\\src\\drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}else if(browsername.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\rkreddy\\rkrworkspace\\drivers\\src\\drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		//==================================================================================
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		//==================================================================================
		
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Util.pageloadtimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Util.imlicitlywait, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		}
		
		public static void mouseover() {
			act=new Actions(driver);
		}
		
		public static synchronized WebDriver getDriver() {
			return tdriver.get();
		}
		
		public String getScreenshot() {
			File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
			String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
			File destination = new File(path);
			try {
				FileUtils.copyFile(src, destination);
			} catch (IOException e) {
				System.out.println("Capture Failed " + e.getMessage());
			}
			return path;
		}
		
		
		
		
	

}
