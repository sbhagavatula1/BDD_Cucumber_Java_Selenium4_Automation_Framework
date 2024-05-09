Feature: A_Search and Place order for the Products

@A_SearchProduct
Scenario Outline: A_Users should have the same search experience in both Home & Offers pages
		
		Given User is on Greenkart LandingPage
		When User searched with shortname <Name> in LandingPage and extracted actual name of the product    
		Then User searched for <Name> shortname in OffersPage
		And validate that the product name in the Offers page matches with that in the Landing page

Examples:
|Name|
|Ban| #---> Present in both Landing and Offer Pages
|Bea| #---> Present in both Landing and Offer Pages
#|Bri| #---> Present in both Landing and Offer Pages
#|Car| #---> Present in both Landing and Offer Pages
#|Man| #---> Present in both Landing and Offer Pages
#|Ora| #---> Present in both Landing and Offer Pages
#|Pot| #---> Present in both Landing and Offer Pages
#|Str| #---> Present in both Landing and Offer Pages
#|Tom| #---> Present in both Landing and Offer Pages
#|Pin| #==> Not present in Landing page
#|Bro| #==> Not present in Offers page
#|Cau| #==> Not present in Offers page
#|Cuc| #==> Not present in Offers page
#|Bee| #==> Not present in Offers page
#|Cap| #==> Not present in Offers page
#|Mus| #==> Not present in Offers page
#|Pum| #==> Not present in Offers page
#|Cor| #==> Not present in Offers page
#|Oni| #==> Not present in Offers page
#|Pea| #==> Not present in Offers page
#|Pom| #==> Not present in Offers page
#|Ras| #==> Not present in Offers page
#|Wat| #==> Not present in Offers page
#|Pis| #==> Not present in Offers page
#|App| #==> Pneapple	&	Apple 
#|Gra| #==> Grapes		&	Pomegranate
#|Mus| #==> Mushroom	&	Musk Mellon
#|Nut| #--> Nuts Mixture & Walnuts
#|Cas| ==> Not present in Offers page
#|Wal| ==> Not present in Offers page
#|Alm| #==> "Almonds" in Landing page & "Almond" in Offer page