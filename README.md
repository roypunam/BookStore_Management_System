
# Bookstore Management Application

RESTful web service for a simple bookstore management system. This service
allow users to manage books and authors. The service support basic CRUD operations,
partial updates, and proper data persistence.

## Requirements

For building and running the application you need:

- Java 17
- Spring Boot 3.3.2
- Spring Data JPA
- Maven
- MySQL database

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.bookstore.management.bookstore_management` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```
`Note: Before running the application change the DB credentials in your application.properties file.`
## API Reference

#### Authors:

```http
GET /author/list/view - Retrieve all authors
GET /author/view/id/{id} - Retrieve an author by ID
POST /author/create - Create a new author
PATCH /author/update/partial/{id} - Partially update an existing author
PUT /author/update/{id} - Update an existing author
DELETE /author/delete/id/{id} - Delete an author
```
- [REF Author controller](https://github.com/roypunam/BookStore_Management_System/blob/main/src/main/java/com/bookstore/management/bookstore_management/controller/AuthorController.java)

#### Books:

```http
GET /book/list/view - Retrieve all books
GET /book/id/{id} - Retrieve a book by ID
POST /book/create/new - Create a new book
PUT /book/update/{id} - Update an existing book
PATCH /book/update/partial/{id} - Partially update an existing book
DELETE /book/delete/id/{id} - Delete a book
```
- [REF Book controller](https://github.com/roypunam/BookStore_Management_System/blob/main/src/main/java/com/bookstore/management/bookstore_management/controller/BookController.java)

## Documentation

 - [Java Documentation](https://github.com/roypunam/BookStore_Management_System/tree/main/doc)
 - [swagger-ui](http://localhost:9090/swagger-ui/index.html#/)

