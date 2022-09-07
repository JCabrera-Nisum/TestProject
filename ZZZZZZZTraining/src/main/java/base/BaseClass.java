package base;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseClass {
	public static WebDriver driver;
	public static Logger log = LogManager.getLogger();
	
	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Joshua\\Desktop\\WORK\\Jar_files\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		if(driver == null) {
			log.info("No driver started");
		}
	}
	
	@AfterSuite
	public void tearDown() throws Exception {
		log.info("Goodbye!");
		
		if(driver != null) {
			Thread.sleep(300);
			driver.quit();
		}
	}

}
