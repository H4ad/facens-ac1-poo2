# AC1 - Orientação a Objeto

O projeto foi gerado pelo [start.spring.io](https://start.spring.io/#!type=maven-project&language=java&platformVersion=2.4.4.RELEASE&packaging=jar&jvmVersion=11&groupId=com.h4ad&artifactId=ac1&name=ac1&description=O%20projeto%20de%20AC1%20de%20Orienta%C3%A7%C3%A3o%20a%20Objetos%20-%202&packageName=com.h4ad.ac1&dependencies=devtools,web,data-jpa,h2,postgresql,restdocs) para o projeto de AC1 da matéria de Orientação a Objeto 2.

## Heroku

Você pode testar a API no seguinte endereço do Heroku: <https://facens-ac1-poo-2.herokuapp.com>

## Rotas

Há as seguintes rotas:

- Get: /events
  - Busca todos os eventos, você pode passar os Query Params como `page` e `limit` para fazer paginação e seus detalhes são retornados nos `Headers`, e Query Params como `name`, `place`, `description`, `emailContact` ou `startDate` para filtrar os resultados ou fazer uma pesquisa.
  - Exemplo: /events?page=0&limit=1&name=Vinicius
  - Exemplo: /events?page=0&limit=1&startDate=2021-03-20
  - Exemplo: /events?page=0&limit=1&place=Facens
  - Exemplo: /events?page=0&limit=1&name=Vinicius&place=Facens
- Post: /events
  - Cria um novo evento passando as seguintes propriedades: `name`, `place`, `description`, `emailContact`, `startDate`, `endDate`, `startTime`, `endTime`, `emailContact`.
- Get: /events/{eventId}
  - Busca um evento pelo seu ID.
- Put: /events/{eventId}
  - Atualiza um evento pelo seu ID, e você pode atualizar os seguintes campos: `name`, `place`, `description`, `emailContact`, `startDate`, `endDate`, `startTime`, `endTime`, `emailContact`.
- Delete: /events/{eventId}
  - Remove um evento pelo seu ID.

## Desenvolvedor

Vinícius Lourenço Claro Cardoso - 180618
Marcelo Zaguette Junior - 180998
