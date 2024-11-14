# Automating E-Commerce Website Scenarios using TestNG Framework

Website Used: [practice software testing](https://practicesoftwaretesting.com/)
This framework is designed to test end-to-end (E2E) scenarios for the specified e-commerce site. It was developed using TestNG and Selenium WebDriver with a Page Object Model (POM) approach.
## Table of Contents
- Overview
* Technologies Used
+ Framework Structure
- Test Case Example
* Reporting
+ Installation

  ### Overview
  This automation framework is designed to test various user scenarios on the specified e-commerce website. The framework is modular, scalable, and easy to extend by adding new test cases and functionalities.
  It supports TestNG for test case management and Selenium WebDriver for browser automation.
  ### Technologies Used
  - Java for scripting
  * Selenium WebDriver for web automation
  + TestNG for test case management
  - Page Object Model (POM) for organizing code
  * ExtentReports for visual test reporting
 ### Framework Structure
 **Selenium_Project.pageObjects/**: Contains page object classes for different pages (e.g., HomePage, LoginPage, ProductsPage, etc.).
 **Selenium_Project.TestCases/**: Contains test case files for different user scenarios (e.g., payment, registration, checkout).
 **Selenium_Project.Utilities/**: Contains utility classes (e.g., BaseClass) for shared functions like selecting a value from a dropdown, waiting for elements to become visible, etc.
 **Selenium_Project.Resources/**: Contains external resources like test data files (e.g., Excel, JSON, or property files).
 **testng.xml**: Configuration file for running the test suites with TestNG.
 ### Test Case Example: test_creditcard_payment
Description:
This test simulates the process of registering a new user, adding a product to the cart, and completing the checkout using a credit card.
1.Sign in and register a new user.
2.Navigate to the product page and add a product to the cart.
3.Complete the checkout process, entering billing information and selecting credit card payment.
4.Verify the payment confirmation.
### Reporting
ExtentReports are integrated to provide detailed insights into test execution results, including pass/fail status, execution time, and screenshots for failed tests.
