package com.microservice.CitizenService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class CitizenServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CitizenServiceApplication.class, args);
    }

}
/* What is the difference between @EnableEurekaClient and @EnableDiscoveryClient?
Answer: @EnableEurekaClient only works with Eureka whereas @EnableDiscoveryClient works with eureka, consul, zookeeper.
But if Eureka is on the application classpath, they are effectively the same. */
