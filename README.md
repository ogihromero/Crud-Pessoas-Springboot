# Crud de Pessoas

## Descrição
Crud de pessoas criado em Java, utilizando o SpringBoot e banco de dados H2

## Instalação
- O requisito é o Java 17
- Após baixar o repositório, execute os comandos: 
  - `mvn verify`
  - Ou `mvnw verify` caso não tenha o maven instalado
  - Ou importe e execute Build no seu IDE

## Execução
- A porta padrão do projeto é a `8080`
- O projeto cria um banco de dados na memória, por padrão o usuário é `sa` e sem senha, mas alterações podem ser realizadas [aqui](src/main/resources/application.properties)
- O console do banco de dados pode ser acessado em http://localhost:8080/h2-console, com as especificações:
  - Driver Class: `org.h2.Driver`
  - JDBC URL: `jdbc:h2:mem:crud`
  - User Name: `sa`
- A rota da API se encontra em http://localhost:8080/pessoas . 
- A partir dela se pode executar todas as funções que se espera de um CRUD utilizando os métodos padrão e incluindo a navegação por id.