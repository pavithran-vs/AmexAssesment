I have created this UI Automation framework with Java, Selenium and TestNG with Page Object Model.
You'll need the following as a setup
- Java JDK 8+
- IDE
- Possibly everything else is covered as Maven Dependency

The folder structure is as follow:
src/ main java - 
  Base class : setup and teardown like browser initialize, maximize and navigating to base url.  
  listeners: capture events like start of execution, pass, faliure and other logging 
  Page objects:  webelment repository 
  utility: 
    Common methods: for all pages
    Helper class for reading configuration files and test data file 
    Logger class
src/main/ resources- 
  properties file: for storing url data and other data for filling forms 
  log4j properties file
src/test/java- 
  Test cases for validations

It consists of 2 test cases
1. Positive- Clicks on the webelements mentioned and give valid data in the last page and verifying it's moving to the next part
2. Negative- Clicks on the webelements mentioned and give invalid data in the last page and verifying error messages are displayed

log4j Logs and Testng report will be found under test-output
screenshots will be taken and save under the above path if failure happens

I've added a 2 second wait while filling the details and clicking continue in the last page, since it's throwing temporariry unavailable error if I won't give that.
Test cases can be run as Testng suite using the testng.xml file
