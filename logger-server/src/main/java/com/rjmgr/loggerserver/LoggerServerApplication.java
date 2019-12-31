package com.rjmgr.loggerserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan({"com.rjmgr.loggerserver.mapper"})
public class LoggerServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoggerServerApplication.class, args);
	}

}
