package march;

import org.apache.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

import march.utils.Utils;

public class FrameworkListners extends Utils implements ITestListener {

	public Logger logger = Logger.getLogger(FrameworkListners.class.getName());
	
	public void onTestStart(ITestResult result) {
		logger.info("Hi Test Started  - I Listen");
	  }
	
	public void onTestFailure(ITestResult result) {
		logger.info("test Failed - I Listen");
		captureScreen();
	}
}
