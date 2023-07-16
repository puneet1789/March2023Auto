package march.ebayPageFactory;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver = null;
	public Logger logger = Logger.getLogger(HomePage.class.getName());
	
	public HomePage (WebDriver driver) {
		logger.info("HomePage - Initialized");
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	
	
	@FindBy(how=How.XPATH, using = "//*[@id='gh-ac']")
	WebElement txt_SearchBar;
	
	@FindBy(how=How.XPATH, using = "//*[@id='gh-btn']")
	WebElement btn_SearchButton;
	
	@FindBy(how=How.XPATH, using = "//*[@id='gh-shop-a']")
	WebElement btn_ShopByCart;
	
	@FindBy(how=How.XPATH, using = "//*[@id='gh-minicart-hover']/div/a[1]")
	WebElement link_Cart;
	
	
	public void clickBtnSeach() {
		logger.info("HomePage - clickBtnSeach");
		btn_SearchButton.click();
	}
	
	public void clickbtn_ShopByCart() {
		logger.info("HomePage - clickbtn_ShopByCart");
		btn_ShopByCart.click();
	}
	
	public void clickbtn_ShopByCart(String text) {
		logger.info("HomePage - clickbtn_ShopByCart");
		txt_SearchBar.sendKeys(text);
	}
	
	public boolean verifyBtn_ShopByCartExist() {
		logger.info("HomePage - verifyBtn_ShopByCartExist");
		return btn_ShopByCart.isDisplayed();
	}
	
	public void clicklink_Cart() {
		logger.info("HomePage - clicklink_Cart");
		link_Cart.click();
	}
}
