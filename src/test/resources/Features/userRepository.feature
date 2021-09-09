Feature: Get gitHub repos for a user
  Narrative:
  As a user
  I want to login to gitHub.com
  So that I can check the repositories associated with user

  Background:
    Given User launch the Chrome Browser
    And User opens gitHub url

  Scenario Outline: Search for the user
    When User Enter the username to search as "<username>"
    And User Click the search button
    Then Page Title should be "<userPageTitle>"
    Then Verify the number of repos is <repoCount>
    And Close the browser
    Examples:
      | username             | userPageTitle                               | repoCount |
      | sangeetha-rageswaran | Search · user:sangeetha-rageswaran · GitHub |2        |

  Scenario: User not able to search for invalid user
    When User Enter the username to search as "random123"
    And User Click the search button
    Then User see "We could not perform this search" message
    And Close the browser