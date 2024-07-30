
@tag
Feature: Purchase the order from Ecommerce Website
  I want to use this template for my feature file
  
  Background:
  Given I landed on Ecommerce Page

  @tag1
  Scenario: Positive Test of Submitting the order
    Given Logge in with name <name> and password <password>
    When I add product <productName> to Cart
    And checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage

  @tag2
  Scenario Outline: Title of your scenario outline
    Given I want to write a step with <name>
    When I check for the <value> in step
    Then I verify the <status> in step

    Examples: 
      | name  								| password 						|productName 						|
      | kantokaryb@gmail.com" | kqa1erb_qdc7UPE-jab | ZARA COAT 3 					|
