package com.rjmgr.loggerserver.rabbit;

import com.alibaba.fastjson.JSON;
import com.rjmgr.loggerserver.model.SysLog;
import com.rjmgr.loggerserver.service.SysLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.concurrent.CountDownLatch;

/**
 * Created by fangzhipeng on 2017/7/12.
 */
@Component
@Slf4j
public class Receiver {

    private CountDownLatch latch = new CountDownLatch(1);

    @Autowired
    private SysLogService sysLogService;
    public void receiveMessage(String message) {
        log.info("LOGGER-SERVER:  Received <" + message + ">");
        SysLog sysLog=  JSON.parseObject(message,SysLog.class);
        sysLogService.add(sysLog);
        latch.countDown();
    }


}