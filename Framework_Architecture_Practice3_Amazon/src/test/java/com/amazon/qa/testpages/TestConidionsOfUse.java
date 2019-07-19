package com.amazon.qa.testpages;

import org.testng.annotations.Test;

import com.amazon.qa.pages.ConditionsOfUse;
import com.amazon.qa.util.TestUtil;

public class TestConidionsOfUse extends TestUtil{
	
	@Test
	public static void TestConditions()
	{
		ConditionsOfUse.Conditions();
	}

}
