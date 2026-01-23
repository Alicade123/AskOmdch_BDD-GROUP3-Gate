Feature: View Product Details
  In order to understand a product before purchasing
  As a customer
  I want to view detailed information about a product

  Scenario: View product details from product listing
    Given the user is on a product Store page
    When the user click on a "Anchor Bracelet" product
    Then the product detail page is displayed