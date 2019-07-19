package com.amazon.qa.testpages;

import org.testng.annotations.Test;

import com.amazon.qa.pages.LogIn;
import com.amazon.qa.util.TestUtil;

public class TestLogIn extends TestUtil{
	
	
	@Test
	public static void RunLoginTest()
	{
		LogIn.LoginTest();
	}

}
