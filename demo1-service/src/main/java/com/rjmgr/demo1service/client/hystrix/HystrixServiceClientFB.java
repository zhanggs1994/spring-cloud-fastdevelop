package com.rjmgr.demo1service.client.hystrix;



import com.rjmgr.demo1service.client.HystrixServiceClient;
import org.springframework.stereotype.Component;

/**
 * Created by fangzhipeng on 2017/5/31.
 */
@Component
public class HystrixServiceClientFB implements HystrixServiceClient {

    @Override
    public String hi() {
        return "Hystrix fallback-------demo1 get demo2";
    }
}
