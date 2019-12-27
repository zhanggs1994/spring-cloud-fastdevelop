package com.rjmgr.demo2service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Demo2ServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Demo2ServiceApplication.class, args);
    }

}
