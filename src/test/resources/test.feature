Feature:

  Background:
    Given Products page is loaded

  Scenario Outline: Add product to the cart
    When User go to "<firstLevelTab>" -> "<secondLevelTab>"
    And User select "<productName>"
    And User go to the cart
    Then Cart contains "<productName>"

    Examples:
      | firstLevelTab | secondLevelTab          | productName                            |
      | Гитары        | Акустические бас-гитары | Бас-гитара CORT AB850F BK W_BAG        |
      | Гитары        | Гитары классические     | Классическая гитара TERRIS TC-3801A NA |