#language: pt
Funcionalidade: Alugar Filme
  Como usuário
  Eu quero cadastrar aluguéis de filmes
  Para controlar preços e datas de entrega

 Cenario: Deve alugar um filme com sucesso
   Dado um filme com estoque de 2 unidades
   E que o preço do aluguel seja R$ 3
   Quando alugar
   Entao o preço do aluguel será R$ 3
   E a data de entrega será em 1 dia
   E o estoque do filme será 1 unidade

   Cenario: Não deve alugar filme sem estoque
     Dado um filme com estoque de 0 unidades
     Quando alugar
     Entao não será possivel por falta de estoque
     E o estoque do filme será 0 unidade

     Cenario: Deve dar condições especiais para categoria extendida
       Dado um filme com estoque de 2 unidades
       E que o preço do aluguel seja R$ 4
       E que o tipo do aluguel seja extendido
       Quando alugar
       Entao o preço do aluguel será R$ 8
       E a data de entrega será em 3 dias
       E a pontuação recebida será de 2 pontos

  Cenario: Deve dar condições especiais para categoria comum
    Dado um filme com estoque de 2 unidades
    E que o preço do aluguel seja R$ 4
    E que o tipo do aluguel seja comum
    Quando alugar
    Entao o preço do aluguel será R$ 4
    E a data de entrega será em 1 dias
    E a pontuação recebida será de 1 pontos

    #Aplicando o Data-Driven

  Esquema do Cenario: Deve dar condições conforme o tipo de aluguel
    Dado um filme com estoque de 2 unidades
    E que o preço do aluguel seja R$ <preco>
    E que o tipo do aluguel seja <tipo>
    Quando alugar
    Entao o preço do aluguel será R$ <valor>
    E a data de entrega será em <qtdDias> dias
    E a pontuação recebida será de <pontuacao> pontos

    Exemplos:
    | preco |    tipo   | valor | qtdDias | pontuacao |
    |   4   | extendido |   8   |    3    |     2     |
    |   4   |   comum   |   4   |    1    |     1     |
    |   10  | extendido |   20  |    3    |     2     |
    |   5   |  semanal  |   15  |    7    |     3     |