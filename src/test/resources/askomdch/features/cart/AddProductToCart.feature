@addToCart
Feature: Add Product To Cart Functionality

  As a customer
  I want to Add product to cart
  so that I can purchase the product

  Scenario: Successful adding the product in cart
    Given I am on the store page
    When I add "Anchor Bracelet" in my cart
    Then On Cart Page I should see 1 "Anchor Bracelet" in the cart
@updateCartQuantity
    Scenario: User update the product quantity in in the cart
      Given I'm on the Cart Page with "Anchor Bracelet" in the cart
      When I do update of product quantity to 500
      Then I should see the product quantity updated to 500 successful
