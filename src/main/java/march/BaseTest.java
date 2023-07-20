package march;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import march.utils.LoadExternalDataUtility;


public class BaseTest {
	public Logger logger = Logger.getLogger(BaseTest.class.getName());
	public static WebDriver driver = null;
	public static LoadExternalDataUtility dbCap = null;
	public static ExtentReports extent;
	public static Properties prop;
	
	@BeforeSuite
	public void LaunchBrowser () {
		//LoadTestData
		try {
			FileInputStream fStr = new FileInputStream(new File("./src/test/resources/testConfigs/config.properties"));
			prop = new Properties();
			prop.load(fStr);
			
			dbCap = new LoadExternalDataUtility(prop.getProperty("testDataPath"));
			
			extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter(prop.getProperty("reportOutputPath"));
	        extent.attachReporter(spark);
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		
		 logger.info("Launching Chrome Driver");
		 System.setProperty("webdriver.chrome.driver", prop.getProperty("driverPath"));	       
	 	 ChromeOptions options = new ChromeOptions();
	     options.addArguments("--remote-allow-origins=*");
	 	
	     // Instantiate a ChromeDriver class.     
	     driver = new ChromeDriver(options);
	     logger.info("Chrome Driver - Launched");
	     	     
	     driver.manage().window().maximize();
	     logger.info("Chrome Maximized");

	}
	
	@BeforeClass
	public void navigate() {
		 logger.info("Browser Navigated to url : https://www.ebay.com/");
		 driver.navigate().to("https://www.ebay.com/");
	}
	
	@AfterSuite
	public void CloseBrowser () {		 
		driver.quit();
		extent.flush();
		logger.info("Browser Closed");
	}
}
