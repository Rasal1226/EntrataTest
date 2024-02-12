*Entrata Final

This project contains automated tests for Entrata final. It utilizes Selenium and Cucumber to automate web testing scenarios.

 *Features

- **Feature File:** `entrataweb.feature`

  Contains three test scenarios:
  1. Handling WebElement using Action Class
  2. Navigating to Watch Demo Webpage and Hanlding Form Without Submission
  3. navigation  to Resources Page Elements and Capture Screenshot of Whole Page using JavaScript Executor
  4. HNDLE Multiple window and cookies on page and return WindowId and title

** Setup

To run these tests locally, you'll need:
- Java Development Kit (JDK)
- Maven
- ChromeDriver (for Chrome browser)

**Usage

1. Clone this repository:
   ```
   git clone https://github.com/Rasal1226/EntrataTest.git
   ```

2. Navigate to the project directory:
   ```
   cd yourproject
   ```

3. Install dependencies:
   ```
   mvn clean install
   ```

4. Execute the automated tests:
   ```
   mvn test
   ```
note: To run all test one by one use runner class give required tag name used in feature file.
