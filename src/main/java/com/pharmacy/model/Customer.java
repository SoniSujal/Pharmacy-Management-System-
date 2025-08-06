package com.pharmacy.model;

/**
 * Customer model class representing a pharmacy customer
 * 
 * @author Your Name
 * @version 1.0
 */
public class Customer {
    private String name;
    private String id;
    private String address;
    private String phoneNumber;
    private String email;
    private String password;

    /**
     * Constructor for Customer
     * 
     * @param name Customer's name
     * @param id Customer's unique ID
     * @param address Customer's address
     * @param phoneNumber Customer's phone number
     * @param email Customer's email address
     * @param password Customer's password
     */
    public Customer(String name, String id, String address, String phoneNumber, String email, String password) {
        this.name = name;
        this.id = id;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", ID: " + id + ", Address: " + address + 
               ", Phone Number: " + phoneNumber + ", Email: " + email;
    }
} 