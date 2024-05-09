package stepDefinitions;

import org.testng.Assert;

//import io.cucumber.java.en.Then;
import io.cucumber.java.en.*;

//import pageObjects.CheckoutPage;
//import pageObjects.PageObjectsManager;
import pageObjects.*;

import util.TestContextSetup;

public class CheckoutPageStepDefinition{
	public	CheckoutPage		checkoutPage;
	public	TestContextSetup	testContextSetup;
	public	PageObjectsManager	pageObjectsManager;
	public	String				offersPageProductName;
	public	String				landingPageProductName;
	public	String				checkoutPageProductName;
	
	public CheckoutPageStepDefinition(TestContextSetup testContextSetup){
		this.testContextSetup	=	testContextSetup;
		this.checkoutPage		=	testContextSetup.pageObjectsManager.getCheckoutPage();
	}
	@Then("^user proceeds to checkout and validate the (.+) items in CheckoutPage$")
	public void user_proceeds_to_checkout_and_validate_the_tom_items_in_checkout_page(String shortName) throws InterruptedException{
		System.out.println("Short Name in Checkout Page = " + shortName);
		checkoutPage.checkOutItems();
		
		//Thread.sleep(2000);   // Not needed since implicit wait is already defined
		
		// Assignment to solve: Assertion to extract name from screen ("cauliflower") and
		//                      compare with <name>
		testContextSetup.checkoutPageProductName	=	checkoutPage.getCheckoutPageProductName();
		System.out.println("Checkout Page Product Name extracted = " + testContextSetup.checkoutPageProductName);
	}
	@Then("verify user has ability to enter promo code and place the order")
	public void verify_user_has_ability_to_enter_promo_code_and_place_the_order(){
		Assert.assertTrue(checkoutPage.verifyPromoButton());
		Assert.assertTrue(checkoutPage.verifyPlaceOrder());
	}
}