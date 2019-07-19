package com.amazon.qa.pages;

import org.openqa.selenium.By;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.amazon.qa.util.TestUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ConditionsOfUse extends TestUtil{
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	
	@BeforeSuite
	public static void ExtentReport()
	{
		htmlReporter = new ExtentHtmlReporter("./ExtentReports/ConditionsOfUseReport.html;");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}
	
	
	@Test
	public static void Conditions()
	{
		ExtentTest Test1 = extent.createTest("Clicking on Conditions Of Use Link", "This is test to vaidate the link works");
		Test1.log(Status.INFO, "Starting Test Case");
		
		Click(By.xpath("//a[@id='nav-link-accountList']"));
		Test1.log(Status.PASS, "Clicked on log in button");
		
		System.out.println("Parent Window Title = " + driver.getTitle());
		Test1.log(Status.PASS, "Printed Title of the login page");
		
		Click(By.xpath("//a[@href='/gp/help/customer/display.html/ref=ap_desktop_footer_cou?ie=UTF8&nodeId=508088']"));
		Test1.log(Status.PASS, "Clicked on Conditions of use link");
		
		SwitchWindows();
		System.out.println("Child Window Title = " + driver.getTitle());
		Test1.log(Status.PASS, "Switched focus onto the child window and printed the title of the new page");
	}
	
	@AfterSuite
	public static void TearDown()
	{
		extent.flush();
	}

}
