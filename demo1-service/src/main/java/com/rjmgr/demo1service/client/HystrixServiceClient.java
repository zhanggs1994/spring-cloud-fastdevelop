package com.rjmgr.demo1service.client;

import com.rjmgr.demo1service.client.hystrix.HystrixServiceClientFB;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by fangzhipeng on 2017/5/27.
 */

@FeignClient(value = "demo2-service",fallback =HystrixServiceClientFB.class)
@Service
public interface HystrixServiceClient {
    @RequestMapping(value = "/test/hi")
    public String hi();
}



