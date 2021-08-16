Feature: Find price
  Create an API Rest end point to query the price of a product based on the chain identifier, product identifier and application date.
  You have to return the product identifier, chain identifier, rate to apply, application dates and final price to apply.
  If two rates coincide in a range of dates, the one with the highest priority (highest numerical value) is applied.
  Scenario Outline: request the price to the API Rest end point for a specific date
    When the client call price with '<brand>', '<product>', '<datetime>'
    And will return the price <price> from the list <pricelist>
    Examples:
      | brand | product | datetime            | price | pricelist |
      | 1     | 35455   | 2020-06-14T10:00:00 | 35.50 | 1         |
      | 1     | 35455   | 2020-06-14T16:00:00 | 25.45 | 2         |
      | 1     | 35455   | 2020-06-14T21:00:00 | 35.50 | 1         |
      | 1     | 35455   | 2020-06-15T10:00:00 | 30.50 | 3         |
      | 1     | 35455   | 2020-06-16T21:00:00 | 38.95 | 4         |