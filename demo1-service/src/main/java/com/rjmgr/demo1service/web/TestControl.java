package com.rjmgr.demo1service.web;

import com.rjmgr.common.annotation.SysLogger;
import com.rjmgr.demo1service.client.HystrixServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    HystrixServiceClient hystrixServiceClient;
    @Value("${foo}")
    String foo;

    @SysLogger("demo1@hi")
    @RequestMapping(value = "/hi")
    public String hi(){
        return foo;
    }
    @SysLogger("demo1@hi2")
    @RequestMapping(value = "/hi2")
    public String hi2(){
        return hystrixServiceClient.hi();
    }


}
