# pluang-assignment
A Simple REST API for Assignment of Pluang

## Technologies Used
- Java
- Spring Boot
- Hibernate
- H2 Database
- Tomcat [Spring Boot Embedded Server]

## System configuration prerequisites

First, make sure that the Java 8 JDK and Maven are installed.

## Download the project
- Open the terminal 
- Run command: ```git clone https://github.com/Asraf-Uddin-Ahmed/pluang-assignment.git```

Before running the clone command please make sure that Git is installed on the PC.

## Build and Run
1. Open the terminal
2. Go to *pluang-assignment* folder where *pom.xml* exists
3. Run ```mvn clean install```
4. Run ```java -jar target\pluang-assignment-0.0.1-SNAPSHOT.jar```

We can also run directly this command: ```mvn spring-boot:run``` , without executing the above. 

Now 8080 port is open to serve our application from the docker container.

## Endpoints
#### Level 1: ```http://localhost:8080/numbers/{item}```
#### Level 2: ```http://localhost:8080/numbers/{item}/persist```

## Solution for Level 3
* Using more than one data center with a load balancer
* Using NoSQL DB since there is no other table
* Applying indexing on the table
* Implementing Sharding
* Using a distributed caching framework

Thanks