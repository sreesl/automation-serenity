@functional
Feature: Validate the endpoints offered by New York Times Best Seller Lists

  Scenario Outline: Verify api authentication
    Given api endpoint is set with "<key>"
    When HTTP request is triggered with "<endpoint>"
    Then api returns a response <code>

    Examples:
    | endpoint| key | code |
    | https://api.nytimes.com/svc/books/v3/lists/names.json | JjkROUOEyNPvgPgAk1fLkRpFv8VoqYHH | 200 |
    | https://api.nytimes.com/svc/books/v3/lists/overview.json | JjkROUOEyNPvgPgAk1fLkRpFv8VoqYHH | 200 |
    | https://api.nytimes.com/svc/books/v3/lists/best-sellers/history.json | JjkROUOEyNPvgPgAk1fLkRpFv8VoqYHH | 200 |
    | https://api.nytimes.com/svc/books/v3/lists.json?list=hardcover-fiction | invalid_key | 401 |
    | https://api.nytimes.com/svc/books/v3/reviews.json?author=Michelle Obama | invalid_key | 401 |


  Scenario Outline: Verify response for Book endpoints with valid input data
    Given an HTTP request is triggered with "<endpoint>" "<key>"
    Then api returns a valid response

    Examples:
      | endpoint| key |
      | https://api.nytimes.com/svc/books/v3/reviews.json?author=Michelle Obama | JjkROUOEyNPvgPgAk1fLkRpFv8VoqYHH |
      | https://api.nytimes.com/svc/books/v3/lists/names.json | JjkROUOEyNPvgPgAk1fLkRpFv8VoqYHH |
      | https://api.nytimes.com/svc/books/v3/lists/overview.json?published_date=2021-06-05 | JjkROUOEyNPvgPgAk1fLkRpFv8VoqYHH |
      | https://api.nytimes.com/svc/books/v3/lists/best-sellers/history.json | JjkROUOEyNPvgPgAk1fLkRpFv8VoqYHH |
      | https://api.nytimes.com/svc/books/v3/lists.json?list=hardcover-fiction | JjkROUOEyNPvgPgAk1fLkRpFv8VoqYHH |


  Scenario Outline: Verify response for Book endpoints with invalid input data
    Given an HTTP request is triggered with "<endpoint>" "<key>"
    Then api returns an error response

    Examples:
      | endpoint| key |
      | https://api.nytimes.com/svc/books/v3/reviews.json | JjkROUOEyNPvgPgAk1fLkRpFv8VoqYHH |
      | https://api.nytimes.com/svc/books/v3/lists.json | JjkROUOEyNPvgPgAk1fLkRpFv8VoqYHH |
      | https://api.nytimes.com/svc/books/v3/lists/overview.json?published_date='2020-06-01' | JjkROUOEyNPvgPgAk1fLkRpFv8VoqYHH |
