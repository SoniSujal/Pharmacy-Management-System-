package com.pharmacy.util;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for ValidationUtil
 * 
 * @author Your Name
 * @version 1.0
 */
public class ValidationUtilTest {

    @Test
    public void testValidEmail() {
        assertTrue("Valid email should return true", ValidationUtil.isValidEmail("test@example.com"));
        assertTrue("Valid email should return true", ValidationUtil.isValidEmail("user.name@domain.co.uk"));
        assertTrue("Valid email should return true", ValidationUtil.isValidEmail("user+tag@example.org"));
    }

    @Test
    public void testInvalidEmail() {
        assertFalse("Invalid email should return false", ValidationUtil.isValidEmail("invalid-email"));
        assertFalse("Invalid email should return false", ValidationUtil.isValidEmail("@example.com"));
        assertFalse("Invalid email should return false", ValidationUtil.isValidEmail("test@"));
        assertFalse("Invalid email should return false", ValidationUtil.isValidEmail(""));
        assertFalse("Invalid email should return false", ValidationUtil.isValidEmail(null));
    }

    @Test
    public void testValidPhoneNumber() {
        assertTrue("Valid phone number should return true", ValidationUtil.isValidPhoneNumber("1234567890"));
        assertTrue("Valid phone number should return true", ValidationUtil.isValidPhoneNumber("9876543210"));
    }

    @Test
    public void testInvalidPhoneNumber() {
        assertFalse("Invalid phone number should return false", ValidationUtil.isValidPhoneNumber("123456789"));
        assertFalse("Invalid phone number should return false", ValidationUtil.isValidPhoneNumber("12345678901"));
        assertFalse("Invalid phone number should return false", ValidationUtil.isValidPhoneNumber("123456789a"));
        assertFalse("Invalid phone number should return false", ValidationUtil.isValidPhoneNumber(""));
        assertFalse("Invalid phone number should return false", ValidationUtil.isValidPhoneNumber(null));
    }

    @Test
    public void testValidString() {
        assertTrue("Valid string should return true", ValidationUtil.isValidString("test"));
        assertTrue("Valid string should return true", ValidationUtil.isValidString(" test "));
    }

    @Test
    public void testInvalidString() {
        assertFalse("Empty string should return false", ValidationUtil.isValidString(""));
        assertFalse("Whitespace string should return false", ValidationUtil.isValidString("   "));
        assertFalse("Null string should return false", ValidationUtil.isValidString(null));
    }

    @Test
    public void testValidPositiveNumber() {
        assertTrue("Positive double should return true", ValidationUtil.isValidPositiveNumber(5.5));
        assertTrue("Positive int should return true", ValidationUtil.isValidPositiveNumber(10));
    }

    @Test
    public void testInvalidPositiveNumber() {
        assertFalse("Zero should return false", ValidationUtil.isValidPositiveNumber(0));
        assertFalse("Negative number should return false", ValidationUtil.isValidPositiveNumber(-5));
        assertFalse("Negative double should return false", ValidationUtil.isValidPositiveNumber(-2.5));
    }
} 