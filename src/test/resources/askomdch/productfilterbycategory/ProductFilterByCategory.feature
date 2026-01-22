@filterProductsByCategory
Feature: Filter products by category

  Scenario Outline: Filter products using category dropdown
    Given I am on the store page
    When I select category "<category>"
    Then I should see "<url_keyword>" in the url

    Examples:
      | category    | url_keyword |
      | Accessories | accessories |
      | Men         | men         |
      | Women       | women       |