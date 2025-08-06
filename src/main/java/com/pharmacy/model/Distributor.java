package com.pharmacy.model;

/**
 * Distributor model class representing a pharmacy distributor
 * 
 * @author Your Name
 * @version 1.0
 */
public class Distributor {
    private String name;
    private String id;
    private String address;
    private String joiningDate;
    private double salary;
    private String phoneNumber;
    private String email;
    private String password;

    /**
     * Constructor for Distributor
     * 
     * @param name Distributor's name
     * @param id Distributor's unique ID
     * @param address Distributor's address
     * @param joiningDate Distributor's joining date
     * @param salary Distributor's salary
     * @param phoneNumber Distributor's phone number
     * @param email Distributor's email address
     * @param password Distributor's password
     */
    public Distributor(String name, String id, String address, String joiningDate, double salary,
                       String phoneNumber, String email, String password) {
        this.name = name;
        this.id = id;
        this.address = address;
        this.joiningDate = joiningDate;
        this.salary = salary;
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

    public String getJoiningDate() {
        return joiningDate;
    }

    public double getSalary() {
        return salary;
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

    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }

    public void setSalary(double salary) {
        this.salary = salary;
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
               ", Joining Date: " + joiningDate + ", Salary: " + salary + 
               ", Phone Number: " + phoneNumber + ", Email: " + email;
    }
} 