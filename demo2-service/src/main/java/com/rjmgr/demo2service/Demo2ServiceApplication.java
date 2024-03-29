package com.rjmgr.demo2service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableHystrixDashboard
@EnableHystrix
@EnableRedisHttpSession
public class Demo2ServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Demo2ServiceApplication.class, args);
    }

}
