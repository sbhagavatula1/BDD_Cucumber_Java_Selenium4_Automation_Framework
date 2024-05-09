package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

	//	Concept of Encapsulation implemented here
	//
	//	The variables are declared private in this class.
	//	This means that they can be accessed directly only by methods in this class,
	//	but cannot be accessed directly by methods from methods in other classes.
	
	private	WebDriver	driver;	

	private	By	cartBag				=	By.cssSelector("img[alt='Cart']");
	private	By	checkOutButton		=	By.xpath("//button[text()='PROCEED TO CHECKOUT']");
	private	By	productName			=	By.xpath("//p[@class='product-name']");
	
	private	By	promoButton			=	By.cssSelector(".promoBtn");
	private	By	placeOrderButton	=	By.xpath("//button[text()='Place Order']");
	
	// refer to lesson #42 in the video
	
	//	Action Methods
	public CheckoutPage (WebDriver driver){
		this.driver = driver;
	}
	public void checkOutItems(){
		driver.findElement(cartBag).click();
		driver.findElement(checkOutButton).click();
	}
	public String getCheckoutPageProductName(){
		return driver.findElement(productName).getText().split("-")[0].trim();
	}
	public Boolean verifyPromoButton(){
		return driver.findElement(promoButton).isDisplayed();
	}
	public Boolean verifyPlaceOrder(){
		return driver.findElement(placeOrderButton).isDisplayed();
	}
}