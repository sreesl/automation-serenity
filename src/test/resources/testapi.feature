Feature: Validate the endpoints offered by New York Times Best Seller Lists

  Scenario Outline: Verify api authentication
    Given api endpoint is set with "<key>"
    When HTTP request is triggered with "<endpoint>"
    Then api returns a response <code>

    Examples:
    | endpoint| key | code |
    | https://api.nytimes.com/svc/books/v3/lists/names.json | JjkROUOEyNPvgPgAk1fLkRpFv8VoqYHH | 200 |
    | https://api.nytimes.com/svc/books/v3/lists/names.json | invalid_key | 401 |
    | https://api.nytimes.com/svc/books/v3/lists/overview.json | JjkROUOEyNPvgPgAk1fLkRpFv8VoqYHH | 200 |

