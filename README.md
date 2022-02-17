# Customer CRUD operations with UI
## Requirements:
- Java ( jdk 1.8+)
- Maven 3.0+
- Spring Boot(2.6.3)
- Database(postgreSQL)
- Database Drivers
- IDE( IntelliJ or Eclipse)
- Browser
## Features
- Create `POST` `http://localhost:8181/customers/create`
- Update `POST` `http://localhost:8181/customers/update/{id}`
- Get `GET` `http://localhost:8181/api/customers/create`
- Search `GET` `http://localhost:8181/_search/customers`
- Delete `DELETE` `http://localhost:8181/customers/{id}`

## Steps to create Application
- Create project using [Spring Initializer](https://start.spring.io/)

- Select `maven`

- Select `spring boot version`

- Select `java version`

- Project metadata
  ```
  group(com.sunglowsys)
  artifact(customer-crud-operation)
  package name(com.sunglowsys)
  ```

- Select Packaging `jar`

- Add dependencies `Spring Web`, `Spring Data JPA`, `PostgreSQL Driver`, `Bean Validation`,`thymeleaf`

- Click on `Generate`

- Extract the generated zip file

- Import application in IntelliJ or Eclipse

- Implement CRUD Operations

## How to run application
- Open terminal and go inside application directory(customer-crud-operation)
- Run command `mvn`
- Open browser and run URL`http://localhost:8181`

