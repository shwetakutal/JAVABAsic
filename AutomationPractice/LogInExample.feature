
@tag
Feature: Log In
  User log in to facebook.com

  @tag1
  Scenario: Successful log in with valid credentials
    Given User on  website facebook.com 
    And user clicked on log in
    And gave <username> as "Shweta" and <password> as "1234"
    
   # is it ok to give both details in one ???
  
    When  user click on "submit"
    Then log in must be succeful with <message> as "successfuly loged in"
    And user should redirected to the home page

  @tag2
  Scenario Outline: Unsccessful log in with invalid credentials
    Given I want to write a step with <name>
    When I check for the <value> in step
    Then I verify the <status> in step

    Examples: 
    
      | <username> | <password> | <message>  |
      | Shweta     |     1234   | successfuly loged in |
     
