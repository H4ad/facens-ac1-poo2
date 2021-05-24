# AC2 - Orientação a Objeto

O projeto foi gerado pelo [start.spring.io](https://start.spring.io/#!type=maven-project&language=java&platformVersion=2.4.4.RELEASE&packaging=jar&jvmVersion=11&groupId=com.h4ad&artifactId=ac1&name=ac1&description=O%20projeto%20de%20AC1%20de%20Orienta%C3%A7%C3%A3o%20a%20Objetos%20-%202&packageName=com.h4ad.ac1&dependencies=devtools,web,data-jpa,h2,postgresql,restdocs) para o projeto de AC1 da matéria de Orientação a Objeto 2.

A arquitetura para o projeto seguiu conforme imagem abaixo:

![image](https://user-images.githubusercontent.com/41178325/118742226-5d637800-b826-11eb-986a-6e428447a261.png)

## Heroku

Você pode testar a API no seguinte endereço do Heroku: <https://facens-ac1-poo-2.herokuapp.com>. Está com o URL de ac1 mas contém o código do projeto da AC2.

## Insomnia

Se você possuir o Insomnia, e quiser testar por ele, baixe o arquivo [insomnia.yaml](/insomnia.yaml) e importe no seu Insomnia, ele possui todas as rotas criadas para essa API com os ambientes configurados para local e para o Heroku.

## Rotas

Há as seguintes rotas:

- Get: /events
  - Busca todos os eventos, você pode passar os Query Params como `page` e `limit` para fazer paginação e seus detalhes são retornados nos `Headers`, e Query Params como `name`, `description`, `emailContact` ou `startDate` para filtrar os resultados ou fazer uma pesquisa.
  - Exemplo: /events?page=0&limit=1&name=Vinicius
  - Exemplo: /events?page=0&limit=1&startDate=2021-03-20
  - Exemplo: /events?page=0&limit=1&name=Vinicius

- Post: /events
  - Cria um novo evento.

 ```json
{
  "name": "Evento do Joga18",
  "description": "Será um evento legal",
  "place": "Facens",
  "emailContact": "vinicius.cardoso@facens.br",
  "startDate": "2021-03-21",
  "endDate": "2021-03-28",
  "startTime": "16:30:00",
  "endTime": "19:00:00",
  "amountFreeTickets": 10,
  "amountPayedTickets": 90,
  "priceTicket": 60.99,
  "adminId": 1
}
```

- Get: /events/{eventId}
  - Busca um evento pelo seu ID.
  
- Put: /events/{eventId}
  - Atualiza um evento pelo seu ID.

```json
{
  "name": "Evento do Joga11",
  "description": "Será um evento legal para caramba.",
  "place": "Facens - LIGA",
  "emailContact": "vinicius.cardoso23@etec.sp.gov.br",
  "startDate": "2021-03-20",
  "endDate": "2021-03-22",
  "startTime": "13:00:00",
  "endTime": "15:00:00",
  "amountFreeTickets": 5,
  "amountPayedTickets": 95,
  "priceTicket": 99.99,
  "adminId": 2
}
```

- Delete: /events/{eventId}
  - Remove um evento pelo seu ID.

- POST: /admins
  - Cria um admin.

```json
{
  "name": "Vinícius Lourenço",
  "email": "vinicius.cardoso@facens.br",
  "phoneNumber": "15988116120"
}
```

- PUT: /admins/{adminId}
  - Edita um admin.

```json
{
  "name": "Vinícius Lourenço 2",
  "email": "vinicius.cardoso2@facens.br",
  "phoneNumber": "15988116120"
}
```

- GET: /admins/{adminId}
  - Busca um admin.

- GET: /admins
  - Busca vários admins.

- DELETE: /admins/{adminId}
  - Remove um admin.

- POST: /attendees
  - Cria um participante.

```json
{
  "name": "Vinícius Lourenço",
  "email": "vinicius.cardoso@facens.br"
}
```

- PUT: /attendees/{attendeeId}
  - Atualiza um participante.

```json
{
  "name": "Vinícius Lourenço 2",
  "email": "vinicius.cardoso2@facens.br"
}
```

- GET: /attendees/{attendeeId}
  - Busca um participante.

- GET: /attendees
  - Busca vários participantes.

- DELETE: /attendees/{attendeeId}
  - Remove um participante.

```json
{
  "name": "Vinícius Lourenço 2",
  "email": "vinicius.cardoso2@facens.br"
}
```

- POST: /places
  - Cria um lugar.


```json
{
  "name": "Casa do Joga10",
  "address": "Rua Monsenhor Benedito Mário Calazans"
}
```

- PUT: /places/{placeId}
  - Atualiza um lugar.

```json
{
  "name": "Casa do Joga10 2",
  "address": "Rua Monsenhor Benedito Mário Calazans 2"
}
```

- GET: /places/{placeId}
  - Busca um lugar.

- GET: /places
  - Busca vários lugares.

- DELETE: /places/{placeId}
  - Remove um lugar.

- POST: /events/1/places/1
  - Adiciona um lugar a um evento.

- DELETE: /events/1/places/1
  - Remove um lugar a um evento.

## Desenvolvedores

- Vinícius Lourenço Claro Cardoso - 180618
- Marcelo Zaguette Junior - 180998
