package com.amazon.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.amazon.qa.util.TestScreenShot;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;
	public static WebElement element;
	public static Properties prop;
	
	
	public TestBase()
	{
		try
		{
			prop = new Properties();
			FileInputStream fis = new FileInputStream("C:\\Users\\Adeel\\Desktop\\Framework_Architecture_Practice3_Amazon\\src\\main\\java\\com\\amazon\\qa\\config\\config.properties");
			prop.load(fis);
		}
		
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	@BeforeClass
	public static void Initialization()
	{
		String browserName = prop.getProperty("browser");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		
	}
	
	@AfterMethod
	public static void TearDown(ITestResult result)
	{
		if(ITestResult.FAILURE == result.getStatus())
		{
			TestScreenShot.TakeScreenShot(result.getName());
		}
		//driver.close();
		//driver.quit();
	}

}
