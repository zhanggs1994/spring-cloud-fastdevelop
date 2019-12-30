package com.rjmgr.demo1service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @EnableEurekaClient  Eureka注册中心客户端
 * @EnableFeignClients 开启feigin功能 FeignClients
 * @EnableHystrixDashboard 熔断器图表
 * @EnableHystrix 开启熔断器功能
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableHystrixDashboard
@EnableHystrix
public class Demo1ServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Demo1ServiceApplication.class, args);
	}

}
