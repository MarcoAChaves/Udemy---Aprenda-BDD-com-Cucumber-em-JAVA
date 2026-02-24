Feature: Aprender Cucumber

  Scenario: Aprendendo usar o Cucumber
    Given criei o arquivo corretamente
    When executar o teste
    Then a especificacao deve finalizar com sucesso

  Scenario: Contador valido
    Given o valor do contador e 15
    When eu encrementar em 3
    Then o valor do contador sera 18

  @smoke
  Scenario: Contador valido
    Given o valor do contador e 123
    When eu encrementar em 35
    Then o valor do contador sera 158

    #    Regex
  Scenario:  Deve calcular atraso na entrega
    Given que a entrega seria dia 05/07/2026
    When a entrega atrasa em 2 dias
    Then a entrega sera feita no dia 07/07/2026

  Scenario:  Deve calcular atraso na entrega da china
    Given que a entrega seria dia 05/07/2026
    When a entrega atrasa em 2 meses
    Then a entrega sera feita no dia 05/09/2026

  @positivo
  Scenario: Deve criar steps genéricos para estes passos
    Given o ticket é AF345
    And o valor da passagem é R$ 230,45
    And o nome do passageiro é "Fulano da Silva"
    And o telefone do passageiro é 9999-9999
    When criar os steps
    Then o teste vai funcionar

  @positivo
  Scenario: Deve reaproveitar os steps "Dado" do cenario anterior
    * o ticket é AB167
    * o ticket especial é AB167
    * o valor da passagem é R$ 1120,23
    * o nome do passageiro é "Cicrano de Oliveira"
    * o telefone do passageiro é 9888-8888

  @negativo
  Scenario: Deve negar todos os steps "Dado" dos cenarios anteriores
    Given o ticket é CD123
    Given o ticket é AG1234
    Given o valor da passagem é R$ 1.1345,56
    Given o nome do passageiro é "Beltrano Souza Matos de Alcântara Azevedo"
    Given o telefone do passageiro é 1234-5678
    Given o telefone do passageiro é 999-2223