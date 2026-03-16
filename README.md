# E-Commerce-Web-Application-Automation

A robust, scalable end-to-end test automation framework built with
Selenium WebDriver and TestNG for the
[TutorialsNinja Demo E-Commerce](https://tutorialsninja.com/demo/) application.

## About the Project

This framework automates the core functional flows of the TutorialsNinja
demo e-commerce application. It follows the **Page Object Model (POM)**
design pattern to keep test logic separate from page interactions,
making tests easy to maintain and scale.

**Key features:**
- Page Object Model (POM) with PageFactory
- Data-Driven Testing (DDT) using Apache POI and Excel
- Cross-browser support — Chrome, Firefox, Edge
- Parallel test execution using TestNG
- Automatic screenshot capture on test failure
- Detailed HTML reports using ExtentReports
- Test grouping — Smoke, Sanity, Regression
- Centralised configuration via config.properties
- TestNG Listeners for real-time reporting

---

## Tech Stack

| Technology       | Version  | Purpose                          |
|-----------------|----------|----------------------------------|
| Java            | 21       | Programming language             |
| Selenium WebDriver | 4.32.0 | Browser automation             |
| TestNG          | 7.9.0    | Test framework and execution     |
| Maven           | 3.x      | Build and dependency management  |
| Apache POI      | 5.2.3    | Excel data reading for DDT       |
| ExtentReports   | 5.1.1    | HTML test reporting              |

---

## Project Structure

tutorialsninja-tests/
├── src/
│   ├── main/
│   │   └── resources/
│   │       ├── config.properties       # URL and credentials
│   │       └── TestData.xlsx           # DDT login test data
│   └── test/
│       └── java/
│           ├── base/
│           │   └── BaseTest.java       # Driver setup and teardown
│           ├── Pages/
│           │   ├── BasePage.java       # PageFactory initialisation
│           │   ├── HomePage.java
│           │   ├── LoginPage.java
│           │   ├── RegistrationPage.java
│           │   ├── AccountPage.java
│           │   ├── CartPage.java
│           │   ├── WishListPage.java
│           │   ├── ProductsPage.java
│           │   ├── EditAccountPage.java
│           │   ├── ChangePasswordPage.java
│           │   ├── ForgottenPasswordPage.java
│           │   ├── ContactUsPage.java
│           │   └── RegistrationConfirmPage.java
│           ├── TestCases/
│           │   ├── TC001_RegistrationTest.java
│           │   ├── TC002_Login_Test.java
│           │   ├── TC003_Logout_Test.java
│           │   ├── TC004_Login_DDT.java
│           │   ├── TC005_Search_Box_Test.java
│           │   ├── TC006_ContactUS_Test.java
│           │   ├── TC007_CartTest.java
│           │   ├── TC008_WishList_Test.java
│           │   ├── TC009_ForgottenPasswordTest.java
│           │   ├── TC010_Edit_Account_Test.java
│           │   └── TC011_Change_Password_Test.java
│           └── utils/
│               ├── DataProviders.java  # TestNG DataProvider binding
│               ├── ExcelUtil.java      # Apache POI Excel reader
│               ├── ExtentReportManager.java
│               └── TestListener.java   # TestNG ITestListener
├── testng.xml                          # Full regression suite
├── testng-smoke.xml                    # Smoke suite
├── testng-sanity.xml                   # Sanity suite
├── testng-regression.xml               # Regression suite
├── LoginDDT.xml                        # DDT suite
└── pom.xml


## Test Cases

| TC ID  | Test Class                  | Feature           | Description                                      |
|--------|-----------------------------|-------------------|--------------------------------------------------|
| TC001  | RegistrationTest            | Registration      | Valid registration, existing email, no privacy policy |
| TC002  | Login_Test                  | Login             | Valid and invalid login credentials              |
| TC003  | Logout_Test                 | Logout            | Successful logout and redirect to home           |
| TC004  | Login_DDT                   | Login             | Data-driven login using Excel                    |
| TC005  | Search_Box_Test             | Search            | Valid text, invalid text, numeric search         |
| TC006  | ContactUS_Test              | Contact Us        | Submit contact form with valid data              |
| TC007  | CartTest                    | Cart              | Add, remove, coupon, gift certificate, checkout  |
| TC008  | WishList_Test               | Wish List         | Add to wishlist with/without login, remove item  |
| TC009  | ForgottenPasswordTest       | Password          | Registered and unregistered email reset          |
| TC010  | Edit_Account_Test           | Account           | Update account info, duplicate email check       |
| TC011  | Change_Password_Test        | Password          | Change password, mismatch validation             |


## Test Groups

| Group       | Tests Included                                           | When to Run         |
|-------------|----------------------------------------------------------|---------------------|
| `smoke`     | Valid login, logout, add to cart                         | Every code push      |
| `sanity`    | All happy-path tests across every feature                | After every build    |
| `regression`| Every test method in all 11 classes                      | Before every release |

## How to Run

### Prerequisites
- Java 21 installed
- Maven installed
- Google Chrome installed
- ChromeDriver managed automatically by Selenium 4
