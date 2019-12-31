package com.rjmgr.loggerserver.service;

import com.rjmgr.loggerserver.mapper.SysLogMapper;
import com.rjmgr.loggerserver.model.SysLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.processing.SupportedAnnotationTypes;

/**
 * @Description Description
 * @Author zgs
 * @Date Created in 2019/12/31
 */
@Service
public class SysLogServiceImpl implements  SysLogService {
    @Autowired
    private SysLogMapper sysLogMapper;
    @Override
    public int add(SysLog record) {
        return sysLogMapper.insertSelective(record);
    }

    @Override
    public int update(SysLog record) {
        return sysLogMapper.updateByPrimaryKeySelective(record);
    }
}
