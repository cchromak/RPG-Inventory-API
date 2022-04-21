## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [How to Run](#how-to-run)

## General info
This project is a REST API inventory and player manager for a role playing game. It allows for CRUD operations on a player's attributes, items, and gaming statistics.

## Technologies
Project is created with:
* Java 8
* Spring Boot
* Maven
* MySQL

## How to Run

* Clone this repository
* Make sure you are using JDK 1.8 and Maven 4
* You can build the project and run the tests by running ```mvn clean package```
* Once successfully built, you can run the service by this method:
```
        java -jar target/RPG-Inventory-API-0.0.1-SNAPSHOT.jar
```
* Check the stdout or boot_example.log file to make sure no exceptions are thrown

Once the application runs you should see something like this

```
2022-04-21 10:13:48.151  INFO 16524 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2022-04-21 10:13:48.151  INFO 16524 --- [           main] c.c.R.RpgInventoryApiApplication         : Started RpgInventoryApiApplication in 9.695 seconds (JVM running for 10.61)
```