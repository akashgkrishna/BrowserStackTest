
  <h1 align="center">BrowserStack Test</h1>

  <p align="center">
    <br />
    This readme provides instructions for configuring and running test automation using BrowserStack with and without Maven.

  </p>

### About The Project

The "BrowserStack Test" project is a test automation project designed for testing the Browserstack Test Observability.

### Prerequisites

Before you can run your tests on BrowserStack, make sure you have the following prerequisites in place:
1. **Clone the Repository**: Clone the test automation project repository to your local machine.
    ```sh
    git clone git@github.com:akashkrishna7/BrowserStackTest.git
    ```
2. **Install Dependencies**
3. **BrowserStack Account:** You need to have an active BrowserStack account. You can sign up at BrowserStack.

### Configuration


1. **browserstack.yml:**
    * Update the userName and accessKey fields with your BrowserStack credentials.
    * You can change the buildName and projectName as per your project requirements.
    * You can also customize other fields like CUSTOM_TAG_1, browserName, browserVersion, and more based on your testing needs.
2. **BaseTest.java:**
    * In the getWebDriver method, update the capabilities and desired capabilities based on your testing requirements.
    * Ensure that you set the browserstackURL correctly using the values from browserstack.yml.


## Running Tests
### Without Maven

To run your tests on BrowserStack without Maven, follow these steps:
1. Install Dependencies (Manual): Make sure you have installed the necessary dependencies for your test automation project, including Java, TestNG, and Selenium WebDriver.

2. Locate browserstack-java-sdk Jar:
    * Locate the browserstack-java-sdk jar file in your project's external libraries.
    * Copy the absolute path of the browserstack-java-sdk jar file.
3. Add Java Agent Argument:
    * Open your test runner (e.g., IDE).
    * Add the following Java agent argument to your test runner's configuration, prefixed with **-javaagent:**
    ```sh
      -javaagent:"<path_to_browserstack-java-sdk.jar>"
    ```
    * Replace **<path_to_browserstack-java-sdk.jar>** with the absolute path you copied in step 2.
    * For example:
    ```sh
      -javaagent:"/Users/userName/.m2/repository/com/browserstack/browserstack-java-sdk/1.11.0/browserstack-java-sdk-1.11.0.jar"
    ```
4. Execute Tests: Run your test automation suite using your preferred method (e.g., IDE, command line).

5. Monitor Test Execution: Monitor the test execution in your test runner and view the test results on the BrowserStack dashboard.


### With Maven

To run your tests on BrowserStack using Maven, follow these steps:
1. Install Maven:
    * Ensure that you have Maven installed on your system. You can download and install Maven from Maven's official website.
2. Open a Terminal:
    * Open a terminal or command prompt on your computer.
3. Navigate to the Project Directory:
    * Use the cd command to navigate to the root directory of your test automation project, where the pom.xml file is located.
4. Run the Tests:
    * To run the Sanity suite, execute the following command:
    ```sh
   mvn test -P sample-test -Dgroups=sanity
    ```
    * To run the Regression suite, execute the following command:
    ```sh
   mvn test -P sample-test -Dgroups=regression
    ```
    * To run all tests, execute the following command:
    ```sh
   mvn test -P sample-test 
    ```
   These commands will trigger the test execution using TestNG, and your tests will run on BrowserStack based on the configuration in **_browserstack.yml_** and **_testng.xml_**, with the specified test group.
5. Monitor Test Execution:
    * Monitor the test execution in the terminal as the tests run.
    * View test results on the BrowserStack dashboard.
