Feature: Validate Stay Tab

  Background: 
    Given I am on home page

  Scenario Outline: 
    When I fill in <city> <district> <checkInDate> <checkOutDate>
    Then I am navigated to Search Hotels Page

    Examples: 
      | city       | district       | checkInDate    | checkOutDate   |
      | "New York" | "Manhattan"    | "Jun 20, 2021" | "Jun 28, 2021" |
      | "New York" | "Times Square" | "Feb 20, 2021" | "Feb 25, 2021" |
	
	@p1
  Scenario: 
    When i press add flight box and i enter city information
      | city | "New York" |
    Then I am navigated to Search Hotels Page
