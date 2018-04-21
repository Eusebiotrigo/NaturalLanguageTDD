Feature: Test Endpoint to retrieve natural language time
  Scenario: client makes call to GET /api/time
    When the client calls /api/time
    Then the client receives current hour in natural language
