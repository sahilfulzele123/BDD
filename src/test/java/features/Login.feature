#Author: Sahil
#Feature: Login


Feature: Login feature
  
   Scenario: Login to Vtiger application using valid credentials
    Given I want to launch the browser
    And I want to load the URL
    When Login page is displayed enter valid credentials
    And Click on login
    Then Validate if Home page is displayed
    

 