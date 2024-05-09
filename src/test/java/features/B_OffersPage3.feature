Feature: B_Search and Place order for the Products

  @B_OffersPage3
  Scenario Outline: B_Users should have the same search experience in both Home & Offers page
    Given User is on Greenkart LandingPage
    Then User searched for <Name> shortname in OffersPage
    And validate that the product name in the Offers page matches with that in the Landing page

    Examples: 
      | Name |
      | Tom  |