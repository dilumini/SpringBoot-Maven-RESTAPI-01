# SpringBoot-Maven-RESTAPI-01

# SpringBoot REST project with Maven

REST API project built in  springboot and Maven.
## Getting Started

### Prerequisites to run this project for development

* JAVA JDK 8
* Apache Maven ~4.0.0
* Sprint Boot ~2.5.2
* MySQL Server ~8.0.30

### Steps to run locally

#### There are two ways you can run this project:

1. Run ```mvn spring-boot:run``` in the terminal on the root directory

#### or

1. Run ```mvn clean install``` in the root directory
2. Go to target folder using ```cd target```
3. Run ```java -jar entgra-task-0.0.1-SNAPSHOT.jar```

#### Application will run on http://localhost:8080

### API

API endpoints can be tested using curl or Postman

* GET all devices - http://localhost:8080/device <br><br>
```curl -v http://localhost:8080/device``` <br><br>
* GET device - http://localhost:8080/device/{id} <br><br>
```curl -v http://localhost:8080/device/1``` <br><br>
* POST - http://localhost:8080/device <br><br>
```curl -v -X POST -H "Content-Type: application/json" -d "{ "name": "samsung","model": "galaxy","status": "ENROLLED","enrolledTime": "2022-09-07" }" http://localhost:8080/device``` <br><br>
* PUT - http://localhost:8080/device <br><br>
```curl -v -X PUT -H "Content-Type: application/json" -d "{ "id": "1","name": "My Phone","model": "Samsung","status": "INACTIVE","enrolledTime": "2022-09-07" }" "http://localhost:8080/device"``` <br><br>
* DELETE - http://localhost:8080/device/{id} <br><br>
```curl -v -X DELETE http://localhost:8080/device/1```
