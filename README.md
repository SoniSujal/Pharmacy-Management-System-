# Pharmacy Management System

A professional Java console application for managing pharmacy operations including customer registration, distributor management, and order processing. This project demonstrates clean code architecture, proper separation of concerns, and industry best practices.

## 🏥 Features

### Customer Features
- **Registration & Login**: Secure customer account creation and authentication
- **Product Browsing**: View available medications and their prices
- **Order Placement**: Place orders for medications with quantity selection
- **Profile Management**: Update personal information and contact details

### Distributor Features
- **Customer Management**: View, edit, and delete customer records
- **Order Processing**: Place and manage orders on behalf of customers
- **Product Management**: Access to product catalog and pricing
- **Administrative Controls**: Full system management capabilities

### System Features
- **Data Validation**: Email and phone number format validation
- **Secure Authentication**: Password-based login system
- **Order Tracking**: Unique order ID generation and tracking
- **Product Catalog**: Pre-loaded medication database with pricing

## 🛠️ Technology Stack

- **Language**: Java 8+
- **Build Tool**: Maven
- **Testing**: JUnit 4
- **IDE**: IntelliJ IDEA / Eclipse / VS Code
- **Architecture**: Object-Oriented Programming (OOP) with MVC pattern

## 📋 Prerequisites

- Java Development Kit (JDK) 8 or higher
- Maven 3.6+ (for building the project)
- Git (for version control)

## 🚀 Installation & Setup

### 1. Clone the Repository
```bash
git clone https://github.com/yourusername/pharmacy-management-system.git
cd pharmacy-management-system
```

### 2. Build the Project
```bash
mvn clean compile
```

### 3. Run the Application
```bash
mvn exec:java -Dexec.mainClass="com.pharmacy.Main"
```

Or run the JAR file:
```bash
mvn package
java -jar target/pharmacy-management-system-1.0.0.jar
```

### 4. Run Tests
```bash
mvn test
```

## 📁 Project Structure

```
pharmacy-management-system/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── pharmacy/
│   │               ├── model/
│   │               │   ├── Customer.java
│   │               │   ├── Distributor.java
│   │               │   └── Order.java
│   │               ├── service/
│   │               │   └── CustomerManager.java
│   │               ├── util/
│   │               │   └── ValidationUtil.java
│   │               └── Main.java
│   └── test/
│       └── java/
│           └── com/
│               └── pharmacy/
│                   └── util/
│                       └── ValidationUtilTest.java
├── pom.xml
├── README.md
└── .gitignore
```

## 🏗️ Architecture

### Model Layer (`com.pharmacy.model`)
- **Customer**: Represents pharmacy customers with personal information
- **Distributor**: Represents pharmacy staff with administrative access
- **Order**: Represents customer orders with product details

### Service Layer (`com.pharmacy.service`)
- **CustomerManager**: Core business logic for managing customers, distributors, and orders

### Utility Layer (`com.pharmacy.util`)
- **ValidationUtil**: Static methods for data validation (email, phone, etc.)

### Main Application (`com.pharmacy.Main`)
- Entry point with user interface logic
- Handles user interactions and menu navigation

## 🎯 Usage

### Starting the Application
1. Run the application using the commands above
2. Choose from the main menu options:
   - **Register**: Create new customer or distributor accounts
   - **Login**: Access existing accounts
   - **Exit**: Close the application

### Customer Workflow
1. Register a new account or login with existing credentials
2. Browse available products
3. Place orders by specifying product name and quantity
4. View order history and manage profile

### Distributor Workflow
1. Login with distributor credentials
2. Manage customer accounts (view, edit, delete)
3. Process orders on behalf of customers
4. Access administrative functions

## 📊 Sample Data

The system comes pre-loaded with sample data:

### Sample Customers
- **Sujal** (ID: 1) - sujalsoni@gmail.com
- **Om** (ID: 2) - om@gmail.com

### Sample Distributor
- **NK** (ID: 1) - nk@gmail.com

### Available Products
- Aspirin: $5.0
- Paracetamol: $3.0
- Ibuprofen: $7.0
- Soliris: $25.0
- Cinryze: $115.0
- Elaprase: $30.0
- Cipro: $10.0

## 🔧 Configuration

### Adding New Products
Edit the `CustomerManager.java` file and add products to the `productPrices` HashMap:

```java
productPrices.put("product_name", price);
```

### Modifying Validation Rules
Update validation methods in `ValidationUtil.java` for custom email/phone validation.

## 🧪 Testing

Run tests using Maven:
```bash
mvn test
```

The project includes unit tests for the `ValidationUtil` class demonstrating:
- Email validation testing
- Phone number validation testing
- String validation testing
- Number validation testing

## 📝 Code Quality

This project follows industry best practices:

- **Clean Architecture**: Separation of concerns with model, service, and utility layers
- **Proper Documentation**: Comprehensive JavaDoc comments
- **Unit Testing**: JUnit tests for validation logic
- **Maven Build**: Professional build configuration
- **Package Structure**: Organized package hierarchy
- **Error Handling**: Proper input validation and error messages

## 🚀 Future Enhancements

Potential improvements for this project:

1. **Database Integration**: Replace in-memory storage with database
2. **Web Interface**: Create web-based UI using Spring Boot
3. **REST API**: Expose services via REST endpoints
4. **Security**: Implement proper password hashing and JWT tokens
5. **Logging**: Add comprehensive logging with SLF4J
6. **Configuration**: External configuration files
7. **Docker**: Containerize the application

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👥 Authors

- **Your Name** - *Initial work* - [YourGitHub](https://github.com/yourusername)

## 🙏 Acknowledgments

- Java community for excellent documentation
- Maven team for the build system
- JUnit team for testing framework
- All contributors and testers


---

**Note**: This is a beginner-friendly project demonstrating core Java concepts including OOP, collections, file I/O, console application development, and professional project structure. Perfect for learning clean code practices and industry standards. 
