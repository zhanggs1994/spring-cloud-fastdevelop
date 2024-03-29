package com.rjmgr.demo1service.service;

import com.alibaba.fastjson.JSON;
import com.rjmgr.demo1service.config.RabbitConfig;
import com.rjmgr.demo1service.model.SysLog;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by fangzhipeng on 2017/7/12.
 */
@Service
public class LoggerService {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void log(SysLog sysLog){
        rabbitTemplate.convertAndSend(RabbitConfig.queueName, JSON.toJSONString(sysLog));
    }
}
