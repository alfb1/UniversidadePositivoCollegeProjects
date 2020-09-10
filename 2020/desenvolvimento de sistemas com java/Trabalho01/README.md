Exercício – Aula presencial 01

Nessa atividade você desenvolver uma aplicação orientada a objetos de
acordo com o exercício proposto utilizando a linguagem Java junto com o
ambiente de desenvolvimento Eclipse.

INTRUÇÕES:
- Criar um novo Java Project no Eclipse;
- Atividade em dupla;
- Comentar o nome completo dos integrantes da equipe, na classe
principal;

Problema

  Identifique as classes e implemente um programa em Java para a
seguinte especificação: “ O supermercado vende diferentes tipos de
produtos. Cada produto tem um preço e uma quantidade em estoque. Um
pedido de um cliente é composto de itens, onde cada item especifica o
produto que o cliente deseja e a respectiva quantidade. Esse pedido pode
ser pago em dinheiro, cheque ou cartão, por exemplo. ”

Levantamento de requisitos
  
  Identificar todas as classes de modelo que sua aplicação irá precisar e
criar os arquivos/classes dentro de uma camada chamada models.

Aplicação

  Após a identificação e criação das classes de modelo necessárias para a
sua aplicação, criar um programa com as seguintes funcionalidades:

1) Cadastrar cliente
2) Cadastrar produto
3) Cadastrar forma de pagamento
4) Cadastrar venda
5) Listar venda
6) Listar vendas por forma de pagamento

Dados para o cadastro

Cliente: Nome e CPF
Produto: Nome e quantidade em estoque
Forma de pagamento: Nome
Venda: Cliente, produtos e forma de pagamento

Arquitetura da aplicação

   O projeto deve ser separado em camadas (modelos/entidades,
visualizações, repositórios e etc...) e cada classe deve ser colocada no lugar
correto.

Validações

  Ao cadastrar uma informação as seguintes validações precisam ser
desenvolvidas:

- Um cliente não pode ser salvo, caso já exista um cadastro com o
mesmo CPF;
- Um produto não pode ser salvo, caso já exista um cadastro com o
mesmo nome;
- Uma forma de pagamento não pode ser salva, caso já exista um
cadastro com o mesmo nome;

Armazenamento

  Todas as informações devem ficar salvas em listas na memória.