package com.flamexander.cloud.service.greeting;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class GreetingApp {
    @Autowired
    private RestTemplate restTemplate;

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(GreetingApp.class, args);
    }

    @GetMapping("/api/v1/greetings")
    public String getGreetings() {
        return "Hello my friend!!!";
    }

    @GetMapping("/api/v1/greetings/slowed")
    public String getSlowGreetings() {
//        String data = restTemplate.getForObject("http://slow-service/api/v1/slow?delay={delay}", String.class, "3");
//        String data = restTemplate.getForObject("http://localhost:63641/api/v1/slow", String.class);
        String data = restTemplate.getForObject("http://slow-service/api/v1/slow", String.class);
        return "Hello my friend: " + data;
    }
}
