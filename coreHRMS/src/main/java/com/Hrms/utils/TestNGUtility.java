package com.Hrms.utils;

import org.testng.Assert;

public class TestNGUtility {

    // This method checks if the actual string contains the expected string
    public static void assertTrue(String actual, String expected) {

        Assert.assertNotNull(actual, "Actual text is NULL");

        if (actual.contains(expected)) {
            Assert.assertTrue(true);
        } else {
            Assert.fail(expected + " not present in " + actual);
        }
    }

    // This method checks if expected and actual integers are equal
    public static void assertEquals(int expected, int actual) {

        if (actual == expected) {
            Assert.assertEquals(actual, expected);
        } else {
            Assert.fail(expected + " is not matched with " + actual);
        }
    }

    // Explicitly fail a test with a message
    public static void assertFail(String logMessage) {
        Assert.fail(logMessage);
    }
}
