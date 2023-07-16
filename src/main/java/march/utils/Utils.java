package march.utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import march.BaseTest;

public class Utils extends BaseTest{
	public Logger logger = Logger.getLogger(Utils.class.getName());
	
	public void captureScreen() {
		Date currentDate = new Date();
		String ssFileName = currentDate.toString().replace(" ", "-").replace(":", "-");
		File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenShotFile, new File(".//screenshots/"+ssFileName+".png"));
			
			logger.info("Screenshot saved at : ====== > " + ".//screenshots/"+ssFileName+".png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
