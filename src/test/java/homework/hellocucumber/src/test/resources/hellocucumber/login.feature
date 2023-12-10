Feature: Check the login to the web site

  Scenario: Login to the web site

    Given Login page opened
    When Enter user name and password
    And Click on the login button
    Then I see main page with notification "Login successful"
