package march.ebayPageFactory;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	WebDriver driver = null;
	public Logger logger = Logger.getLogger(CartPage.class.getName());
	
	public CartPage (WebDriver driver) {
		logger.info("CartPage - initialized");
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	
	
	@FindBy(how=How.XPATH, using = "//*[@id='mainContent']/div/div[2]/div/div[2]/div/div[3]/a[2]")
	WebElement btn_StartShopping;
	
	@FindBy(how=How.XPATH, using = "//*[@id='mainContent']/div/div[2]/div/div[2]/div/div[3]/a[1]")
	WebElement btn_SignIn;
	
	@FindBy(how=How.XPATH, using = "//*[@id='mainContent']/div/div[2]/div/div[2]/div/div[1]/span/span/span")
	WebElement lbl_Message;
	
	
	public void clickbtn_StartShopping() {
		
		logger.info("CartPage - clickbtn_StartShopping");
		btn_StartShopping.click();
	}
	
	public void clickbtn_SignIn() {
		logger.info("CartPage - clickbtn_SignIn");
		btn_SignIn.click();
	}

	public boolean verifylbl_Message() {
		logger.info("CartPage - verifylbl_Message");
		return lbl_Message.isDisplayed();
	}
	
	public boolean verifylbl_Message(String text) {
		logger.info("CartPage - verifylbl_Message");
		return lbl_Message.getText().equals(text);
	}
	
}
