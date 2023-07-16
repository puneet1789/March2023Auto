package march.Automation.testcases;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import march.BaseTest;
import march.ebayPageFactory.CartPage;
import march.ebayPageFactory.HomePage;
import march.utils.Utils;

public class AutomationTestCases extends BaseTest {

	public Utils util = new Utils();
	public Logger logger = Logger.getLogger(AutomationTestCases.class.getName());
	
	@Test
	public void basic_Test_To_Validate_Ebay_Home() {
		logger.info("basic_Test_To_Validate_Ebay_Home - Started");
		HomePage hp = new HomePage(driver);
		
		logger.info("basic_Test_To_Validate_Ebay_Home - verifyBtn_ShopByCartExist");
		assertTrue(hp.verifyBtn_ShopByCartExist());
		
		logger.info("basic_Test_To_Validate_Ebay_Home - clickbtn_ShopByCart");		
		hp.clickbtn_ShopByCart(dbCap.getData("EbayTest", "basic_Test_To_Validate_Ebay_Home", "SearchData"));
		
		
		logger.info("basic_Test_To_Validate_Ebay_Home - clickBtnSeach");
		hp.clickBtnSeach();
		
		logger.info("basic_Test_To_Validate_Ebay_Home - captureScreen");
		util.captureScreen();
		logger.info("basic_Test_To_Validate_Ebay_Home - Completed");
	}
	
	
	
	@Test
	public void basic_Test_To_Validate_Ebay_Cart() {
		logger.info("basic_Test_To_Validate_Ebay_Cart - Started");
		HomePage hp = new HomePage(driver);
		
		logger.info("basic_Test_To_Validate_Ebay_Cart - verifyBtn_ShopByCartExist");
		assertTrue(hp.verifyBtn_ShopByCartExist());
		
		logger.info("basic_Test_To_Validate_Ebay_Cart - clicklink_Cart");
		hp.clicklink_Cart();		
		
		CartPage cp = new CartPage(driver);
		
		logger.info("basic_Test_To_Validate_Ebay_Cart - verifylbl_Message");
		assertTrue(cp.verifylbl_Message());
		
		logger.info("basic_Test_To_Validate_Ebay_Cart - verifylbl_Message");
		assertTrue(cp.verifylbl_Message(dbCap.getData("EbayTest", "basic_Test_To_Validate_Ebay_Cart", "VerifyMessage")));
		
		logger.info("basic_Test_To_Validate_Ebay_Cart - captureScreen");
		util.captureScreen();
		logger.info("basic_Test_To_Validate_Ebay_Cart - completed");
	}
}
