package com.amazon.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.util.TestUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


import io.github.bonigarcia.wdm.WebDriverManager;

public class LogIn extends TestUtil{
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	
	@BeforeSuite
	public static void ExtentReport()
	{
		htmlReporter = new ExtentHtmlReporter("./ExtentReports.ExtentReport.html;");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}
	
	@Test
	public static void LoginTest()
	{
		com.aventstack.extentreports.ExtentTest Test1 = extent.createTest("Logging Into Amazon Account", "This is test to validate amazon login functionality");
		
		Test1.log(Status.INFO, "Starting Test Case");
		
		Click(By.xpath("//a[@id='nav-link-accountList']"));
		Test1.pass("Clicked on login button");
		
		Type(By.xpath("//input[@id='ap_email']"), prop.getProperty("username"));
		Test1.pass("Entered username in the box");
		
		Type(By.xpath("//input[@id='ap_password']"), prop.getProperty("password"));
		Test1.pass("Entered password in the box");
		
		ExplicitWait(By.cssSelector("input[id='signInSubmit']"), 10);
		Click(By.cssSelector("input[id='signInSubmit']"));
		Test1.pass("Test Completed");
		
		
	}
	
	@AfterSuite
	public static void TearDown()
	{
		extent.flush();
	}
	
	
	
	
}
