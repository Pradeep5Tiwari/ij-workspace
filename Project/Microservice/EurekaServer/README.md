Problem statement: If you ever get this status saying
status = Cannot execute request on any known server stacktrace.

Conclusion: It's trying to execute and get register to another eureka server.
So every eureka server internally behave as eureka client because there may be chances that if you have one eureka server which is going to give you the all the information about your microservice.

So what if eureka server gets down then you won't be able to identify your search if any url for any of the services.
So, that is why it's good deal that you should always create multiple copies of eureka server. you can have one main eureka server having the urls with the different eureka server which is actually helping you to relocate to any of the microservice.
if you have one eureka server and you don't want your eureka server to register with different eureka server in the same network as eureka client then you would have to put the different properties. 

(i) If you are behaving as client then don't fetch any registry.
add the below properties in the application.yml configuration file
server:
   port: 8761   --> This is default port for eureka server.
eureka:
   client: 
      fetch-registry: false  
      register-with-eureka: false

(ii) Now the last thing is to annotate the main class "EurekaServerApplication" with @EnableEurekaServer

Now after adding all these property and annotation above the above status error should have gone and there should not be any kind of service discovery from eureka server being a eureka client to different eureka server. 
Now run the application and hit the localhost url http://localhost:8761 into browser & you would be seeing the "Spring Eureka Dashboard" page with system status.

Note: If you look at UI it would display that: Instances currently registered with Eureka: No instances available, and the answer is that we haven't started any other console yet. The only one running is Eureka Server.

So, here in this Eureka Dashboard Page you can see that 
which application is running and what is the url of an application.

Now you can run your another microservice - CitizenService.
This microservice we don't need to enable the EurekaServer as it's already depreciated into EurekaServerApplication. And it is already running.
Since CitizenServiceApplication is an automatically an eureka client because we have dependency (spring-cloud-starter-netflix-eureka-client) of eureka client it will automatically register to the eureka server that we have created. 
Now you would see that there are two application instance running 
1. EurekaServer on 8761 port and 
2. CitizenService on 8081 port.

Results: 
Attached screenshot before running CitizenService on Eureka with 0 instance: EurekaServerDashboard.png
Attached screenshot after running CitizenService on Eureka: CitizenServiceOnEureka.png 
