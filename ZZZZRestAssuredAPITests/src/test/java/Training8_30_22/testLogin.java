package Training8_30_22;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class testLogin {
	
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
	public void testYahooLogin() throws Exception {
		driver.get("https://login.yahoo.com/");
		Thread.sleep(200);
		
		driver.findElement(By.id("createacc")).click();
		Thread.sleep(200);
		
		String title1 = driver.getTitle();
		Assert.assertEquals("Yahoo", title1);
		
		WebElement firstName = driver.findElement(By.name("firstName"));	
		firstName.sendKeys("Abc");
		Thread.sleep(200);
		
		WebElement lastName = driver.findElement(By.name("lastName"));
		lastName.sendKeys("Def");
		Thread.sleep(200);
		
		WebElement email = driver.findElement(By.name("userId"));
		email.sendKeys("adef10000000");
		Thread.sleep(200);
		
		WebElement passwd = driver.findElement(By.name("password"));
		passwd.sendKeys("12345678_90asdfjkl;");
		Thread.sleep(200);
		
		WebElement bYear = driver.findElement(By.name("birthYear"));
		bYear.sendKeys("1990");
		Thread.sleep(200);
		
		driver.findElement(By.name("signup")).click();
		
		String title2 = driver.getTitle();
		Assert.assertEquals("Yahoo", title2);
	}
	
	@Test
	public void testTelerikLogin() throws Exception{
		driver.get("https://www.telerik.com/login/v2/telerik#register");
		Thread.sleep(2000);
		
		WebElement email = driver.findElement(By.name("Email"));	
		email.sendKeys("adef10000000@yahoo.com");
		Thread.sleep(200);
		
		WebElement firstName = driver.findElement(By.name("FirstName"));	
		firstName.sendKeys("Abc");
		Thread.sleep(200);
		
		WebElement lastName = driver.findElement(By.name("LastName"));
		lastName.sendKeys("Def");
		Thread.sleep(200);
		
		driver.findElement(By.id("Textbox-3")).sendKeys("Nisum");
		Thread.sleep(3000);
		Select country = new Select (driver.findElement(By.name("Country")));
		Thread.sleep(3000);
		country.selectByVisibleText("USA");
		Thread.sleep(2000);
		
		Select state = new Select (driver.findElement(By.name("State")));
		Thread.sleep(3000);
		state.selectByVisibleText("California");
		Thread.sleep(2000);
		
		WebElement phone = driver.findElement(By.name("PhoneNumber"));
		phone.sendKeys("1234567890");
		Thread.sleep(1000);
		

		driver.findElement(By.xpath("html/body/div[1]/div/div/div[2]/section[2]/div/div[1]/div[1]/div/div/div[3]/div[10]/button")).click();
		
		String title = driver.getTitle();

		Assert.assertEquals("Telerik Client Login", title);
	}
	
	@Test
	public void testRediffRegister() throws Exception{
		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("/html/body/center/form/div/table[2]/tbody/tr[3]/td[3]/input")).sendKeys("Joshs Test");//full name
		Thread.sleep(200);
		
		driver.findElement(By.xpath("/html/body/center/form/div/table[2]/tbody/tr[7]/td[3]/input[1]")).sendKeys("Joshuas_TEST");//id
		Thread.sleep(200);
		
		driver.findElement(By.id("newpasswd")).sendKeys("alksdjflajsdf_;oalsdijf");
		Thread.sleep(200);
		
		driver.findElement(By.id("newpasswd1")).sendKeys("alksdjflajsdf_;oalsdijf");
		Thread.sleep(200);
		
		driver.findElement(By.xpath("/html/body/center/form/div/table[2]/tbody/tr[14]/td/div/table/tbody/tr[1]/td[3]/input")).sendKeys("altJoshua");
		Thread.sleep(200);
		
		driver.findElement(By.xpath("/html/body/center/form/div/table[2]/tbody/tr[20]/td/div/table/tbody/tr/td[3]/div[3]/input")).sendKeys("1234567890");
		Thread.sleep(2000);
		
		Select day = new Select(driver.findElement(By.xpath("/html/body/center/form/div/table[2]/tbody/tr[22]/td[3]/select[1]")));
		day.selectByVisibleText("01");
		Thread.sleep(2000);
		
		Select month = new Select(driver.findElement(By.xpath("/html/body/center/form/div/table[2]/tbody/tr[22]/td[3]/select[2]")));
		month.selectByVisibleText("JAN");
		Thread.sleep(2000);
		
		Select year = new Select(driver.findElement(By.xpath("/html/body/center/form/div/table[2]/tbody/tr[22]/td[3]/select[3]")));
		year.selectByVisibleText("2000");
		Thread.sleep(2000);
		
		driver.findElement(By.id("Register")).click();
	}

}
