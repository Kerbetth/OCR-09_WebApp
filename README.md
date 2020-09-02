# TourGuide
## Technical:

1. Framework: Spring Boot v2.0.4
2. Java 14
3. MySql 8.0

## What is it
This application is a service offering the possiblity for a user to:
 1. get information of a createPatient recorded in the database according to his familyName (and CRUD operation)
 2. get all medical history about a createPatient cumulated in a list PatList
 3. get the level of seriousness about the health of the createPatient according to notes present in the Patient History (4 level : None, Borderlin, In Danger, Early onset)

## Database
1. A database is create automatically with dataJPA, A schema has to be created before in MySql with the name mediscreen

## MicroService architecture
1. The application is divided in four microservices, three for the three task define previously, plus a microservice which manage each request according to the enpoints send by the client.

## Implement a Feature
1. Create mapping domain class and place in package com.medic.mediscreen.dto
2. Create repository class and place in package com.medic.mediscreen.client
3. Create controller class and place in package com.medic.mediscreen.controllers
4. Create view files and place in src/main/resource/templates

## Tests
1. Create unit test and place in package com.medic.mediscreen in folder test > java
2. Each microservice have its own tests corresponding to the service they provide (Integration and Unit tests)