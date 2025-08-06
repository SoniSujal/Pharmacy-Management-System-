package com.pharmacy.model;

/**
 * Order model class representing a pharmacy order
 * 
 * @author Your Name
 * @version 1.0
 */
public class Order {
    private String orderId;
    private String customerId;
    private String productCode;
    private String productName;
    private double amount;
    private int quantity;

    /**
     * Constructor for Order
     * 
     * @param orderId Unique order ID
     * @param customerId Customer's ID who placed the order
     * @param productName Name of the product ordered
     * @param amount Total amount for the order
     * @param quantity Quantity of the product ordered
     */
    public Order(String orderId, String customerId, String productName, double amount, int quantity) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.productName = productName;
        this.amount = amount;
        this.quantity = quantity;
    }

    // Getters
    public String getOrderId() {
        return orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getProductName() {
        return productName;
    }

    public double getAmount() {
        return amount;
    }

    public int getQuantity() {
        return quantity;
    }

    // Setters
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId + ", Product Name: " + productName +
               ", Amount: " + amount + ", Quantity: " + quantity;
    }
} 