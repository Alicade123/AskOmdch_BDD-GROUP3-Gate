@addToCart
Feature: Add Product To Cart Functionality

  As a customer
  I want to Add product to cart
  so that I can purchase the product

  Scenario: Successful adding the product in cart
    Given I am on the store page
    When I add "Anchor Bracelet" in my cart
    Then On Cart Page I should see 1 "Anchor Bracelet" in the cart