package com.pharmacy.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utility class for validation methods
 * 
 * @author Your Name
 * @version 1.0
 */
public class ValidationUtil {

    /**
     * Validates email format using regex pattern
     * 
     * @param email Email address to validate
     * @return true if email is valid, false otherwise
     */
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    /**
     * Validates phone number format (10 digits)
     * 
     * @param phoneNumber Phone number to validate
     * @return true if phone number is valid, false otherwise
     */
    public static boolean isValidPhoneNumber(String phoneNumber) {
        // Allow only 10-digit numbers
        return phoneNumber.matches("\\d{10}");
    }

    /**
     * Validates if a string is not null or empty
     * 
     * @param str String to validate
     * @return true if string is not null and not empty, false otherwise
     */
    public static boolean isValidString(String str) {
        return str != null && !str.trim().isEmpty();
    }

    /**
     * Validates if a number is positive
     * 
     * @param number Number to validate
     * @return true if number is positive, false otherwise
     */
    public static boolean isValidPositiveNumber(double number) {
        return number > 0;
    }

    /**
     * Validates if a number is positive
     * 
     * @param number Number to validate
     * @return true if number is positive, false otherwise
     */
    public static boolean isValidPositiveNumber(int number) {
        return number > 0;
    }
} 