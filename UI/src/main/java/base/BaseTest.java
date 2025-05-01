package base;

import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ConfigReader;

public class BaseTest {
	
	 protected WebDriver driver;
	 
	 //clearing log file before the start of execution
	 @BeforeSuite
	 public void clearLogsBeforeExecution() {
	        try {
	            FileWriter writer = new FileWriter("test-output/test.log", false);
	            writer.write(""); // Overwrites file with an empty string
	            writer.close();
	            System.out.println("Log file cleared at start of execution.");
	        } catch (IOException e) {
	            System.out.println("Failed to clear log file: " + e.getMessage());
	        }
	    }
	    
    //setting up browser
	@BeforeClass
    public void setUp() {
    	String browser = ConfigReader.getProperty("browser"); 
    	PropertyConfigurator.configure("src/main/resources/log4j.properties");
    	if (browser.equals("edge")) {
    		WebDriverManager.edgedriver().setup();
    		driver= new EdgeDriver();	
    	} else if(browser.equals("chrome")) {
    		WebDriverManager.chromedriver().setup();
    		driver= new ChromeDriver();
    	}
        driver.manage().window().maximize();
    }
	
	//hitting base url and setting web driver attribute in TestNG context
    @BeforeMethod
    public void set(ITestContext context)
    {
        driver.get(ConfigReader.getProperty("baseURL")); 
       	context.setAttribute("WebDriver", driver);        
    }

    //quitting once execution is done
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
