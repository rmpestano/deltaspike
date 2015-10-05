Feature: ApplicationScoped bean test
  As a user of DeltaSpike Test Control module
  I want to inject application scoped beans
  So that I can test application scoped beans


  Scenario Outline: bean increment
    Given test bean value is set to <value>
    When bean value is incremented by 2
    Then bean value should be <result>

  Examples: examples1
  | value | result |
  | 1     | 3      |
  | 0     | 2      |
  | 10    | 12     |


