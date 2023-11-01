# OrderProductsTask
This project demonstrates the implementation of the Ordering Task:

## Features
* User registration and login with JWT authentication
* Password encryption using BCrypt
* Customized access denied handling

## Technologies
* Spring Boot 3.0.1
* Spring Security
* JSON Web Tokens (JWT)
* BCrypt
* Maven
* java 17

## Getting Started
To get started with this project, you will need to have the following installed on your local machine:

* JDK 17+
* Maven 3+

To build and run the project, follow these steps:

* Clone the repository: git clone https://github.com/aliabdelmohsen/OrderProductsTask.git
* Build the project: mvn clean install
* Run the project: mvn spring-boot:run

* or using dockerImage
* link https://hub.docker.com/repository/docker/aliabdelmohsen1/shopping/general
* then run dockerCompose -> docker compose up 

-> The application will be available at http://localhost:9090.

## Swagger

* http://localhost:9090/swagger-ui/index.html

# H2_console

 * http://localhost:9090/h2-console/login.jsp
 * username: sa

 * 
## postman collection

* you need to import OrderPostManCollection.postman_collection.json into postman
* you need to add environment Shop_Local.postman_environment.json 
