Feature: BBC Example Web Tests:

  Scenario: Check my local news
    Given i navigate to "https://www.bbc.co.uk/"
    When i check news for "Scotland" "Edinburgh, Fife & East"
    Then i see stories for "Edinburgh, Fife & East"

  Scenario: Check Sports F1
    Given i navigate to "https://www.bbc.co.uk/sport"
    When i check the Formula 1 driver table
    Then i see current formula 1 driver table

  Scenario: Check My Local Weather
    Given i navigate to "https://www.bbc.co.uk/weather"
    When i input the location "Dunfermline"
    And click search
    Then i see current weather for my location

  Scenario: Check The Tv Guide
    Given i navigate to "https://www.bbc.co.uk/iplayer"
    When i click tv guide
    And i click "bbc one"
    Then i see todays Tv Guide