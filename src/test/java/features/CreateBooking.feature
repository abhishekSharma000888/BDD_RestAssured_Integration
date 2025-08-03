Feature: Create Booking API

  Scenario: Create a booking with valid data
    Given the booking payload is prepared with valid data
    When the client sends a POST request to create a booking
    Then the API should return status code 200
    And the response should contain the booking details
