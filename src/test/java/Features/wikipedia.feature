Feature:Wyszukiwanie fraz

  Scenario Outline: Sprawdzenie czy wyszuka bdd
    Given Uzytkownik jest na stronie "https://www.wikipedia.org"
    When  Uzytkownik wpisuje <fraza> w pole wyszukiwania
    And Uzytkownik klika w przycisk Szukaj
    Then <tekst> zostaje poprawnie wyszukana

    Examples:
      | fraza | tekst |
      | bdd   | bdd   |
      #|||
      #|       |       |




