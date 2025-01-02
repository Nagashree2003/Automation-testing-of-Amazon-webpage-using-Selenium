## Amazon-Like Website Automation Testing with Selenium
This project demonstrates the automation testing of an Amazon-like eCommerce website using Selenium WebDriver and Java. The test case automates the Login functionality, where it performs actions such as opening the website, entering login credentials, and verifying a successful login.

# Table of Contents
# Prerequisites
# Setup Instructions
# Test Case Details
# Running the Test
# Contributing
# License
# Prerequisites

Before running the automation test, ensure the following are installed and set up:

Java JDK: Ensure that you have Java Development Kit installed.
You can verify by running the command:



* java -version
If Java is not installed, you can download it from Oracle's JDK Download.

Maven (optional): If you are using Maven for project dependency management, ensure it's installed by running:


* mvn -version
Selenium WebDriver: Selenium is used for browser automation. You can download it from the Selenium Downloads Page. If using Maven, add the dependency in the pom.xml file.

ChromeDriver: Selenium requires a browser-specific driver to interface with the browser. For Google Chrome, download the appropriate version of ChromeDriver from here and ensure it matches your Chrome browser version.

IDE: You can use any IDE such as IntelliJ IDEA, Eclipse, or VSCode to work with Java.

### Setup Instructions ###

# 1. Clone the Repository
Clone the project repository to your local machine:


git clone https://github.com/your-username/amazon-automation-test.git
cd amazon-automation-test

### 2. Add Dependencies
Using Maven:
If you're using Maven for dependency management, add the following to your pom.xml:



<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>4.0.0</version> <!-- Or the latest version -->
</dependency>
Alternatively, you can manually download the required Selenium jars from the Selenium website and add them to your project's classpath.

# Download ChromeDriver:
Download the ChromeDriver that matches your Chrome version from ChromeDriver Download.
Place the ChromeDriver executable in a directory, and update the System.setProperty in the test code with its correct path:

System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

## Test Case Details
This project automates the following login functionality test case for an Amazon-like eCommerce website:

Open the website (e.g., https://www.example.com).
Click the "Sign In" button.
Enter a test email address (testuser@example.com).
Click the "Continue" button.
Enter a test password (testpassword).
Click the "Login" button.
Verify successful login by checking if a user profile element is visible.
Close the browser after verifying the result.

The test is written in Java using Selenium WebDriver.

# Running the Test


## 1. Run the AmazonTest.java File
Once the setup is complete, you can run the AmazonTest.java file either from your IDE or using the command line.

From IDE:
Open the project in your preferred Java IDE.
Right-click the AmazonTest.java file and select "Run."
From Command Line:
Navigate to the project directory where AmazonTest.java is located.

Compile the Java file:

javac AmazonTest.java
Run the compiled Java program:

java AmazonTest

# 2. Verify Test Results
Upon running the test, a browser window will open, perform the login actions, and display the test result in the terminal or IDE's console.
If the login is successful, you should see:

Login successful!

If the login fails, the console will show:

Login failed!

Contributing
If you'd like to contribute to this project, follow these steps:

Fork this repository.
Create a new branch (git checkout -b feature-name).
Make your changes.
Commit your changes (git commit -m 'Add new feature').
Push to the branch (git push origin feature-name).
Open a pull request.
License
This project is licensed under the MIT License - see the LICENSE file for details.

