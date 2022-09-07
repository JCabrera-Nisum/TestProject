package training8_31_22;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Login_with_Excel {

	private WebDriver driver;
	private XSSFWorkbook wb;
	private File f;
	private FileInputStream input;

	private final String file = "C:\\\\Users\\\\Joshua\\\\Desktop\\\\WORK\\\\JSON_files\\\\login_test.xlsx";
	private FileOutputStream out;



	@Before
	public void setUp() throws IOException {
		f = new File(file);
		input = new FileInputStream(f);

		wb = new XSSFWorkbook(input);

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Joshua\\Desktop\\WORK\\Jar_files\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@After
	public void tearDown() throws Exception {
		input.close();
		out.close();
		wb.close();

		Thread.sleep(2000);
		driver.quit();
	}

		@Test
		public void testYahooExcel() throws Exception {
			XSSFSheet ya = wb.getSheet("YAHOO");
			
			driver.get("https://login.yahoo.com/");
			Thread.sleep(200);
			
			driver.findElement(By.id("createacc")).click();
			Thread.sleep(200);
			
			driver.findElement(By.name("firstName")).sendKeys(ya.getRow(1).getCell(0).toString());
			Thread.sleep(200);
			
			driver.findElement(By.name("lastName")).sendKeys(ya.getRow(1).getCell(1).toString());
			Thread.sleep(200);
			
			driver.findElement(By.name("userId")).sendKeys(ya.getRow(1).getCell(2).toString());
			Thread.sleep(200);
			
			driver.findElement(By.name("password")).sendKeys(ya.getRow(1).getCell(3).toString());
			Thread.sleep(200);
			
			driver.findElement(By.name("birthYear")).sendKeys(ya.getRow(1).getCell(4).toString());
			Thread.sleep(200);
			
			driver.findElement(By.name("signup")).click();
			
			String title = driver.getTitle();
			Assert.assertEquals(ya.getRow(1).getCell(5).toString(), title);
			
			//set actual value in excel sheet
			
			Cell act = ya.getRow(1).getCell(6);//actual value
			act.setCellValue(title);
			
			//set result value in excel sheet
			Cell res = ya.getRow(1).getCell(7);//result of writing to excel sheet
			if(ya.getRow(1).getCell(5).toString().equals(title)) {
				res.setCellValue("pass");
			}
			else {
				res.setCellValue("fail");
			}
			
			out = new FileOutputStream(file);
			wb.write(out);
			
		}
		
	@Test
	public void testTelerikExcel() throws Exception{
		XSSFSheet te = wb.getSheet("TELERIK");

		driver.get("https://www.telerik.com/login/v2/telerik#register");
		Thread.sleep(2000);

		driver.findElement(By.name("Email")).sendKeys(te.getRow(1).getCell(0).toString());
		Thread.sleep(2000);

		driver.findElement(By.name("FirstName")).sendKeys(te.getRow(1).getCell(1).toString());
		Thread.sleep(2000);

		driver.findElement(By.name("LastName")).sendKeys(te.getRow(1).getCell(2).toString());
		Thread.sleep(2000);

		driver.findElement(By.id("Textbox-3")).sendKeys(te.getRow(1).getCell(3).toString());
		Thread.sleep(3000);
		Select country = new Select (driver.findElement(By.name("Country")));
		Thread.sleep(300);
		country.selectByVisibleText(te.getRow(1).getCell(4).toString());
		Thread.sleep(2000);

		Select state = new Select (driver.findElement(By.name("State")));
		Thread.sleep(300);
		state.selectByVisibleText(te.getRow(1).getCell(5).toString());
		Thread.sleep(2000);

		driver.findElement(By.name("PhoneNumber")).sendKeys(te.getRow(1).getCell(6).toString());
		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@id=\"form--1\"]/div[3]/div[10]/button")).click();

		String title = driver.getTitle();
		Assert.assertEquals(te.getRow(1).getCell(7).toString(), title);

		//set actual value in excel sheet
		Cell act = te.getRow(1).getCell(8);//actual value
		act.setCellValue(title);

		//set result value in excel sheet
		Cell res = te.getRow(1).getCell(9);//result of writing to excel sheet
		if(te.getRow(1).getCell(7).toString().equals(title)) {
			res.setCellValue("pass");
		}
		else {
			res.setCellValue("fail");
		}

		out = new FileOutputStream(file);
		wb.write(out);
	}

	@Test
	public void testRediffRegister() throws Exception{
		XSSFSheet red = wb.getSheet("REDIFF");

		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[starts-with(@name, 'name')]")).sendKeys(red.getRow(1).getCell(0).toString());//full name
		Thread.sleep(200);

		driver.findElement(By.xpath("//input[starts-with(@name, 'login')]")).sendKeys(red.getRow(1).getCell(1).toString());
		Thread.sleep(200);

		driver.findElement(By.xpath("//input[starts-with(@name, 'passwd')]")).sendKeys(red.getRow(1).getCell(2).toString());
		Thread.sleep(200);

		driver.findElement(By.xpath("//input[starts-with(@name, 'confirm_passwd')]")).sendKeys(red.getRow(1).getCell(3).toString());
		Thread.sleep(200);

		driver.findElement(By.xpath("//input[starts-with(@name, 'altemail')]")).sendKeys(red.getRow(1).getCell(4).toString());
		Thread.sleep(200);

		driver.findElement(By.xpath("//input[starts-with(@name, 'mobno')]")).sendKeys(red.getRow(1).getCell(5).toString());
		Thread.sleep(200);

		Select day = new Select(driver.findElement(By.xpath("/html/body/center/form/div/table[2]/tbody/tr[22]/td[3]/select[1]")));
		double da = Double.parseDouble(red.getRow(1).getCell(6).toString());
		int d = (int) da;
		day.selectByVisibleText(String.valueOf(d));
		Thread.sleep(1000);

		Select month = new Select(driver.findElement(By.xpath("/html/body/center/form/div/table[2]/tbody/tr[22]/td[3]/select[2]")));
		month.selectByVisibleText(red.getRow(1).getCell(7).toString());
		Thread.sleep(1000);

		Select year = new Select(driver.findElement(By.xpath("/html/body/center/form/div/table[2]/tbody/tr[22]/td[3]/select[3]")));
		double mo = Double.parseDouble(red.getRow(1).getCell(8).toString());
		int m = (int) mo;
		year.selectByVisibleText(String.valueOf(m));
		Thread.sleep(2000);

		String title = driver.getTitle();;
		Assert.assertEquals(red.getRow(1).getCell(9).toString(), title);

		//set actual value in excel sheet
		Cell act = red.getRow(1).getCell(10);//actual value
		act.setCellValue(title);

		//set result value in excel sheet
		Cell res = red.getRow(1).getCell(11);//result of writing to excel sheet
		if(red.getRow(1).getCell(9).toString().equals(title)) {
			res.setCellValue("pass");
		}
		else {
			res.setCellValue("fail");
		}

		out = new FileOutputStream(file);
		wb.write(out);
	}

	@Test
	public void sauceDemo() throws Exception {
		XSSFSheet sau = wb.getSheet("SAUCEDEMO");
		driver.get("https://www.saucedemo.com/");

		driver.findElement(By.name("user-name")).sendKeys(sau.getRow(1).getCell(0).toString());
		Thread.sleep(200);

		driver.findElement(By.name("password")).sendKeys(sau.getRow(1).getCell(1).toString());
		Thread.sleep(1000);

		driver.findElement(By.name("login-button")).click();
		Thread.sleep(200);

		driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
		Thread.sleep(2000);

		String title = driver.getTitle();
		Assert.assertEquals(sau.getRow(1).getCell(2).toString(), title); 

		//set actual value in excel sheet
		Cell act = sau.getRow(1).getCell(3);//actual value
		act.setCellValue(title);

		//set result value in excel sheet
		Cell res = sau.getRow(1).getCell(4);//result of writing to excel sheet
		if(sau.getRow(1).getCell(2).toString().equals(title)) {
			res.setCellValue("pass");
		}
		else {
			res.setCellValue("fail");
		}

		out = new FileOutputStream(file);
		wb.write(out);
	}

}
