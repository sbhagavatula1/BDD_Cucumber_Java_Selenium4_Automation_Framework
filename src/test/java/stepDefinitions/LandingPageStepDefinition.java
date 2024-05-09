package stepDefinitions;

import java.net.MalformedURLException;

//import org.testng.Assert;
import org.testng.*;

//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.When;
import io.cucumber.java.en.*;

//import pageObjects.LandingPage;
//import pageObjects.PageObjectsManager;
import pageObjects.*;

import util.TestContextSetup;

public class LandingPageStepDefinition{
	public	LandingPage			landingPage;
	public	TestContextSetup	testContextSetup;
	public	PageObjectsManager	pageObjectsManager;	
	public	String				offersPageProductName;
	public	String				landingPageProductName;
	
	public LandingPageStepDefinition(TestContextSetup testContextSetup){
		this.testContextSetup = testContextSetup;
		this.landingPage = testContextSetup.pageObjectsManager.getLandingPage();
	}
	@Given("User is on Greenkart LandingPage")
	public void user_is_on_greenkart_landing_page() throws MalformedURLException{
		Assert.assertTrue(landingPage.getLandingPageTitle().contains("GreenKart"));
	}
	@When ("^User searched with shortname (.+) in LandingPage and extracted actual name of the product$")
	public void user_searched_with_shortname_tom_and_extracted_actual_name_of_the_product(String shortName) throws InterruptedException{
		System.out.println("Short Name in Landing Page = " + shortName);
		
		landingPage.searchItem(shortName);
		Thread.sleep(2000);
		
		//testContextSetup.landingPageProductName	=	testContextSetup.driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
		testContextSetup.landingPageProductName		=	landingPage.getLandingPageProductName();
		
		System.out.println("Landing Page Product Name extracted = " + testContextSetup.landingPageProductName);
	}
	@When("Added {string} items of the selected product to cart")
	public void added_items_of_the_selected_product_to_cart(String quantity){
		
		if(testContextSetup.landingPageProductName != null &&
				!testContextSetup.landingPageProductName.isEmpty()){
			System.out.println("Landing Page Product Name is not null and not empty");
			landingPage.incrementQuantity(Integer.parseInt(quantity));
			landingPage.addtoCart();
		}
	}
}