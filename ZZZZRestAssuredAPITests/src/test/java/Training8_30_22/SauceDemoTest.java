package Training8_30_22;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SauceDemoTest {

	private WebDriver driver;
	
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Joshua\\Desktop\\WORK\\Jar_files\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

	@Test
	public void sauceDemo() throws Exception {
		driver.get("https://www.saucedemo.com/");
		
		driver.findElement(By.name("user-name")).sendKeys("standard_user");
		Thread.sleep(200);
		
		driver.findElement(By.name("password")).sendKeys("secret_sauce");
		Thread.sleep(1000);
		
		driver.findElement(By.name("login-button")).click();
		Thread.sleep(200);
		
		driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a")).click();
		Thread.sleep(200);
		
		String title = driver.getTitle();
		Assert.assertEquals("Swag Labs", title); 
		
	}

}
