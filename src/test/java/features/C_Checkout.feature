Feature: C_Place the order for the Products

@C_Checkout
Scenario Outline: C_Users should have the same search experience in both Home & Checkout pages
		
		Given User is on Greenkart LandingPage
		When User searched with shortname <Name> in LandingPage and extracted actual name of the product
		And Added "3" items of the selected product to cart
		Then user proceeds to checkout and validate the <Name> items in CheckoutPage
		And verify user has ability to enter promo code and place the order

Examples:
|Name|
#|Bro|
#|Cau|
#|Cuc|
#|Bee|
#|Car|
|Tom|
#|Bea|
#|Bri|
#|Cap|
#|Mus|
#|Pot|
#|Pum|
#|Cor|
#|Oni|
#|App|
#|Ban|
#|Gra|
#|Man|
#|Mus|
#|Ora|
#|Pea|
#|Pom|
#|Ras|
#|Str|
#|Wat|
#|Alm|
#|Pis|
#|Nut|
#|Cas|
#|Wal|