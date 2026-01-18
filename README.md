# REST API Automation Framework

![Java](https://img.shields.io/badge/Java-17-orange)
![RestAssured](https://img.shields.io/badge/RestAssured-5.3-green)
![TestNG](https://img.shields.io/badge/TestNG-7.8-red)
![Maven](https://img.shields.io/badge/Maven-3.9-blue)

## 📋 Overview

A robust and scalable REST API automation framework built with **Java**, **RestAssured**, and **TestNG**. This framework implements **Client-based Architecture** and **Builder Pattern** to ensure clean, maintainable, and reusable API test automation.

## ✨ Key Features

- ✅ Client-based architecture for separation of concerns
- ✅ Reusable Request/Response specifications
- ✅ Multi-environment support (QA, UAT, Production)
- ✅ POJO-based request/response models
- ✅ Centralized configuration management
- ✅ Random test data generation
- ✅ Comprehensive logging
- ✅ JSON schema validation
- ✅ Parallel test execution
- ✅ Detailed HTML test reports

## 🛠️ Tech Stack

| Technology | Purpose |
|------------|---------|
| Java 17+ | Programming Language |
| Maven 3.9+ | Build & Dependency Management |
| RestAssured 5.3+ | REST API Testing |
| TestNG 7.8+ | Test Framework |
| Jackson 2.15+ | JSON Processing |
| Lombok 1.18+ | Reduce Boilerplate Code |
| Hamcrest 2.2+ | Assertion Matchers |

## 📁 Project Structure

```
RestAssured-API-Framework/
│
├── src/main/java/com/framework/
│   ├── base/                           # Base configurations
│   │   ├── BaseTest.java
│   │   ├── RequestSpecBuilderUtil.java
│   │   └── ResponseSpecBuilderUtil.java
│   ├── client/                         # API client classes
│   │   ├── UserClient.java
│   │   └── BookingClient.java
│   ├── config/                         # Configuration management
│   │   ├── ConfigReader.java
│   │   └── Environment.java
│   ├── models/                         # POJO classes
│   │   ├── request/
│   │   └── response/
│   ├── utils/                          # Utility classes
│   │   ├── JsonUtils.java
│   │   ├── RandomDataUtils.java
│   │   └── LoggerUtils.java
│   └── constants/                      # Constants
│       └── Endpoints.java
│
├── src/test/java/com/framework/tests/
│   ├── base/
│   │   └── TestBase.java
│   └── user/                           # User API tests
│       ├── CreateUserTest.java
│       └── GetUserTest.java
│
├── src/test/resources/
│   ├── config/                         # Environment configs
│   │   ├── qa.properties
│   │   └── uat.properties
│   └── testng.xml                      # TestNG suite
│
├── pom.xml
└── README.md
```

## 📋 Prerequisites

- Java JDK 17 or higher
- Apache Maven 3.9+
- Git
- IntelliJ IDEA / Eclipse (recommended)

## 🚀 Installation

### Clone the Repository
```bash
git clone https://github.com/your-username/restassured-api-framework.git
cd restassured-api-framework
```

### Install Dependencies
```bash
mvn clean install -DskipTests
```

### Import to IntelliJ IDEA
1. Open IntelliJ IDEA
2. File → Open → Select project folder
3. Wait for Maven to download dependencies

## ⚙️ Configuration

### Environment Setup

Update `src/test/resources/config/qa.properties`:

```properties
base.uri=https://api-qa.example.com
port=443
base.path=/api/v1
api.key=your-api-key
connection.timeout=5000
response.timeout=10000
```

### TestNG Configuration

Edit `src/test/resources/testng.xml`:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="API Test Suite" parallel="tests" thread-count="3">
    <test name="User API Tests">
        <classes>
            <class name="com.framework.tests.user.CreateUserTest"/>
            <class name="com.framework.tests.user.GetUserTest"/>
        </classes>
    </test>
</suite>
```

## 🧪 Running Tests

### Run All Tests
```bash
mvn clean test
```

### Run Specific Test Suite
```bash
mvn clean test -DsuiteXmlFile=testng.xml
```

### Run Specific Test Class
```bash
mvn clean test -Dtest=CreateUserTest
```

### Run Tests by Environment
```bash
# QA Environment
mvn clean test -Denv=qa

# UAT Environment
mvn clean test -Denv=uat
```

### Run Tests by Groups
```bash
# Smoke tests
mvn clean test -Dgroups=smoke

# Regression tests
mvn clean test -Dgroups=regression
```

### Parallel Execution
```bash
mvn clean test -DparallelMode=methods -DthreadCount=5
```

## 📊 Test Reports

After execution, reports are generated at:

```
target/surefire-reports/index.html
```

Open in browser:
```bash
# Windows
start target/surefire-reports/index.html

# Mac/Linux
open target/surefire-reports/index.html
```

## 🏗️ Framework Architecture

### Client-Based Architecture

```
Tests → Client Layer → Request/Response Builders → RestAssured → API
```

**Benefits:**
- Clean separation of concerns
- Reusable API calls
- Easy maintenance
- Better readability

### Sample Test Structure

```java
public class CreateUserTest extends BaseTest {
    
    private UserClient userClient = new UserClient();
    
    @Test(priority = 1, groups = {"smoke"})
    public void testCreateUser() {
        CreateUserRequest request = new CreateUserRequest(
            "John Doe",
            "john@example.com",
            "1234567890"
        );
        
        Response response = userClient.createUser(request);
        
        Assert.assertEquals(response.statusCode(), 201);
        UserResponse user = response.as(UserResponse.class);
        Assert.assertNotNull(user.getId());
    }
}
```

## 🔑 Key Components

### 1. BaseTest.java
- Common setup and teardown
- RestAssured initialization
- Request/Response spec configuration

### 2. Client Classes
- Encapsulate all API calls
- UserClient.java - User API operations
- BookingClient.java - Booking API operations

### 3. RequestSpecBuilderUtil
- Reusable request specifications
- Default headers, authentication
- Request logging

### 4. ResponseSpecBuilderUtil
- Reusable response specifications
- Expected content type
- Response logging

### 5. ConfigReader
- Read environment-specific properties
- Dynamic configuration loading

### 6. POJO Models
- Type-safe request/response handling
- Located in models/request and models/response

### 7. Utils Classes
- JsonUtils - JSON operations
- RandomDataUtils - Generate test data
- LoggerUtils - Custom logging

### 8. Endpoints
- Centralized API endpoint constants

## 📝 Best Practices

1. **Follow AAA Pattern** (Arrange-Act-Assert)
2. **Use meaningful test names**
3. **Group tests logically** (smoke, regression, negative)
4. **Use POJO models** for type safety
5. **Don't hardcode values** - use config files
6. **Log important steps** for debugging
7. **Clean up test data** in @AfterMethod
8. **Use soft assertions** for multiple validations

## 🤝 Contributing

1. Fork the repository
2. Create feature branch (`git checkout -b feature/new-feature`)
3. Commit changes (`git commit -m 'Add new feature'`)
4. Push to branch (`git push origin feature/new-feature`)
5. Open Pull Request

## 📄 License

This project is licensed under the MIT License

## 👤 Author

**Your Name**
- Email: your.email@example.com
- LinkedIn: [Your Profile](https://linkedin.com/in/your-profile)
- GitHub: [@your-username](https://github.com/your-username)

## 📞 Support

For issues and questions:
- Open an [Issue](https://github.com/your-username/restassured-api-framework/issues)
- Contact via email

## 🗺️ Roadmap

- [ ] Allure reporting integration
- [ ] Database validation
- [ ] CI/CD pipeline setup
- [ ] Docker containerization
- [ ] API contract testing
- [ ] Performance testing integration

---

**⭐ If you find this framework useful, please give it a star!**

**Happy Testing! 🚀**