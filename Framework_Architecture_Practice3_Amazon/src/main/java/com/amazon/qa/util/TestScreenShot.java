package com.amazon.qa.util;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import com.amazon.qa.base.TestBase;

public class TestScreenShot extends TestUtil{
	public static WebDriver driver;
	
	@AfterTest
	public static void TakeScreenShot(String errorShots)
	{
		try
		{
			TakesScreenshot ts = (TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyDirectory(src, new File("./ErrorScreenShots/"+errorShots+".png"));
			System.out.println("Screen Shot of the error taken");
		}
		
		catch (Exception e)
		{
			System.out.println("Error Occured While taking screenshot = " + e.getMessage());
		}
	}

}
