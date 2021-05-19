# AC1 - Orientação a Objeto

O projeto foi gerado pelo [start.spring.io](https://start.spring.io/#!type=maven-project&language=java&platformVersion=2.4.4.RELEASE&packaging=jar&jvmVersion=11&groupId=com.h4ad&artifactId=ac1&name=ac1&description=O%20projeto%20de%20AC1%20de%20Orienta%C3%A7%C3%A3o%20a%20Objetos%20-%202&packageName=com.h4ad.ac1&dependencies=devtools,web,data-jpa,h2,postgresql,restdocs) para o projeto de AC1 da matéria de Orientação a Objeto 2.

A arquitetura para o projeto seguiu conforme imagem abaixo:
<br>
![image](https://user-images.githubusercontent.com/41178325/118742226-5d637800-b826-11eb-986a-6e428447a261.png)


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
  <br>
![image](https://user-images.githubusercontent.com/41178325/118742133-28efbc00-b826-11eb-9ba9-f3f955df9275.png)

- Post: /events
  - Cria um novo evento passando as seguintes propriedades: `name`, `place`, `description`, `emailContact`, `startDate`, `endDate`, `startTime`, `endTime`, `emailContact`.
  <br>
![image](https://user-images.githubusercontent.com/41178325/118742106-1c6b6380-b826-11eb-9281-8fe2b00de8b3.png)

- Get: /events/{eventId}
  - Busca um evento pelo seu ID.
  <br>
![image](https://user-images.githubusercontent.com/41178325/118742153-360cab00-b826-11eb-9d82-5b27e64983f0.png)

- Put: /events/{eventId}
  - Atualiza um evento pelo seu ID, e você pode atualizar os seguintes campos: `name`, `place`, `description`, `emailContact`, `startDate`, `endDate`, `startTime`, `endTime`, `emailContact`.
  <br>
![image](https://user-images.githubusercontent.com/41178325/118742175-43299a00-b826-11eb-8e23-6761dc55fa7d.png)

- Delete: /events/{eventId}
  - Remove um evento pelo seu ID.
  <br>
![image](https://user-images.githubusercontent.com/41178325/118742190-4c1a6b80-b826-11eb-8054-a6f7e4ea9deb.png)


## Desenvolvedor

Vinícius Lourenço Claro Cardoso - 180618
<br>
Marcelo Zaguette Junior - 180998
