package com.rjmgr.demo3service.web;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Description Description
 * @Author zgs
 * @Date Created in 2019/12/26
 */
@RefreshScope
@RestController
@RequestMapping(value = "/test")
public class TestControl {
    @Autowired
    RestTemplate restTemplate;

    @Value("${foo}")
    String foo;
    @Value ("${server.port}")
    String port;
    @RequestMapping(value = "/hi")
    public String hi(){
        return foo+"im from port:"+port;
    }

    @HystrixCommand(fallbackMethod = "hiError" )
    @RequestMapping(value = "/hi2")
    public  String hi2(){
         return restTemplate.getForObject("http://demo1-service/test/hi", String.class);
    }

    public String hiError() {
        return "hiError sorry , error ！";
    }
}
