package com.rjmgr.loggerserver.service;

import com.rjmgr.loggerserver.model.SysLog;

/**
 * @Description Description
 * @Author zgs
 * @Date Created in 2019/12/31
 */
public interface SysLogService {
    int add(SysLog record);
    int update(SysLog record);
}
