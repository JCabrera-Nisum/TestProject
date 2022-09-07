package com.automatenow.testcases;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.BaseClass;

public class YahooLogin extends BaseClass{
	@Test
	public void testYahooLogin() throws Exception {

		driver.get("https://login.yahoo.com/");
		Thread.sleep(200);
		log.info("Set driver url");
		log.warn("Added thread sleep of 200");

		driver.findElement(By.id("createacc")).click();
		Thread.sleep(200);
		log.info("Click create account on Yahoo page");
		log.warn("Added thread sleep of 200");

		WebElement firstName = driver.findElement(By.name("firstName"));	
		firstName.sendKeys("Abc");
		Thread.sleep(200);
		log.info("Input first name");
		log.warn("Added thread sleep of 200");

		WebElement lastName = driver.findElement(By.name("lastName"));
		lastName.sendKeys("Def");
		Thread.sleep(200);
		log.info("Input last name");
		log.warn("Added thread sleep of 200");

		WebElement email = driver.findElement(By.name("userId"));
		email.sendKeys("adef1000000000");
		Thread.sleep(200);
		log.info("Input user id");

		WebElement passwd = driver.findElement(By.name("password"));
		passwd.sendKeys("12345678_90asdfjkl;");
		Thread.sleep(200);
		log.info("Input password");
		log.warn("Added thread sleep of 200");

		WebElement bYear = driver.findElement(By.name("birthYear"));
		bYear.sendKeys("1990");
		Thread.sleep(200);
		log.info("Input the birth year");
		log.warn("Added thread sleep of 200");

		driver.findElement(By.name("signup")).click();
		log.info("Click sign in button");

	}
}
