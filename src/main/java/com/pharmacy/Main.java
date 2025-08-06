package com.pharmacy;

import com.pharmacy.model.Customer;
import com.pharmacy.model.Distributor;
import com.pharmacy.service.CustomerManager;

import java.util.Scanner;

/**
 * Main class for the Pharmacy Management System
 * 
 * @author Your Name
 * @version 1.0
 */
public class Main {
    
    /**
     * Main method - entry point of the application
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        CustomerManager customerManager = new CustomerManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("----------Home Page----------");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    handleRegistration(customerManager, scanner);
                    break;
                case 2:
                    handleLogin(customerManager, scanner);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    /**
     * Handles user registration process
     * 
     * @param customerManager CustomerManager service instance
     * @param scanner Scanner for user input
     */
    private static void handleRegistration(CustomerManager customerManager, Scanner scanner) {
        System.out.println("----------Registration Page----------");
        System.out.println("1. Register Customer");
        System.out.println("2. Register Distributor");
        System.out.print("Choose an option: ");
        int registerOption = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (registerOption) {
            case 1:
                registerCustomer(customerManager, scanner);
                break;
            case 2:
                registerDistributor(customerManager, scanner);
                break;
            default:
                System.out.println("Invalid option");
        }
    }

    /**
     * Handles customer registration
     * 
     * @param customerManager CustomerManager service instance
     * @param scanner Scanner for user input
     */
    private static void registerCustomer(CustomerManager customerManager, Scanner scanner) {
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter customer ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String regPassword = scanner.nextLine();
        System.out.print("Confirm password: ");
        String confirmPassword = scanner.nextLine();

        if (!regPassword.equals(confirmPassword)) {
            System.out.println("Passwords do not match. Registration failed.");
            return;
        }

        customerManager.registerCustomer(name, id, address, phoneNumber, email, regPassword);
    }

    /**
     * Handles distributor registration
     * 
     * @param customerManager CustomerManager service instance
     * @param scanner Scanner for user input
     */
    private static void registerDistributor(CustomerManager customerManager, Scanner scanner) {
        System.out.print("Enter distributor name: ");
        String distName = scanner.nextLine();
        System.out.print("Enter distributor ID: ");
        String distId = scanner.nextLine();
        System.out.print("Enter address: ");
        String distAddress = scanner.nextLine();
        System.out.print("Enter joining date: ");
        String joiningDate = scanner.nextLine();
        System.out.print("Enter salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter phone number: ");
        String distPhoneNumber = scanner.nextLine();
        System.out.print("Enter email: ");
        String distEmail = scanner.nextLine();
        System.out.print("Enter password: ");
        String distPassword = scanner.nextLine();
        System.out.print("Confirm password: ");
        String distConfirmPassword = scanner.nextLine();

        if (!distPassword.equals(distConfirmPassword)) {
            System.out.println("Passwords do not match. Registration failed.");
            return;
        }

        customerManager.registerDistributor(distName, distId, distAddress, joiningDate,
                salary, distPhoneNumber, distEmail, distPassword);
    }

    /**
     * Handles user login process
     * 
     * @param customerManager CustomerManager service instance
     * @param scanner Scanner for user input
     */
    private static void handleLogin(CustomerManager customerManager, Scanner scanner) {
        System.out.println("----------Login Page----------");
        System.out.println("1. Login as Customer");
        System.out.println("2. Login as Distributor");
        System.out.print("Choose an option: ");
        int loginOption = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (loginOption) {
            case 1:
                handleCustomerLogin(customerManager, scanner);
                break;
            case 2:
                handleDistributorLogin(customerManager, scanner);
                break;
            default:
                System.out.println("Invalid option");
        }
    }

    /**
     * Handles customer login and customer menu
     * 
     * @param customerManager CustomerManager service instance
     * @param scanner Scanner for user input
     */
    private static void handleCustomerLogin(CustomerManager customerManager, Scanner scanner) {
        System.out.println("----------Login Customer Page----------");
        System.out.print("Enter customer name: ");
        String loginName = scanner.nextLine();
        System.out.print("Enter password: ");
        String loginPassword = scanner.nextLine();
        
        Customer loggedInCustomer = customerManager.loginCustomer(loginName, loginPassword);
        if (loggedInCustomer != null) {
            handleCustomerMenu(customerManager, scanner, loggedInCustomer);
        }
    }

    /**
     * Handles customer menu after successful login
     * 
     * @param customerManager CustomerManager service instance
     * @param scanner Scanner for user input
     * @param loggedInCustomer Logged in customer
     */
    private static void handleCustomerMenu(CustomerManager customerManager, Scanner scanner, Customer loggedInCustomer) {
        while (true) {
            System.out.println("----------Customer Home Page----------");
            System.out.println("1. Add Order");
            System.out.println("2. About Us");
            System.out.println("3. Contact Us");
            System.out.println("4. Display All Product");
            System.out.println("5. Logout");
            System.out.print("Choose an option: ");
            int userOption = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (userOption) {
                case 1:
                    handleCustomerOrder(customerManager, scanner, loggedInCustomer);
                    break;
                case 2:
                    System.out.println("----------About Us----------");
                    System.out.println("About Us: Welcome to our pharmacy! We provide a wide range of medications and healthcare products.");
                    break;
                case 3:
                    System.out.println("----------Contact Us----------");
                    System.out.println("For any inquiries, please contact us at: ");
                    System.out.println("Phone: 123-456-7890");
                    System.out.println("Address: 123 Pharmacy Street, Ahmedabad, India");
                    break;
                case 4:
                    customerManager.displayAvailableProducts();
                    break;
                case 5:
                    System.out.println("Logged out.");
                    return;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    /**
     * Handles customer order placement
     * 
     * @param customerManager CustomerManager service instance
     * @param scanner Scanner for user input
     * @param loggedInCustomer Logged in customer
     */
    private static void handleCustomerOrder(CustomerManager customerManager, Scanner scanner, Customer loggedInCustomer) {
        System.out.println("----------Customer Add Order Page----------");
        System.out.print("Enter Product Name: ");
        String productName = scanner.nextLine().toLowerCase();
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();
        customerManager.placeOrder(loggedInCustomer, productName, quantity);
    }

    /**
     * Handles distributor login and distributor menu
     * 
     * @param customerManager CustomerManager service instance
     * @param scanner Scanner for user input
     */
    private static void handleDistributorLogin(CustomerManager customerManager, Scanner scanner) {
        System.out.println("----------Login Distributor Page----------");
        System.out.print("Enter distributor name: ");
        String distLoginName = scanner.nextLine();
        System.out.print("Enter password: ");
        String distLoginPassword = scanner.nextLine();
        
        Distributor loggedInDistributor = customerManager.loginDistributor(distLoginName, distLoginPassword);
        if (loggedInDistributor != null) {
            handleDistributorMenu(customerManager, scanner);
        }
    }

    /**
     * Handles distributor menu after successful login
     * 
     * @param customerManager CustomerManager service instance
     * @param scanner Scanner for user input
     */
    private static void handleDistributorMenu(CustomerManager customerManager, Scanner scanner) {
        while (true) {
            System.out.println("----------Distributor Home Page----------");
            System.out.println("1. Display all customer details");
            System.out.println("2. Edit customer details");
            System.out.println("3. Delete customer");
            System.out.println("4. Order for customer");
            System.out.println("5. Display All Product");
            System.out.println("6. Logout");
            System.out.print("Choose an option: ");
            int distributorOption = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (distributorOption) {
                case 1:
                    System.out.println("----------All Customer Details----------");
                    customerManager.printAllCustomers();
                    break;
                case 2:
                    System.out.println("----------Edit Customer Details----------");
                    System.out.print("Enter customer ID to edit: ");
                    String editCustomerId = scanner.nextLine();
                    customerManager.editCustomerDetails(editCustomerId);
                    break;
                case 3:
                    System.out.println("----------Delete Customer Details----------");
                    System.out.print("Enter customer ID to delete: ");
                    String deleteCustomerId = scanner.nextLine();
                    customerManager.deleteCustomer(deleteCustomerId);
                    break;
                case 4:
                    System.out.println("----------Order For Customer----------");
                    System.out.print("Enter customer ID to order for: ");
                    String customerId = scanner.nextLine();
                    customerManager.placeOrderForCustomer(customerId);
                    break;
                case 5:
                    customerManager.displayAvailableProducts();
                    break;
                case 6:
                    System.out.println("Logged out.");
                    return;
                default:
                    System.out.println("Invalid option");
            }
        }
    }
} 