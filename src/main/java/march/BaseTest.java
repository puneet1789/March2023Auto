package march;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import march.utils.LoadExternalDataUtility;

public class BaseTest {
	public Logger logger = Logger.getLogger(BaseTest.class.getName());
	public static WebDriver driver = null;
	public static LoadExternalDataUtility dbCap = null;
	
	@BeforeSuite
	public void LaunchBrowser () {
		
		//LoadTestData
		try {
			dbCap = new LoadExternalDataUtility("src/test/resources/testData/DemoExceFileForTestData.xlsx");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 logger.info("Launching Chrome Driver");
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\OneDrive\\Desktop\\Drivers\\chromedriver114.exe");	       
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
		logger.info("Browser Closed");
	}
}
