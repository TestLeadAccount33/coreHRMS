package com.util;

import org.testng.Assert;

public class TestngUtils {

	
	 public static void assertTrue(String actual,String expected)
	 {
		 Assert.assertNotNull(actual,"Actual text is NULL");
		 if(actual.contains(expected))
		 {
			 Assert.assertTrue(true);
		 }
		 else
		 {
			 Assert.fail(expected+" not present in "+actual);
		 }
	 }

	 public static void assertFail(String message) {
		

	 }
	 
	 

}
