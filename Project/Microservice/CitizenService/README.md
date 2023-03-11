Project Name: VaccinationCenterService and CitizenService.

Introduction: This project is microservice based application architecture.
where we have three web-services

1. VaccinationCenterService - For vaccination center where we add, delete or update the vaccination center, timing slot and all other details.

2. CitizenService - For registering the citizens via Co-Win website.

3. Eureka Service - Which service discovery is going to have registry of above two microservice (VaccinationCenterService and CitizenService) that we are going to create so when we go to deploy these 2 microservice into cloud or when the property changes then it should not affect us. 


In order to create the microservice we are using spring-boot based application.
So we are creating spring-boot based microservice through the spring initializr(start.spring.io).

Project Name: CitizenService
Project Type: Maven
Version: 3.9.0 
Language: Java
Version: 19.0.2
Packaging: Jar
Artifact: CitizenService

Dependencies: 
MySQLDriver: This is driver dependency to connect to MySQL. 
When creating MySQL real database where my citizens information will be saved.

Spring Data JPA: This is going to be a way / technique to connect my spring application to the database.

Lombok: This is a java library tool that is used to minimize/remove the boilerplate code and save the precious time of developers during development by just using some annotations. By using this dependency we don't need getters and setters and we use annotations only.

Spring Web: The spring-web dependency contains common web specific utilities for both Servlet and Portlet environments. This dependency is used to build a spring based web application. Can also be used to build a REST application like Tomcat as the default embedded container.

Eureka Discovery Client: This starter dependency is going to help us to be discovered from eureka server.

For application configuration we are using yaml file --> application.yml instead "application.properties" because it provides better readability and configuration in structural way.
YAML stands: Yet Another Markup Language
Question: What is YAML used for? 
Answer: One of the most common uses for YAML is to create configuration files. It's recommended that configuration files be written in YAML rather than JSON, even though they can be used interchangeably in most cases, because YAML has better readability and is more user-friendly.
The extension for yaml file is .yml





