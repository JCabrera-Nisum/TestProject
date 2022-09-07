package extentReporst;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class ExtentReportClass {

	public WebDriver driver;
	public ExtentSparkReporter spark;
	public ExtentReports extent;
	public ExtentTest logger;


	@Test
	public void YahooLogin() throws Exception {
		logger = extent.createTest("To verify Yahoo create account");
		
		driver.get("https://login.yahoo.com/");
		Thread.sleep(200);
		
		driver.findElement(By.id("createacc")).click();
		Thread.sleep(200);
		
		WebElement firstName = driver.findElement(By.name("firstName"));	
		firstName.sendKeys("Abc");
		Thread.sleep(200);
		
		WebElement lastName = driver.findElement(By.name("lastName"));
		lastName.sendKeys("Def");
		Thread.sleep(200);
		
		WebElement email = driver.findElement(By.name("userId"));
		email.sendKeys("adef10000");
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
	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Joshua\\Desktop\\WORK\\Jar_files\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws Exception{
		Thread.sleep(200);
		driver.quit();
	}

	@BeforeTest
	public void beforeTest() {
		extent = new ExtentReports();
		spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/YahooExtentReport.html");
		
		extent.attachReporter(spark);
		extent.setSystemInfo("User Name", "Joshua C");
		
		spark.config().setDocumentTitle("Testing Extents Report");
		spark.config().setReportName("Testing with Yahoo Login");
		
		spark.config().setTheme(Theme.DARK);
	}

	@AfterTest
	public void afterTest() {
		extent.flush();
	}

}
