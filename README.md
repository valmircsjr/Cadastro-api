# Projeto de Cadastro de Pessoa

Este é um projeto de exemplo que gerencia o cadastro de pessoas.

## Requisitos

Para executar este projeto, certifique-se de ter os seguintes requisitos:

- Java 17
- Gradle
- IDE

## Configuração do Banco de Dados

O projeto utiliza um banco de dados para persistir as informações das pessoas cadastradas. Por padrão, está configurado para usar o banco de dados H2.

## Executando o Projeto Localmente

1 - Clone o repositorio para seu ambiente de trabalho;

2 - Acesse o diretório do projeto;

3 - Compile o projeto usando o Gradle: 
``gradle build``

4 - Execute o projeto:
``gradle bootRun``

5 - Para executar os testes: 
``gradle test``


## Documentação da API

A API possui documentação gerada automaticamente usando o Swagger. Você pode acessar a documentação da API em `http://localhost:8080/swagger-ui.html`.