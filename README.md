## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Install the Database](#install-the-database)
* [How to Run](#how-to-run)
* [About the Service](#about-the-service)

## General info
This project is a REST API inventory and player manager for a role playing game. It allows for CRUD operations on a player's attributes, items, and gaming statistics.

## Technologies
Project is created with:
* Java 8
* Spring Boot
* Maven
* MySQL

## Install The Database
Copy and paste the content of **RPGdb.sql** on the MySQL command line or import this data from the MySQL Workbench.

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

## About the Service

#### Full documentation can be found at (when project is running):
```
http://localhost:8080/swagger-ui.html
```

### GET requests
#### No parameters
```
http://localhost:8080/player/getAll
http://localhost:8080/item/getAll
http://localhost:8080/stats/getAll
```

#### Integer Parameter
```
http://localhost:8080/player/getById/{id}
```

### POST Requests

#### Accepts JSON
```
http://localhost:8080/player/create
http://localhost:8080/item/addItemToPlayer
http://localhost:8080/stats/addStatForPlayer
```

#### String Parameter
```
http://localhost:8080/item/create/{itemName}
http://localhost:8080/stats/create/{statName}
```

### PUT Requests

#### Accepts JSON
```
http://localhost:8080/player/update
http://localhost:8080/stats/updateStatForPlayer
http://localhost:8080/item/updateItemForPlayer
```

### DELETE Requests

#### Integer Parameter
```
http://localhost:8080/player/delete/{id}
```

#### String Parameter
```
http://localhost:8080/item/delete/{itemName}
http://localhost:8080/stats/delete/{statName}
```