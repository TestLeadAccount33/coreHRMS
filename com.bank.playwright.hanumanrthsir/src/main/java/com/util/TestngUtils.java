package com.util;

import org.testng.Assert;

public class TestngUtils {

	
	 public static void assertTrue(String actual,String expected)
	 {
		 if(actual.contains(expected))
		 {
			 Assert.assertTrue(false);
		 }
		 else
		 {
			 Assert.fail(expected+" not present in "+actual);
		 }
	 }

	 public static void assertFail(String message) {
		// TODO Auto-generated method stub
		
	 }
	 
	 

}
