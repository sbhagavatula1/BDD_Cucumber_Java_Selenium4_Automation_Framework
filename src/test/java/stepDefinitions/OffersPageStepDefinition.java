package stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectsManager;
import util.TestContextSetup;

public class OffersPageStepDefinition{
	public		TestContextSetup	testContextSetup;
	//public	PageObjectsManager	pageObjectsManager;
	public		OffersPage			offersPage;
	public		String				offersPageProductName;
	//public	String				landingPageProductName;
	
	//	This "OffersPageStepDefinition" constructor method is called automatically
	//	whenever we create an object for the "OffersPageStepDefinition" class
	
	//	Since an instance of the "TestContextSetup" is passed as parameter to this constructor.
	//	whenever any method in this step definition is called. the "TestContextSetup" class is
	//	instantiated and the "testContextSetup" object gets created.
	
	//	Since "PageObjectsManager" is now part of the "TestContextSetup" constructor, it may be
	//	noted that whenever the "TestContextSetup" class is instantiated (triggered by whenever
	//	any method of this step definition is called), automatically the "PageObjectsManager" class
	//	also is instantiated and readily available in this step definition.
	
	public OffersPageStepDefinition(TestContextSetup testContextSetup){
		this.testContextSetup = testContextSetup;
	}

	@Then("^User searched for (.+) shortname in OffersPage$")
	public void user_searched_for_shortname_in_offers_page(String shortName) throws InterruptedException, IOException {
		
		System.out.println("Short Name in Offer Page = " + shortName);		
		if (testContextSetup.testBase.driver.getCurrentUrl().equalsIgnoreCase
			("https://rahulshettyacademy.com/seleniumPractise/#/offers")) {
			//	Do nothing, since the application is already on Offers page.
			//	Hence, No need to switch again
		} else {
			switchToOffersPage();
		}
		
		Thread.sleep(100);
		
		//testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		
		//OffersPage	offersPage	=	new OffersPage(testContextSetup.driver);
		//OffersPage	offersPage	=	pageObjectsManager.getOffersPage();
		//OffersPage		offersPage 	= testContextSetup.pageObjectsManager.getOffersPage();
		offersPage 	= testContextSetup.pageObjectsManager.getOffersPage();
		
		offersPage.searchItem(shortName);
		
		Thread.sleep(500);
		
		//offersPageProductName	=	testContextSetup.driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
		offersPageProductName	=	offersPage.getOffersPageProductName();	
		System.out.println("Offers Page Product Name = " + offersPageProductName);
	}
	
	public void switchToOffersPage() throws InterruptedException, IOException {
		
		//testContextSetup.driver.findElement(By.linkText("Top Deals")).click();
		//LandingPage	landingPage	=	new LandingPage(testContextSetup.driver);
		//pageObjectsManager			=	new PageObjectsManager(testContextSetup.driver);
		//LandingPage		landingPage	=	pageObjectsManager.getLandingPage();
		
		LandingPage landingPage = testContextSetup.pageObjectsManager.getLandingPage();
		landingPage.selectTopDealsPage();
		
		// Currently Selenium is in Parent window and has no knowledge of child window,
		// To work on the offers page, We need to be able to switch to child window.
		// Once switched to child window, Selenium will not have knowledge of parent window
		
		//	testContextSetup.driver.switchTo().window(childWindow);
		testContextSetup.genericUtils.SwitchWindowToChild();
		//Thread.sleep(2000);
		
		// Since the script is in child window, ie in Orders page
		// it can access the elements in that page
	}
	
	@Then("validate that the product name in the Offers page matches with that in the Landing page")
	public void validate_that_the_product_name_in_the_offers_page_matches_with_that_in_the_landing_page() {
		
		if (
				(offersPageProductName != null && 
					!offersPageProductName.isEmpty()) &&
				(testContextSetup.landingPageProductName != null && 
					!testContextSetup.landingPageProductName.isEmpty())
			)
		{
			Assert.assertEquals(offersPageProductName, testContextSetup.landingPageProductName);
			//testContextSetup.testBase.driver.quit();
		}
	}
}