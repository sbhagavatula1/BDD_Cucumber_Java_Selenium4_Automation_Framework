Feature: B_Place order for the Products

  Background: 
	Given User is on Greenkart LandingPage
	  
	@B_PlaceOrderBackground
	Scenario Outline: B_Users should have the same search experience in both Home & Checkout pages		
		//Given User is on Greenkart LandingPage

		When User searched with shortname <Name> in LandingPage and extracted actual name of the product
		And Added "3" items of the selected product to cart
		Then user proceeds to checkout and validate the <Name> items in CheckoutPage
		And verify user has ability to enter promo code and place the order

		Examples:
		|Name|
		|Tom|
	
  @B_OffersPageBackground
  Scenario Outline: B_Users should have the same search experience in both Home & Offers page
    //Given User is on Greenkart LandingPage
		
		When User searched with shortname <Name> in LandingPage and extracted actual name of the product    
		Then User searched for <Name> shortname in OffersPage
		And validate that the product name in the Offers page matches with that in the Landing page
		
    Examples: 
      | Name |
      | Tom  |
