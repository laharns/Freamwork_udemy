@tag
Feature: Purchase the order from Ecommerce Website
  I want to use this template for my feature file

  Background:
    Given I landed on Ecommerce page

  @Regression
  Scenario Outline: Positive Test of Submitting the order
    Given Logged in with username <name> and password <password>
    When I add product <productname> to Cart
    And Checkout <productname> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage

    Examples:
      |name|password|productname|
      |lhr@yopmail.com|Test@123|ZARA COAT 3|





