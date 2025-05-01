I have created this UI Automation framework with Java, Selenium and TestNG with Page Object Model.
You'll need the following as a setup
- Java JDK 8+
- IDE
- Possibly everything else is covered as Maven Dependency

It consists of 2 test cases
1. Positive- Clicks on the webelements mentioned and give valid data in the last page and verifying it's moving to the next part
2. Negative- Clicks on the webelements mentioned and give invalid data in the last page and verifying error messages are displayed

log4j Logs and Testng report will be found under test-output
screenshots will be taken and save under the above path if failure happens
I've used properties files to store data

I've added a 2 second wait while filling the details and clicking continue in the last page, since it's throwing temporariry unavailable error if I won't give that.
