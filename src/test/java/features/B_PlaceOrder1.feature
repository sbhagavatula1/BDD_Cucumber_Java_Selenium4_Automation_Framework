Feature: B_Place the order for the Products

@B_PlaceOrder1
Scenario Outline: B_Users should have the same search experience in both Home & Checkout pages
		
    Given User is on Greenkart LandingPage
    When User searched for <Name> shortname in OffersPage
    Then Added "3" items of the selected product to cart
    And user proceeds to checkout and validate the <Name> items in CheckoutPage
    And verify user has ability to enter promo code and place the order

    Examples: 
      | Name |
      | Tom  |
      | Beat |
