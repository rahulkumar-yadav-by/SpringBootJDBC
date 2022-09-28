WEB LAYER CLIENT => displayed on the client

CONTROLLER => getPlayerController => Autowired Player DAO => view -> json data => client

DAO layer => PlayerDAO => @Autowired JDBCTemplate

=> Jdbc Template => Querying => From the Database, Mapping to => Player Model [Encapsulated Data]

DATABASE

Layers representation -> https://drive.google.com/file/d/1I3tRl8oKDn7YJBADJUisSqqQXmTJy-D0/view?usp=sharing

//FLOW***//

CLIENT => BROWSER => REQUEST => http://localhost:8080/movies => GET TOMCAT SERVER => 127.0.01:8080 => SpringBootJDBCApp => Class => @SpringBootApplication SpringBootJDBCApp => @ComponentScan => Player Controller @RestController[Bean] => Default Constructor => @Autowired Player DAO PlayerDAO.getAllPlayers() =>Communicate with the Database using JDBC Template=> @Autowired JDBC Template => Querying, RowMapping [Player Model] DAO=>

Flow Diagram -> https://drive.google.com/file/d/1zh-lA4336Upk4H67mXPlJ_LVnkx16Ko6/view?usp=sharing

JPA

=> No Row Mapper => No schema.sql

@Repository

@Entity1 => @Table => In Database => Hibernate Core Will Drop in the database and create new one => @Column, @Id,=> Columns inside our database @Entity2 @Entity3

JPA Diagram -> https://drive.google.com/file/d/17oghBGETMLB6HeFLVZiI1QQfSXEpor2R/view?usp=sharing



<h2> (28 September)</h2>
Request Line => Contains HTTP Method like(Get, Post, Put, Delete)

Request Header => Data with additional information about the request you are passing => Configurations for your request line

Request Body => content of the entity player



Client

Request Line => http://localhost:3000/add-todo + POST Method

Request Header => Content Type => Application/JSON

Request Body => {
"todoName": "Spring API",
"todoDescription": "Spring API Representation",
"id": 1
}

Server

Response Line => http://localhost:3000/add-todo + POST Method

Response Header
access-control-allow-origin →*
connection →keep-alive
content-length →119
content-type →application/json; charset=utf-8
date →Wed, 28 Sep 2022 05:25:41 GMT
etag →W/"77-GK4wpj1Vv1Ho5AHfUOXxsHhTdA0"
keep-alive →timeout=5
x-powered-by →Express

Response Body/Message
{
"id": 1,
"todoName": "Spring API",
"todoDescription": "Spring API Representation",
"_id": "6333dad5a2d5136faf28489b",
"__v": 0
}


https://drive.google.com/file/d/1Jpdv77XTyuGgAbOkfHniEOO14I2vI4l-/view?usp=sharing


HTTP Methods
1. POST => CREATING A RESOURCE => h2Database testdb
2. GET => READING A RESOURCE => h2Database:testdb
3. PUT => UPDATING A RESOURCE => h2Database:testdb
4. DELETE => DELETING A RESOURCE=> h2Database:testdb
