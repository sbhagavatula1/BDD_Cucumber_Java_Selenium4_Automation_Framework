
package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectsManager{
	//	Concept of Encapsulation implemented here
	//
	//	The variables are declared private in this class.
	//	This means that they can be accessed directly only by methods in this class,
	//	but cannot be accessed directly by methods from methods in other classes.
	
	private		WebDriver		driver;
	
	private		LandingPage		landingPage;
	private		OffersPage		offersPage;
	private		CheckoutPage	checkoutPage;
	
	public PageObjectsManager (WebDriver driver){
		this.driver = driver;
	}
	public LandingPage	getLandingPage(){
		landingPage = new LandingPage (driver);
		return landingPage;
	}
	public OffersPage	getOffersPage(){
		offersPage = new OffersPage (driver);
		return offersPage;
	}
	public CheckoutPage	getCheckoutPage(){
		checkoutPage = new CheckoutPage (driver);
		return checkoutPage;
	}
}