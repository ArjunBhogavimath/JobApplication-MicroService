package com.ArjunCode.jobms.job;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {


    @Bean //spring boot needs to manage this objects of the class
    @LoadBalanced //it makes spring boot to use load balancer in the background.
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    //Note :
    //Only use this when we use restTemplate
    //Now we moved our application from restTemplate to openFeign
}
