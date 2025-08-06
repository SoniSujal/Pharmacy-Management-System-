package com.pharmacy.service;

import com.pharmacy.model.Customer;
import com.pharmacy.model.Distributor;
import com.pharmacy.model.Order;
import com.pharmacy.util.ValidationUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Service class for managing customers, distributors, and orders
 * 
 * @author Your Name
 * @version 1.0
 */
public class CustomerManager {
    private ArrayList<Customer> customers;
    private ArrayList<Distributor> distributors;
    private ArrayList<Order> orders;
    private static int orderIdCounter = 1000;
    private HashMap<String, Double> productPrices;

    /**
     * Constructor initializes data structures and populates sample data
     */
    public CustomerManager() {
        this.customers = new ArrayList<>();
        this.distributors = new ArrayList<>();
        this.orders = new ArrayList<>();
        this.productPrices = new HashMap<>();

        // Populate productPrices with sample data
        productPrices.put("aspirin", 5.0);
        productPrices.put("paracetamol", 3.0);
        productPrices.put("ibuprofen", 7.0);
        productPrices.put("soliris", 25.0);
        productPrices.put("cinryze", 115.0);
        productPrices.put("elaprase", 30.0);
        productPrices.put("cipro", 10.0);

        // Add sample customers
        Customer customer1 = new Customer("sujal", "1", "surat", "8780290182", "sujalsoni@gmail.com", "1234");
        Customer customer2 = new Customer("om", "2", "vapi", "8782547800", "om@gmail.com", "525255");
        customers.add(customer1);
        customers.add(customer2);

        // Add sample distributor
        Distributor distributor1 = new Distributor("nk", "1", "veraval", "1st jan 2023", 25000, "9737594985", "nk@gmail.com", "9810");
        distributors.add(distributor1);
    }

    /**
     * Checks if a product is available in the product catalog
     * 
     * @param productName Name of the product to check
     * @return true if product is available, false otherwise
     */
    private boolean isProductAvailable(String productName) {
        return productPrices.containsKey(productName.toLowerCase());
    }

    /**
     * Registers a new customer with validation
     * 
     * @param name Customer's name
     * @param id Customer's unique ID
     * @param address Customer's address
     * @param phoneNumber Customer's phone number
     * @param email Customer's email address
     * @param password Customer's password
     */
    public void registerCustomer(String name, String id, String address, String phoneNumber, String email, String password) {
        Scanner scanner = new Scanner(System.in);
        
        while (!ValidationUtil.isValidEmail(email)) {
            System.out.print("Enter a valid email: ");
            email = scanner.nextLine();
        }
        
        while (!ValidationUtil.isValidPhoneNumber(phoneNumber)) {
            System.out.print("Enter a valid phone number: ");
            phoneNumber = scanner.nextLine();
        }
        
        customers.add(new Customer(name, id, address, phoneNumber, email, password));
        System.out.println("Registration successful for customer: " + name);
    }

    /**
     * Registers a new distributor with validation
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
    public void registerDistributor(String name, String id, String address, String joiningDate, double salary,
                                    String phoneNumber, String email, String password) {
        Scanner scanner = new Scanner(System.in);
        
        while (!ValidationUtil.isValidEmail(email)) {
            System.out.print("Enter a valid email: ");
            email = scanner.nextLine();
        }
        
        while (!ValidationUtil.isValidPhoneNumber(phoneNumber)) {
            System.out.print("Enter a valid phone number: ");
            phoneNumber = scanner.nextLine();
        }
        
        distributors.add(new Distributor(name, id, address, joiningDate, salary, phoneNumber, email, password));
        System.out.println("Registration successful for distributor: " + name);
    }

    /**
     * Authenticates customer login
     * 
     * @param name Customer's name
     * @param password Customer's password
     * @return Customer object if login successful, null otherwise
     */
    public Customer loginCustomer(String name, String password) {
        for (Customer customer : customers) {
            if (customer.getName().equals(name) && customer.getPassword().equals(password)) {
                System.out.println("Customer login successful for: " + name);
                return customer;
            }
        }
        System.out.println("Invalid customer username or password");
        return null;
    }

    /**
     * Authenticates distributor login
     * 
     * @param name Distributor's name
     * @param password Distributor's password
     * @return Distributor object if login successful, null otherwise
     */
    public Distributor loginDistributor(String name, String password) {
        for (Distributor distributor : distributors) {
            if (distributor.getName().equals(name) && distributor.getPassword().equals(password)) {
                System.out.println("Distributor login successful for: " + name);
                return distributor;
            }
        }
        System.out.println("Invalid distributor username or password");
        return null;
    }

    /**
     * Places an order for a customer
     * 
     * @param customer Customer placing the order
     * @param productName Name of the product to order
     * @param quantity Quantity of the product
     */
    public void placeOrder(Customer customer, String productName, int quantity) {
        if (!isProductAvailable(productName)) {
            System.out.println("Sorry, " + productName + " is not available.");
            return;
        }

        double productPrice = productPrices.get(productName.toLowerCase());
        double amount = productPrice * quantity;
        String orderId = "ORD" + orderIdCounter++;

        orders.add(new Order(orderId, customer.getId(), productName, amount, quantity));
        System.out.println("Order placed successfully with ID: " + orderId);
    }

    /**
     * Displays all available products and their prices
     */
    public void displayAvailableProducts() {
        System.out.println("Available Products:");
        for (String productName : productPrices.keySet()) {
            System.out.println(productName + " - Price: $" + productPrices.get(productName));
        }
    }

    /**
     * Displays all registered customers
     */
    public void printAllCustomers() {
        System.out.println("All Customers:");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    /**
     * Edits customer details by customer ID
     * 
     * @param customerId ID of the customer to edit
     */
    public void editCustomerDetails(String customerId) {
        Customer foundCustomer = null;
        for (Customer customer : customers) {
            if (customer.getId().equals(customerId)) {
                foundCustomer = customer;
                break;
            }
        }
        
        if (foundCustomer != null) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Editing details for customer with ID: " + customerId);
            System.out.println("Current details: " + foundCustomer);

            System.out.print("Enter new name (press Enter to skip): ");
            String newName = scanner.nextLine().trim();
            if (!newName.isEmpty()) {
                foundCustomer.setName(newName);
            }

            System.out.print("Enter new address (press Enter to skip): ");
            String newAddress = scanner.nextLine().trim();
            if (!newAddress.isEmpty()) {
                foundCustomer.setAddress(newAddress);
            }

            System.out.print("Enter new phone number (press Enter to skip): ");
            String newPhoneNumber = scanner.nextLine().trim();
            if (!newPhoneNumber.isEmpty()) {
                foundCustomer.setPhoneNumber(newPhoneNumber);
            }

            System.out.print("Enter new email (press Enter to skip): ");
            String newEmail = scanner.nextLine().trim();
            if (!newEmail.isEmpty()) {
                foundCustomer.setEmail(newEmail);
            }

            System.out.print("Enter new Password (press Enter to skip): ");
            String newPassword = scanner.nextLine().trim();
            if (!newPassword.isEmpty()) {
                foundCustomer.setPassword(newPassword);
            }

            System.out.println("Customer details updated successfully.");
        } else {
            System.out.println("Customer with ID " + customerId + " not found.");
        }
    }
    
    /**
     * Deletes a customer by customer ID
     * 
     * @param customerId ID of the customer to delete
     */
    public void deleteCustomer(String customerId) {
        int index = -1;
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId().equals(customerId)) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            customers.remove(index);
            System.out.println("Customer with ID " + customerId + " deleted successfully.");
        } else {
            System.out.println("Customer with ID " + customerId + " not found.");
        }
    }
    
    /**
     * Manages orders for a specific customer
     * 
     * @param customerId ID of the customer to manage orders for
     */
    public void placeOrderForCustomer(String customerId) {
        Customer customer = null;
        for (Customer c : customers) {
            if (c.getId().equals(customerId)) {
                customer = c;
                break;
            }
        }

        if (customer == null) {
            System.out.println("Customer with ID " + customerId + " not found.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. See order details for customer " + customerId);
            System.out.println("2. Edit order details for customer " + customerId);
            System.out.println("3. Entered Ordered for customer " + customerId);
            System.out.println("4. Back");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    System.out.println("Order details for customer " + customerId + ":");
                    boolean foundOrders = false;
                    for (Order order : orders) {
                        if (order.getCustomerId().equals(customerId)) {
                            System.out.println(order);
                            foundOrders = true;
                        }
                    }
                    if (!foundOrders) {
                        System.out.println("No orders found for customer " + customerId);
                    }
                    break;
                case 2:
                    System.out.println("Editing order details for customer " + customerId + ":");
                    System.out.print("Enter order ID to edit: ");
                    String orderId = scanner.nextLine();
                    boolean foundOrder = false;
                    for (Order order : orders) {
                        if (order.getCustomerId().equals(customerId) && order.getOrderId().equals(orderId)) {
                            System.out.print("Enter new Product Name (press Enter to skip): ");
                            String newProductName = scanner.nextLine().trim().toLowerCase();
                            if (!newProductName.isEmpty()) {
                                if (isProductAvailable(newProductName)) {
                                    order.setProductName(newProductName);
                                    double productPrice = productPrices.get(newProductName);
                                    order.setAmount(productPrice * order.getQuantity());
                                    System.out.println("Product name updated successfully.");
                                } else {
                                    System.out.println("Product name not found in the available products.");
                                }
                            }

                            System.out.print("Enter new Product Quantity (press Enter to skip): ");
                            String quantityInput = scanner.nextLine().trim();
                            if (!quantityInput.isEmpty()) {
                                try {
                                    int newQuantity = Integer.parseInt(quantityInput);
                                    order.setQuantity(newQuantity);
                                    order.setAmount(productPrices.get(order.getProductName()) * newQuantity);
                                    System.out.println("Quantity updated successfully.");
                                } catch (NumberFormatException e) {
                                    System.out.println("Invalid quantity input.");
                                }
                            }
                            foundOrder = true;
                            break;
                        }
                    }
                    if (!foundOrder) {
                        System.out.println("Order with ID " + orderId + " not found for customer " + customerId);
                    }
                    break; 
                case 3:
                    System.out.println("Adding order for customer " + customerId + ":");
                    System.out.print("Enter Product Name: ");
                    String productName = scanner.nextLine().toLowerCase();
                    if (!isProductAvailable(productName)) {
                        System.out.println("Product not found in the available products.");
                        break;
                    }
                
                    System.out.print("Enter Quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                
                    double productPrice = productPrices.get(productName);
                    double amount = productPrice * quantity;
                    String orderId1 = "ORD" + orderIdCounter++;
                    orders.add(new Order(orderId1, customerId, productName, amount, quantity));
                    System.out.println("Order placed successfully with ID: " + orderId1);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option");
            }
        }
    }
} 