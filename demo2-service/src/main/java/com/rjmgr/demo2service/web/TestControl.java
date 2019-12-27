package com.rjmgr.demo2service.web;

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
    @Value("${foo}")
    String foo;
    @RequestMapping(value = "/hi")
    public String hi(){
        return foo;
    }
}
