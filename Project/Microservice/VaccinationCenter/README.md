Question: What is Model class in spring boot?
Answer: In Spring MVC, the model works a container that contains the data of the application. Here, a data can be in any form such as objects, strings, information from the database, etc. It is required to place the Model interface in the controller part of the application.

Question: What is the purpose of dialect in hibernate?
Answer: Dialect is a class that acts as a bridge between Java JDBC types and SQL types, which contains the mapping between java language data type and database datatype. Dialect allows Hibernate to generate SQL optimized for a particular relational database.

Here we need to copy / want Citizen.java in my Model package to return the list of citizen and vaccination center to return.
So, we need one more class which is capable enough to return us response where we have list of citizens and the vaccination center details.

So, we should have POJO to handle both of them(List of citizen + VaccinationCenter Details) rather than giving it separately. So we should have one combined response. So, we have created the "ResultsOfCitizenWithVaccinationCenter" POJO that is required to be return from the controller(VaccinationCenterController).

Now we want "VaccinationCenterController" should be capable enough to handle adding vaccination center.

To get the list of citizens list from CitizenService microservice into VaccinationCenter microservice we need to use rest template and specify the CitizenService url and then set the response to the Model class - "ResultsOfCitizenWithVaccinationCenter" because this class would combine the vaccination center and list of citizens as per the vaccination center id pass by us in rest url in postman which is handle by findListOfCitizenWithCenter() method.

This is the local url "http://localhost:8081/citizen/id/ which we are using in findListOfCitizenWithCenter() method to get the list of citizens but the question is:-  
Question: if we put this local url given above thing to cloud will this work?
Answer: The answer is No. It will not work we need to continuously modify this url!!! and I need to put this url in property file but every time you need to change the url in property file but what is the way to not do that? The way to not do that is EUREKA.

Now I want EUREKA you should do this for me!
So, we are going put "CITIZEN-SERVICE" instead of localhost:8081
Example: http://CITIZEN-SERVICE/citizen/id/
But will this work?
And the answer is : No, It will not work!!!
Why?
Because it needs some "LoadBalanced" RestTemplate
So, how to load Balanced your rest template ? 
The answer is: by using single annotation - @LoadBalanced

Example: Apart than changing URL with CITIZEN-SERVICE we must annotate rest template with @LoadBalanced like given below then only we can get the data from EUREKA instead localhost.

@Bean
@LoadBalanced
public RestTemplate getRestTemplate() {
return new RestTemplate();
}

Though we are good to go with this http://CITIZEN-SERVICE/citizen/id/ url by annotating rest template with @LoadBalanced.

So, this is how we get the data from EUREKA instead localhost by using CITIZEN-SERVICE in url and annotating rest template with @LoadBalanced annotation.
So, overall workflow: we had --> Postman --> We hit the vaccination center service --> It's gets into its own database and fetch the result of vaccination center --> Then it goes through the rest template to citizen service and get the data out of it and give it back to the postman.
***************************************************************************************
Fault Tolerance in Microservices 
Hystrix(Circuit Breaker)

Question: What is Fault Tolerance?
Answer: Fault Tolerance is the property that enable a system to continue operating properly in the event of the failure of some of its components.

Example:Earlier we were fetching the list of citizens along with vaccination center id's based on the vaccination center id using postman with this URL: http://localhost:8082/vaccinationcenter/id/101
and we were able to get the list of citizens who are registered the vaccination center having id: 101.

Now the question arises that what is fault? so, the fault can arise when your citizen service is down and there could be many reason that it's down.
In our local if we want to make down our microservice citizen-service down then just close the server of citizen service in cloud.

So, lets implement the fault tolerance. Let's do make things below where 
    1. Eureka Server service is ON
    2. Vaccination service is ON
    3. Citizen service is OFF
So, we have turn on the first 2 service, we will turn off the citizen service to implement fault tolerance.
As soon as we close / turn off the citizen service there is a fault.

















