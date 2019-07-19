package com.amazon.qa.util;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazon.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	public static void Click(By selector)
	{
		WebElement element = driver.findElement(selector);
		element.click();
		
	}
	
	public static void Type(By selector, String setValue)
	{
		WebElement element = driver.findElement(selector);
		element.sendKeys(setValue);
	}
	
	public static void ClearField(By selector)
	{
		WebElement element = driver.findElement(selector);
		element.clear();
		
	}
	
	
	public static void ExplicitWait(By selector, int x)
	{
		WebDriverWait wait = new WebDriverWait(driver, x);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(selector)));
		//Other ways to use it:
		//wait.until(ExpectedConditions.visibilityOfAllElements((List<WebElement>)By.xpath(xlocator)));
		//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xlocator)));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xlocator)));
	}
	
	public static void SwitchWindows()
	{
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println("Window Handles = " + windowHandles);
		Iterator<String> it = windowHandles.iterator();
		String parentWindow = it.next();
		System.out.println("ParentWindow = " + parentWindow);
		String childWindow = it.next();
		System.out.println("ChildWindow = " + childWindow);
		driver.switchTo().window(childWindow);
		//If you want to bring focus back to parent window then first close the child window, 
		//then do driver.switchto().window(parentWindow);
	}
	
	
	public static void TearDown()
	{
		driver.close();
		driver.quit();
	}
	
	
	
}
