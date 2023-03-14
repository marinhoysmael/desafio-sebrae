# language: pt
Funcionalidade: buscar cep
  Preciso saber os dados de um determinado cep

  Cenario: CEP 64053070
    Dado que informei o cep 64053070
    Quando eu solicito a api as informacoes do cep
    Entao eu deveria ser informado que o logradouro é "Rua Antilhon Ribeiro Soares"
    E o bairro é "Santa Isabel"
    E a localidade é "Teresina"
    E a uf é "PI"
    E o ibge é "2211001"
    E o ddd é "86"
    E o siafi é "1219"